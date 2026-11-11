package com.sist.regex;
//? => 0회 , 1회가 있는 경우 
//color => colou?r

public class Regex_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println("color".matches("colo?r"));
     System.out.println("colour".matches("colou?r"));
     System.out.println("colouur".matches("colou?.r"));
     System.out.println("cat".matches("c?a?t?"));
     System.out.println("".matches("c?a?t?"));
     
     // 문자 집합 [] => [abc] => a|b|c => [(abc)] => abc
     // [asfkop] => 그대로 사용 
     // [abcdef] => [a-f]
     // [가-힣]{5} => 한글이 5글자 
     // [가-힣]{3,5} => 3,4,5
     // => AI (데이터 수집 = 데이터분석) 
     
	}

}