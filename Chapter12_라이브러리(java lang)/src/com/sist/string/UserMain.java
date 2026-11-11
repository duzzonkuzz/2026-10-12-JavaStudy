package com.sist.string;

import java.util.*;
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        GenieMusic gm=new GenieMusic();
        while(true)
        {
        	System.out.println("===============카테고리============");
        	System.out.println("1. Top50");
        	System.out.println("2. 가요");
        	System.out.println("3. POP");
        	System.out.println("4. OST");
        	System.out.println("5. 트롯");
        	System.out.println("6. ZAZZ");
        	System.out.println("7. CLASSIC");
        	System.out.println("9. EXIT");
        	System.out.println("=================================");
        	System.out.print("카테고리 선택:");
        	int cno=scan.nextInt();
        	if(cno==9)
        	{
        		System.out.println("프로그램 종료");
        		System.exit(0);
        	}
        	gm.getData(cno-1);
        }
	}

}