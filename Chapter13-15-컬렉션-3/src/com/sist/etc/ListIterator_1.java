package com.sist.etc;
// List에서만 사용 
/*
 *   데이터 수정 / 추가 기능이 가능 => 양방향 
 *   
 *   hasNext()
 *   next()
 *   hasPrevious()
 *   previous()
 *   add()
 *   set()
 *   remove()
 *   -------------------------------------
 *   Iterator 
 *      =간단헌 코드로 데이터를 순차적으로 탐색 
 *      =List / Set 
 *      = 반복중에 remove()를 이용해서 안전하게 삭제 
 *      = 뒤로 이동이 불가능 
 *      = 반복중에 데이터 추가 , 수정 기능은 제한적 
 *      = 출력용 
 *      ------------------------------------
 *      실무 
 *       전체 데이터 조회 
 *       조건에 맞는 데이터 삭제 
 *       게시판 목록 ...
 *       
 *   ListIterator 
 *      = 앞뒤 방향에서 이동 가능 
 *      = 반복중에 데이터 추가 / 수정 / 삭제가 가능 
 *      = List에서만 사용 
 *      = Iterator보다 사용법이 복잡
 *      ------------------------------------
 *      실무 
 *      = 이전 / 다음 페이지 
 *      = 데이터 탐색 => 수정 가능 
 *      = 리스트 중간에 데이터 첨부 
 *   -----------------------------------------
 *   Iterator : 하나씩 조회 => 삭제 
 *   ListIterator : 조회 + 추가 + 수정 + 삭제 
 *   단순한 조회 => for-each 
 *   => 반복 도중에 삭제나 수정 => Iterator
 */
import java.util.*;
public class ListIterator_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
       
        
        /*ListIterator<Integer> it=list.listIterator();
        while(it.hasNext())
        {
        	int num=it.next();
        	if(num<3)
        		it.remove();
        }
        System.out.println(list);
        while(it.hasPrevious())
        {
        	System.out.println(it.previous());
        }*/
        for(int i:list)
        {
        	if(i<3)
        		list.remove(i);
        	System.out.println(i);
        }
//        for(int i=0;i<list.size();i++)
//        {
//        	int ii=list.get(i);
//        	if(i<3)
//        		list.remove(i);
//        	System.out.println("인덱스 4번 삭제");
//        }
	}

}