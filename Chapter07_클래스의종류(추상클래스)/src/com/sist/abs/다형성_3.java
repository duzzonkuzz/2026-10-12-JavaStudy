package com.sist.abs;
/*
 *    객체 지향의 4대 특성 
 *    ----------------
 *    ***1. 캡슐화 : 데이터 보호 
 *    2. 상속 : 서로 다른 클래스를 한개의 클래스로 묶어서 관리 
 *             기존의 클래스의 내용(변수,메소드)를 가지고 온다 
 *             -------------------------------------
 *             | 변경해서 사용이 가능 : 오버라이딩 
 *    3. 다형성 : 오버로딩 / ***오버라이딩 
 *               메소드 추가 / 메소드 내용 변경 
 *    ***4. 추상화 : 공통적인 클래스를 묶어서 관리 
 *                 => 인터페이스 
 */
import java.util.*;
class 동물
{
	int a=100;
	public void run() {
		System.out.println("달린다");
	}
}
class 개 extends 동물
{
	int a=200;
	public void run() {
		System.out.println("개가 달린다");
	}
}
class 소 extends 동물
{
	int a=300;
	public void run() {
		System.out.println("소가 달린다");
	}
}
class 말 extends 동물
{
	int a=400;
	public void run() {
		System.out.println("말이 달린다");
	}
}
public class 다형성_3 {
    // new 사용전에 모든 클래스는 null값이다 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("동물 이름:");
        String ani=scan.next();
        
        동물 animal=null; // 기본 초기화 null(메모리 주소가 없는 상태)
        // 상위 클래스 이용시 => 변수호출 (클래스 타입) / 메소드 호출(생성자 타입) 
        switch(ani)
        {
        case "개":
        	animal=new 개(); // 동적바인딩 => 실행시마다 주소값을 변경 
        	break;
        case "말":
        	animal=new 말();
        	break;
        case "소":
        	animal=new 소();
        	break;
        }
        System.out.println(animal.a);
        animal.run();
	}

}
