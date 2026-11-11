package com.sist.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 *   java.time 
 *   java.time.format => 날짜시간 변경 
 *   => MySQL => LocalDateTime
 *   => Oracle => Date 
 *   
 *   LocalDateTime : 날짜+시간
 *   LocalDate : 날짜 
 *   LocalTime : 시간 
 *   => final 
 *   
 *   라이브러리 
 *      Object/String/Math/StringBuilder/StringBuffer/System 
 *      ===> 계속 나온다 (웹)
 *      Date/Calendar/LocalDateTime => 웹,데이터베이스
 *      ---------------------------
 *      컬렉션 => => 웹,데이터베이스
 *      ---------------------------
 *      
 *   
 */
public class Time_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. 현재 날짜 + 시간 
		LocalDateTime now=LocalDateTime.now();
		System.out.println(now);
		// 2. 특정 날짜 시간 생성 
		LocalDateTime dateTime=
				LocalDateTime.of(2026, 11, 11, 12, 30,30);
		System.out.println(dateTime);
		
		// 3. 날짜/시간 더하기 / 빼기 
		LocalDateTime f=now.plusDays(4).plusHours(3);
		System.out.println(f);
		LocalDateTime p=now.minusMonths(1);
		System.out.println(p);
		
		// 값추출 
		int year=now.getYear();
		int month=now.getMonthValue();
		int day=now.getDayOfMonth();
		int hour=now.getHour();
		
		System.out.println("년도:"+year);
		System.out.println("월:"+month);
		System.out.println("일:"+day);
		System.out.println("시:"+hour);
		
		// ==> Date / Calendar 
		// 2026-11-11 12:22:28 
		
		// 변경 ==> JPA
		DateTimeFormatter ff=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// MM / mm  hh(1~12) / HH(1~24)
		String str="2026-03-31 15:47:40";
		LocalDateTime t=LocalDateTime.parse(str,ff);
		System.out.println(t);
		String fff=dateTime.format(ff);
		System.out.println(fff);
		
	}

}
