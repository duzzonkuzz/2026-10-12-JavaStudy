
  /*
   * 여러개의 경우의 수(조건) => 메뉴
   * 형식)
   *         if(조건)
   *         {
   *           1. 조건 true => 실행 문장 수행 ===> 종료
   *           2. 조건 fasle 
   *                 | 다음 조건으로 내려간다
   *           
   *         }
   *         else if(조건)
   *         {
   *           1. 조건 true => 실행 문장 수행 ===> 종료
   *           2. 조건 fasle 
   *                    | 다음 조건으로 내려간다
   *         }
   *          else if(조건)
   *         {
   *          1. 조건 true => 실행 문장 수행 ===> 종료
   *           2. 조건 fasle 
   *                    | 다음 조건으로 내려간다
   *         }
   *         else
   *         {
   *            해당 조건이 없는 경우 처리되는 문장 => 생략이 가능
   *         }
   *         
   *         해당 조건 1개만 수행
   *         일반 if = 여러개 수행 가능
   *         
   *         데이터베이스 / 네트워크 서버
   *         | => 브라우저 
   */

import java.util.Scanner; // 사칙연산
public class 다중조건문_1 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("정수 입력:");
		int num1=scan.nextInt();
		
		System.out.println("정수 입력:");
		int num2=scan.nextInt();
		
		System.out.println("연산자 입력:");
		char op=scan.next().charAt(0);
		
		if(op=='+')
		{
		System.out.println(num1+num2+"="+(num1+num2));
		}
		else if(op=='-')
		{
			System.out.println(num1+num2+"="+(num1-num2));
		}
		else if(op=='x')
		{
			System.out.println(num1+num2+"="+(num1*num2));
		}
		else if(op=='/')
		{
			if(num2==0)
			{ System.out.println("0으로 나눌 수 없음");}
			
			else
			{
				System.out.printf("%d/%d=%.2f\n",num1,num2,num1/(double)num2);
				
			}
		
		}
		else
		{
		 System.out.println("연산자가 아님");
		}
		
		
		
		

		
	}

}
