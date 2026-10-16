import java.util.Scanner;
/*
 * 국어 영어 수학 => 총점 평균 학점
 * 
 *  
 *  
 *  */

public class 다중조건문_3 {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("국어 입력");
		int kor=scan.nextInt();
	
		System.out.println("영어 입력");
		int eng=scan.nextInt();
	
		System.out.println("수학 입력");
		int math=scan.nextInt();
		
		int total=kor+eng+math;
		double avg=total/3.0;
		
		char score='A',opt='+';
		
		int avg2=(int)avg;
		if(avg2>=90)
		{
			score='A';
			if(avg2>=97 && avg2<=100)
				opt='+';
			if(avg2>=94 && avg2<=96)
				opt='0';
			if(avg2<94)
				opt='-';
			
			
		}
		else if(avg2>=80)
		{
			score='B';
			if(avg2>=87 && avg2<=89)
				opt='+';
			if(avg2>=84 && avg2<=86)
				opt='0';
			if(avg2<84)
				opt='-';
		}
		else if(avg2>=70)
		{
			score='C';
			if(avg2>=77 && avg2<=79)
				opt='+';
			if(avg2>=74 && avg2<=76)
				opt='0';
			if(avg2<74)
				opt='-';
		}
		else if(avg2>=60)
		{
			score='D';
			if(avg2>=67 && avg2<=69)
				opt='+';
			if(avg2>=64 && avg2<=66)
				opt='0';
			if(avg2<64)
				opt='-';
		}
		else
		{
			score='F';
			opt=' ';
		}
		
		
		System.out.println("==결과값==");
		System.out.println("국어점수"+kor);
		System.out.println("영어점수"+eng);
		System.out.println("수학점수"+math);
		System.out.println("총점"+total);
		System.out.printf("평균:%.2f\n",avg);
		System.out.println("학점"+score+""+opt);	
		// char + char = int
	
	
	}
}
