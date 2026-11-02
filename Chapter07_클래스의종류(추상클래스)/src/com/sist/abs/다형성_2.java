package com.sist.abs;/*
 *    1. 모든 클래스 (라이브러리,사용자 정의) 
 *       => Object로부터 상속을 받는다 
 *          ------ 최상위 클래스 
 *    2. 상위 클래스 이용 
 *           동물 
 *            |
 *        --------------
 *        |     |      |
 *       개     소     말 
 *       => 여러개의 클래스를 한개로 모아서 처리
 *       => 관련된 클래스 
 */
class AA
{
	int a,b;
	public void aaa() {
		System.out.println("A:aaa() Call...");
	}
}
class BB extends AA
{
	// int a, b , aaa()
	int c;
	public void bbb() {
		System.out.println("B:bbb() Call...");
	}
}
public class 다형성_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        BB bb=new BB();
        
	}

}