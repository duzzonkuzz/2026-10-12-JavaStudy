import java.util.*;
public class 메소드_3 {
static boolean isLogin(String id,String pwd)
{
	if(id.equals("admin") && pwd.equals("1234"))
	
		return true;
		
		else
			return false;
	
}
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("id");
	String id=scan.next();
	String pwd=scan.next();
	boolean bCheck=isLogin(id,pwd);
	if(bCheck==true)
		System.out.println("o");
	else
		System.out.println("x");
}
}

