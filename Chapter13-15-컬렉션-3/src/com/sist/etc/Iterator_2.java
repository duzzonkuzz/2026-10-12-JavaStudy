package com.sist.etc;
import java.util.*;
public class Iterator_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Set<String> set=new HashSet<String>();
        set.add("사과");
        set.add("배");
        set.add("포도");
        set.add("바나나");
        set.add("참외");
        
        Iterator<String> it=set.iterator();
        while(it.hasNext())
        {
        	System.out.println(it.next());
        }
        // set/map => iterator이 더 많이 사용 
	}

}