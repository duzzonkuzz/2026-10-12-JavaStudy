package com.sist.lang;

//getClass() : 데이터형을 가지고 온다 => 클래스명 
class Food
{
	private int fno;
	private String name;
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
//Object 
//객체 생성 / 소멸 / 복제 / 비교 / 타입 => 확인 => 모든 클래스가 가지고 있다 
/*
*   java.lang 
*     = Object 
*     = String => 문자열 저장 / 문자열를 제어하는 메소드 제공 
*       변환 
*         = toUpperCase() : 대문자 변환  
*         = toLpwerCase() : 소문자 변환 
*         = replace() / replaceAll() => 문자 변경 , 문자열 변경 
*           --------- 일반  | 정규식
*         = valueOf() => 모든 데이터형을 문자열 변환 
*           => static => String.valueOf()
*       자르기 
*         = substring(int start) , substring(int start,int end)
*                                     => end는 end-1
*         = 단어별 => split(String regex) => 정규식 포함 
*       찾기 => 단어위치 , 문자 위치 (인덱스번호 찾기)
*         = indexOf() => 앞에서부터 
*         = lastIndexOf() => 뒤에서부터 
*         = 모든 문자열은 0부터 시작 
*       비교
*         = equals() ==> 같은 문자열 
*         = compare() ==> 크기 (같은값 => 0 , 왼쪽 => 양수 , 오른쪽 => 음수)
*                         => 정렬 
*         = startsWith() ==> 시작 문자열 
*         = endsWith() ==> 끝 문자열 
*         = contains() ==> 포함 
*         -------------------------- 대소문자 구분 
*       기타 
*         = length() : 문자의 갯수 
*         = concat() : 문자열 결합 ===> +
*         = trim() : 공백문자 제거 
*     = StringBuffer / StringBuilder 
*       = append() => 문자열 결합 
*     = Math : 수학 
*       = ceil() : 올림 함수 
*       = random() : 난수 (0.0~0.99)
*     = System
*       = gc() , in.read() / out.println() / exit()
*       = currentTimeMillis() : 시간측정 
*     = Wrapper : 기본형을 클래스화 => 사용이 편리하게 만든다  
*       int ====> Integer 
*       long ====> Long 
*       double ====> Double
*       boolean ===> Boolean 
*       byte   ====> Byte 
*       ---------------------- 기능 사용 / 제네릭에서 주로 사용 
*       => parseInt() / parseDouble() / parseBoolean() 
*       
*       => 오토박싱 / 언박싱 
*          Integer i=100; ==> 오토박싱 
*          int ii=i ==> 언박싱 
*          ==> int / Integer는 호환 
*     = Thread : Application 
*                => 크롤링 데이터가 많은 경우 
*   java.lang => import를 생략이 가능 
*   
*   ***java.util => 컬렉션  
*   ***java.text => DecimalFormat 
*   ***java.io => File관련 
*   java.net : URL => Socket
*   ***java.sql : Connection / Statement / ResultSet
*   ----------------------
*   => 어노테이션 
*   => 리플렉션 
*   => JSON
*   => 정규식 
*   ----------------------
*   람다 
*   쓰레드 
*   ----------------------
*/
public class Object_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// package 위치 => 데이터형 / 클래스도 데이터형 (참조형)
     Food f=new Food();
     System.out.println(f.getClass());
     String s="";
     System.out.println(s.getClass());
     
	}

}