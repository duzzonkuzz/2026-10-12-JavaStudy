package exception;

public class 예외처리_실행순서 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        // 의심 
        try
        {
        	System.out.println("4");
        	System.out.println("5");
        	///////////////////////////
        	System.out.println(10/0);
        	System.out.println("7");
        	/////////////////////////// 수행이 안된다 
        }catch(Exception ex)
        {
        	System.out.println("0으로 나눌 수 없습니다"); // 에러 발생 처리 => if
        }
        finally
        {
        	System.out.println("프로그램 정상 수행");
        }
        System.out.println("10");
        System.out.println("프로그램 종료");
	}

}