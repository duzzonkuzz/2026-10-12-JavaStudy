package com.sist.study;

/*
 *    ArrayList : 데이터베이스의 실행 결과값 == 브라우저로 전송시 
 *    Set : 접속자정보를 저장할때 
 *    Map : 클래스 관리 / 쿠키 관리 / SQL 관리 
 *    -------------------------------------------------
 *    실행중에 수정 / 삭제 필요시 
 *      for-each ===> Iterator / ListIterator
 *                               ------------- List 전용  
 *                               | 양방향 
 *                   ---------- Set/Map 
 *                    | 단방향 
 *     Map ----------------------  List<Sawon> Sawon sabun/name
 *       = put(키,값) : 저장
 *       = get(키) : 읽기 
 *       = remove(키) 
 *       --------------------------------------------
 *       = containsKey(키) => if에서 사용 => 키 존재 여부
 *       = containsValue(값) => 값 존재 여부 
 *       ---------------------------------- 쿠키 저장 
 *       = clear() : 전체 삭제 
 *       ------------------------------
 *       = Set ketSet() => key 전체 읽기 
 *       ------------------------------
 *       = values() : 값 전체 읽기
 *       ------------------------------ webSocket
 *       = 키+값 : entrySet()  
 *       
 */
import java.util.*;
public class 컬렉션_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Map => 값 설정 
		Map<String,Integer> map=
				new HashMap<String,Integer>();
		map.put("사과", 100);
		map.put("배", 200);
		map.put("바나나", 150);
		map.put("포도", 180);
		map.put("참외", 120);
		
		// 값읽기 
		System.out.println("사과 갯수:"+map.get("사과"));
		System.out.println("배 갯수:"+map.get("배"));
		System.out.println("바나나 갯수:"+map.get("바나나"));
		System.out.println("포도 갯수:"+map.get("포도"));
		System.out.println("참외 갯수:"+map.get("참외"));
		
		// 전체 
		System.out.println("전체 데이터:"+map);
		// 키 존재 
		if(map.containsKey("바나나"))
		{
			System.out.println("바나나가 있음");
		}
		
		// ***키 
		for(String key:map.keySet())
		{
			System.out.println(key+":"+map.get(key));
		}
		// ***값 
		for(int val:map.values())
		{
			System.out.println(val);
		}
		// 키+값 
		for(Map.Entry<String, Integer> e:map.entrySet())
		{
			System.out.println(e.getKey()+":"+e.getValue());
		}
	}

}