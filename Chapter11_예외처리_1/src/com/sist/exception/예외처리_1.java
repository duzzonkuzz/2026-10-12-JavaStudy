package com.sist.exception;

import java.io.IOException;

/*
 *   class MyException extends Exception
 *   {
 *       public MyExeption(String msg)
 *       {
 *           super(msg);
 *       }
 *   }
 *   예외처리 
 *   1) 종류 
 *      직접처리 : try ~ catch ~ finally
 *                             | 자원 관리 / 파일,서버,데이터베이스 => close
 *                             | 생략이 가능 
 *                     | 에러 처리 / 복구 / 에러 확인 
 *               | 정상 수행 코드           | = getMessage() / printStackTrace()
 *        = catch를 여러개 사용이 가능 => 반드시 크기가 작은 순으로 
 *                                   ---------
 *                                   | 상속과정 
 *                    Object 
 *                      |
 *                    Throwable 
 *                      |
 *                ---------------
 *                |             |
 *              Error          Exception
 *                              |
 *               CheckedException            UnCheckedException
 *               예외처리 필수                    선택 
 *              --------------------------------------------
 *              |                                          |
 *           IOException                              RuntimeException
 *             => 파일 관련                                  | 한개만 예외처리 
 *           InterruptedException                     ArrayIndexOutOfBoundsException
 *             => 쓰레드                                NullPointerException 
 *           MalformedURLException                    NumberFormatException
 *             => Network  (Jsoup)                           ClassCastExeption 
 *           ClassNotFoundExeption                    ArithmeticException
 *             => 리플렉션  
 *           SQLException
 *             => 오라클  
 *           MyException
 *      try ~ catch => 에러 복구 (가장 많이 사용되는 예외처리)
 *           try
 *           {
 *              => 정상 수행하는 문장 
 *           }
 *           catch(예외클래스)
 *           {
 *              => 예외처리후 복구 
 *           }
 *           
 *      간접처리 : 예외 회피 => 시스템에 전담 => 선언(예외가 발생할 수 있다)
 *                       => 처리는 호출하는 메소드에서 처리 
 *                          ------------------------ 예외 떠넘기기
 *                       => 소스가 복잡한 경우 : 이미 만들어진 소스 
 *      public String display() throws 예외처리클래스
 *      {
 *        String s="";
 *        try
 *        {
 *          ...
 *          ...
 *          ...
 *          ...
 *          ...
 *          ...
 *        }catch(예외클래스)
 *        {
 *        }
 *        return s;
 *      }
 *      ==> try
 *          {
 *             for()
 *             {
 *             }---
 *                |
 *          }catch()
 *          {
 *          }
 *          
 *          for()
 *          {
 *            try
 *            {
 *            }catch()
 *            {
 *            }
 *          }
 *      => 라이브러리에서 주로 나온다 
 *         sleep(long m) throws InterrupedException
 *      임의발생 / 사용자 정의
 *        테스팅 ==> throw 
 *        사용법 
 *          throw new 예외생성자()
 *          -----
 *        => 사용자 정의 예외처리 => 자바 JVM 인식을 못한다 
 *            => throw를 이용해서 호출 
 *        ------------------------------------------
 *        에러 발생 
 *        -------
 *          1. 프로그래머 실수
 *             => 초기값이 없는 상태 
 *             => 배열 인덱스 오류 
 *             => 무한 루프 
 *             => 파일명 / URL / IP
 *          2. 사용자 오류          
 *             => 입력 
 *             => 유효성 검사 
 *        ------------------------- 예외처리를 이용해서 => 견고한 프로그램 
 *             => 비정상를 방지 => 사전 에러를 차단 
 *        1. 처리시에는 
 *           고려할 점 : if문을 먼저 생각 
 *                     => 멤버변수의 초기화 => 명시적 초기화 
 *                     if문으로 처리가 불가능 => 예외처리 
 *                     UTF-8 / UFT-8
 *           => 웹 : 404 , 500 , 415 , 400 , 403 
 *        2. 예외의미 => 프로그램 돌발적으로 문제가 발생 
 *                            ----- 의도하지 않는 상황 
 *                    => 사전에 방지 / 정상적으로 수행 
 *      ---------------------------------------------------
 *      throws : 간접 처리 => JVM에 맡긴다 
 *               | 복구가 불가능 => 건너뛴다 
 *      형식) 
 *            method() throws 예상되는 예외처리 클래스 , 예상되는 예외처리 클래스...
 *                            ------------------------------------------
 *                             순서는 없다 
 *              | 메소드를 사용하려면 반드시 예외처리후에 사용한다 
 *      예외 떠넘기기 => 라이브러리 메소드 
 *      
 *      => 예외처리후 사용 : try ~ catch 
 *      => 예외 떠넘긴다 : throws 
 *      
 *      void method() throws IOException 
 *      
 *      void method1() 
 *      {
 *         try
 *         {
 *            method();
 *         }catch(IOException  i){}
 *      }
 *      
 *      void method2() throws IOException 
 *      {
 *         method(); => 오류 
 *      }
 *      
 *      void display() throws RuntimeException 
 *      
 *      void display1(){
 *        display();
 *      }
 *                   
 *   
 *   
 *      예외 던지기 
 *        =>  테스트 목적 (배포)
 *        형식) 
 *             throw new 예외클래스 생성자()
 *                   ------------------- catch호출이 가능 
 *                   
 *     -------------------------------------
 *     # throws는 예외를 처리하는 것이아니다 
 *       예외가 발생할 수 있다는 사실을 메소드에게 알려만 준다 = 위임을 내려준다 
 *       => 예외 떠넘기기 
 *       
 *     # 예외가 발생이 가능성이 있는 메소드를 사용한자 
 *     # 예외를 직접 처리하지 않는다 
 *     # 메소드를 호춯출하는 곳에서 예외를 넘겨준다 
 *     ----------------------------------------
 *     try : 예외가 발생할 수 있는 코드가 들어가는 부분 
 *     catch : 발생한 예외를 처리하는 역할 
 *     finally : 자원 관리 => 닫기 
 *     throw : 예외를 직접 발생 
 *     throws : 예외처리를 호출한 곳에 위임한다 
 *  
 */
import java.util.Scanner; 
public class 예외처리_1 {
    public static void display() throws Throwable,IOException,ClassNotFoundException,InterruptedException
    {
    	System.out.println("display() Call...");
    }
    // RuntimeException < Exception < Throwable 
    // IOException < Exception < Throwable
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		/*
		 * for(int i=1;i<=10;i++) { try { int a=(int)(Math.random()*3);
		 * System.out.println(i+":"+(i/a)); }catch(Exception e) {} }
		 */
		/*try
		{
		  display();
		}catch(Throwable e) {}*/
		 // 통합 
		//catch(IOException e) {}
		//catch(ClassNotFoundException e) {}
		//catch(InterruptedException e) {}
		/*
		 * int a=10; try { if(a%2==0) { throw new Exception("홀수만 가능"); // -catch이동 // 소스
		 * 코딩 불가 임의로 예외 발생 => 견고 (테스트) } }catch(Exception ex) {
		 * System.out.println("catch 수행"); System.out.println(ex.getMessage()); }
		 */
		Scanner s=new Scanner(System.in);
		System.out.print("정수 입력:");
		int a=s.nextInt();
		try
		{
		  if(a%2==0)
		  {
			 System.out.println("예외를 임의의로 발생");
			 throw new Exception("홀수만");
		  }
		  /*
		   *   class My extends Exception
		   *   {
		   *      public My(String msg)
		   *      {
		   *         super(msg);
		   *      }
		   *   }
		   */
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
