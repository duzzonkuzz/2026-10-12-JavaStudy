package com.sist.set;
import java.util.*;
//Random => 원하는 부분의 난수 발생이 가능 => nextInt(100) 
public class Set_6 {
	public static void main(String[] args) {
		Set<Integer> set=new HashSet<Integer>();
		Random r=new Random();
		for(int i=0;i<10;i++)
		{
			int k=r.nextInt(100)+1;
			set.add(k);
		}
		TreeSet<Integer> tSet=new TreeSet<Integer>();
		tSet.addAll(set);
		System.out.println("==전체데이터==");
		System.out.println(tSet);
		System.out.println("==50이상==");
		System.out.println(tSet.tailSet(50));
		System.out.println("==50이하==");
		System.out.println(tSet.headSet(50));
		System.out.println("==바로 위에 값==");
		System.out.println(tSet.higher(30));
		System.out.println("==바로 밑에 값==");
		System.out.println(tSet.lower(30));
		System.out.println(tSet.lower(30));
		System.out.println("==같거나 큰 값==");
		System.out.println(tSet.ceiling(50));
		System.out.println("==작거나 큰 값==");
		System.out.println(tSet.floor(50));
		
	}
}
