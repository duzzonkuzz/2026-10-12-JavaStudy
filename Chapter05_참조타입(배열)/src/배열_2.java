import java.util.Arrays;

public class 배열_2 {
public static void main(String[] args) {
	int[] arr=new int[10];
	for(int i=0;i<arr.length;i++)
	{
		arr[i]=(int)(Math.random()*100+1);
		
	}
	System.out.println("===for =====");
	for(int i=0;i<arr.length;i++)
	{
		System.out.println(arr[i]+" ");
	}
	
	
	System.out.println("\n===for each====="); //값을 변경할 수 없다 => 출력용으로만 사용
	for(int i:arr)
	{
		System.out.println(i+" ");
	}
	
	
	System.out.println("\n===toString=====");
	System.out.println(Arrays.toString(arr));
	/*
	 * int[] arr=
	 */
	
	int max=arr[0];
	int min=arr[0];
	for(int i:arr)
	{
		if(i>max)
			max=i;
		if(i<min)
			min=i;
	}
	System.out.println(max);
	System.out.println(min);
	//////////
	System.out.println("===max의 위치====");
	int index=0;
	for(int i=0;i<arr.length;i++)
	{
		if(max==arr[i])
		{
			index=i;
			break;
		}
	}
	System.out.println("위치"+(index+1));
	System.out.println("===min의 위치===");
	for(int i=0;i<arr.length;i++)
	{
		if(min==arr[i])
		{
			index=i;
			break;
		}
		
	}
	System.out.println("위치"+(index+1));
}
}
