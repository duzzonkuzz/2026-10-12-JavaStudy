package com.sist.main;
// import
/*\
 * 1.생성자 
 *  =역할
 *    멤버변수(전역변수=인스턴스+스태틱) 초기화
 *    시작과 동시에 처리하는 기능 (자동 로그인, 파일읽기 -> 초기화)
 *    객체 생성시마다 다른 데이터 초기화
 *     => 생성자는 무조건 사용하는 것이 아니라 필요시에만 사용
 *       => 생성자가 없는 경우에는 자동 생성자 한개 추가
 *                          ------- 디폴트 생성자 ( 매개변수가 없는 생성자)
 *    객체 생성시에 호출되는 메소드
 *     -------------------> 반드시 new 동반                      
 *  =특징
 *    클래스명과 동일
 *    리턴형이 없는 특별 메소드 (void도 리턴형이다)
 *     => 리턴형이 존재하는 일반 인스턴스 메소드로 인식한다
 *     class A
 *     {
 *       리턴형이 있다면 일반 메소드
 *     }
 *  =여러개 만들 때 사용 규칙
 *    오버로딩 : 같은 메소드명을 이용해서 새로운 기능을 만드는 것.
 *    조건)
 *      - 메소드명이 동일
 *      - 같은 클래스 내에서 만든다
 *      - 매개변수 갯수 / 데이터형이 다르다
 *      - 리턴형은 관련없다.
 *  = 생성자 호출 방법
 *    new 생성자();
 */
class Sawon
{
	private int sabun;
	private String name;
	private String dept;
	// 기본 디폴트 값을 가지고 있다.
	// 지역변수 => 인스턴스 변수/스태틱변수
	public Sawon()
	{
		sabun=1;
		name="홍길동";
		dept="개발부";
		
	}
	
	public Sawon(int sabun,String name)
	{
		this.sabun=sabun;
		this.name=name;
		
	}
	public Sawon(String name,String dept)
	{
		this(); //생성자 호출 반드시 생성자 함수 사용 ㅇ반드시 첫줄에 온다
		this.name=name;
		this.dept=dept;
		
	}
	public Sawon(int sabun,String name,String dept)
	{this.dept=dept;
		this.sabun=sabun;
		this.name=name;
	}
	public void display()
	{
		System.out.println("사번"+sabun);
		System.out.println("이름"+name);
		System.out.println("부서"+dept);
	}
	/*
	 * 
	 */
}
public class 생성자_오버로딩 {
	public 생성자_오버로딩() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Sawon s1=new Sawon();
		s1.display();  // 생성자 초기화
		Sawon s2=new Sawon(2,"심청이"); //생성자 초기화 안됨
		s2.display();
		Sawon s3=new Sawon("박문수","영업부");
		s3.display();
	}

}
