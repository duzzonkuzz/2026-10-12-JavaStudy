/*
 * 
 */
import java.util.*;
public class 메소드_2 {
	static String[] nameFind(String name)
	{
		String[] names= {"홍길동","이순신","강감찬","심청이","춘향이"};
		int count=0;
		for(String n:names)
		{
			if(n.contains(name))
			{
				count++;
			}
		}
		System.out.println(count);
		String[] nn=new String[count];
		int i=0;
		for(String n:names)
		{
			if(n.contains(name))
			{
				nn[i]=n;
				i++;
		}
			}
		return nn;
	}
public static void main(String[] args) {
	String[] arr=nameFind("홍길동");
	System.out.println(Arrays.toString(arr));
	arr=nameFind("이");
	System.out.println(Arrays.toString(arr));
	
}
}
