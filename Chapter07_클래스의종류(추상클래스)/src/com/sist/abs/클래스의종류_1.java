package com.sist.abs;
/*
 *   final / static => 제어어
 *   |확장이 안되는 클래스 => String , Math , System, StringBuffer ...
 *                       표준화된 클래스 (모든 개발자가 동일하게 사용)
 *   자바에서 지원하는 클래스의 종류 
 *   1) 추상클래스 : abstract (326page)
 *      1. 미완성 클래스 (구현이 안된 메소드를 포함) 
 *         new이용해서 메모리 할당이 불가능 => 상속을 내려서 상속받은 클래스가
 *         메소드를 구현해서 사용 
 *      2. 많이 사용하지 않는다 => 확장 (인터페이스가 많이 사용된다)
 *      3. 추상 : 공통점울 모아서 관리 
 *      4. 추상 클래스는 관련된 클래스를 모아서 한개로 관리가 가능 
 *                    --------------------------
 *      5. 요구사항 분석 => 설계와 관련 
 *         ----------
 *         예)
 *             뮤직 => 추상 클래스  
 *              = 지니뮤직 
 *              = 멜론 
 *              = MNet 
 *      6. 형식)
 *              
 *              public abstract class ClassName
 *              {
 *                 공통으로 사용 
 *                 public abstract 리턴형 메소드(매개변수..);
 *                 // 프로그램마다 구현이 다른 경우 
 *                 // 공통으로 사용 => 구현을 한다 
 *                 
 *              }
 *      7. 단점 
 *         단일 상속 / 프로그램 제약이 많이 존재 => 다중 구현 : 인터페이스 
 *                  -----------
 *                  지정된 메소드만 사용 => 추가 기능이 어렵다 
 *      8. 장점 
 *         서로 다른 클래스를 모아서 한개 이름으로 객체를 제어 할 수 있다 
 *         결합성이 낮은 프로그램을 구현 할 수 있다 
 *         -----------------
 *               DriverManager 
 *                   |
 *           -------------------------
 *           |      |     |     |    |
 *                                  MariaDB
 *          오라클  MySQL  MSSQL PostgreSQL  =====> DB2
 *          
 *        => 기능을 설정 => 프로그램에 맞게 구현 
 *        => 모아서 관리 => 관련 클래스를 모아서 
 *           -------- 객체 지향 프로그램 : 재사용 , 관리 
 *           | 데이터 관리 : 배열 / 클래스 
 *           | 클래스 관리 : 추상 클래스 / 인터페이스 
 *        *** 추상클래스 
 *            = 기능 추가할 경우에 다른 클래스에 영향 
 *              
 *   2) 인터페이스 : interface 
 *   3) 내부클래스 :
 *                  class A(윈도우)
 *                  {
 *                     class B(쓰레드)
 *                     {
 *                     }
 *                  }
 *                  
 *                  class A(서버)
 *                  {
 *                     class B(통신담당)
 *                     {
 *                     }
 *                  }
 *                  
 *            public abstract class ClassName
 *            ------ --------
 *            abstract public class ClassName
 */
abstract class 도형{
   String color="검정색";
   ////////////////////
   abstract void setColor(String color);
   abstract void draw();
   /////////////////////  공통 기반 => 기능이 다른 경우 
   void tick() {
	  System.out.println("두께: 5mm"); 
   }
   ///////////////////// 선택 사항 
}
class 선 extends 도형{

	
	@Override
	void setColor(String color) {
		// TODO Auto-generated method stub
		this.color=color;
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("선을 그린다:색상은 "+color);
	}
	
}
class 네모 extends 도형{

	@Override
	void setColor(String color) {
		// TODO Auto-generated method stub
		this.color=color;
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("사각형을 그린다:색상은 "+color);
	}
	
}
class 세모 extends 도형{

	@Override
	void setColor(String color) {
		// TODO Auto-generated method stub
		this.color=color;
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("삼각형을 그린다:색상은 "+color);
	}
	
}
class 원 extends 도형{

	@Override
	void setColor(String color) {
		// TODO Auto-generated method stub
		this.color=color;
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("원을 그린다: 색상은 "+color);
	}

	@Override
	void tick() {
		// TODO Auto-generated method stub
		System.out.println("두께: 10mm");
	}
	
}
public class 클래스의종류_1 {

	static public void main(String[] args) {
		// TODO Auto-generated method stub
        /*선 line=new 선();
        line.draw();
        네모 rect=new 네모();
        rect.draw();
        세모 tr=new 세모();
        tr.draw();
        원 c=new 원();
        c.draw();*/
		//도형 aa=new 도형();
		
		도형 a=new 선();
		a.draw();
		a.tick();
		
		a=new 네모();
		a.draw();
		a.tick();
		
		a=new 세모();
		a.draw();
		a.tick();
		
		a=new 원();
		a.draw();
		a.tick();
		
	}

}