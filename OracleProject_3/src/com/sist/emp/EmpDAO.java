package com.sist.emp;
/// 오라클과 연결 - 송수신
/// 
import java.util.*;
import java.sql.*;
public class EmpDAO {

	//연결객체
	private Connection conn;
	
	// 송수신
	private PreparedStatement ps;
	// URL
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// 메모리 한개 사용 => 메모리 절약 / 일관성 => 싱글턴 방식
	private static EmpDAO dao;
	
	// 드라이버등록
	public EmpDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
	// 오라클연결
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
	// 오라클닫기
	public void disConnection()
	{
		try
		{
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
		}catch (Exception ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
	}
	// 싱그렅ㄴ 패턴
	public static EmpDAO getInstance()
	{
		if(dao==null)
			dao=new EmpDAO();
		return dao;
	}
	
    //------ 모든 dao 공통
	// dao는 테이블당 한개씩 만든다
	// 기능 empvo 사원하나
	public List<EmpVO> empListData(int page)
	{
		List<EmpVO> list=
				new ArrayList<EmpVO>();
		
		try
		{              //연결
	            getConnection();
	            // 오라클 전송 할 sql 문장
	            String sql="SELECT empno,ename,job,hiredate,sal "
	            		+"FROM emp "
	            		+"ORDER BY empno "
	            		+"OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
	            // MY SQL => LIMIT 0,10
	            // 오라클로 sql 문장 전송
	            ps=conn.prepareStatement(sql);
	            int start=(page*10)-10;
	            ps.setInt(1, start);
	            // sql injection
	            // 실행 요청후에 결과값 받기
	            ResultSet rs=ps.executeQuery();
	            // List에 이동
	            while(rs.next())
	            {
	            	EmpVO vo=new EmpVO();
	            	vo.setEmpno(rs.getInt(1));
	            	vo.setEname(rs.getString(2));
	            	vo.setJob(rs.getString(3));
	            	vo.setHiredate(rs.getDate(4));
	            	vo.setSal(rs.getInt(5));
	            	
	            	// 리스트 저장
	            	list.add(vo);
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
		return list;
	}
	
	// 총페이지 구하기
	public int empTotalPage()
	{
		int total=0;
		try
		{
				// 연결
			getConnection();
			// sql 문장
			String sql="SELECT CEIL(COUNT(*)/10.0) FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return total;
		
	}
	// like
	public List<EmpVO> empFindData(String name)
	{
		List<EmpVO> list=
				new ArrayList<EmpVO>();
		try
		{
			// conn
			getConnection();
			// sql
			String sql="SELECT empno,ename,job,hiredate,sal "
					+"FROM emp "
					+"WHERE ename LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			 while(rs.next())
	            {
	            	EmpVO vo=new EmpVO();
	            	vo.setEmpno(rs.getInt(1));
	            	vo.setEname(rs.getString(2));
	            	vo.setJob(rs.getString(3));
	            	vo.setHiredate(rs.getDate(4));
	            	vo.setSal(rs.getInt(5));
	            	
	            	// 리스트 저장
	            	list.add(vo);
	            }
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally {
			
		}
		return list;
	}
}








// 물음표













