package com.sist.set;
//TreeSet : 검색 / 통계 
import java.util.*;
/*
*    class A
*    {
*       aaa()/bbb()/ccc()
*    }
*    class B extends A
*    {
*       ddd()/eee()
*    }
*    
*    A a=new B() => aaa bbb ccc
*    B b=new B() => aaa bbb ccc ddd eee
*    
*    // 같은 종류의 클래스 => 한개로 제어
*/
public class Set_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     TreeSet<Integer> tSet=
     		   new TreeSet<Integer>();
     HashSet<Integer> hSet=
     		   new HashSet<Integer>();
     /*
      *    상속 
      *      상속을 내리는 클래스 : 내리기만 한다 
      *      상속을 받은 클래스 => 새로운 기능에 접근이 불가능 
      *      클래스 / 인터페이스 => 클래스의 일종 
      *      | 단일   | 다중 
      *        extends implements 
      *        
      *      Set 
      *       |
      *     TreeSet :  자체 검색과 관련된 메소드 
      *     
      *     Set set=new TreeSet()
      *                 ---------- 메소드 사용이 불가능 
      */
     for(int i=0;i<10;i++)
     {
     	int r=(int)(Math.random()*100)+1;
     	tSet.add(r);
     	hSet.add(r);
     }
     
     System.out.println("====== HashSet에 저장된 데이터 =======");
     for(int i:hSet)
     {
     	System.out.print(i+" ");
     }
     System.out.println("\n====== TreeSet에 저장된 데이터 =======");
     for(int i:tSet)
     {
     	System.out.print(i+" ");
     }
     System.out.println("====== TreeSet 검색 ======");
     System.out.println("50보다 작은 수:"+tSet.headSet(50));
     System.out.println("50보다 큰은 수:"+tSet.tailSet(50));
	}

}