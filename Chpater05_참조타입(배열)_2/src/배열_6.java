import java.util.*;
/*
 * 3자리 정수 => 맞추는 프로그램
 * ----------
 * 힌트 
 *       포함 숫자 있다
 *       -----
 *       같은 자리 : s
 *       다른자리 : b
 *       123 => 235 ==> 0s2b
 *       
 *       1. break continue
 *       --------------
 *   
 */
public class 배열_6 {
public static void main(String[] args) {
	int[] com=new int[3];
	for(int i=0;i<com.length;i++)
	{
		com[i]=(int)(Math.random()*9)+1;
		for(int j=0;j<i;j++)
		{
			if(com[j]==com[i])
			{
				i--;
				break;
				
			}
		}
	}
}
}
