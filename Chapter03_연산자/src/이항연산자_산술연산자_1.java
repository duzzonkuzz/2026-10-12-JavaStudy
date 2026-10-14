import java.util.Scanner;
public class 이항연산자_산술연산자_1 {
	public static void main(String[] args) {
		System.out.println(5/2);
		System.out.println(5/2.0);
		int a=10;
		int b=0;
		System.out.println(b==0?"0으롷 나눌 수 없다":a/b);
		
		System.out.println("=======%=======");
		System.out.println("5%2"+5%2);
		System.out.println("5%-2="+5%-2);
		System.out.println("-5%2="+-5%2);
		
		int won=789;
		int w100=won/100;
		int w10=(won%100)/10;
		int w1=won%10;
		System.out.print(w100);
		System.out.print(w10);
		System.out.println(w1);
		
		// => 배수 구하기 / 날짜계산 
		
		Scanner scan=new Scanner(System.in);
		System.out.println("정수 입력:");
		int num=scan.nextInt();
		
		System.out.println(num%2==0?num+"은 짝수입니다":num+"은 홀수입니다");
		
	}

}
