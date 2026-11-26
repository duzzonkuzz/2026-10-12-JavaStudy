package com.sist.music;
import java.util.*;
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("선택 지니뮤직(1),멜론(2):");
        int select=scan.nextInt();
        MusicSystem ms=null; // 추상 / 인터페이스 
        // => 변수가 있는 경우 : 추상 클래스 => 인터페이스는 상수만 가지고 있다
        // 추상 => 공통으로 가지고 있는 
        if(select==1)
        {
        	ms=new GenieMusic();
        	ms.dataCollection();
        }
        else
        {
        	ms=new MelonMusic();
        	ms.dataCollection();
        }
        
        while(true)
        {
        	System.out.println("========== Menu ========");
        	System.out.println("1. 전체 목록");
        	System.out.println("2. 상세보기");
        	System.out.println("3. 검색");
        	System.out.println("4. 종료");
        	System.out.println("========================");
        	System.out.print("메뉴 선택:");
        	int menu=scan.nextInt();
        	if(menu==4)
        	{
        		System.out.println("프로그램 종료");
        		System.exit(0);
        	}
        	else if(menu==1)
        	{
        		ArrayList<Music> list=ms.musicAllData();
        		// 람다 
        		for(Music m:list)
        		{
        			System.out.println(m.getMno()+"."+
        		                       m.getTitle());
        		}
        	}
        }
	}

}