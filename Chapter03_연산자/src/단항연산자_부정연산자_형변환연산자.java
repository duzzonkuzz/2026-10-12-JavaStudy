/*/
 *   부정연산자 :
 *     결과값 => true / false
 *     => 조건문(if)
 *     => 예약일 체크 / 체크인 / 체크아웃
 *     
 *     형변환 연산자
 *      기본형 / 참조형
 *     
 *     1) 자동형변환 : 작은 데이터 < 큰 데이터형
 *     2) 강제형변환 : 큰 데이터형 => 작은 데이터형
 *      int a=10.5;
 *       => 오류
 *      int a=(int)10.5; a=10 => 소수점이 사라짐
 *      char a=65; 예외 => 'A'
 *      int a=(int)(10.5+10.5) => 21
 *     3) 산술규칙 : 
 */
public class 단항연산자_부정연산자_형변환연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bCheck=false;
		bCheck=!bCheck;
		System.out.println("bCheck="+bCheck);
		

	}

}
