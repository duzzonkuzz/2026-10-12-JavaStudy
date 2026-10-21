/*
 * 1. *trim() : 좌우 공백 제거
 * 2. *valueOf() : 모든 데이터형을 문자열로 변환시에 사용
 * 3. *split() : 단어(토큰) 별로 나눠서 배열에 저장
 * 4. join() : 문자를 묶어서 한개의 문자열로 저장
 * 5. format() : 문자열 변환
 *      ------ printf()
 *      ------------
 *  라이브러리 => 자바에서 만든 클래스
 *     |= 메소드 (기능)
 *     
 *   메소드 : 특정 기능을 수행하는 명령문의 집합
 *   메소드의 구성 요소
 *      리턴형(결과값) 메소드명(매개변수..)
 *      {
 *          기능 수행 (요청 처리)
 *            return 값
 *                   -- 데이터형 동일
 *      }
 *      
 *      리턴형 / 메소드 / 매개변수
 *      ------
 *      => 호출시에는 리턴형을 제외한다
 *      int add(int a,int b) => 원형
 *             return a+b;
 *      { 
 *       return a+b;
 *      }
 *      
 *      => int c=add(10,20)
 *      
 *  1. 어떤 클래스인지
 *  2. 어떤 기능이 필요한지
 *  3. 매개변수 값
 *  4. 리턴형
 *  5. 어떻게 호출
 *  *** 결과값이 없는 경우도 있다 => 리턴형 void
 *                                   ----
 *  trim() : 좌우 공백 제거
 *   => 원형 : String trim()
 *            ------
 *            
 *  String valueOf(int, long, ...,많음) : 모든 데이터형을 문자열로 변경
 *     10 => "10"
 *     ----------오버로딩
 */
public class 문자열_5 {
	public static void main(String[] args) {
//		System.out.println();
		String ms=" Hello Java "; //인스턴스
		System.out.println("문자 갯수:"+ms.length());
		System.out.println("ms="+ms);
	ms=ms.trim();
	System.out.println("문자 갯수:"+ms.length());
	System.out.println("ms="+ms);
	// trim() => 검색어 id, pw
	// 공백 => space 문자
	int a=100;
	int b=200;
	
	System.out.println(a+b);
	// 공유 메소드 => static
	System.out.println(String.valueOf(a)+b);
	System.out.println((a)+b);
	
	String s=String.join("/","2026","10","21");
	System.out.println(s);
	
	s=String.format("%d %d %d %d %.2f", 90,90,80,260,260/3.0);
	System.out.println(s);
	
	
	
	
	
	
	
	
	}
	


}
