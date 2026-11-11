package com.sist.string;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GenieMusic {
    // 노래 목록 = 공유 
	private static MusicVo[] musics=new MusicVo[50];
	private static String[] category={
		"https://www.genie.co.kr/chart/top200",
		"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20261108&genrecode=M0100",
		"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20261108&genrecode=M0200",
		"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20261108&genrecode=M0300",
		"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20261108&genrecode=M0107",
		"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20261108&genrecode=M0500",
		"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20261108&genrecode=M0600"
	};
	// 초기화 => 초기화블록(static 변수 초기화) / 생성자(인스턴스 변수 초기화)
	// 초기화 블록 => 자동 호출 / 상속에서 예외 조건 
	/*public GenieMusic()
	{
		getData(0);
	}*/
	// 재사용 => 사용자 요청시마다 호출하는 메소드 
	// static{} / 생성자는 한번만 호출 => 재호출이 안된다 
	public void getData(int cno) 
	{
		/*
		 *    반드시 예외처리해야 되는 클래스 
		 *    ------------------------ CheckedException 
		 *    1. 파일 IOException 
		 *    2. 네트워크 관련 MalformedURLException 
		 *       ---------- web연결 
		 *    3. 데이터베이스 관련 SQLException 
		 *    4. 쓰레드 관련  InterruptedException 
		 *    5. 클래스 관련  ClassNotFoundException
		 */
		try
		{
			//1. 웹 연결 => 소스 읽기 (HTML) => 메모리에 저장 
			Document doc=Jsoup.connect(category[cno]).get();
			// Document => 문서 저장하는 클래스 
			// 태그 집합 => 컬렉션 
			Elements title=doc.select("table.list-wrap a.title");
			Elements singer=doc.select("table.list-wrap a.artist");
			Elements album=doc.select("table.list-wrap a.albumtitle");
			Elements poster=doc.select("table.list-wrap a.cover img");
			Elements etc=doc.select("table.list-wrap span.rank span.rank");
			
			for(int i=0;i<title.size();i++)
			{
				musics[i]=new MusicVo();
				// static => 클래스 전체에서 사용이 가능 
				// instance변수는 static 메소드 / static {} 사용이 안된다 
				// 객체변수       ------- 클래스 변수 
				musics[i].setMno(i+1);
				musics[i].setTitle(title.get(i).text());
				musics[i].setSinger(singer.get(i).text());
				musics[i].setAlbum(album.get(i).text());
				musics[i].setPoster(poster.get(i).attr("src"));
				String state="";
				int id=0;
				String temp=etc.get(i).text();
				// 유지 , 1상승 , 5하강 
				if(temp.equals("유지"))
				{
					state="유지";
					id=0;
				}
				else
				{
					// replaceAll
					state=temp.replaceAll("[^가-힣]", "");
					// ^ 제외
					id=Integer.parseInt(temp.replaceAll("[^0-9]", ""));
					// 문자열을 정수로 변환 => String.valueOf()
				}
				musics[i].setState(state);
				musics[i].setIdcrement(id);
			}
			
		}catch(Exception ex){}
		// 출력 
		// for-each 
		for(MusicVo vo:musics)
		{
			System.out.println(vo.getMno()+"."+vo.getTitle());
		}
		
	}}
	
