package com.sist.list;
/*
 *    Vector 
 *      => 배열기반 (ArrayList와 거의 동일) 
 *      => 메소드가 동기화되어 있다  
 *      => ArrayList보다 성능에 부담
 *      => 예전에 개발된 프로그램에서만 사용이 됨 
 *      => 최근에는 ArrayList변경 
 *      => 동시성 제어 => 예약/은행 ....
 *         --------- 오라클안에 존재 
 *      => 크롤링 => 쓰레드 => 나눠서 작업 => 동기화 
 *      => 주요 기능        동기화 메소드 
 *         추가 : add() => addElement()
 *         수정 : set() => set()
 *         삭제 : remove() => removeEelement()
 *         읽기 : get() => elementAt() 
 *         갯수 : size() => size()    
 */
import java.util.*;
public class Vector_1 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Vector<String> names=new Vector<String>();
        names.addElement("홍길동");// add
        names.addElement("심청이");
        names.addElement("박문수");
        System.out.println("인원:"+names.size());
        for(String name:names)
        {
        	System.out.println(name);
        }
        System.out.println("====== 삭제 ======");
        names.removeElementAt(0);//remove()
        for(String name:names)
        {
        	System.out.println(name);
        }
        System.out.println("====== 수정 ======");
        names.setElementAt("춘향이",0);// set(int index,Object obj)
        
        for(String name:names)
        {
        	System.out.println(name);
        }
        
        System.out.println("====== 전체 삭제 ======");
        names.removeAllElements();// clear()
        System.out.println("인원:"+names.size());
        
        System.out.println("======= 존재여부 ======");
        if(names.isEmpty())
        {
        	System.out.println("인원이 없다");
        }
        else
        {
        	System.out.println("인원이 있다");
        }
	}

}