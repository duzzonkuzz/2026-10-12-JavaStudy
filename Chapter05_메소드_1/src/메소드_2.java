import java.util.*;
public class 메소드_2 {
  static int plus(int a,int b)
	{
		return a+b;
	}
 static int minus(int a,int b)
	{
		return a-b;
	}

 static int gop(int a,int b)
	{
		return a*b;
	}

 static String div(int a,int b)
	{
		if(b==0)
			 return "0으로 나눌 수 없다";
		else
			 return String.valueOf(a/(double)b);
	}
 static void process()
 {
	 Scanner scan=new Scanner(System.in);
	 System.out.println("첫번 째 정수 입력:");
	 int a=scan.nextInt();
	 System.out.println("두번 째 정수 입력:");
	 int b=scan.nextInt();
	 
	 System.out.println("연산자 입력:");
	 switch(scan.next())
	 {
	 case "+" -> System.out.println(a+"+"+b+"="+plus(a,b));
	 case "-" -> System.out.println(a+"-"+b+"="+minus(a,b));
	 case "*" -> System.out.println(a+"*"+b+"="+gop(a,b));
	 case "/" -> System.out.println(div(a,b));
	 }
 }


public static void main(String[] args) {
	process();
	메소드_1.process();
}
}