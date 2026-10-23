import java.util.*;

/*
 * 출력 
 *  for(int i=0;i<arr.length;i++)
 *  {
 *  sysout
 *  }
 */
public class 배열_3 {
public static void main(String[] args) {
	int[] lotto=new int[6];
	for(int i=0;i<lotto.length;i++)
	{
		lotto[i]=(int)(Math.random()*45+1);
		for(int j=0;j<i;j++)
		{
			if(lotto[i]==lotto[j])
			{
				i--;
				break;
			}
		}
		
	}
	Arrays.sort(lotto);
	for(int i:lotto)
	{
		System.out.println(i+" ");
	}
	
	
	
	int[] arr = new int[3];
	for(int i=0;i<arr.length;i++) //제어 변수 i for 밖에서 사라짐
	{
		System.out.println(arr[i]);
	}
	
	for(int a : arr)
	{
		System.out.println(a);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
