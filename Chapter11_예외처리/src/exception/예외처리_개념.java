package exception;
/*
 *   예외처리 : 소스상에서 처리할 수 있는 가벼운 에러 
 *   ------- 
 *     정의 : 프로그램 실행시에 발생할 수 있는 에러에 대비하는 코드 
 *           사전에 에러 방지 
 *     목적 : 비정상 종료를 방지하는 경우 사용 => 프로그램의 정상 상태 유지
 *   --------------------------------------------------------
 *     에러 종류 
 *     -------
 *      1) 에러 
 *           심각한 에러 / 메모리 부족 (윈도우) , 윈도우 종료 
 *      2) 예외
 *           가벼운 에러 / URL주소(X) , File명, 경로, 서버 IP/PORT
 *         *** 예외처리를 하면 에러를 자동으로 수정되는 것은 아니다 
 *             에러를 건너뛴다 : if 
 *                                    JVM
 *      A.java =========== A.class ========= 실행  
 *               javac                java
 *              (컴파일)             (인터프리터)
 *      -------                     ---------
 *                         --------
 *                         컴퓨터가 인식하는 언어 (바이트 코드) => 0,1
 *                                              |
 *                                            모든 문자가 정수형으로 저장
 *       원시소스 (개발자만 알 수 있는 언어)           |
 *           |      
 *         컴파일시                              실행시 에러 
 *           |                                   |
 *        CheckedException                     UnCheckedExcepion
 *          ** 반드시 예외처리 한다                  ** 필요시에만 예외처리
 *       ----------------------                 ------------------
 *       1. 컴파일시에 예외처리가 되었는지 확인         예외처리 여부를 확인하지 않는다
 *          => 파일읽기 => 파일 경로 / 파일명         자주 에러나는 부분 
 *          => 크롤링 => URL주소 
 *          => 오라클 연동 => IP / PORT 
 *                              1521
 *             PostgreSQL => 5687 (X)
 *                           3306  
 *             --------------------- 
 *          => 서버 / 네트워크 : IP / PORT(임의로)
 *          => 웹 : 사이트 주소 
 *          => 쓰레드  : 충돌 방지 
 *          => java.io / java.sql / java.net 
 *       -----------------------------------    ----------------------
 *                   |                                    |
 *                 개발자 실수                            사용자 입력 
 *       ==> 처리 방법 
 *           -------
 *           ***1. 예외 복구 (직접 처리)
 *                 try ~ catch ~ finally
 *                  |      |        |
 *                                 자원관리 (파일닫기, 서버연결 해제)
 *                        예외 발생시 처리 
 *                 정상 수행 문장 (평상시에  사용한 코드) 
 *           ***2. 예외 회피 (간접 처리) => 시스템에 위해 처리 
 *                 메소드() throws 예외처리클래스
 *           3. 예외 발생 => 테스트 / 사용자 정의일 경우 => 임의로 발생 
 *                 throw new 예외클래스()
 *                 ----- 호출 
 *           4. 사용자 정의 
 *              class MyException extends Exception
 *                                -----------------
 *              *** JavaScript / Vue / React / Next / 오라클(PL-SQL)
 *       ==> 예외처리 계층구조 
 *                  Object 
 *                    |
 *                 Throwable : 예외처리의 최상위 클래스 
 *                    |
 *          -----------------------------
 *          |                           |
 *        Error                      Exception 
 *                                      |
 *                 CheckedException           UnCheckedException
 *                 -----------------------------------------
 *                 |                                       |
 *               IOException                            RuntimeException
 *                 입출력 관련 
 *                 => 메모리 입출력 
 *                    System.in
 *                    ---------- 예외처리가 있다
 *                    System.out
 *                    ---------- 예외처리가 없다
 *                 => 파일 입출력 
 *                    FileReader / FileWriter
 *                    FileInputStream / FileOutputStream
 *                 => 네트워크 입출력 
 *                    BufferedReader / OutputStream 
 *               InterruptedException 
 *                 => 쓰레드 충돌 방지 (비동기)
 *               MalformedURLException 
 *                 => URL => 크롤링 
 *               ClassNotFoundException 
 *                 => 리플렉션 (클래스명을 이용해서 제어) 
 *                    : Spring
 *                    : new없이 메모리 할당이 가능 
 *                    : 변수값 설정 / 메소드 찾기 
 *               SQLExceion 
 *                 => 데이터베이스 연동 
 *               => DB연동 , 파일 입출력 , 쓰레드
 *                  크롤링 , 네트워크 서버연동 
 *                  
 *             -----------------------------------------------
 *               RuntimeException : 필요에 의해서만 예외처리 
 *                    |
 *                ArrayIndexOutOfBoundsException : 배열 범위 초과
 *                NumberFormatException : 문자열을 숫자변경이 안되는 경우 
 *                    "10" => " 10"(X)
 *                ClassCastException : 클래스 형변환 
 *                NullPointerException : 메모리 할당없이 사용 
 *                ArithmeticException : 0으로 나눈 경우 
 *      1) try ~ catch ~ finally 
 *                       ------- 생략이 가능 (자원관리)
 *         => 예외 복구 / 어떤 에러 발생인지 확인 
 *         try
 *         {
 *            정상적으로 수행 문장
 *            => 지금까지 코딩이 여기에서 있다 
 *            => 실수 / 입력값 문제 
 *            => 에러 발생 --------- catch로 이동 
 *         }catch(예외처리클래스)
 *         {
 *            에러확인 / 처리 => 복구 
 *            | => printStackTrace() => 에러 위치 확인 
 *              => getMessage() => 에러문장 출력 
 *         }
 *         finally
 *         {
 *            자원 관리 => 에러가 나든 / 정상 수행 => 무조건 수행 문장 
 *         }
 *         
 *         ==> try ~ catch : 전체 사용이 가능 / 부분적으로 가능 
 *         
 *         1
 *         2 ==> error : 종료
 *         3
 *         try
 *         {
 *            4 
 *            5 ==> 10/0 ---- catch 이동 
 *            6
 *         }catch()
 *         {
 *            7
 *            8
 *         }
 *         finally
 *         {
 *            9
 *            10
 *         }
 *         11
 *         12 => 정상 종료
 *         
 *         1 2 3 4 (5 6) 7 8 9 10 11 12 
 *                 ----- catch에 있는 내용 수행
 *                 
 *         전체 
 *         try
 *         {
 *            1
 *            2
 *            3
 *            4== error
 *            5
 *         }catch(Exception e)
 *         {
 *            6
 *         }
 *         finally
 *         {
 *            7
 *         }
 */
public class 예외처리_개념 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    for(int i=1;i<=10;i++)
        {
	      try
	      {
        	int a=(int)(Math.random()*3);// 0~2
        	int val=i/a;
        	// 1 2 3 4=> a=0
        	System.out.println(i+":"+val);
	      }catch(Exception e) {}
        }
	 
   }

}