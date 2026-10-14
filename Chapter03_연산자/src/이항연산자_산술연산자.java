/*/
 *   피연산자가 2개인 경우
 *   -----
 *   5 + 10 => 이항연산자
 *   
 *   + - *    / %
 *   
 *   +. 산술 기능
 *      문자열 결합
 */

//import java.util.Scanner;  //입력값 받는 경우

/*/
 *  Scanner 는 클래스다
 *  1) 클래스를 읽어 온다
 *   import java.util.Scanner;
 *   => 라이브러리 사용시 
 *  2) 사용하기 위한 메모리에 저장
 *    Scanner scan=new Scanner(System.in)
 *              클래스 변수 => 객체 (키보드 입력값)
 *  3) 사용자 입력 
 *   1. 정수
 *   2. 실수
 *   3. 문자열
 *   4. 논리
 *              
 *    참조
 *      package 
 */

//import java.util.Scanner;

import java.util.Scanner;

public class 이항연산자_산술연산자 {

	public static void main(String[] args) {
//		Scanner scan=new Scanner(System.in);
		
	//정수 2개 받기 => enter / space 
//		System.out.print("정수 두개 입력:");
//		int a=scan.nextInt();
//		int b=scan.nextInt();
//		
//		System.out.println("a="+a);
//		System.out.println("b="+b);
//		
//		
//		System.out.println("===== + 결과 =====");
//		System.out.println(a+b);
//		System.out.println("===== + 결과 =====");
//		System.out.println(a-b);
//		System.out.println("===== + 결과 =====");
//		System.out.println(a*b);
	
//		int a=10;
//		int b=3;
//		System.out.println(a/(double)b);
//		System.out.printf("%d / %d = %.2f", a,b,a/(double)b);
		
		Scanner scan=new Scanner(System.in);
		
		
		System.out.println("국어 점수 입력");
		int kor=scan.nextInt();
		
		System.out.println("영어 점수 입력");
		int eng=scan.nextInt();
		
		System.out.println("수학 점수 입력");
		int math=scan.nextInt();
		
		int total=kor+eng+math;
		double avg=total/3.0;
		
		System.out.println("===결과===");
		System.out.println("총점"+total);
		System.out.printf("평균:%.2f",avg);

		// println 다음줄
//	       print 옆에
//	       f 값
//		
		
		
		
		
		
		
		
		
		
		
		
	}
}
