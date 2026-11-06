package com.sist.lang;
/*
 *    라이브러리 
 *      = java.lang : 프로그램에서 가장 많이 사용되는 기본이 되는 클래스 집합 
 *                    ** 특징은 import를 생략할 수 있다
 *        : Object = 모든 클래스의 최상위 클래스
 *                   ** 라이브러리에서 제공하는 클래스 
 *                      + 사용자 정의 클래스 =======> Object상속을 받고 있다 
 *        : String = 문자열 저장 / 문자열 제어 
 *                   ** char[] 제어 
 *        : StringBuffer / StringBuilder => 문자열을 빠르게 만든 클래스 
 *          | 비동기         | 동기화
 *        : Wrapper : 기본형 데이터형을 클래스화 시킨 클래스의 집합 
 *          int = Integer 
 *          long = Long 
 *          double = Double 
 *          float = Float 
 *          boolean = Boolean
 *        : Math => 수학과 관련 클래스 
 *        : System : 화면 출력 / 키보드 읽기 / 동작 시간 / 가비지 컬렉션 
 *       ---------------------------------------------------------
 *       라이브러리 => 표준화
 *          1) 패키지 
 *          2) 클래스명 = 뭐하는 역할 
 *          3) 메소드명 = 기능
 *          4) 리턴형 = 결과값 
 *          5) 매개변수 = 어떤 값을 주는지 
 *          6) 예외처리 존재여부
 *          -------------------------------- 메소드 원형 
 *      = java.util 
 *      = java.text
 *      = java.util.reflect
 *      = java.io 
 *      = java.net 
 *      = java.sql 
 *      ---------------- J2SE : 기본 라이브러리 
 *      = J2EE : 웹 사이트 라이브러리 
 *      = Spring 라이브러리 
 *      
 *   java.lang => 
 *       Object : 모든 클래스는 Object로 부터 상속을 받는다 
 *                          ----------------- Object가 가지고 있는 모든 기능을 사용할 수 있게 만든다
 *       public class A (extends Object)
 *       {
 *       }
 *       
 *       import java.lang.* 
 *       
 *       public void display()
 *       {
 *          ...
 *          return;
 *       }
 *       
 *       public class A
 *       {
 *          public A(){}
 *       }
 *       
 *       public class A
 *       {
 *          int a;
 *          double d;
 *          String s:
 *          boolean b;
 *       }
 *   
 *       Object => 주요 메소드 
 *       1. 소멸자 : 객체 메모리 해제 
 *          class A
 *             => A() 
 *             => ~A() => finalize()
 *       2. 객체 복제 기능 : clone() 
 *           => 같은 값을 가지고 있는 객체 메모리를 복사해서 새로운 메모리 생성 
 *                                                 --------------
 *                                                 깊은 복사 
 *           => Spring => prototype 
 *       3. toString() : 객체를 문자열화 
 *                       오버라이딩중에 가장 많이 사용 (생략이 가능)
 *       4. getClass() : 객체를 얻어오는 메소드 (객체 정보)
 *       5. equals() : 객체 비교 
 *       6. hashCode() : 객체 구분자 
 *       
 *       => 홍길동 20 개발자 서울 마포구 new 
 *       => 홍길동 20 개발자 서울 마포구
 */
class A
{
	String name;
	public A(String name)
	{
		this.name=name;
	}
}
public class 라이브러리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        A a=new A("홍길동");
        A b=new A("홍길동");
        System.out.println(a.hashCode()+","+a);
        System.out.println(b.hashCode()+","+b);
        if(a.equals(b))
        {
        	System.out.println("같다");
        	
        }
        else
        {
        	System.out.println("다르다");
        }
	}

}