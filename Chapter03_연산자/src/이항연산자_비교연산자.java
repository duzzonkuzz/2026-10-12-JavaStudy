

/*/
 *  부정연산자 : ! (반전)
 *  비교연산자 : ==, !=, <, >, <=, >=
 *  논리연산자 : &&, ||
 *  ---------- 조건문 안에 들어가는 연산자 : true/false
 *  대입연산자 : 계산 결과값
 *            =, +=, -=, *=, /=
 *  삼항연산자 : if~else : 조건에 맞는 결과값을 가지고 온다
 *            JSP에서 주로 사용 / ThymeLeaf => HTML + Java
 *            => Java+HTML     HTML
 *            
 *            
 *  비교연산자 : 조건문 / 반복문에서 주로 사용하는 연산자
 *   => 숫자 + char 
 *   => boolean : ==, !=
 *   => String : equals(), !equals() 
 *               compare(), contains(), startswith(), endswith()
 *               
 *  비교연산자 종류
 *   =>
 *      ==같다 
 *      != 같지 않다
 *      < 작다
 *      > 크다
 *      <= 
 *      >= 10>10 || 10==10
 *      
 */
import java.util.Scanner;
public class 이항연산자_비교연산자 {

	public static void main(String[] args) {
		int a='A';
		int b=65;
		// 문자는 연산시에 자동으로 int로 변경
		System.out.println(a==b);
		System.out.println(a!=b);
		System.out.println(a<b);
		System.out.println(a>b);
		System.out.println(a<=b);
		System.out.println(a>=b);
		float f=10.5F;
		double d=10.5;		
	    System.out.println(f==d);
	    System.out.println(f!=d);
	    System.out.println(f<=d);
	    System.out.println(f>=d);
	    System.out.println(f<d);
	    System.out.println(f>d);
	    //데이터형 다른 경우 => 모든 연산은 큰 데이터형으로 변경 후에 연산
	    
	    boolean b1=true;
	    boolean b2=false;
	    System.out.println(b1==b2);
	    System.out.println(b1!=b2);
	    //System.out.println(b1<b2);
	    
	    String s1="Hello";
	    String s2="Hello";
	    
	    
	    String mid="admin";
	    Scanner scan=new Scanner(System.in);
	    System.out.println("ID 입력:");
	    String id=scan.next();
	    
	    System.out.println(mid.equals(id));
	    		
	    
	    
	}
}
