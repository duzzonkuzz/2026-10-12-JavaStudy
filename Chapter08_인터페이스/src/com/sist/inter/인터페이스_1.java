package com.sist.inter;
/*
 *   인터페이스 : 연결 (리모콘) 
 *     1) 추상클래스의 일종이다 (인터페이스도 클래스와 동일하게 취급) 
 *                          상속 내리면 / 상위 클래스
 *                          => 클래스 여러개를 묶어서 한개 이름으로 관리 
 *        예)
 *              List => 생성자가 없다 (메모리 할당 안된다)
 *               |      ==> 구현된 클래스를 이용해서 접근 
 *           ------------------------------
 *           |          |           |     |
 *         ArrayList  LinkedList  Vector Queue
 *         
 *         ***List list=new ArrayList() 데이터베이스
 *         list=new LinkedList() 파일 
 *         list=new Vector()  네트워크 
 *     2) 다중 상속이 가능 (추상클래스 => 단일 상속) 
 *     3) 구성요소 (인터페이스 => only public)
 *                           |=> 1.9 => private 메소드만 사용이 가능 
 *        interface 인터페이스명{
 *           ---------------------
 *             변수(X) => 상수(O) 
 *             => 반드시 초기화 시킨다 
 *                int MAX=100;
 *                int MAX; (오류)
 *                
 *                (public static final) int MAX=100;
 *                  생략이 가능 => 없는 경우에 자동 추가
 *           ---------------------
 *             ***추상 메소드 : 구현이 안된 메소드 
 *                void display();
 *                
 *                => (public abstract) void display();
 *                public void display();
 *                      |
 *                    abstract 
 *           ---------------------
 *             ***default 메소드 : 구현된 메소드 
 *             (public) default void diplay(){}
 *             
 *           ---------------------
 *             static 메소드 : 구현된 메소드 
 *             (public) static void display(){}
 *           ---------------------
 *             private 메소드 : 구현된 메소드 
 *             private void display(){} 
 *               => 자체내에서 수행 => 사용빈도는 거의 없다 
 *           ---------------------
 *        
 *        }
 *        메소드는 {} 구현이 됨
 *      4) 역할 
 *         서로 다른 클래스를 모아서 한개의 이름 관리 
 *      5) 결합성이 낮은 프로그램 
 *         => 유지보수에 사용하기 좋다 
 *         => 인터페이스를 수정하면 관련된 모든 클래스가 오류 발생 
 *            고정해서 사용 => 최근에는 default 
 *      6) 인터페이스는 변수(X) => 상수 
 *      7) 다중 상속이 가능 
 *      8) 상속을 내려서 => 오버라이딩을 사용하다 
 *      9) 인터페이스 ===> 인터페이스 
 *                extends
 *         인터페이스 ===> 클래스
 *                implements 
 *         클래스 ===> 인터페이스 
 *               X 
 *      10) 다중 상속시에는 ,
 *          interface A
 *          interface B extends A
 *          interface C extends B
 *          
 *          ***interface C extends A,B
 *          
 *          interface A
 *          interface B
 *          class C implements A,B
 *          
 *          interface A
 *          interface B 
 *          class C
 *          class D extends C implements A,B
 *                -----------            ---
 *                               |
 *                             오버라이딩 
 *                           1) 상속이 있는 경우 
 *                           2) 메소드명이 동일 
 *                           3) 매개변수 동일 
 *                           4) 리턴형 동일 
 *                           5) 접근 지정어는 같거나 확장이 가능 
 *                              ------------------------
 *                              인터페이스 only public 
 *          interface A
 *          {
 *              int a; => 상수 반드시 값을 등록 
 *              int a=100;
 *                   -----
 *              void display();
 *          } 
 *          class B implements A
 *          {
 *              public void display(){}
 *          }
 *         
 *      11) 인터페이스 사용 
 *          1) 윈도우 : 이벤트   
 *          2) 쓰레드 : 동작에 대한 개발 
 *          ----------------
 *          3) 데이터베이스 
 *          4) 웹연동 / 앱연동 
 *          ----------------
 *      12)
 *           설계 , 요구사항 => 아키텍쳐 => 사이버다임 
 *           데이터베이스 => DBA
 *           구현  ==== 웹개발
 *                     | = Front-End
 *                     | = Back-End 
 *           테스트 === 테스터 
 *      ---------------------------------------
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
interface A
{
	int a=100;
	void display();
}
public class 인터페이스_1 extends JFrame implements MouseListener,WindowListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}