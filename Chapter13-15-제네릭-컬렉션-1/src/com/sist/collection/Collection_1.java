package com.sist.collection;
/*
 *   1. 컬렉션 
 *       => 데이터를 담아두는 상자의 모음 
 *          ----         ---- 메모리 
 *       => 예) 친구이름 / 전화번호 / 맛집 정보 
 *       => 쉽게 관리하기 위해 만든 라이브러리 
 *          --------------------------
 *           컬렉션 프레임워크 
 *                -------- 통일화 (표준화)
 *   2. 사용하는 이유 
 *      = 배열 
 *        1) 크기 고정 (늘리기 / 줄이기) => 고정적 
 *                           | 작은 배열을 만든다 
 *                    | 큰 배열을 만든다 
 *        2) 일반 목록 출력 => 검색이 어렵다 
 *        3) 배열의 단점 보완 
 *           = 크기 조절이 자유롭다 (가변) => 크기를 정하지 않고 사용 
 *           = 정렬 , 검색 기능을 제공 
 *           = 모든 개발자가 동일하게 사용 => 표준화 
 *   3. 컬렉션의 종류 
 *             Collection --- interface 
 *                |
 *       -------------------------
 *       |          |            |
 *     List        Set          Map  ------- interface 
 *                  |           |
 *                        ---------------
 *                        |             |
 *                      ***HashMap       Hashtable
 *             -----------
 *             |          |
 *           ***HashSet     TreeSet
 *       | 구현된 클래스
 *   ----------------------
 *   |          |         |
 *  ***ArrayList  Vector   LinkedList -- Queue
 *  
 *  List의 기준 
 *    1) 순서가 존재 (추가시마다 자동 인덱스 번호를 부여) 
 *    2) 데이터 중복을 허용 
 *    3) 데이터베이스(오라클) 관리
 *       ArrayList : 데이터베이스용 => 비동기 
 *                   => 단점 : 추가 / 삭제 => 속도가 느리다 
 *                   => 장점 : 연결하는 속도가 빠르다 
 *       Vector : 동기화 => 네크워크의 접속자 정보를 저장 
 *                Vector를 보완 => ArrayList
 *       LinkedList : 추가 / 삭제 => 빈번한 경우 => 파일 관리 
 *                    => C언어 개발자의 전향  
 *   Set의 기준 
 *     1) 순서가 없다 , 데이터중복이 없다 
 *     2) HashSet : 비동기 , Hashtable : 동기화 
 *                          | 보완 HashSet
 *        => DISTINCT : 오라클 => 중복없이 => 장르 , 부서명 , 직위
 *   Map의 기준 
 *     1) 키,값 => 동시에 저장 
 *     2) HashMap 
 *     3) 클래스 관리 , SQL 
 *     4) ---------  ----
 *        Spring      MyBatis
 *        
 *        <bean id="a" class="A">
 *        <select id="list">
 *         SELECT * FROM member
 *        </select>
 *     5) 사용자 요청 / 결과값 전송 / 쿠키 저장 / 세션 저장 
 *        ----------------------------------------- Map 
 *        request     response   cookie    session
 *                                         session.setAttribute("키","값")
 *                               new Cookie("키","값")
 *        request.setAttribute("키",값)
 *        => 파일 : properties / yml
 *        
 *     => 데이터를 효율적으로 관리할 수 있게 만든 라이브러리 
 *     
 *     이름 전화번호
 *         -- 값은 중복 허용 
 *     --- 키가 중복이 없다 
 *     
 *     --------------------------------------------
 *      List : java.util 
 *             ----------
 *        => 순차적으로 데이터 저장 => for
 *        => 인덱스 통해서 접근 
 *        ArrayList list=new ArrayList();
 *        list.add(1) = 0
 *        X list.add(2) = 1
 *        list.add(3) = 1
 *        ...
 *        ...
 *      
 */
import java.util.*;
//  자료구조 => 메모리 효율적으로 사용이 가능 : Create Read Update Delete 
//  => RDBMS : 오라클 (SQL) => SELECT INSERT UPDATE DELETE 
/*
 *    ArrayList 
 *      1) 순서를 가지고 있다 (추가시마다 => 자동 인덱스) => 배열 기반 
 *         인덱스는 0부터 시작한다 
 *      2) 저장된 데이터가 중복 허용 
 *         => 메모리에 저장 
 *      3) 비동기적 => 속도가 빠르다 = 데이터베이스 연동의 최적화 
 *      4) 주요기능 
 *         ***추가 : add() , add(int index)
 *         삭제 : remove(int index) => [0]
 *         수정 : set(int index,데이터)
 *         ***읽기 : get(int i)
 *         ***갯수 : size() => length
 *         ***전체 삭제 : clear()
 *         ***데이터 존재 여부 확인 : isEmpty()
 *      5) 주요사용처 
 *         오라클에서 데이터 읽는 경우 => 배열 (X)
 *         쿠키를 읽어서 브라우저 전송  
 *      6) 같은 데이터형을 저장한다 
 *         ---------- <> : 제네릭 
 *         
 */
public class Collection_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. 저장공간 만들기 
		Vector list=new Vector(); // 모든 데이터가 Object
		// 2. 데이터 저장 
		list.add("홍길동"); // 0
		list.add("심청이"); // 1
		// 을지문덕
		list.add("이순신"); // 3 
		list.add("강감찬"); // 4
		list.add("박문수"); // 5
		//list.add("춘향이"); //6
		
		// 
		// 출력 
		//A name1=(A)10
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(i+":"+name);
		}
		
		System.out.println("========= 추가 ========");
		
		list.add("춘향이");
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("======= 지정된 위치에 추가 =====");
		list.add(2,"을지문덕"); // 속도가 느리다
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("======== 삭제 =========");
		list.remove(1);
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("====== 현재 인원 ======");
		System.out.println("현재 인원:"+list.size());
		System.out.println("======= 수정 =========");
		list.set(1, "춘향이");
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("====== 전체 삭제 =======");
		list.clear();
		System.out.println("현재 인원:"+list.size());
		System.out.println("====== 데이터 존재 여부 =======");
		if(list.isEmpty()) // 장바구니 , 검색 
		{
			System.out.println("존재하는 인원이 없습니다");
		}
		else
		{
			System.out.println("존재하는 인원이 있습니다");
		}
	}


	
	
	
}

