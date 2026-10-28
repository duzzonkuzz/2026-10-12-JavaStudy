import java.util.*;
public class 배열_5 {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.print("년도 입력:");
	int year=scan.nextInt();
	System.out.print("월 입력:");
	int month=scan.nextInt();
	System.out.print("일 입력:");
	int day=scan.nextInt();
	
	System.out.println(year+"년 "+month+"월 "+day+"일");
	
	Calendar cal=Calendar.getInstance();
	cal.set(Calendar.YEAR, year);
	cal.set(Calendar.MONTH, month-1);
	cal.set(Calendar.DATE, 1);
	
	int week=cal.get(Calendar.DAY_OF_WEEK);
	week=week-1;
	int lastday=cal.getActualMaximum(Calendar.DATE);
	String[] strweek= {"일","월","화","수","목","금","토"};
	for(String w:strweek)
	{
		System.out.print(w+"\t");
	}
	System.out.println("\n");
	for(int i=1;i<=lastday;i++)
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
	}
}
}
