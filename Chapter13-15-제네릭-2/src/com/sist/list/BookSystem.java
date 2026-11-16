package com.sist.list;
import java.util.*;

import lombok.Getter;
/*
 *    java.util 
 *      = Date / Calendar => 날짜와 시간을 제어 
 *               | => Date에 없는 기능 추가 
 *        | => 기능은 없다 => 오라클(데이터베이스) => 데이터를 저장 목적
 *      = StringTokenizer : spilt를 쉽게 제어할 수 있게 만든 클래스 
 *          => 단어별 분리 
 *      = Random : 난수 발생 
 *        ------ Random r=new Random() 
 *               r.nextInt(100) => 0~99 /  r.nextInt(100)+1
 *      = Collection
 */
import java.sql.*;
public class BookSystem {
   @Getter
   private static ArrayList<BookVO> bList=new ArrayList<BookVO>();
   // 모든 사용자가 공유하는 변수 
   // static에 대한 초기화 
   static 
   {
	   try
	   {
		   // 드라이버 등록 
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   // 연결 
		   String url="jdbc:oracle:thin:@xxx.xxx.xxx.xx:1521:XE";
		   Connection conn=DriverManager.getConnection(url,"hr","happy");
		   // SQL문장 전송 
		   String sql="SELECT no,title,author,poster,pubdate,pages,price "
				     +"FROM book ORDER BY no ASC";
		   PreparedStatement ps=conn.prepareStatement(sql);
		   // 결과값 받기 
		   ResultSet rs=ps.executeQuery();
		   // 닫기 
		   while(rs.next())
		   {
			   BookVO vo=new BookVO();
			   vo.setNo(rs.getInt(1));
			   vo.setTitle(rs.getString(2));
			   vo.setAuthor(rs.getString(3));
			   vo.setPoster(rs.getString(4));
			   vo.setPubdate(rs.getDate(5));
			   vo.setPages(rs.getString(6));
			   vo.setPrice(rs.getInt(7));
			   bList.add(vo);
		   }
		   rs.close();
		   ps.close();
		   conn.close();
	   }catch(Exception ex){ex.printStackTrace();}
   }
   
   // 기능 
   // 1. 목록 => 페이지 나눠서 => 사이트의 기본 => 페이징 기법 
   public ArrayList<BookVO> bookListData(int page)
   {
	   // 653/10.0   65.3 => 66
	   final int ROWSIZE=10;
	   int start=(page*ROWSIZE)-ROWSIZE;
	   // 0 10 20 30 650 
	   
	   int end=page*ROWSIZE;
	   if(end>=bList.size())
		   end=bList.size();
	   
	   ArrayList<BookVO> list=
			     new ArrayList<BookVO>(bList.subList(start, end));
	   return list;
   }
   // 2. 상세보기 
   public BookVO bookDetailData(int no)
   {
	   BookVO vo=new BookVO();
	   for(BookVO bvo:bList)
	   {
		   if(no==bvo.getNo())
		   {
			   vo=bvo;
			   break;
		   }
	   }
	   return vo;
   }
   // 3. 검색 
   public ArrayList<BookVO> bookFindData(String title)
   {
	   ArrayList<BookVO> list=new ArrayList<BookVO>();
	   // 가변 => 데이터 갯수가 필요없다 
	   for(BookVO vo:bList)
	   {
		   if(vo.getTitle().contains(title))
		   {
			   list.add(vo);
		   }
	   }
	   return list;
   }
   // 4. 삭제 
   public void bookDelete(int no)
   {
	   for(int i=0;i<bList.size();i++)
	   {
		   BookVO vo=bList.get(i);
		   if(no==vo.getNo())
		   {
			   bList.remove(i);
			   break;
		   }
	   }
   }
}





