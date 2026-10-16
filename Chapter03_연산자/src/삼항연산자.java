/*/
 *  삼항연산자 :: 소스를 간결하게 만드는 경우
 *  
 *  조건?값1:값2
 *  
 *  true => 값1
 *  false => 값2
 *  조건 => 부정연산자 / 논리연산자 / 비교연산자
 *  
 */

import java.util.Scanner;

public class 삼항연산자 {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("정수입력:");
		int num=scan.nextInt();
		
		System.out.println(num%2==0?"짝수":"홀수");
		
	}
	
	}
	


