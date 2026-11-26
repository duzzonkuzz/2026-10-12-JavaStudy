package com.sist.io;
// 웹 => 가장 많이 사용되는 입출력 => BufferedReader
// https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do

import java.io.*;
import java.net.*; // URL
/*
 *   https://www.kobis.or.kr /kobis/business/main/searchMainDailyBoxOffice.do
 *   -----   --------------- ------------------------------------------------
 *     |           |         | 사용자 요청 정보 
 *     -------------           ------------ URI
 *       | 서버 정보  -------------------+ URL
 *      
 *      한줄을 읽을 수 있다 => readLine()
 *   => BufferedReader => new FileInputStream() (FileReader X)
 *              ------            -----------
 *               2                   1
 *               |                   |
 *               ---------------------
 *                 | InputStreamReader : byte변환 
 *      BufferedWriter => new FileOutputStream() 연결 (FileWriter X)
 */
public class Buffuered_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// JDK 20부터 
        	/*
        	 *   Document doc=Jsoup.connect(url).get();
        	 */
        	URI uri=new URI("https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do");
        	URL url=uri.toURL();
        	HttpURLConnection conn=
        			(HttpURLConnection)url.openConnection();
        	// 웹 연결 
        	if(conn!=null)//연결이 된 경우 
        	{
        		BufferedReader br=
        			new BufferedReader(
        					new InputStreamReader(conn.getInputStream()));
        		while(true)
        		{
        			String json=br.readLine();
        			if(json==null)
        				break;
        			System.out.println(json+"\n");
        		}
        		br.close();
        	}
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
	}

}