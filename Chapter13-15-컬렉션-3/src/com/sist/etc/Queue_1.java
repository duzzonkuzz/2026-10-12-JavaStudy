package com.sist.etc;

//FIFO => LinkedList => 네트워크 / 운영체제 / Kafka 
import java.util.*;
public class Queue_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Queue<String> q=new LinkedList<String>();
     // 저장 
     q.offer("홍길동");// 데이터 추가 offer
     q.offer("이순신");
     q.offer("강감찬");
     System.out.println(q.size()); // 데이터 갯수 
     System.out.println(q.peek()); // 맨 앞에 있는 데이터 
     System.out.println(q.poll()); // 데이터 꺼내기 => 데이터가 없어진다  
     System.out.println(q.poll());
     System.out.println(q.poll());
     
     
	}

}