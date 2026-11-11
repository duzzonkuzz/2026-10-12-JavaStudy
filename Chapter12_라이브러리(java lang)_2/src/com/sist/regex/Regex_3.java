package com.sist.regex;

/*
 *    ^ 시작   => ^홍   ^[A-Z] 대문자 시작 , [^A-Z] 대문자 제외 
 *    $ 끝    => 동$ [A-Z]$  , [A-C]$ A,B,C
 *    맛있고 맛있게 .....
 *    ----------------
 *    
 *    WHERE s LIKE '%맛있고%' OR ... 
 *    A B C D E 
 *    
 *    WHERE REGEXP_LIKE(s,'[A-E]')
 *    
 */
public class Regex_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("h##llo".matches("h..llo"));
        // . 한글자 => 모든 문자 (알파벳, 한글 , 특수문자 , 숫자)
        // 오라클 => _ h__llo 
        System.out.println("안녕하세요".matches("....."));
        System.out.println("홍길동".matches("^홍[가-힣]+"));
        // * 
        System.out.println("Hefgdgdgdgdgllo".matches("H[A-Za-z]*llo"));
        // H* HH HHH HHH
        System.out.println("sflsafaklfalfo".matches("s.*o$"));
        System.out.println("d".matches("."));
        
	}

}