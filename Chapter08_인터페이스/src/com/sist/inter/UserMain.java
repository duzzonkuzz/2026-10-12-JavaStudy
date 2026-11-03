package com.sist.inter;
import java.util.*;
public class UserMain {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("메뉴 선택:(게시판=1,회원가입=2,로그인=3,목록출력=4,상세보기=5)");
	int menu=scan.nextInt();
	Map map=new HashMap();
	map.put("1", new 게시판());
	map.put("2", new 회원가입());
	map.put("3", new 로그인());
	map.put("4", new 맛집목록());
	map.put("5", new 맛집상세보기());
	 Execute e=(Execute)map.get(String.valueOf(menu));
	 e.execute();
	
//	if(menu==1)
//	{
//		게시판 a=new 게시판();
//		a.execute();
//	}
//	if(menu==2)
//	{
//	    회원가입 a=new 회원가입();
//		a.execute();
//	}
//	if(menu==3)
//	{
//		로그인 a=new 로그인();
//		a.execute();
//	}
//	if(menu==4)
//	{
//		맛집목록 a=new 맛집목록();
//		a.execute();
//	}
//	if(menu==5)
//	{
//		맛집상세보기 a=new 맛집상세보기();
//		a.execute();
//	}
}
}
