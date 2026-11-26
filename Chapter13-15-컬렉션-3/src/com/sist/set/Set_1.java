package com.sist.set;
/*
 *    목적 
 *      => 배열의 단점을 보완 => 고정적 => 가변적 
 *      => 표준화 / 일정 틀 => 메소드만 기억 
 *    컬렉션 
 *    ------
 *          Collection 
 *             |
 *     ---------------------
 *     |       |           |
 *    List   Set         Map 
 *     |      |           |
 *                      HashMap 
 *           HashSet
 *   ArrayList
 *   
 *   List (ArrayList,LinkedList,Vector)
 *     1) 순서를 가지고 있다 (인덱스가 자동 생성) => 0 / 추가/삭제 상관없이 순차적 
 *     2) 데이터 중복이 가능 
 *     3) CRUD를 주로 사용 
 *     4) 비동기적 => 속도가 빠르다 => 데이터베이스 주로 사용 
 *     5) 주요 기능 
 *        add(Object) : 추가 
 *        get(int index) : 읽기 
 *        set(int index,Object) : 수정 
 *        remove(int index) : 삭제 
 *        size() : 갯수 
 *        clear() : 전체 삭제 
 *        isEmpty() : 데이터 존재 여부 => 장바구니 
 *     6) java.util에 존재 
 *    ----------------------------------------------------
 *    Set (HashSet , TreeSet) 
 *     1) 순서가 없다 (인덱스가 없다) 
 *     2) 중복데이터를 허용하지 않는다 
 *     3) 주로 사용 => List에서 중복된 데이터 제거 
 *                   WebSocket을 이용해 채팅 => 중복 User제거 
 *     4) 주요 기능 
 *         add(Object) : 추가 
 *         get() : 읽기
 *         set(Object) : 수정 
 *         remove(Object) : 삭제 
 *         size() : 갯수 
 *         clear() : 전체 삭제 
 *         isEmpty() : 존재여부 확인 
 *     5) 일반 for문은 사용하지 못한다 => for-each 
 *        => Iterator : 데이터 전체를 모아서 출력 
 *        
 *        어떤 클래스 : 역할 
 *        종류 / 주요 메소드 / 사용처 / 선택기준 
 *        ------------------------------- 라이브러리 
 *        1. 클래스명 / 메소드 (메소드명 , 리턴형 , 매개변수) 
 *        2. 어떤 효과 / 속도의 최적화 
 *        
 *    -------------------------------------------
 *                  Collection
 *                  => 데이터를 저장후에 관리 
 *    -------------------------------------------
 *       List            Set             Map
 *       순서(O)          순서(X)          key - value 
 *                                      중복(X)  중복(O)
 *       ArrayList       HashSet         HashMap
 *                                       => 자바스크립트 , 코틀린 연동 
 *                                       => JSON 
 *                       => Web에서 채팅 
 *                       => List의 중복 제거 
 *       => 오라클 연동 
 *       => Spring: 클래스 관리 
 *       => MyBatis의 SQL관리 
 *       => HashSet / TreeSet       
 *     -------------------------------------------
 *      전체 적용 
 *        = 제네릭 => 최대한으로 데이터형을 통일화 => 형변환(X) , 관리가 쉽다
 *        = 클래스<클래스형>
 *      ------------------------------------------
 *      HashSet 
 *        => 중복 제거에 가장 많이 사용되는 클래스 (O)
 *        => 중복을 허용(X) 
 *        => 저장 순서가 보장되지 않는다 
 *        => 검색 / 추가 / 삭제가 평균적 빠르다 
 *      TreeSet 
 *        => 중복을 허용(X) 
 *        => 정렬시에 사용 => 자동으로 정렬 (O)
 *        => 범위 검색에 적합 
 *        => 시험 점수 순위 
 *        => 가격순 상품 목록 
 *        => 중복없는 점수 정렬 
 */
import java.util.*;
public class Set_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. 객체생성 
		HashSet<String> set=new HashSet<String>();
		// 2. 데이터 첨부 
		set.add("사과");
		set.add("배");
		set.add("수박");
		set.add("참외");
		set.add("귤");
		set.add("사과"); // 제외
		set.add("참외"); // 제외 
		// 같은 데이터가 들어오면 제외
		System.out.println("과일 갯수:"+set.size());
		// 출력 
		for(String f:set)
		{
			System.out.println(f);
		}
		// 3. 삭제 
		System.out.println("======== 삭제 =======");
		set.remove("배");
		System.out.println("과일 갯수:"+set.size());
		// 출력 
		for(String f:set)
		{
			System.out.println(f);
		}
		// 인덱스번호가 없다 
		System.out.println("========= 전체 삭제 ======");
		set.clear();
		System.out.println("과일 갯수:"+set.size());
		// 출력 
		for(String f:set)
		{
			System.out.println(f);
		}
		System.out.println("======== 존재 여부 확인 ======");
		// DISTINCT : 오라클 명령어 => 중복 제거 가능 
		if(set.isEmpty())
		{
			System.out.println("과일이 없습니다");
		}
		else
		{
			System.out.println("과일이 있습니다");
		}
		/*
		 *   단점 
		 *    객체 단위 저장 => 같은 이름이 있는 경우에는 제거할 수 없다 
		 *                   -----------------------
		 *                   Sawon s1=new Sawon("홍길동");
		 *                   Sawon s2=new Sawon("홍길동");
		 *                   ==> hashCode를 동일하게 만든다 
		 *                       -------- 객체 구분자 
		 *    JSP , Servlet , Spring , SpringBoot (X)
		 *    만약 사용 : WebSocket을 이용한 접속자 정보 
		 *    TreeSet ==> 오라클에도 존재 
		 */
	}

}