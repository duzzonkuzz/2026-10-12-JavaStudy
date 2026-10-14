/*/
 * 
 *   프로그램 
 *    데이터 저장  ===  데이터 가공  === 결과값 화면에 출력 
 *      ㅣ               ㅣ
 *                    연산자 / 제어문     ㅣ    
                                   핸드폰 => 앱
                                   브라우저 => 웹애플리케이션  
                                   윈도우 / 도스 => 애플리케이션      
 *      한개 저장
 *     여러개 저장 (같은 데이터형) : 배열
 *     여러개 저장 (다른 데이터형) : 클래스
 *     ------------ 메모리에 저장
 *      ㅣ
 *      영구적으로 저장
 *      = 파일
 *      = RDBMS (오라클)
 *     
 * 1.데이터형 (기본형 / 참조형)
 *                    ㅣ 사용자 정의 => 직접 메모리 크기
 *                        int[] arr=new int[45]
 *            ㅣ자바에서 제공하는 데이터형
 *              정수형
 *               byte / int / long
 *               ㅣ 파일 업로드
 *              실수형
 *               float / double
 *              논리형
 *               boolean
 *              문자 
 *               char -> String 
 * 2.변수 선언 = 초기화
 *   멤버변수 : 자동으로 초기화 = Class
 *   지역변수 : 메소드안 선언 => 초기화가 없다 : 반드시 초기화 후에 사용
 *                          ㅣ 명시적 초기화 int a=10
 *                          ㅣ 사용자 입력값 
 *                          ㅣ 난수
 *    초기화 방법
 *       1) 선언 + 초기화
 *          int age=20
 *          String name="jjj"
 *       2) 선언 후에 초기화
 *          int age;
 *          age=20;  // 입력값을 받아서
 *       3) 여러개 변수 설정
 *          int a=10;
 *          int b=10;
 *          int c=10;
 *          -> int a,b,c;
 *             a=b=c=10;
 *       4) 초기값을 다른 변수에 대입
 *         int a=10;
 *         int b=a;
 *       5) 값 교체
 *          int a=10;
 *          int b=20;
 *          int temp=a;   임시변수 => 정렬
 *          a=b;
 *          b=temp;
 *       6) 각 데이터형 별 초기화
 *        int  20
 *        double  10.5
 *        float 1.5F
 *        byte 10
 *        boolean false
 *        char 'a'  \n \t \a (한문자)
 *        long 10l
 *        
 *        특수문자
 *         \n newline
 *         \t tab
 *         \\ \ : 경로명
 *         \" "
 * 3.연산 처리
 *   피연산자 / 연산자
 *    ㅣ 연산 대상 
 *       1개 : 단항연산자
 *              1) 증감연산자 : ++ -- => 한개 증가 / 함개 감소
 *              2) 부정연산자 : !
 *                    => turn
 *                    => %
 *              3) 형변환 여산자
 *                  (데이터형) => (int) (char)
 *                  byte<char<..<double
 *       2개 : 이항연산자
 *              1) 산술연산자
 *                 + - * 곱 /나누 %
 *                 + -> 산술 , 문자열 결합
 *              2) 비교 연산자
 *                ==같다  6==7 false 
 *                != 같지 않다
 *                => 기본형 비교는 가능 (문자열,날짜 불가능)
 *                "홍".equals("홍")   
 *       3개 : 삼항연산자
 * 4.제어문 -> 프로그램 제어
 * 5.데이터를 모아서 관리 : 배열 / 클래스(사용자 정의)
 * 6.명령문을 모아서 관리 : 메소드
 * -------------- 기본
 * 7.객체지향 프로그램 : 체계적으로 모아서 관리 -> 재사용
 * 8.프로그램이 비정상 종료가 없이 사용 : 예외처리
 * ----------문법
 * 9.자바에서 제공하는 라이브러리
 *   외부에서 제공하는 라이브러리 : Jsoup / JSON (jackson) / lombok
 *   ---------------
 *   -> 데이터 영구적으로 저장 : 오라클
 *   ----------------- Java + 오라클
 *   -> 브라우저에서 실행 : HTML / CSS / JavaScript
 *                                        l Jquery / Vue3 / React
 *   -> WEB 관련 : JSP
 *   ---------------
 *   실무
 *   1. Spring Boot
 *   2. Spring Security
 *   3. Kafka
 *   4. WebSocket -> Stomp -> Redis
 *   5. Spring AI 
 *   6. CI/CD
 *      -> 우분투 / Docker / Docker-compose
 *      쿠바네티스 / Jenkins 
 *   7. AWS
 *      EC2 / S3 / CloudWatch
 *   ----------------
 *   개인프로젝트 : NextJs / NodeJs / TypeScript
 *   ------> 적극적 취업 / 포트폴리오 / 이력서 (자소서)
 *   
 */
public class 연산자종류 {
	static int a;
	public static void main(String[] args) {
		System.out.println("\"홍길동\"");
		
		System.out.println("c:\\javaDev\\sa\\javastudy");
		int age=20;
		age=21;
		
		System.out.println("5%2="+(5%2));
		System.out.println("5%-2="+(5%-2));
		System.out.println("-5%2="+(-5%2));
		System.out.println("-5%-2="+(-5%-2));
		
	
	}

}
