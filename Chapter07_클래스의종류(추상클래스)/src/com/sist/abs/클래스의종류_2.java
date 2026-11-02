package com.sist.abs;
/*
 *    객체지향 프로그램 : 조립식 (CBD)
 *                    Component : 부품 => class 
 *                                ---- 업그레이드 / 수정 
 *                                     | 오라버이딩 
 *    1. 목적 => 재사용 :  80년대 => HW / SW 
 *                                    | 모방 
 *                                | 집적회로 
 *               | => 있는 그대로 사용 / 변경해서 사용 / 새로운 기능 추가 
 *                    | 포함 클래스     | 상속(오버라이딩) | 오버로딩 
 *    2. 이미 사용중인 프로그램 : 신뢰성이 좋다 (검증을 거친 상태) 
 *    3. 대규모 프로젝트 => 재사용 (자바, C# , C++ , MFC) 
 *       예) 안산 시청 =====> 서울 시청 
 *    4. 상속 : 일반 클래스 / 추상 클래스 / 인터페이스 
 *                           |          |
 *                           ------------
 *                             | 무조건 상속을 받아서 사용 
 *       => 구분 (라이브러리) : new의 사용여부 
 *       
 *       기존의 클래스 (라이브러리 , 사용자 정의)의 기능(메소드)을 받아서 재사용 
 *                             | 데이터베이스 
 *                               => 연결 
 *                               => 처리 
 *                               => 연결해제
 *                              ------------- MyBatis / JPA
 *                              500 => 120 => 15 
 *                              => 	import 
 *       추상클래스 : extends => 단일 상속
 *       인터페이스 : implements => 다중 상속 
 *       -------- 라이브러리에서 지원하는 인터페이스를 주로 사용 
 *       | 메소드 기능이 같다 / 구현하는 내용이 클린 경우 
 *         예) 
 *             버튼 : click()
 *              => 로그인 / 계산기 / 회원 가입 / 페이지 버튼 
 *              => 기능 설계 => 개발 속도가 빠르다 (요구사항) 
 *     => 추상 클래스의 형식
 *            -----
 *            | 모든 클래스에 접근이 가능하게 설계 
 *              public class 
 *            | [접근지정어] abstract class ClassName
 *              {
 *                  -----------------
 *                   변수 / 상수 
 *                  -----------------
 *                   생성자 
 *                  -----------------
 *                   메소드 : 구현이 안된 메소드 = 선언만 된 메소드
 *                           => 공통 기반 : 구현 내용이 다른 경우  
 *                           => 메모리 할당이 불가능 => 상속을 내려서 사용 
 *                              --------------- new 사용이 불가능 
 *                  -----------------
 *                   메소드 : 구현이 된 메소드 = 일반 메소드 동일 
 *                           => default => 선택 
 *                  -----------------
 *                   => 유지보수 : 기능 추가 
 *                      ----------------> 반드시 구현된 메소드를 만든다 
 *                      *** 인터페이스 : 고정 
 *                      *** 1.8 => 구현된 메소드 추가가 가능 
 *                          default 메소드 
 *              }
 *              
 *              => 여러개의 관련된 클래스를 묶어서 관리 
 *              => int a1~a1000; 
 *                 int[] arr=new int[1000]
 *                       ---
 *              => 클래스는 추상클래스 / 인터페이스를 이용한다 
 *       추상클래스는 접근지정어 사용이 가능 
 *          변수 : private / public ...
 *          => 인터페이스는 only public 
 *          
 *          interface A
 *          {
 *              int a; (X)
 *              (public static final) int a=10; // 상수
 *              (public abstract) void display();
 *          }
 */
import java.util.*;

public class 클래스의종류_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //Scanner scan=new Scanner(System.in);
        //Calendar cal=Calendar.getInstance();
		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("쓰레드 실행");
			}
		};
		new Thread(r).start();
		
		Runnable rr=()->{
			System.out.println("쓰레드 실행");
		};
		new Thread(rr).start();
	}

}