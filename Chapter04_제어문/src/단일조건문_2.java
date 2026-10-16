/*?
 *          사용자 입력 : 정수
 *          1 => google
 *          2 => naver
 *          3=> daum
 *              
 */
 import java.util.Scanner;
public class 단일조건문_2 {
public static void main(String[] args) throws Exception{
	
	
	Scanner scan=new Scanner(System.in);
	System.out.println("정수 입력:");
	int num=scan.nextInt();
	if(num==1)
	{
		Runtime.getRuntime().exec(new String[]{"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe","http:\\www.google.co.kr"});
	}

	if(num==2)
	{
		Runtime.getRuntime().exec(new String[]{"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe","http:\\www.naver.com"});
	}

	if(num==3)
	{
		Runtime.getRuntime().exec(new String[]{"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe","http:\\www.daum.net"});
}
}
}