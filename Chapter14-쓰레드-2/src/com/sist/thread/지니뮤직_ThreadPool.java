package com.sist.thread;
import java.util.*;
import java.util.concurrent.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class 지니뮤직_ThreadPool {
	private static List<Music> list=
			       new ArrayList<Music>();
    public void dataCollection()
    {
    	//1. 쓰레드 풀 생성 => 쓰레드 4개 
    	ExecutorService service=
    			Executors.newFixedThreadPool(4);
    	// 작업 결과를 저장 
    	List<Future<List<Music>>> futures=
    			           new ArrayList<>();
    	/*
    	 *    newFixedThreadPool => 쓰레드 몇개 저장할지 설정 
    	 *    Future => 결과값 관리 => 결과 보관 장소 
    	 *    submit() => 작업 등록 => 일 시키기 (쓰레드 동작)
    	 *    get() : 작업 결과 가지고 온다 
    	 *    shutdown() : 작업 정리 => 종료
    	 *    
    	 *    ------------------------------------
    	 *             thread         threadpool
    	 *    ------------------------------------
    	 *          직접 생성            풀에서 관리
    	 *          new Thread()
    	 *          
    	 *          start()            submit()
    	 *          
    	 *          직접 구현            Future 
    	 *          종료대기(join())     get()
    	 *          직접 관리
    	 *          interrupt()        shutdown
    	 *          재사용(X)            재사용이 가능 
    	 *    ------------------------------
    	 *          Runnable           Callable
    	 *          
    	 *    ---------------------------------------
    	 *                 메인 쓰레드
    	 *    ---------------------------------------
    	 *                   | 쓰레드 등록 
    	 *                ExecutorService
    	 *                   |
    	 *    ------------------------------------------
    	 *      Thread-1   Thread-2  Thread-3 Thread-4
    	 *        1page      2page     3page   4page
    	 *    ------------------------------------------
    	 *                   |
    	 *                Callable 
    	 *                 => 페이지별 수집된 데이터를 List 반환 
    	 *                   |
    	 *                Future.get 
    	 *                작업된 데이터 읽기 
    	 *                  |
    	 *                List 저장 => 정렬 
    	 *                  |
    	 *                shutdown 
    	 *                
    	 *            Thread => Runnable => ExecutorService
    	 *                                      |
    	 *                                   Callable
    	 *                                      |
    	 *                                    Future
    	 *                                      |
    	 *                                   ThreadPool
    	 *             => synchronized 동기화
    	 *             => 메소드 앞에 존재 : 제어어
    	 *               
    	 *               
    	 *    
    	 */
    	//3. 페이지별 작업 등록 
    	for(int i=1;i<=4;i++)
    	{
    		final int page=i;
    		// 데이터 저장 
    		/*
    		 *   new Thread(new Runnable(){
    		 *      public void run(){
    		 *      
    		 *      }
    		 *   });
    		 */
    		Future<List<Music>> future=
    				  service.submit(new Callable<List<Music>>() 
    				  {

    					    // call ==> run()
							@Override
							public List<Music> call() throws Exception {
								// TODO Auto-generated method stub
								List<Music> temp=new ArrayList<Music>();
								try
				                {
				                    Document doc = Jsoup.connect(
				                        "https://www.genie.co.kr/chart/top200?ditc=D&ymd=20261117&hh=14&rtm=Y&pg="
				                        + page
				                    ).get();

				                    Elements title =
				                        doc.select("table.list-wrap a.title");
				                    Elements singer =
				                        doc.select("table.list-wrap a.artist");
				                    Elements poster =
				                        doc.select("table.list-wrap a.cover img");
				                    Elements album =
				                        doc.select("table.list-wrap a.albumtitle");

				                    for(int i = 0; i < title.size(); i++)
				                    {
				                        Music music = new Music();

				                        music.setTitle(title.get(i).text());
				                        music.setSinger(singer.get(i).text());
				                        music.setPoster(poster.get(i).attr("src"));

				                        // 페이지별 순위 계산
				                        music.setMno((page - 1) * 50 + i + 1);

				                        music.setAlbum(album.get(i).text());

				                        temp.add(music);
				                    }

				                    System.out.println(
				                        page + "페이지 수집 완료 : " + temp.size()
				                    );
				                }
				                catch(Exception ex)
				                {
				                    System.out.println(page + "페이지 오류");
				                    ex.printStackTrace();
				                }
								return temp;
							}
    					   
					  });
    		futures.add(future);
    	}
    	// 모든 작업 완료 => 대기 => 결과값 가지고 오기 
    	for(Future<List<Music>> future:futures)
    	{
    		try
    		{
    			List<Music> temp=future.get();
    			// join
    			list.addAll(temp);
    		}catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	
    	// 4-1 저장된 값을 출력 
    	for(Music m:list)
    	{
    		System.out.println(m.getMno()+" "
    				+m.getTitle()+" "
    				+m.getSinger());
    	}
    	// 5. 쓰레드 종료 
    	service.shutdown();
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        지니뮤직_ThreadPool t=new 지니뮤직_ThreadPool();
        long start=System.currentTimeMillis();
        t.dataCollection();
        long end=System.currentTimeMillis();
        System.out.println("총 걸린시간:"+(end-start)+"MS");
	}

}