/*
 *  1. 난수 (1~100)
 *  2. 문제 발생
 *    => 몇번 수행
 *    => 무한루프 
 *    3. for문 수행 (x)
 *      => if / switch
 *      
 *      어디부터 시작 int i=1.. : 초기값
 *      어디까지 i<=10 :조건식
 *      반복횟수 i++ : 증감식
 *      반복 수행 문장
 *       => for(초기값;조건식;증감식)
 */

import java.util.Scanner;

public class 반복문_4 {
 public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	// 난수 발생
	int com=(int)(Math.random()*100)+1; 
	for(;;)
	{
		//사용자 입력 값
		System.out.println("1~100 사이의 정수를 입력:");
		int user=scan.nextInt();
		// 오류발생
		if(user<1 || user>100)
		{
			System.out.println("잘못된 입력입니다.");
			continue; // 처음부터 다시 시작 => 증가식으로 이동
		}
		
		//비교
		if(com>user)
		{
			System.err.println("큰 수를 입력하세요.");
		}
		else if(com<user)
		{
			System.err.println("작은 수를 입력하세요.");
		}
		else
		{
			System.err.println("정답입니다.");
			break; //종료
		}
		System.out.println("종료.");
	}
}
}
