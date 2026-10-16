/*/
 *    사칙연산 (+ - *   / )
 *    ------------
 *    사용자 입력
 *     숫자 연산자 숫자 
 */
import java.util.Scanner;

public class 단일조건문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		System.out.println("첫번째 정수 입력:");
		int num1=scan.nextInt();
		System.out.println("두번째 정수 입력:");
		int num2=scan.nextInt();
		System.out.print("연산자 입력(사칙연산%)");
		char op=scan.next().charAt(0);
		// 스캐너는 캐릭터를 받을 수 없다 => 문자열로 받는다 "+" => '+'
		// abcd
		// 0123
		if(op=='+')
		{
			//%c char %s string %f double/float %d 정수
			System.out.printf("%d+%d=%d\n",num1,num2,num1+num2);
		
		
	}
		if(op=='-')
		{
			System.out.printf("%d-%d=%d\n",num1,num2,num1-num2);
		
	}

		if(op=='*')
		{
			System.out.printf("%d*%d=%d\n",num1,num2,num1*num2);
		
	}

		if(op=='/')
		{
			if(num2==0)
			{
				System.out.println("0으로 나눌 수 없음.");
			}
			if(num2!=0)
			System.out.printf("%d/%d=%.2f\n",num1,num2,num1/(double)num2);
	}
		if(op=='%')
		{
			System.out.printf("%d %% %d=%d\n",num1,num2,num1%num2);
		// %%
	}
		
	}
}

