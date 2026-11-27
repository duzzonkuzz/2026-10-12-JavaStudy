package com.sist.emp;
import java.util.*;
// 내장 함수 정리
// 그룹바이
// 헤빙
public class UserMain {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	// ㅇ녀결
	EmpDAO dao=EmpDAO.getInstance();
	while(true)
	{
		System.out.println("===menu===");
		System.out.println("1.사원모곩");
		System.out.println("2.사원검색");
		System.out.println("9.종료");
		System.err.println("=========");
		System.out.println("메뉴 입력");
		int menu=scan.nextInt();
		
		if(menu==9)
		{
			System.out.println("종료");
			break;
			
		}
		else if(menu==1)
		{
			int total=dao.empTotalPage();
			System.out.println("페이지입력(1~10");
			int page=scan.nextInt();
			List<EmpVO> list=dao.empListData(page);
			for(EmpVO vo:list)
			{
				System.out.println(vo.getEmpno()+" "
						+vo.getEname()+" "
						+vo.getJob()+" "
						+vo.getHiredate().toString()+" "
						+vo.getSal()
						);
			}
			
		}
		else if(menu==2)
		{
			System.out.println("이름 입력");
			String name=scan.next();
			List<EmpVO> list=dao.empFindData(name);
			for(EmpVO vo:list)
			{
				System.out.println(vo.getEmpno()+" "
						+vo.getEname()+" "
						+vo.getJob()+" "
						+vo.getHiredate().toString()+" "
						+vo.getSal()
						);
		
	}
		}
	}
}
}
