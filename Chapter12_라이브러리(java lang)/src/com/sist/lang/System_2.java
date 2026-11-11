package com.sist.lang;

/*
 *    클래스명 => 역할 
 *    메소드명 / 매개변수 / 리턴형
 *    static / instance 
 *    ----------------------
 *    라이브러리는 제공 => 변경 / 추가하는 기능이 없다
 *    java.lang ==> final : 모든 개발자가 동일하게 사용 
 *    사용처 / 언제 사용 
 *    
 *    => 입력 / 출력 
 */
public class System_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	System.out.print("정수 입력:");
        	int num1=System.in.read(); // char => int 
        	// 예외처리를 반드시 사용
        	// 예) '1' => 49 , '0' => 48
        	System.out.println("num1="+(num1-'0'));
        	
        	System.in.read();//enter
        	
        	System.out.print("정수 입력:");
        	int num2=System.in.read();//enter => 13
        	
        	System.in.read();// 사용빈도가 거의 없다 => Scanner
        	System.out.println("num2="+num2);
        	
        	// BufferedReader 
        	
        }catch(Exception ex) {}
	}

}