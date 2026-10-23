// Arrays.sort()
/*
 * 30 20 50 10 40 올림차순 ASC / 내림차순 DESC
 * 
 */

import java.util.Arrays;

public class 선택정렬 {
public static void main(String[] args) {
//	int[] arr=new int[5];
//	for(int i=0;i<arr.length;i++)
//	{
//		arr[i]=(int)(Math.random()*100)+1;
//		
//	}
//	System.out.println("정렬전: "+Arrays.toString(arr));
//for(int i=0;i<arr.length-1;i++)
//{
//	for(int j=i+1;j<arr.length;j++)
//	{
//		if(arr[i]>arr[j])
//				{
//			int temp=arr[i];
//			arr[i]=arr[j];
//			arr[j]=temp;
//				}
//		
//	}
//	System.out.println((i+1)+"round:"+Arrays.toString(arr));
//}
//System.out.println("정렬후: "+Arrays.toString(arr));
	char[] arr=new char[5];
	for(int i=0;i<arr.length;i++)
	{
		arr[i]=(char)((Math.random()*26)+65);
		
	}
	System.out.println("정렬전: "+Arrays.toString(arr));
for(int i=0;i<arr.length-1;i++)
{
	for(int j=i+1;j<arr.length;j++)
	{
		if(arr[i]<arr[j])
				{
			char  temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
				}
		
	}
	System.out.println((i+1)+"round:"+Arrays.toString(arr));
}
System.out.println("정렬후: "+Arrays.toString(arr));

}
}
