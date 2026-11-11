package com.sist.string;
import java.util.*;
public class 문자열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        String color="red|green|blue|black|white";
        ///color.replaceAll("[가-힣]", "");
        String[] colors=color.split("\\|"); // String regex
        /*
         *     ^ : 제외 
         *     | : 선택 
         *     ? : 0,1
         *     + : 1개 이상 
         *     * : 0개 이상 
         *     . : 임의 한글자 
         */
        for(String c:colors)
        {
        	System.out.println(c);
        }
        StringTokenizer st=new StringTokenizer(color, "|");
        while(st.hasMoreTokens())
        {
        	System.out.println(st.nextToken());
        }
	}

}