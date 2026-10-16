/*/
 *   3개의 정수를 난수 발생 ==> 1~100
 *             ------- 
 *             Math.random() => 0.0 ~ 0.99 
 *       
 *     => 최대값 / 최소값 추출 => 단일 조건문
 *                            1. 조건문 만들기
 *                            2. 어떤 내용 출력
 */
public class 단일조건문_1 {
 public static void main(String[] args) {
//	int a=(int)(Math.random()*100)+1;
//	
//	int b=(int)(Math.random()*100)+1;
//	int c=(int)(Math.random()*100)+1;
//	System.out.printf("a=%d,b=%d,c=%d\n",a,b,c);
//	int max=a;
//	if(max<b)
//		 max=b;
//	if(max<c)
//		max=c;
//	System.out.println("최대값:"+max);
	
int a=(int)(Math.random()*100)+1;
	
	int b=(int)(Math.random()*100)+1;
	int c=(int)(Math.random()*100)+1;
	System.out.printf("a=%d,b=%d,c=%d\n",a,b,c);
	int min=a;
	if(min>b)
		 min=b;
	if(min>c)
		min=c;
	System.out.println("최소값:"+min);
	
	
}
}
