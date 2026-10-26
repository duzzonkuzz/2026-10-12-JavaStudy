import java.util.*;
enum 전화국번{
	서울("02"),
	경기도("031"),
	인천("032"),
	강원도("333"),
	충청남도("041"),
	대전("042"),
	충청북도("043"),
	세종("044"),
	부산("051"),
	울산("052"),
	대구("053"),
	경상북도("054"),
	경상남도("055"),
	전라남도("061"),
	광주("062"),
	전라북도("063"),
	제주("064");

	
	String code;
	전화국번(String code)
	{
		this.code=code;
	}
	String getCode()
	{
		return code;
	}
}
public class 열거형 {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("지역 입력:");
	String loc=scan.next();
	
	for(전화국번 n:전화국번.values())
	{
		if(n.name().contains(loc))
		{
			System.out.println(loc+"의 국번은"+n.getCode());
		}
	}

  }
}
