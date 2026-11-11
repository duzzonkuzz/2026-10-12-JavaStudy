 package com.sist.format;
/*
 *   java.text.* 패키지
 *   ---------------
 *   
 *   
 *   new DecimalFormat("##
 */
 
 import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class Format_1 {
public static void main(String[] args) {
	/*
	 *  1. 년도 yyyy yy
	 *  2. 월   MM   M
	 *  3. 일   dd   d
	 */
	Date date=new Date();
	System.out.println(date);
	SimpleDateFormat sdf=new SimpleDateFormat("yy-M-d h:m:s");
	System.out.println(sdf.format(date));
	
	DecimalFormat df=new DecimalFormat("###,###,###");
	int won=100000;
	System.out.println(df.format(won));
	
	int no=1;
	String name="홍길동";
	String sex="남자";
	String address="서울";
	String phone="101-1111-1111";
	int age=30;
	String content="홍길동입니다";
	
//	String sql="INSERT INTO member VALUES"("
//		+no+",	)	
	
	double[] limits= {0,60,70,80,90};
	String[] formats= {
			"f","d","c","b","a"
	};
	ChoiceFormat cf=new ChoiceFormat(limits, formats);
	System.out.println(cf.format(85));
double num=1234567.89;
	NumberFormat nf=NumberFormat.getInstance();
	// new를 사용하지 않는 경우 => 인터페이스 / 추상클래스
	// 미완성 클래스 => new를 사용ㄹ해서 메모리 할당이 안된다
	System.out.println(nf.format(num));
	
	nf=NumberFormat.getCurrencyInstance();
	System.out.println(nf.format(num));
	
	
	nf=NumberFormat.getPercentInstance();
	System.out.println(nf.format(0.25));

	
	
}
}
