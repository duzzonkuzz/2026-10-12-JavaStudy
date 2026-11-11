package com.sist.math;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 *  수학 연산과 관련된 클래스 
 *  -------
 *   Math (웹) => ceil (올림 = 총페이지) , random() => 0.0 ~ 0.99
 *                round() : 반올림 
 *                => 오라클에도 존재 
 *   => Math는 모든 메소드가 static => Math.ceil() / Math.random()..
 *   => 원형 
 *      double random() 
 *      double ceil(double)
 *      double round(double)
 *      ------------------------ int 형변환 
 *   => 예외처리가 있는지 확인 
 *   => 라이브러리 
 *      역할(어떤 기능) / 리턴형 / 매개변수 / 메소드명 / 예외처리  
 */
public class Math_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// 1. 오라클 연결 => driver 설정 
        	Class.forName("oracle.jdbc.driver.OracleDriver"); // 자동으로 메모리 할당 => 리플렉션 
        	// 2. 연결 
        	String url="jdbc:oracle:thin:@xxx.xxx.xxx.xx:xxxx:XE";
        	Connection conn=DriverManager.getConnection(url,"hr","happy");
        	// 3. 오라클 명령어 전송 
        	String sql="SELECT CEIL(COUNT(*)/10) FROM recipe";
        	PreparedStatement ps=conn.prepareStatement(sql); // 네트워크 통신 
        	ResultSet rs=ps.executeQuery();
        	rs.next();
        	int count=rs.getInt(1);
        	rs.close();
        	ps.close();
        	conn.close();
        	
        	System.out.println("레시피의 갯수:"+count);
        	
        	// 10개씩 => 1페이지 => 총페이지 
        	int totalpage=(int)(Math.ceil(count/10.0));
        	// ceil => 10.1 => 11 
        	System.out.println("총페이지:"+totalpage);
        	int rand=(int)(Math.random()*100)+1;
        	// 1~100
        	System.out.println(rand);
        	
        	double d=Math.round(10.5);
        	System.out.println(d);
        }catch(Exception ex){ex.printStackTrace();}
	}

}