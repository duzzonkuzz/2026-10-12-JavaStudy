/*
 *  Arrays.copyOf()
 *     기존의 배열의 내용을 복사해서 새로운 배열을 만드는 메소드
 *       => 배열의 크기를 조절 가능
 *   Arrays.copyOf(기존배열,length)
 */
import java.util.*;
public class 배열_2 {public static void main(String[] args) {
	int[] a= {100,200,300};
//	int[] c=Arrays.copyOf(a, 5);
//	System.out.println(Arrays.toString(a));System.out.println(Arrays.toString(c));
//	
//	int[] c2=new int[5];
//	for(int i=0;i<a.length;i++)
//	{
//		c2[i]=a[i];
//	}
//	System.out.println(Arrays.toString(a));
//	System.out.println(Arrays.toString(c2));
	
	/*
	 *  System.Arrayscopy()
	 *  배열의 데이터를 다른 배열로 복사하는 메소드
	 */
	
	int[] arr= {10,20,30,40,50};
	int[] tar=new int[5];
	System.arraycopy(arr, 0, tar, 3, 1);
	       // 원본/ 시작인덱스/ 대상 / 인덱스 번호 / 갯수
	System.out.println(Arrays.toString(arr));
	System.out.println(Arrays.toString(tar));
	/*
	 * System.arraycopy()          ** Arrays.copyOf()
	 * 기존에 배열 데이터 복사          새로운 배열 생성 => 데이터 복사
	 *   크기 자동 변경 x                 원하는 크기로 변경 가능
	 *   부분 복사/배열 통합           배열 크기 변경 / 전체 복사
	 *   
	 *   참조 a=b / Call By Reference
	 *   Arrays.copyOf() / Clone
	 */
	
	
	
	
	
	
}
}
