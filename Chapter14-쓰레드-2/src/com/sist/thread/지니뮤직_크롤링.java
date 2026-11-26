package com.sist.thread;
import java.util.*;
/*
 *    1. 변수 / 데이터형 
 *    2. 연산자 
 *    3. 제어문 
 *    4. 배열 => 일차원 
 *    5. 클래스 / 객체 => 참조변수 
 *    6. 객체지향 
 *       = 캡슐화 / 상속 / 다형성 (오버라이딩)
 *    7. 추상 클래스 / 인터 페이스 
 *    8. 예외처리 
 *    9. 라이브러리 
 *       java.lang : Object / String / StringBuffer / Wrapper
 *                                                    Integer
 *                                                    Long 
 *                                                    Boolean
 *                                                    Double  
 *       java.util : ArrayList / HashSet / HashMap 
 *                   Date / Calendar / StringTokenizer 
 *       java.text : SimpleDateFormat / DecimalFormat 
 *    10. java.io : 입출력 
 *    --------------------------------------------------------
 *    2차 자바 
 *    => 람다식 / 데이터베이스 연동 
 *    => 웹에서 사용되는 라이브러리 
 *       
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/*
 *       메인 쓰레드 => main() => dataCollection()
 *                      |
 *                  쓰레드 4개 생성 
 *                for(int i = 0; i < 4; i++)
                  {
                      final int page = i + 1;
                      threads[i] = new Thread(new Runnable()
                  }  
          ---------------------------------------------
           Thread-0    Thread-1    Thread-2   Thread-3
             1페이지      2페이지       3페이지     4페이지
          ---------------------------------------------
                             |
                          순차적으로 저장 
                        synchronized(list)
                        {
                           list.addAll(temp);
                        }
                           |
                          join 
                          4개 쓰레즈가 동시에 종료될때까지 대기
                           |
                        번호별로 정렬 
                        list.sort(Comparator.comparingInt(Music::getMno));
                           |
                        화면에 출력 
                          
 */
public class 지니뮤직_크롤링 {

public void dataCollection()
{
    List<Music> list = new ArrayList<Music>();
    // 1. 페이지별 쓰레드 4개 생성
    Thread[] threads = new Thread[4];
    // 2. 쓰레드 생성
    for(int i = 0; i < 4; i++)
    {
        final int page = i + 1;
        threads[i] = new Thread(new Runnable() {
            List<Music> temp = new ArrayList<Music>();
            @Override
            public void run()
            {
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

                // 3. 공유 리스트에 저장 (동기화)
                synchronized(list)
                {
                    list.addAll(temp);
                }
            }// run
        });// new Runnable()
    }// for

    // 4. 모든 쓰레드 시작
    for(Thread t : threads)
    {
        t.start();
    }

    // 5. 모든 쓰레드 종료 대기
    for(Thread t : threads)
    {
        try
        {
            t.join();
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
            return;
        }
    }

    // 6. 순위순 정렬
    list.sort(Comparator.comparingInt(Music::getMno));

    System.out.println("전체 수집 완료 : " + list.size() + "곡");

    // 결과 확인 => 오라클로 전송 
    for(Music m : list)
    {
        System.out.println(
            m.getMno() + ". " +
            m.getTitle() + " - " +
            m.getSinger()
        );
    }
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        지니뮤직_크롤링 m=new 지니뮤직_크롤링();
        long start=System.currentTimeMillis();
        m.dataCollection();
        long end=System.currentTimeMillis();
        System.out.println("총 걸린시간:"+(end-start)+"MS");
	}

}