package com.sist.annotation;
/*
 *   어노테이션은 기능은 없다 
 *   ------------------- 구분자 역할
 *   => 클래스 / 변수 / 메소드 / 생성자 / 매개변수 
 *   => if을 대체하는 프로그램 
 *   => 인덱스 => 표시하는 기능 
 *   1) 유지 정책 : Retention
 *      SOURCE : 소스코드에만 존재 => 컴파일시에 사라진다 
 *      CLASS : 클래스파일까지 유지 => 실행중인 리플렉션으로 읽을 수 없다 
 *      RUNTIME : 프로그램 종료까지 유지 => 리플렉션으로 읽을 수 있다 
 *      -------
 *   2) 구분 
 *      class ===> TYPE
 *      method ===> METHOD 
 *      constructor ==> CONSTRUCTOR
 *      field  ===> FIELD 
 *      parameter ==> PARAMETER
 *   3) 제어 위치 
 *      메소드위 / 생성자위 / 클래스위 / 매개변수 옆
 *    
 */
import java.util.Date;
import java.sql.*;
public class 어노테이션_1 {public static void main(String[] args) {
	Date date=new Date();
}

}
