/*/
 *  제어문 
 *   1) 사용 목적
 *      조건에 따라서 코드를 다르게 실행이 가능하게 만든다.
 *      => 같은 작업을 반복, 반복 실행을 중단
 *      => 해당 조건 처리
 *      1) 조건에 따라 실행
 *         => if / switch
 *            회원 / 비회원
 *      2) 같은 작업 방문
 *        for / while / do~while
 *                         | 반드시 한번 이상을 수행
 *               |반복 횟수가 없는 경우 => DataBase 
 *        | 반복횟수가 지정 => 화면 출력
 *        
 *      3) 반복수행 중단 / 정지
 *        break / continue
 *                   | 특정 부분을 제외
 *         | 종료 => ESC
 *         
 *         --------------
 *         **if
 *         **if~else
 *         if~else if~else if
 *         switch 
 *         **for 
 *         ------- 조건에 따라 선택하는 문장
 *         **while
 *         do~while
 *         ----- 반복 수행이 많은 경우
 *         **break
 *         continue
 *         ------- 반복을 변경
 *         
 *         조건문 
 *          = 단일 조건문
 *            형식)
 *                 if(조건문)
 *                     | 반드시 true/false => 부정연산자 / 비교연산자 / 논리연산자만 사용이 가능
 *                 {
 *                     조건이 true 일 경우에 수행 문장
 *                     ** false 면 수행하지 않고 건너뛴다
 *                     }
 *                     => 독립적이다 => 속도가 늦다
 *          = 선택 조건문
 *          = 다중 조건문
 */

// 컴퓨터와 가위바위보 (0,1,2)
 import java.util.Scanner;
 //사용자 => 정수 입력 => 적수 / 홀수
 //  num%2==0
public class 제어문종류 {
	public static void main(String[] args) {
		 Scanner scan=new Scanner(System.in);
		 System.out.println("정수 입력:");
		 // 입력된 값 받기
		 int num=scan.nextInt();
		 
		 /* 1) 정수 nextInt()
		  * 2) 실수 nextDouble()
		  * 3) 논리 nextBoolean()
		  * 4) 문자열 next() / nextLine()
		  * ***문자(x)
		  */
		 //모든 제어문은 {}이 없는 경우 바로 밑에 있는 1개의 문장만 제어
		 // 문장이 여러개면 {} => 기본 
		if(num%2==0)
		{
			System.out.println("num값은"+num);
			System.out.println(num+"은 짝수입니다");
		}
		if(num%2!=0)
		{
			System.out.println("num값은"+num);
			System.out.println(num+"은 홀수입니다");
		}
		
		
		
		
		
		
		
		
		
		
		
		 
	}

}
