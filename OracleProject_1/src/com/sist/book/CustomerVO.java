package com.sist.book;

import lombok.Data;

/*
 *   

CUSTID  NOT NULL NUMBER(3)    
NAME             VARCHAR2(40) 
ADDRESS          VARCHAR2(50) 
PHONE            VARCHAR2(20)

  오라클 데이터형
  char / varchar2 / clob => string
  number => int double
  date  => java.util.date
  timestamp => localdatetime
  blob => InputStream
  bfile => InputStream
  
  
 */
@Data
public class CustomerVO {
private int custid;
private String name;
private String address;
private String phone;
}
