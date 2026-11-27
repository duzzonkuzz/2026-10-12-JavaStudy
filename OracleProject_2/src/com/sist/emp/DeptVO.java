package com.sist.emp;

import lombok.Data;

/*
 *   DEPTNO NOT NULL NUMBER(2)    부서번호 
     DNAME  NOT NULL VARCHAR2(20) 부서명 
     LOC             VARCHAR2(20) 근무지
 */
@Data
public class DeptVO {
  private int deptno;
  private String dname,loc;
}