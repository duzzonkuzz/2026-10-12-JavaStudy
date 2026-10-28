// 달력
/*
 *  1년도 1월 1일 ~~ 전년도까지 => 총날 수 
 *                 전달까지 => +
 *                 Day +
 *      ---------------
 *   %7 => 요일 구함
 *   => 윤년 계산
 */
import java.util.*;
public class 배열_4 {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.print("년도 입력:");
	int year=scan.nextInt();
	System.out.print("월 입력:");
	int month=scan.nextInt();
	System.out.print("일 입력:");
	int day=scan.nextInt();
	
	System.out.println(year+"년 "+month+"월 "+day+"일");
	
	int total=(year-1)*365
			  +(year-1)/4
			  -(year-1)/100
			  +(year-1)/400;
	int[] last= {31,28,31,30,31,30,31,31,30,31,30,31};
	if((year%4==0 && year%100!=0)||(year%400==0))
	
	last[1]=29;
		else
			last[1]=28;
	
	for(int i=0;i<month-1;i++)
	{
		total+=last[i];
	}
	
//	total+=day;
	total++;
	int week=total%7;
	
	String[] strweek= {"일","월","화","수","목","금","토"};
//	System.out.println(year+"년도 "+month+"월 "+day+"일은 "+strweek[week]+"요일입니다");
	//달력 출력
	for(String w:strweek)
	{
		System.out.print(w+"\t");
	}
	System.out.println("\n");
	for(int i=1;i<=last[month-1];i++)
	{
		if(i==1)
		{
			for(int j=0;j<week;j++)
			{
				System.out.print("\t");
			}
		}
		if(i==day)
		{
			System.err.printf("%2d\t",i);
		}
		else
		{
			System.out.printf("%2d\t",i);
		}
		
		week++;
		if(week>6)
		{
			week=0;
			System.out.println();
		}
	}//for
	
}
}
