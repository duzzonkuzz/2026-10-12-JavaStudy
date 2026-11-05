/*
 *    공통으로 사용하는 변수 / 메소드가 있는 경우 
 *    -----------------  ---------------
 *      => 네트워크 / 쓰레드 / 윈도우 
 *      => 웹에서 사용빈도가 없다 
 *              ------ JPA (데이터베이스 연동)
 *              | 데이터베이스(웹의 핵심)
 *                => JDBC / DBCP / ORM (MyBatis,JPA)
 *                => SpringFramework : MyBatis 
 *                => SpringBoot : JPA
 *                --------------------------- Back-End 
 *                Front-End : React / Next(표준) / Vue3 / Jquery 
 *                                                       => 3-4
 *      => 장점 
 *          : 다른 클래스와 연결해서 사용하기 쉽다 
 *          : 코드의 복잡성을 줄일 수 있다
 *          
 *          class A  A a=new A()
 *          {
 *          }
 *          class B  B b=new B()
 *          {
 *          }
 *          
 *          ------------------------
 *          class A(Server)
 *          {
 *             데이터 / 메소드 공유해서 사용이 가능 
 *             class B(Thread) => 멤버
 *             {
 *             }
 *          }
 *          단점 :  객체 생성이 어렵다 
 *                 A a=new A();
 *                 A.B b=a.new B();
 *          종류 
 *            ***1. 멤버 클래스 => 서로 변수를 , 메소드 마음대로 사용이 가능하게 
 *                  쓰레드+윈도우 / 서버 (서버+통신)
 *                  class A extends JFrame
 *                  {
 *                     Image / Button / ....
 *                     
 *                     class Game extends Thread
 *                     {
 *                        A a=new A();
 *                        
 *                     }
 *                  }
 *                  서버 
 *                    = 교환 
 *                    = 통신  ==> Thread
 *                    
 *                  class Server
 *                  {
 *                     List list=new ArrayList();
 *                     int port=3355;
 *                     // 접속자 정보 저장 => IP / PORT
 *                     class Client extends Thread
 *                     {
 *                        통신 
 *                     }
 *                     
 *                  }
 *                  
 *                  class Server
 *                  {
 *                     static List list=new ArrayList();
 *                  }
 *                  class Client extends Thread
 *                  {
 *                     
 *                  }
 *           --------------------------------------------
 *            ***2. 익명의 클래스 : 상속없이 오버라이딩을 수행 
 *               class A
 *               {
 *               }
 *               class B
 *               {
 *                  public void display(){}
 *               }
 *               
 *               class A extends B
 *               {
 *                  public void display(){}
 *               }
 *               
 *               class A
 *               {
 *                   B b=new B(){
 *                      public void display(){}
 *                   };
 *               }
 *            3. 지역 클래스 : CallBack => 사용빈도는 거의 없다 
 *               class A
 *               {
 *                  public void display()
 *                  {
 *                     class B
 *                     {
 *                         public void print(){}
 *                     }
 *                     
 *                     B b=new B();
 *                     b.display();
 *                  }
 *               }
 *            ---------------------------------- 람다식 
 *            
 *            
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
public class 중첩클래스 extends JFrame{
    JTable table;
    DefaultTableModel model;
    public 중첩클래스()
    {
    	String[] col={"아이디","이름","성별"};
    	String[][] row=new String[0][3];
    	// 일회성 => 익명의 클래스
    	model=new DefaultTableModel(row,col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
    		// 메소드 추가도 가능 
    	};
    	table=new JTable(model);
    	JScrollPane js=new JScrollPane(table);
    	add("Center",js);
    	setSize(350, 300);
    	setVisible(true);
    	
        String[] arr={"admin","홍길동","남자"};
        model.addRow(arr);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new 중첩클래스();
	}

}