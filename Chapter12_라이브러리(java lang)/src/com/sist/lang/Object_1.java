package com.sist.lang;

/*
 *    Object 
 *    = 모든 클래스에 상속을 내린다 (최상위)
 *    = Object클래스는 가장 큰 데이터형 = 모든 데이터값을 받을 수 있다 
 *                   ------------
 *                   1) 기본형 2) 참조형
 *                   예) Object o=10 , o=0.5 , o=true , o="Hello"...
 *                      Object o=new A() 
 *    = 상속 => Object가 가지고 있는 모든 메소드를 사용할 수 있다 
 *      라이브러리 : 메소드 ( 어떤 기능 , 리턴형 , 매개변수 , 메소드명 )
 *        | 변수는 제공하지 않는다 
 *    = java.lang => 자바 프로그램의 기본 
 *                   Object를 제외하고 다른 클래스는 final이다 
 *                                  --------- 상속을 받아서 변경이 불가능 
 *                                  --------- 고정된 클래스 
 *                                  --------- String , System , Math..
 *    = Object 
 *      -------
 *       소멸자 : finalize() 
 *       **객체 복제 : clone() => 메모리를 따로 생성 => 깊은 복사 
 *       **객체를 문자열화 : toString()
 *                     ----------- 생략이 가능 
 *       **객체 비교 : equals() : 객체 주소값 => 재정의해서 사용 (String)
 *       **객체 구분 : hashCode() 
 *       객체 얻기 : getClass() .class / 리플렉션이용   
 *    = 상속 
 *      | 상위 클래스는 하위 클래스에 추가된 메소드 , 변수에 접근이 불가능 
 *        class A
 *        {
 *            int a;
 *            void display(){}
 *        }
 *        class B extends A
 *        {
 *           int b;
 *           void bbb(){}
 *           
 *           //int a;
 *           //void display(){}
 *        }
 *        
 *        B bb=new B(); a,b,display(),bbb()
 *        A aa=new A(); a,display()
 *        A cc=new B(); a,display()
 *        ----            --------- 오버라이딩 메소드 호출
 *        | = 변수 (클래스)  | = 메소드 (생성자) 
 */
// toString() : 객체를 문자열화 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 *     Object 
 *       |
 *     JFrame
 *       |
 *     Object_1 : Object포함 
 */
public class Object_1 extends JFrame implements ItemListener{
    JComboBox box=new JComboBox();
    JLabel la=new JLabel();
    public Object_1()
    {
    	// 초기화 
    	// 화면 UI
    	box.addItem("홍길동"); // addItem(Object o)
    	box.addItem("심청이");
    	box.addItem("박문수");
    	box.addItem("이순신");
    	box.addItem("김두한");
    	
    	add("North",box);
    	add("Center",la);
    	
    	setSize(300,250);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	box.addItemListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Object_1();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		// 라이브러리 => 클래스 리턴 => 거의 대부분이 Object 
		// => 필수로 형변환 / (String:toString()) 
		// => Object를 변경 => 제네릭 => 데이터형을 통일 
		// <클래스> <int>(X) , <double>(X)
		//        <Integer>  <Double>
		if(e.getSource()==box)
		{
			//String name=(String)box.getSelectedItem()
			String name=box.getSelectedItem().toString();
			la.setText(name);
		}
	}

}