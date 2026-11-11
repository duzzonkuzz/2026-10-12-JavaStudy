package com.sist.lang;
/*   System 
*     1) 프로그램 종료 
*        System.exit(int code) 
*                   ----------
*                   1. 0 ==========> 정상 종료 
*                   2. 0이 아닌 경우 ===> 비정상 종료
*                   3. 윈도우 종료 (웹에서는 사용하지 않는다) 
*                                | = 브라우저 종료 
*     2) 표준 입출력 
*        System.in
*        System.out 
*        
*        => in : InputStream() 
*                키보드 입력값 받기 
*                => System.in.read() 
*        => out : OutputStream()
*                화면 출력 
*                System.out.print() => 가로 (\n미포함)
*                System.out.println() => 세로 (\n)
*                System.out.printf() => 출력 형식을 만들어서 데이터 출력 
*                       %d , %s , %f , %c
*                                     -- 문자
*                                --실수
*                            -- 문자열
*                       --정수
*                => 일반 문법 
*     3) 메모리 회수 => heap에 있는 데이터 저장 메모리 회수 
*        System.gc() : 가비지 컬렉션 
*        
*     4) 시간 측정 
*        System.currentTimeMillis() 
*        => 웹 = 로그파일 
*     ------------------------------ static메소드
*/
public class System_1 {
  public static void main(String[] args) {
	  // exit() => 프로그램 종료 => 윈도우
	  int a=5;
	  for(int i=1;i<=10;i++)
	  {
		  if(i==a)
		  {
			  System.out.println("프로그램 종료");
			  System.exit(0); // 윈도우 창을 종료 => 완전 종료
			  //break; => for문 종료
		  }
		  System.out.println("i="+i);
	  }
	  System.out.println("시작");
	  System.out.println("GO");
  }
}