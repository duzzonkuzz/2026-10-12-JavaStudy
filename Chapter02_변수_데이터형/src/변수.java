/*/
 * 36page
 * 
 * 변수 -> 한개의 데이터를 저장하는 메모리 공간
 *          ----
 *          -> 모든 프로그램 언어는 메모리 -> Ram에 저장
 *                                     ---- 프로그램 종류시 해제
 *      ㅣ
 *      파일
 *      
 *      ㅣ
 *      
 *      오라클 : 영구적인 저장 장치 / MySQL / PostgraSQL 
 *      ----------
 *      
 *      저장되는 과정
 *    메모리 크기 -> 데이터형 (자료형)
 *    기본형 / 참조형 (사용자 정의)
 *           -> 배열 / 클래스 
 *      ㅣ 자바에서 제공하는 데이터형
 *         ---------------
 *         정수
 *            byte  (1byte -> 8bit) 0,1 -> 8개까지 저장이 가능 127
 *            short (2byte -> 16bit) 32767
 *            int 4byte -> 32bit 2147483647
 *            -> 일반 프로그램에서 가장 많이 사용
 *            -> 컴퓨터는 무조건 숫자는 int인식
 *            long 8byte -> 64bit 
 *         실수
 *           float 4byte, 소수점 : 6자리
 *                   vectorDB
 *           double 8byte 소수점 : 15자리
 *               Default -> 컴퓨터가 인식 -> 건축 설계
 *         논리
 *          boolean true/false 1byte
 *        
 *         문자
 *          char 문자 1개
 *               값 => 'A' , '홍'
 *               여러개 => "ABC"
 *               
 *      변수 설정
 *      데이터형 변수명 = 값 (초기값) 변수 (변하는 수) / 상수 
 *      int a=10;
 *      final int b = 10; 상수
 *      변수 명칭법
 *      1. 알파벳, 한글로 시작
 *         ㅣ
 *         대소문자 구분
 *      2. 숫자 사용이 가능
 *         앞에 사용할 수 없다.
 *         a1 a2 a3
 *      3. 특수 문자 사용이 가능
 *         _ $ 
 *         1) 임시 변수
 *         2) 단어가 2개 이상인 경우 file_name
 *      4. 공백은 사용할 수 없다
 *      5. 키워드는 사용이 불가능  int int
 *      ----
 *      약속사항
 *       변수는 소문자로 시작
 *       상수는 대문자      
 *       final double PI=3.14
 *      캐멀방식
 *       단어 두개 이상 
 *       firstName
 *       first_name   
 *       
 *       
 *       int math=90;
 *       int eng=30;
 *       char c1='홍';
 *       String name="홍길동";
 *       
 *       byte < char < int < long < float < double
 *       
 *       1byte = 8bit 0과1이 8개
 */
public class 변수 {
	public static void main(String[] args) {
		//System.out.println(0101);
		
		byte byteValue=127;
		int intValue=10;
		long longValue=10L;  //L 생략 가능 인트기때문에
		float floatValue=10.5F; //F는 생략 불가능 D이기떄문에 D>F
		double doubleValue=10.5D;
		boolean booleanValue=true;
		char charValue='A';
		
		System.out.println("byteValue="+byteValue);
		System.out.println("intValue="+intValue);
		
		double d=100; //자동 형 변환

		
		
		// 정수 int 실수 double 존재 boolean 
//		long : AI , 데이터가 많은 경우
//		전송 (네트워크) -> byte
//		형변환 -> 데이터형을 변경 
		/*/
		 * 자동 형변황 : UpCasting
		 * 작은 데이터를 큰 데이터에 저장
		 * long a=10 롱으로 변경
		 * dluble d=10L double로 변경
		 * 
		 * 강제 형변환  DownCasting
		 *  int a=10.5   (int)10.5   a=10
		 */
		
	}

}
