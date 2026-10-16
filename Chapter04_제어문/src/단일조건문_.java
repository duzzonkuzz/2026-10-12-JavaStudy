/*/
 *    알파벳 받아서 => 대문자/소문자/숫자/기타
 *    ----------------------------------
 *    && => 어디에서 어디까지 => 사이에 존재
 *    || => 범위에 없는 경우
 *    
 */
import java.util.Scanner;
public class 단일조건문_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



Scanner scan=new Scanner(System.in);
System.out.println("문자 입력");
char c=scan.next().charAt(0);
if(c>='A' && c<='Z')
{ System.out.println(c+"대문자");

	}
if(c>='a' && c<='z')
{ System.out.println(c+"소문자");

	}
if(c>='0' && c<='9')
{ System.out.println(c+"숫자");

	}
if( !((c>='A' && c<='Z')||(c>='a' && c<='z')||(c>='0' && c<='9')))
{ System.out.println(c+"기타");

	}

}
}