/*/
 *   = 일반대입
 *   int a=10;
 *   변수의 초기값 : 연산자 결과값
 *   우선 순위가 가장 낮다
 *   오른쪽 -> 왼쪽
 *   a=10+20+30 a+60
 *   +=
 *     복합 대입연산자 => 문자열 결합, 누적
 *      int a=10;
 *      a+=1;   ==> a=a+1  ==> a=11
 *   -=
 *   -------
 *   *=
 *   /=
 *   %=
 */
public class 이항연산자_대입연산자 {
public static void main(String[] args) {
	int a=10;
	a+=5;
	System.out.println(a);
	
	System.out.println("문자열결합");
	
	String s1="abc";
	String s2="def";
	String s3="";
	s3+=s1;
	s3+=s2;
	System.out.println(s3);
	
	System.out.println("==== -= ====");
	int b=10;
			b-=5;
			System.out.println(b);
			
			System.out.println("x");
			int c=10;
					c*=100;
					System.out.println(c);
					
					System.out.println("/");
					
					int d=10;
					d/=3;  //d=d/3.0 ==> 내부적으로 처리
					System.out.println(d);
					
					int e=10;
					e%=3;
					System.out.println(e);
	
}
}
	
	
