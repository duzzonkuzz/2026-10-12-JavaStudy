package com.sist.emp;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserMain {
public static void main(String[] args) {
	EmpDAO dao=EmpDAO.getInstance();
	List<EmpVO> list=dao.empdeptJoinData();
	for(EmpVO vo:list)
	{
		System.out.println(vo.getEmpno()+" "
		+vo.getEname()+" "
		+vo.getJob()+" "
		+vo.getHiredate().toString()+" "
		+vo.getSal()+" "
		+vo.getDvo().getDname()+" "
		+vo.getDvo().getLoc());
	}
}

}
