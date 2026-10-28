import java.util.*;
public class 이중for_4 {public static void main(String[] args) {
	// TODO Auto-generated method stub
	
//    for(int i=1;i<=3;i++)
//    {
//    	for(int j=1;j<=3;j++)
//    	{
//    		if(j==2)
//    			break aaa; // 자신의 반복문만 제어
//    			// continue;
//    		System.out.println("i="+i+",j="+j);
//    	}
//    }
//	
	
	Scanner scan=new Scanner(System.in);
	
	System.out.print("년도 입력");
	int year=scan.nextInt();
	System.out.print("달 입력");
	int mon=scan.nextInt();
	System.out.print("일 입력");
	int date=scan.nextInt();
	
	System.out.println(year+"년 "+mon+"월 "+date+"일");
	
	int total=((year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400);
	
	int[] last=  {31,28,31,30,31,30,31,31,30,31,30,31};
	
	if((year%4==0 && year%100!=0) || year%400==0)
		last[1]=29;
	else
		last[1]=28;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





}
