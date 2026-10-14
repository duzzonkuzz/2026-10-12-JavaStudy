import java.util.Arrays;

public class 단항연산자_증감연산자_1 {
	public static void main(String[] args) {
		int[] arr=new int[10];
		int count=10;
		for(int i=10;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*10)+1;
			if(arr[i]==5)
				  count++;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(count);
			
	}

}
