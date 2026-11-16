package com.sist.list;
/*
 *   LinkedList 
 *   ----------
 *     | 연결 구조     1 - 2 - 3 .... 
 *     | 중간에 추가 / 삭제가 많은 경우 
 *            ---------- ArrayList/Vector => index번호를 조절 
 *     | 인덱스를 이용해서 검색 : ArrayList보다 속도가 느리다 
 *     | 사용처 : Queue사용시 사용 
 */
import java.util.*;
public class LinkedList_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LinkedList<Integer> list=
        		 new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        // list.add(5)
        list.add(3);
        System.out.println("갯수:"+list.size());
        for(int i:list)
        {
        	System.out.println(i);
        }
        System.out.println("===== 추가 =====");
        list.add(4);
        list.add(2,5);
        for(int i:list)
        {
        	System.out.println(i);
        }
        System.out.println("===== 삭제 =====");
        list.remove(0);
        for(int i:list)
        {
        	System.out.println(i);
        }
        System.out.println("===== 수정 ======");
        list.set(0, 100);
        for(int i:list)
        {
        	System.out.println(i);
        }
        System.out.println("===== 전체 삭제====");
        list.clear();
        System.out.println("갯수:"+list.size());
        
        if(list.isEmpty())
        {
        	System.out.println("데이터가 없습니다");
        }
        else
        {
        	System.out.println("데이터가 있습니다");
        }
        
	}

}