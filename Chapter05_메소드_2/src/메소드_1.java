/*
 * 메소드는 사용자 요청 처리하기 위한 명령문의 집합
 *        ------------ 특정 작업(기능)
 * => 코드 재사용 / 기능 분리 (분업 처리)
 * => 개발 x => 유지보수 목적
 * ------------------------------
 * 매개변수 : 사용자가 요청 값
 * 리턴형 : 요청처리 결과값
 * ---- 권장 (동일) = 클수도 있다
 * 결과값을 넘겨주는 경우 : return 값
 * => 정수 10개 -> 합을 구해서 반환
 * 매개변수 : int[]
 * 리턴형 : int
 * return 합계값
 */
import java.util.*;


public class 메소드_1 {
	static int hap(int[] arr)
	{
		int sum=0;
		for(int i:arr)
		{
			sum+=i;
		}
		return sum;
	}
	// 최댓값
	// 최솟값

	static int max(int[] arr)
	{
		int max=0;
		for(int i:arr)
		{
			if(i>max)
				max=i;
		}
		return max;
	}
	static int min(int[] arr)
	{
		int min=110;
		for(int i:arr)
		{
			if(i<min)
				min=i;
		}
		return min;
	}
	static double avg(int[] arr)
	{
		int sum=0;
		for(int i:arr)
		{
			sum+=i;
		}
		return sum/10.0;
		
	}
	//홀짝 갯수
	
	static int even(int[] arr)
	{
		int count=0;
		for(int i:arr)
		{
			if(i%2==0)
				count++;
		}
		return count;
	}
	static int odd(int[] arr)
	{
		int count=0;
		for(int i:arr)
		{
			if(i%2!=0)
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
			
		}
		int sum=hap(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("합:"+sum);
	int max=max(arr);
	
	System.out.println("max:"+max);
	int min=min(arr);
	
	System.out.println("min:"+min);
	double avg=avg(arr);
	
	System.out.printf("평균:%.2f\n",avg);
	
	int even=even(arr);
	System.out.println("짝수:"+even);
	int odd=odd(arr);
	System.out.println("홀수:"+odd);
	
	}
}
