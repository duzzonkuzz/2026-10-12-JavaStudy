package exception;
/*
 *    1. 변수 : 한개의 데이터를 저장하는 공간 
 *       전역변수 : 클래스 전체에서 사용하는 변수 
 *                = 객체가 같이 사용하는 변수 : static
 *                = 객체마다 따로 저장되는 변수 : instance 
 *          | = 다른 클래스에서 연결해서 사용이 가능 
 *       지역변수 : 메소드안에서만 사용하는 변수 
 *       ------ 매개변수 
 *    2. 데이터형 
 *       기본형                         참조형 
 *       | 정수                         | 배열 / 클래스 
 *          int / long / byte          | 데이터가 여러개 저장 => 메모리 주소
 *       | 실수                         | 스택 : 주소 / 주소 : 데이터가 저장 (heap)
 *          double 
 *       | 문자 
 *          char 
 *       | 논리 
 *          boolean 
 *     ------------------------
 *       byte < char < int < long < float < double 
 *                            1     0.000000
 *                                     | 클래스 : 상속 / 포함 => 크기 
 *                                     | 상속 내린 클래스 > 상속 받은 클래스
 *      데이터형 변수 = 값 
 *      ------      --
 *      값보다 크거나 같다 
 *      
 *      클래스 객체=new 생성자()
 *      ----         -------
 *      생성자의 클래스보다 크거나 같다 
 *      
 *      class A
 *      class B 
 *      ---------  A a=new B() X
 *      
 *      class A
 *      class B extends A  A>B   A a=new B() / B b=(B)new A();
 *            int      double    double d=10   int a=(int)10.5
 *      
 *      class A
 *      {
 *         B b=new B()     A>B
 *      }
 *     ----------------------------------------- 데이터 저장 방법 
 *     메모리에 저장 => 영구적인 저장 
 *                   ---------- 파일 
 *                   ---------- RDBMS
 *     처리 
 *      = 연산처리 
 *      
 *      = 제어문 
 *      ------------------ 묶어서 사용 : 메소드 
 *      
 *      변수 + 메소드 = 클래스 
 *      클래스 여러개 저장 = 패키지 
 *      ------------------------ 묶음 처리 (관련된 내용)
 *                                       -----------
 *                                       | 재사용 
 *      관련된 클래스 => 제어 
 *                   ----- 인터페이스 
 *    
 *    
 */
public class 예외처리_1 {
    public static void display(int... a)
    {
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        display(10);
        display(10,20);
        display(10,20,30);
        
	}

}