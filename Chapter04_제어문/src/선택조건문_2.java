/*
 * 국어 영어 수학 점수를 입력 받아서 => 총점 평균 합격 => 60점이상이면 합격
 */

import java.util.Scanner;

public class 선택조건문_2 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("국어 점수:");
		int kor=scan.nextInt();
		System.out.println("영어 점수:");
		int eng=scan.nextInt();
		System.out.println("수학 점수:");
		int math=scan.nextInt();
		
		System.out.println("총점"+(kor+eng+math));
		double avg=(kor+eng+math)/3.0;
		System.out.printf("평균:%.2f\n",avg);
		
		if(avg>=60)
		{
			System.out.println("합격");
			
		}
		else
		{ System.err.println("불합");
		}
		
		
		
		}
		}



