package com.sist.book;
// 테이블 당 한개 생성 = 필요시에 재사용
/*
 *  오라클 연동
 *    드라이버 등록 - 한번만 수행 - 생성자
 *    오라클 연경 - url username password
 *    sql 문장 전송 - sql문장 작성이 가능
 *    실행 결과값 받기 - 레코드 => 헌줄씩 => vo
 *    2. 브라우조ㅓ / 자바스크립트 ./자바 자체 처리
 *    
 *    connection 오라클 연결
 *       getconnection
 *    preparedstatement sql 무ㅠㄴ장 보내고 결과받기
 *         preparestatement sql 문장으로 오라클 전송
 *         excuteQuery 실행후에 결과값 알기
 *    ㄱresultset 오라클에 가지고 온 데이터 저장
 *      커서의 위치 변경
 *        next() 처음부터 밑으로 내려가면서 데이터 일기
 *        prevous() 밑에서부터 위로 올라온다
 *        데이터 읽을 때
 *          getInt  getDouble gtString getDate
 *          
 *       => rs.close()
 *          ps.close()
 *          conn.close()
 */
import java.sql.*;
import java.util.*;
public class BookDAO {
// 연결 객체
	private Connection conn;
	// sql 송수신
	private PreparedStatement ps;
	// url
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	//1. 드라이버 드옥
	public BookDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	// 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		
	}
	// 닫기
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch (Exception ex) {
			// TODO: handle exception
			
		}
	}
	public void bookADAte()
	{
		try
		{
			//1 d연결
			getConnection();
			// 2 sql 문장
			String sql="SELECT * FROM book";
			ps=conn.prepareStatement(sql); //sql로 전송 메소드
			// 3결과값 
			ResultSet rs=ps.executeQuery();
			// ResultSet 결과값을 저장하는 메모리 공간
			/*
			 *     resultSet
			 *     -------------------
			 *     no name address rate regdate
			 *     -------------------
			 *     1 홍길동   서울   10.5    26/11/24
			 *     ---------------------------
			 *     
			 *     ------------------------
			 */
			while(rs.next())
			{
				System.out.println(
						rs.getInt("bookId")+" "
						+rs.getString("bookname")+" "
						+rs.getString("publisher")+" "
						+rs.getInt("price")
						);
			}
			
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	
	public void find()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("책제목:");
		String name=scan.next();
		try
		{
			getConnection();
			String sql="SELECT * "
					+"FROM book "
					+"WHERE bookname LIKE '%'||'?'||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
			rs.close();
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	public static void main(String[] args) {
		BookDAO dao=
				new BookDAO();
		//dao.bookADAte();
		dao.find();
		
		
		
	}
	
}
