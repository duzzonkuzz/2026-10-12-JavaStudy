package com.sist.book;

import lombok.Data;

/*
 *  BOOKID    NOT NULL NUMBER(3)    
BOOKNAME           VARCHAR2(40) 
PUBLISHER          VARCHAR2(40) 
PRICE              NUMBER(8)  


 */
@Data
public class BookVO {
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
}
