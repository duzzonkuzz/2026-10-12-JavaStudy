import java.util.Scanner;

public class 반복문_9 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("정수 입력:");
		int num=scan.nextInt();
		
		int sum=0;
		for(int i=1;i<=num;i++)
		{
			sum+=i;
		}
		System.out.println(sum);
		
		/*
		 *  반복문
		 *   초기값 : 어디부터 시작
		 *   조건식 : 어디까지 
		 *   증가식 : 몇번 수행
		 *   ---------
		 *   어떤 문장을 수행
		 *   
		 *   자바에서 지원하는 모든 제어문은 한문장만 수행한다
		 *    => 여러 문장 사용시에는 {}
		 */
		
	
	}
}
