/// 정수를 5개를 보내고 최댓값 가지고 온다 
// 정수 5개를 보내고 정렬된 데이터 받기 
/*
 *    데이터형 
 *      기본형 / 참조형 
 *             배열 => 메소드연습_2[] 
 *             클래스 
 *    class A  => A
 *    class B  => B ==> 참조데이터형
 *    int a=10;
 *    A a => 객체
 *    
 *    int / double / String
 *    
 */
import java.util.Arrays;

public class 메소드연습_2 {
	static int max(int[] arr)
    {
    	int m=0;
    	for(int i=0;i<arr.length;i++)
    	{
    		if(m<arr[i])
    			m=arr[i];
    	}
    	return m;
    }
    static int[] sort(int[] arr)
    {
    	Arrays.sort(arr);
    	return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr= {10,30,50,20,40};
        int m=max(arr);
        System.out.println(m);
        System.out.println(Arrays.toString(sort(arr)));
	}

}