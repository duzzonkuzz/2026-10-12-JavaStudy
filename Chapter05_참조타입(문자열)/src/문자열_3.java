// 변환
/*
 * toUpperCase()
 *  => 대문자 변환
 *  
 * toLowerCase()
 *  소문자 변환
 *  
 * replace() : 일반 문자
 *  문자 변경 문자열 변경
 *  
 * replaceAll() 정규식
 * 한글 전체 / 알파벳 전체 / 숫자 전체
 *    문자 변경 문자열 변경
 *    
 *    IP
 *      [0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}
 *    
 */

import java.util.Scanner;


public class 문자열_3 {

	public static void main(String[] args) {
//		Scanner scan=new Scanner(System.in);
//		System.out.println("알파벳 입력:");
//		String alpha=scan.nextLine();
//		/*
//		 * nextLine() ABCD EFG// 전체 ㅇㅇ
//		 * next() ABCD// EFG 공백 이후는 ㄴㄴ
//		 */
//		System.out.println(alpha.toUpperCase());
//		System.out.println(alpha.toLowerCase());
//		System.out.println(alpha);
//		
		String ms="Hello Java";
		System.out.println(ms.replace('a', 'b'));
		System.out.println(ms.replace("Java", "Oracle"));
		
		
		String s="ABCD가나다라1234";
		System.out.println(s.replaceAll("[가-힣]", ""));
		System.out.println(s.replaceAll("[A-Z]", ""));
		System.out.println(s.replaceAll("[0-9]", ""));
		System.out.println(s.replaceAll("[^가-힣]", ""));
		
		
		
		
		
		
		
		
	}
}