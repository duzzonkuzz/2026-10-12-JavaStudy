import java.util.Scanner;

public class 반복제어문_2 {
	public static void main(String[] args) {
		int kor=0,eng=0,math=0;
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("국어 입력:");
			kor=scan.nextInt();
			if(kor<0 || kor>100)
			{
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			break;
			
			
			
		}//while
		
		while(true)
		{
			System.out.println("영어 입력:");
			eng=scan.nextInt();
			if(eng<0 || eng>100)
			{
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			break;
			
			
			
		}//while
		
		while(true)
		{
			System.out.println("수학 입력:");
			math=scan.nextInt();
			if(math<0 || math>100)
			{
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			break;
			
			
			
		}//while
		
	   System.out.println("==결과==");
		System.out.println("국어점수:"+kor);
		System.out.println("영어점수:"+eng);
		System.out.println("수학점수:"+math);
		System.out.println("총점:"+(kor+eng+math));
		System.err.printf("평균:%.2f\n",(kor+eng+math)/3.0);
		int avg=(kor+eng+math)/3;
		char score='A';
		switch(avg/10)
		{
		case 10,9 -> score='A';
		case 8,7 -> score='B';
		case 6,5 -> score='C';
		case 4,3 -> score='D';
		default -> score='F';
		}
		System.out.println("학점:"+score+"학점");
		
		
		
		
		
		
		
	}
	
	
	
	

}
