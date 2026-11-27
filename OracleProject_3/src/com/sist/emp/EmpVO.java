package com.sist.emp;
import java.util.*;

import lombok.Data;
/*
 *       오라클 데이터형          자바 데이터형
 *      number 4
 *      number 8 2
 *      --------------------  결과값 : 정수면 int /  실수면 double
 *      char
 *      varchar2
 *      clob
 *      ----------- String
 *      date
 *      timestamp
 *      ----------- java.util
 */
@Data
public class EmpVO {
private int empno,comm,sal,deptno;
private String ename,job;
private Date hiredate;
}
