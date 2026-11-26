package com.sist.music;
/*
 *    = 코드 재사용 : 데이터형을 변경해서 사용이 가능 
 *                 데이터형을 안정성있게 만드는 도구 
 *    = 클래스<클래스형> : 기본형은 사용이 불가능 => Wrapper 
 *    1. 제네릭을 사용하는 이유 
 *       ArrayList list=new ArrayList();
 *       --------- 모든것이 Object 
 *                 -----
 *                 | 변수 , 메소드의 리턴형 / 매개변수 => Object로 되어 있다
 *                 | 형변환 / 모든 데이터를 추가할 수 있다 
 *                 | for수행이 어렵다 
 *                 | 처음 => 유지보수하는 개발자 => 데이터형 확인이 어렵다
 *                 | 데이터 읽기마다 => 형변환 필요 => CastClassException
 *               --------------------------------------------------
 *               해결 => 모든 데이터형을 한번에 통일화 
 *    2. 프로그램에서는 데이터형을 고정 
 *       int a / var a (Object)   
 *       => 고정화 / 통일화     
 *       => 불필요한 형변환을 가급적이면 안하는 것이 좋다 == 제네릭 
 *       => 데이터형 고정 => 데이터를 한가지만 설정이 가능 
 *                        ----------- 사용하기 편리 => 가독성 
 *       => 컴파일 오류 방지 
 *       => 형변환이 없다 => 소스 간결해 진다   
 *       
 *       먼저 만들고 => 나중에 데이터형을 변경해서 사용이 가능 
 *       => 제네릭을 사용하지 않으면 경고가 있다 
 *       
 *       => 제한된 제네릭 
 *          class Box<T extends Number>{
 *               // 숫자만 제한 = 실수 , 정수
 *          }
 *          
 *          Box<Integer>
 *          Box<Double>
 *          Box<Byte>
 *          Box<String>(X)
 *       => 데이터형을 모르는 경우 : 와일드카드 => ?
 *          Class<?>   
 *          => 데이터형을 잘 모른다 : 경고를 피해 가는 상태
 *       => extends 제한된 제네릭 => 꺼내기 전용 (읽기 전용) 
 *          타입을 모르는 경우 => only 읽기 => ? 
 *          => 가끔 라이브러리에 나온다 
 *       
 */
class Box<T>
{
	T t;
	public void setT(T t)
	{
	   this.t=t;
	
	}
	public T getT()
	{
	   return t;
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Box box=new Box();
        Box<String> box1=new Box<String>();
        Box<Integer> box2=new Box<Integer>();
        try
        {
        	
        }catch(Exception e) {}
	}

}