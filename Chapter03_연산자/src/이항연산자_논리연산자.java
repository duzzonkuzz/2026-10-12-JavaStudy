
/*/
 *  논리 연산자
 *   &&  ||
 *   직렬 병렬
 *   
 *   형식) (조건) && (조건)
 *        true      true  => true
 *        true     fals   => false
 *        => 범위안에 포함된 경우 / id , pwd
 *        
 *        || 
 *        => 범위밖에 있는 경우
 */

import java.util.Scanner;


public class 이항연산자_논리연산자 {
public static void main(String[] args) { 
	
	Scanner scan=new Scanner(System.in);
	System.out.println("알파벳 입력:");
	char c=scan.next().charAt(0);
	
	System.out.println(c>='A' && c<='Z');
	System.out.println(c>='a' && c<='z');
	
	System.out.println(
	!((c>'A' && c<='Z')||(c>'a' && c<='Z')));
	
}
}
