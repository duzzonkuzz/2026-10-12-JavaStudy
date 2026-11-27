package com.sist.emp;
/*
 *  EMPNO    NOT NULL NUMBER(4)    
	ENAME    NOT NULL VARCHAR2(20) 
	JOB               VARCHAR2(20) 
	HIREDATE          DATE         
	COMM              NUMBER(10,2) 
	SAL               NUMBER(10,2) 
	DEPTNO            NUMBER(2)  
 */
import java.util.*;

import lombok.Data;
@Data
public class EmpVO {
   private int empno,comm,sal,deptno;
   private String ename,job;
   private Date hiredate;
}