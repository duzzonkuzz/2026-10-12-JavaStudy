
public class 반복문_while_3 {
	public static void main(String[] args) {
		int sum=0,even=0,odd=0;
		// 합을 누적 => 누적변수 
		int i=1; // 루프변수 1~100까지 저장
		while(i<=100)
		{
			sum+=i;
			if(i%2==0)
				even+=i;
			else
				odd+=i;
			i++;
			
		}
		System.out.println("총합"+sum);
		System.out.println("짝수"+even);
		System.out.println("홀수"+odd);
	}

}
