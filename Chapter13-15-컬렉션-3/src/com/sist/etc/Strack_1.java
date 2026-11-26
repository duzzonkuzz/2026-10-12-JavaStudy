package com.sist.etc;
import java.util.*;
//LIFO 
public class Strack_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> s=new Stack<String>();
		// 주차장
		s.push("사과");//3
		s.push("배");//2
		s.push("포도");//1 ==> 저장 
		System.out.println(s.size());// 갯수  
		System.out.println(s.peek()); // 마지막 데이터 
		System.out.println(s.pop()); // 마지막 데이터 꺼내기 
		System.out.println(s.pop());
		System.out.println(s.pop());
		
		
	}

}