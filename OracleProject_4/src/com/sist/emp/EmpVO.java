package com.sist.emp;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EmpVO {
	private int empno,deptno,sal,comm;
	private String ename,job;
	private Date hiredate;
	private DeptVO dvo=new DeptVO();
}
