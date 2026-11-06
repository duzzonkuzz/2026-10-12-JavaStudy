package com.sist.lang;
/*
 * 소멸자 ==> hashCode() : 같으면 같은 객체
 *                       다르면 다른 객체
 *   클래스 설계
 *   객체 생성 => new 생성자()
 *   객체 활용 => 객체.메소드()
 *   객체 주소값 삭제 => 객체=null
 *   소멸여부 확인 => 메모리 해제 => finalize()
 */

class Main
{
private int a=10;
public Main(int a)
{
	this.a=a;
	System.out.println("main 클래스 메모리 할당..(객체 생성)");
}
public void display()
{
	System.out.println("display call 객체활용");
}
@Override
protected void finalize() throws Throwable {
	// TODO Auto-generated method stub\
	// 소멸하는 게 역할이 아닌 소멸 됐을 때 호출하는 메소드
	
	System.out.println("메인 객체 메모리 해제");
}

}
public class 라이브러리_2 {
public static void main(String[] args) {
	Main m=new Main(100);
	m.display();
	m=null;
	System.gc();
}
}
