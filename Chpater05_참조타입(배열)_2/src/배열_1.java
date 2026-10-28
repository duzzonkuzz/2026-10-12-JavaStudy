/*
 *   1. 배열 
 *      같은 데이터형을 모아서 관리가 쉽게 만든다 
 *      ---------------------
 *      사용시에는 index를 이용하는 방식 
 *      속도가 빠르다, 자료구조 => 단신하다 
 *      고정데이터 : 수정 / 삭제 / 추가 => 어렵다 
 *      --------
 *      *** index번호는 0부터 순차적 => 반복문을 이용하기 쉽다 
 *      
 *      = 배열 선언 
 *        데이터형[] 배열명; => 권장사항 
 *         => 기본형 
 *         byte[] => 파일 / 네트워크 
 *                   업로드시 주로 등장 
 *         int[] => 가격/ 성적 ...
 *         long[] => 금융권 
 *         char[] => 사용 빈도가 거의 없다 
 *         double[] => 평점 ...
 *         boolean[] => 존재여부 => 재고
 *        => 클래스 
 *         String[] => 영화제목 / 노래
 *         Food[]
 *         Recipe[]
 *        데이터형 배열명[];
 *      = 배열 초기화 
 *        int[] arr={10,20,30...}
 *        int[] arr=new int[10] ====> 가장 많이 사용 
 *      = 배열 데이터 출력 
 *        데이터 변경 =======> 일반 for 
 *        데이터만 출력 =====> for-each
 *      = 배열 데이터 변경 
 *        int[] arr={10,20,30};
 *                      |   |
 *                         arr[2]=300
 *                     arr[1]=100
 *      = 배열크기 조절 / 새로운 배열 생성
 *                     | clone() 
 *                     | 참조 => 대입 
 *        Arrays.copyOf()  
 *        
 *      -----------------------------------------
 *       int[] arr={10,20,30};
 *       
 *         stack             heap
 *       ----arr----        0x100-----------------
 *                                    arr[1] arr[2]
 *         0x100       ==>        10   20   30
 *                                 |   |     |
 *                                arr[0]
 *       -----------             -----------------
 *                               arr=> 0x100에 있는 index는 자동 생성
 *                                               --------
 *                                               | 값마다 구분자 
 *                               => length
 *                               int a=10 ==> & / *
 *      
 */
import java.util.*;
public class 배열_1 {
	public static void main(String[] args) {
		int[] a= {10,20,30,40,50,};
		System.out.println(a);
		int[] b=a;
		System.out.println(b);
		b[0]=100;
		System.out.println(b[0]); //같은 주소면 같은 데이터를 공유
		
		int[] c=a.clone();
		// 데이터 포함 복사 새로운 메모리 생성
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(c));
		c[0]=200;System.out.println(a);System.out.println(c);
	}

}
