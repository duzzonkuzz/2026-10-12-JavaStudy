package com.sist.string;

//문자열 분리 => split / StringTokenizer 
/*
*   계란,새송이버섯,대파,참기름,통깨,물,굵은소금,식초,진간장,맛술,설탕,올리고당,다진 마늘
*/
import java.util.*;
//525page
public class 문자열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String data="계란,새송이버섯,대파,참기름,통깨,물,굵은소금,식초,진간장,맛술,설탕,올리고당,다진 마늘";
     String[] datas=data.split(",");
     for(String s:datas)
     {
     	System.out.println(s);
     }
     System.out.println();
     StringTokenizer st=new StringTokenizer(data,",");
     System.out.println("분리된 재료:"+st.countTokens());
     while(st.hasMoreTokens())
     {
     	System.out.println(st.nextToken());
     }
     /*
      *  countTokens() : 분리된 단어 갯스
      *  hasMoreTokens() : 분리된 단어가 있는 동안 
      *  nextToken() : 실제 단어를 한개씩 읽어온다 
      *  단점 : ""공백 / null인 경우에는 문제가 발생 
      */
	}

}