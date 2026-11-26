package com.sist.io;

//BufferedReader 
//웹 데이터 읽기 => 주요 기능 , 파일 (IP , User  , Password) 
//                      ---------------------------- Properties
//실시간으로 출력 : 날씨 , 키워드 
import java.io.*;
import java.util.*;
import java.net.*;
public class IO_2 {
	private static final String baseUrl="https://www.kobis.or.kr/kobis/business/main/";
 private static String[] strUrl={
 		"",
 		"searchMainDailyBoxOffice.do",
 		"searchMainRealTicket.do",
 		"searchMainDailySeatTicket.do"
 };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner scan=new Scanner(System.in);
     System.out.print("1.박스오피스,2.실시간 예매율,3.좌석 점유율:");
     int menu=scan.nextInt();
     try
     {
     	// 웹 연결 
     	URI uri=new URI(baseUrl+strUrl[menu]);
     	URL url=uri.toURL();
     	
     	HttpURLConnection conn=
     			(HttpURLConnection)url.openConnection();
     	
     	String movie="";
     	
     	if(conn!=null) // 연결이 된 경우
     	{
     		BufferedReader br=
     			new BufferedReader(new InputStreamReader(conn.getInputStream()));
     		while(true)
     		{
     			String json=br.readLine();
     			if(json==null)
     				break; // 더이상 읽을 데이터가 없다 
     			movie+=json+"\n";
     		}
     		br.close();
     	}
     	System.out.println(movie.trim());
     	
     }catch(Exception ex)
     {
     	ex.printStackTrace();
     }
	}

}



