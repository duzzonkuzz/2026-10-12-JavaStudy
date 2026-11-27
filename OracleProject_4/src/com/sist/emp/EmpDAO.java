package com.sist.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

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
		
		public List<EmpVO> empdeptJoinData()
		{
			List<EmpVO> list=
					new ArrayList<EmpVO>();
			try
			{
					getConnection();
					String sql="SELECT empno,ename,job,hiredate,sal,dname,loc "
							+"FROM emp JOIN dept "
							+"ON emp.deptno=dept.deptno "
							+"ORDER BY empno ASC";
					// 전송
					ps=conn.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						EmpVO vo=new EmpVO();
						vo.setEmpno(rs.getInt(1));
						vo.setEname(rs.getString(2));
						vo.setJob(rs.getString(3));
						vo.setHiredate(rs.getDate(4));
						vo.setSal(rs.getInt(5));
						vo.getDvo().setDname(rs.getString(6));
						vo.getDvo().setLoc(rs.getString(7));
						list.add(vo);
					}
					rs.close();
					
			}catch (Exception ex) {
				// TODO: handle 	exception
			ex.printStackTrace();
			}
			finally {
				disConnection();
			}
			return list;
		}
		
}
