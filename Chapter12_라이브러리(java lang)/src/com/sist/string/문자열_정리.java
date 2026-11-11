package com.sist.string;
/*
 *    라이브러리 (자바에서 지원) => String :  표준화 => 오버라이딩이 불가능 
 *                            ------- final 
 *    | String의 주요 메소드 
 *      -----------------
 *      1) 메소드명 
 *      2) 매개변수 
 *      3) 리턴형
 *      4) 어떤 기능 
 *     
 *     ***= length() :  문자의 갯수 
 *       int length() 
 *     ***= trim() : 공백문자 제거 
 *       String trim()
 *     ***= substring(int) 지정된 위치 => 마지막까지  
 *       substring(int,int) 지정위치 ~ 지정위치 
 *       
 *       String substring(int begin) 
 *       String substring(int begin,int end) 
 *       ------------------------------------ 오버로딩 
 *       
 *    ***=  indexOf : 지정된 문자의 위치 (앞에서부터 찾는다) 
 *       int indexOf(char c)
 *       int indexOf(String s) ("Java") ('J')
 *    
 *    ***=  lastIndexOf : 지정된 문자의 위치 (뒤에서부터 찾는다) 
 *       int lastIndexOf(char c)
 *       int lastIndexOf(String s) ("Java") ('J')
 *       => 인덱스번호 
 *       
 *    ***= contains : 포함된 단어 찾기 
 *      boolean contains(String s)
 *    = startsWith: 시작문자열 
 *      boolean startsWith(String s)
 *    = endWith : 끝 문자열 
 *      boolean endsWith(String s)
 *      
 *    ***= equals : 같은 문자열 (대소문자 구분) 
 *      boolean equals(String s)
 *    = equalsIgnoreCase() : 대소문자 구분없이 비교 
 *      boolean equalsIgnoreCase(String s)
 *    ***= valueOf : 모든 데이터형 문자열로 변환 
 *                => static 
 *      String valueOf(기본형) => int , long , char ....
 *    
 *    = split : 단어별 분리 
 *      String[] split(String regex) 
 *                     ------------- 정규식 => 단어 
 *      예) 맛있고 맛있는 맛있게 .....
 *    
 *    ***= replace() : 문자열 , 문자를 변경 
 *      String replace(char c, char c1)
 *      String replace(String s1,String s2)
 *    = replaceAll() : 정규식을 이용한 변경 
 *      String replaceAll(String regex,String s)
 *             [A-Za-z] [0-9] [가-힣] 
 *    = concat : 문자열 결합 
 *      String concat(String s)
 *      
 *      예)
 *         String s="Hello ";
 *         String ss=s.concat("Java")
 *         ss="Hello Java"
 *         ---------------------------
 *         
 *         String s="Hello ";
 *         s+="Java"
 *         ---------------------------
 *         
 *    
 *      
 */
public class 문자열_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}

}