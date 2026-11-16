package com.sist.list;
/*
 *   NO            NOT NULL NUMBER        
TITLE         NOT NULL VARCHAR2(500) 
POSTER                 VARCHAR2(500) 
AUTHOR        NOT NULL VARCHAR2(50)  
PUBDATE                DATE          
PAGES                  VARCHAR2(10)    
PRICE         NOT NULL NUMBER             

 */
// => 오라클 / 크롤링 
import java.util.*;

import lombok.Data;
@Data
public class BookVO {
  private int no;
  private String title;
  private String poster;
  private String author;
  private Date pubdate;
  private String pages;
  private int price;
}