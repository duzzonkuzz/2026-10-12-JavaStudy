import java.util.Scanner;

/*
 * if 조건에 맞는 경우에만 수행 => 상세보기 / 입력이 안된 경우 아이디중복 우편번호
 * if else /// if 조건 else => 웹에서 사용 / 로그인 
 * if else if (다중 조건) 여러 조건을 순서대로 검사 = menu 네트워크
 * switch 변수에 값에 따라 선택 => 여러가기 중에 한개만 실행
 */
public class 선택문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan=new Scanner(System.in);
System.out.println("첫번째 정수 입력:");
int num1=scan.nextInt();
System.out.println("두번째 정수 입력:");
int num2=scan.nextInt();

System.out.println("연산자 입력");

switch(scan.next())
{
case "+" -> System.out.println(num1+"+"+num2+"="+(num1+num2));
case "-" -> System.out.println(num1+"-"+num2+"="+(num1-num2));
case "*" -> System.out.println(num1+"*"+num2+"="+(num1*num2));
case "/" -> {
	switch(num2) {
	case 0 -> System.out.println("0으로 나눌 수 없다.");
	default -> System.out.println(num1+"/"+num2+"="+(num1/num2));
	}
}
	default -> System.out.println("없는 연산자 입니다.");

}
	}

}
