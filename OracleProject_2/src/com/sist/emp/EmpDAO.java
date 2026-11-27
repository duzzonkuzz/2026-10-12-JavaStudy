package com.sist.emp;
import java.util.*;
import java.sql.*;
public class EmpDAO {
   // 연결 객체 
   private Connection conn;
   // 송수신 객체 
   private PreparedStatement ps;
   // 한개의 메모리 사용 => 싱글턴 
   private static EmpDAO dao;
   // URL 
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   /*
    *   오라클에서 지원하는 함수 
    *   => SUBSTR() / COUNT() / TO_CHAR() 
    *   => AVG() / SUM() 
    *   => SYSDATE 
    *   => RANK
    *   
    *   => 비교연산자 / BETWEEN / IN / NULL / LIKE 
    */
   // 1. 드라이버 설정  == 한번 설정 (생성자)
   public EmpDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   // 2. 오라클 연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex) {}
   }
   // 3. 오라클 해제 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   // 4. 싱글턴 
   public static EmpDAO newInstance()
   {
	   if(dao==null)
		   dao=new EmpDAO();
	   return dao;
   }
   
   // 기능 
   // 1. 목록 
   public List<EmpVO> empAllData()
   {
	   List<EmpVO> list=new ArrayList<EmpVO>();
	   try
	   {
		   // 1. 연결 
		   getConnection();
		   // 2. SQL문장 
		   String sql="SELECT empno,ename,job,hiredate,deptno "
				     +"FROM emp "
				     +"ORDER BY hiredate";
		   // 3. 오라클 전송 
		   ps=conn.prepareStatement(sql);
		   // 4. 결과값 받기 
		   ResultSet rs=ps.executeQuery();
		   // 5. List에 추가 
		   while(rs.next())
		   {
			   EmpVO vo=new EmpVO();
			   vo.setEmpno(rs.getInt(1));
			   vo.setEname(rs.getString(2));
			   vo.setJob(rs.getString(3));
			   vo.setHiredate(rs.getDate(4));
			   vo.setDeptno(rs.getInt(5));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return list;
   }
   // 2. 상세보기
   // 3. 로그인 
   public String isLogin(int empno,String ename)
   {
	   String result="";
	   try
	   {
		   // 1. 연결 
		   getConnection();
		   // 2. SQL문장 
		   String sql="SELECT COUNT(*) FROM emp "
				     +"WHERE empno=?"; // SQL Injection = 해킹 방지 
		   // => ?는 미리 SQL문장을 오라클로 전송 
		   // => 나중에 값을 채워서 처리하는 방식 
		   ps=conn.prepareStatement(sql);
		   // ?에 값을 채운다 
		   ps.setInt(1, empno);
		   // 오라클 실행 명령 => 결과값을 받는다 
		   ResultSet rs=ps.executeQuery();
		   rs.next();// 값이 출력되어 있는 첫번째 위치 커서 이동 
		   int count=rs.getInt(1);
		   rs.close();
		   
		   if(count==0) // 사번이 없는 경우 
		   {
			   result="NOSABUN";
		   }
		   else // 사번이 있는 경우 
		   {
			   sql="SELECT ename FROM emp "
				  +"WHERE empno=?";
			   ps=conn.prepareStatement(sql);
			   // ?에 값을 채운다 
			   ps.setInt(1, empno); 
			   rs=ps.executeQuery();
			   rs.next();
			   String db_name=rs.getString(1);
			   rs.close();
			   if(db_name.equals(ename)) // 로그인 
			   {
				   result="OK";
			   }
			   else // 없는 이름 
			   {
				   result="NONAME";
			   }
		   }
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // 닫기 
		   disConnection();
	   }
	   return result;
   }
   
   
}