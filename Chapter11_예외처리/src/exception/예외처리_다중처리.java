package exception;
/*
 *   다중 catch사용 
 *   ------------ 의심되는 에러가 여러개 존재 
 *   
 *   1. 배열 생성 
 *   2. 문자열 => 정수 변환 => 배열에 저장 
 *   3. 나누기 
 */
import java.util.*;
public class 예외처리_다중처리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("첫번째 문자 입력:");
        String first=scan.next();
        System.out.print("두번째 문자 입력:");
        String second=scan.next();
        
        int[] arr=new int[2];
       try
       {
        arr[0]=Integer.parseInt(first);
        arr[1]=Integer.parseInt(second);
        System.out.println(arr[0]/arr[1]);
       }
       catch(NumberFormatException e)
       {
    	   System.out.println("정수 변환에 실패하였습니다");
       }catch(ArrayIndexOutOfBoundsException e)
       {
    	   System.out.println("배열 범위 초과");
       }catch(Exception e)
       {
    	   System.out.println(e.getMessage());
       }
       System.out.println("프로그램 종료");
	}

}