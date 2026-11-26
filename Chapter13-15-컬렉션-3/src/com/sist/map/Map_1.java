package com.sist.map;
import java.util.*;
/*
 *    Map : 인터페이스 
 *     |
 *   -------------
 *   |           |
 *  HashMap Hashtable(레거시) => 동기화 
 *   | 비동기 => 가장 많이 사용되는 클래스 
 *  --------------------------------
 *   1) 프레임워크 
 *      Spring =>  등록된 클래스 관리 
 *      MyBatis => SQL문장 관리 
 *   2) 자바스크립트 연동 / 코틀린 연동 
 *         |              |
 *         ----------------
 *             | JSON ===> 키:값 
 *                         -- --
 *                            | 중복 
 *                         | 중복 
 *      => Vue3 / React / Jquery 4
 *   3) 구분이 있는 경우에 주로 사용 : 쿠키 저장 / 세션 저장 / 요청값 / 응답값 
 *   
 *   4) 특징 
 *      => 두개를 동시에 저장 
 *         key  , value 
 *                | 중복이 가능하다 
 *         | 중복없는 값 => 구분자로 주로 사용 
 *         Map<String,Object> 
 *             | 문자열 
 *         => key가 중복되면 저장이 안된다 
 *         map.put("id","admin")
 *         map.put("id","shim") ==> X
 *         
 *   5) 주요메소드 
 *      저장 put(키,값) / 읽기 get(키)
 *   
 */

public class Map_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, String> map=
				new HashMap<String, String>();
		  map.put("id", "admin");
	        map.put("password", "1234");
	        map.put("name", "홍길동");
	        map.put("age", "30");
	        map.put("sex", "남자");
	        map.put("id", "hong");
	        
	        System.out.println(map.get("id"));
	        System.out.println(map.get("password"));
	        
	        Set<String> set=map.keySet();
	        System.out.println(set);
	        
	        for(String key:set)
	        {
	        	System.out.println(key+":"+map.get(key));
	        }
		
	        for(String s:map.values())
	        {
	        	System.out.println(s);
	        }
		
		
	}
}