package com.sist.set;
//Set<> set=new HashSet<>
//List<> list=new ArrayList<>()
//=> 메소드를 통일할 수 있다 
/*
*    Set set=new HashSet()
*    set=new TreeSet()
*/
import java.util.*;
public class set_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Set<Integer> set=new HashSet<Integer>();
     List<Integer> list=new ArrayList<Integer>();
     // <클래스형> 제네릭 : 데이터을 통일 => 변경 => 기본형은 사용이 불가능 => Wrapper
     Random rand=new Random();
     for(int i=0;i<10;i++)
     {
     	int r=rand.nextInt(10)+1; // 1~10 사이의 숫자 추출 
     	//   0~99
     	set.add(r);
     	list.add(r);
     }
     System.out.println("set에 저장된 갯수:"+set.size());
     System.out.println("list에 저장된 갯수:"+list.size());
     System.out.println("======= set에 저정된 데이터 출력 ======");
     for(int i:set)
     {
     	System.out.print(i+" ");
     }
     System.out.println("\n====== list에 저정된 데이터 출력 ======");
     for(int i:list)
     {
     	System.out.print(i+" ");
     }
     System.out.println("\n====== set 검색 =======");
     // set에서 검색 
     for(int i:set)
     {
     	if(i<5)
     		System.out.print(i+" ");
     }
     System.out.println("\n====== set 검색 ======");
     for(int i:set)
     {
     	if(i>5)
     		System.out.print(i+" ");
     }
     // 데이터가 많으면 속도가 늦다 
     // => TreeSet 
     

	}

}