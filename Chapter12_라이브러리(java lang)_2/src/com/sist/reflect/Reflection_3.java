package com.sist.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

import com.sist.annotation.RequestMapping;
// 사용자 정의 => 패키지가 다르면 임포트

/*
 *  1. 개념 - 동작원리 - 문법 - 실무 사용법
 *  
 *     = 리플렉션 : 실행중인 프로그램이ㅡ 클래스, 변수, 생성자, 메소드
 *               정보를 얻어서 직접 조작하는 기술
 *     = 어노테이션 : 클라스, 변수, 메소드에 표시를 해서
 *                 바로 찾을 수 있게 만드는 기술
 *                 => 인덱스, if문이 추가
 *                          --------- 기능은 없다
 *        Spring : @Controller @Service
 *                 @Autowired @GetMapping @RequestMapping
 *                 => 이미 제작 => 메뉴얼
 *        MyBatis : @Select @Insert @Update @Delete
 *    -------------------------------------------------
 *    동작원리
 *      리플렉셙
 *       1) 클래스 정보 읽기
 *          Class.forName("패키지.클래스명")
 *       2) 구성 요소 확인
 *          변수 => Field => 이름 => getName() / set() / get()
 *          생성자 => Constructor
 *                  class A
 *                  {
 *                      public A(){}
 *                      public A(int a,String b){}
 *                  }
 *                  
 *                      class cls=Class.forName("A")
 *                      cls.getDeclareConstructor().newInstance()
 *                      // 객체 생성
 *                      // A()
 *                      cls.getDeclareConstructor(int.class,String.class).
 *                      newInstance(1,"")
 *                      ==> public A(int,a String b)
 *                     
 *          메소드 => Method
 *                  invoke() => 클래스에 있는 모든 메소드를 호출할 수 있다.
 *          어노테이션 확인
 *       3) 조작 => 변수값 설정 / 생성자 호출 / 메소드 호출
 *       4) 실행
 */
class Board
{
	/*
	 *     ------- 변수 : 여러개 
	 *             Field f=getDeclaredField("변수명")
	 *             String name,address,phone...
	 *             Field[] f=getDeclaredFields()
	 *     ------- 생성자 : 여러개 
	 *     ------- 메소드 : 여러개 
	 *             Method m=getDeclaredMethod("메소드명")
	 *             Method[] m=getDeclaredMethods()
	 */
	@RequestMapping("1")
	public void list()
	{
		System.out.println("list");
	}
	@RequestMapping("2")
	public void insert()
	{
		System.out.println("insert");
	}
	@RequestMapping("3")
	public void detail()
	{
		System.out.println("detail");
	}
	@RequestMapping("4")
	public void delete()
	{
		System.out.println("delete");
	}
	@RequestMapping("5")
	public void find()
	{
		System.out.println("find");
	}@RequestMapping("6")
	public void update()
	{
		System.out.println("update");
	}
	@RequestMapping("8")
	public void reply()
	{
		System.out.println("reply");
	}

}
public class Reflection_3 {
public static void main(String[] args) {
	Board board=new Board();
	Scanner scan=new Scanner(System.in);
	while(true)
	{
		System.out.println("==메뉴==");
		System.out.println("1. 목록요청");
		System.out.println("2.글쓰기");
		System.out.println("3.상세");
		System.out.println("4.수정");
		System.out.println("5.삭제");
		System.out.println("6.검색");
		System.out.println("7.종료");
		System.out.println("=====");
		System.out.println("메뉴 선택");
		int menu=scan.nextInt();
		if(menu==7)
		{
			System.out.println("프로그램 종료");
		}
//		else if(menu==1)
//		{
//			board.list();
//		
//		}
//		else if(menu==2)
//		{
//			board.insert();
//		
//		}
//		else if(menu==3)
//		{
//			board.detail();
//		
//		}
//		else if(menu==4)
//		{
//			board.update();
//		
//		}
		
//		else if(menu==5)
//		{
//			board.delete();
//		
//		}else if(menu==6)
//		{
//			board.find();
//		
//		}
		try {
		//1. class 읽기
		Class clsName=Class.forName("com.sist.reflect.Board");
		//2. 메모리 할당 
		Object obj=clsName.getDeclaredConstructor().newInstance();
		// Board obj=new Board()
		//3. Method전체 읽기 
		Method[] methods=clsName.getDeclaredMethods();
		//4. Method위에 있는 @RequestMapping 찾기 
		for(Method m:methods)
		{
			// .class / getClass() 
			RequestMapping rm=m.getAnnotation(RequestMapping.class);
			if(Integer.parseInt(rm.value())==menu)
			{
				m.invoke(obj, null);
			}
		
		}
    	}catch(Exception ex) {}
    	
    }
}

}