package com.sist.construction;
/*
 *  생성자 
 *    = 객체 생성시에 호출되는 메소드 (직접 호출)
 *      --------------------------------
 *      new 생성자()
 *    = 객체가 가지고 있는 변수에 대한 초기화 
 *      => 매개변수가 있는 생성자 
 *    =  클래스명과 동일 / 리턴형이 없다 
 *    = 생성자는 여러개를 만들 수 있다 : 오버로딩 
 *      오버로딩 
 *        => 메소드명 동일 
 *        => 매개변수가 다르다 (갯수, 데이터형) 
 *        => 리턴형은 관계없다 
 *        => 접근 지정어도 관계없다 
      = 모든 클래스는 생성자를 가지고 있다 
        생성자가 없는 경우에는 자동으로 매개변수가 없는 생성자를 만들어준다 
 *    class A
 *    {
 *       int a,b,c;
 *       A()
 *       {
 *         a=10;
 *         b=20;
 *         c=30;
 *       }
 *       A(int a,int b,int c)
 *       {
 *          this.a=a;
 *          this.b=b; 
 *          this.c=c;
 *       }
 *    }
 *    A aa=new A(100,200,300)
 *    A bb=new A(1000,2000,3000)
 *    A cc=new A(10000,20000,30000) 
 *    
 *    super / super()
 *            | 상속 내린 클래스 생성자 호출 
 *    | 상속 내린 클래스 객체 
 *    
 *    this / this()
 *           | 자신이 가지고 있는 생성자 호출 
 *    | 자신의 객체 
 *    
 *    super() / this()는 반드시 생성자안에 호출 
 *    => 생성자의 첫번째줄에 호출 
 */
class Human
{
	String name;
	String sex;
	String address;
	String phone;
	//public Human() {}
	public Human(String name,String sex,String address,String phone)
	{
		this.name=name;
		this.sex=sex;
		this.address=address;
		this.phone=phone;
	}
}
class Student extends Human
{
	int hakbun;
	String subject;
	public Student(String name,String sex,String address,String phone)
	{
		super(name,sex,address,phone);
	}
}
class Sawon extends Human
{
	int sabun;
	String dept;
	public Sawon(String name,String sex,String address,String phone)
	{
		super(name,sex,address,phone);
	}
}
// 매개변수가 없는 생성자는 자동 호출 => super()  
// 매개변수가 있는 생성자는 직접 호출해서 사용 => super()
public class 생성자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}