import java.util.Scanner;

public class 반복제어문_3 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int com=(int)(Math.random()*100)+1;
		//while(true)
		for(;;)
		{
			System.out.print("정수 입력:");
			int user=scan.nextInt();
			if(user<1 || user>100)
			{
				System.out.println("1~100사이 정수");
				continue; //다시 시작
			}
			//비교
			if(com>user)
			{
				System.out.println("입력값 UP");
				
			}
			else if(com<user)
			{
				System.out.println("입력값 DOWN");
			}
			else
			{
				System.out.println("게임 오버");
				break;
			}
		}
	}
}
