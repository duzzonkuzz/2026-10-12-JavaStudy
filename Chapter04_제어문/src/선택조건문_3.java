// 알파벳 => 난수 => 대문자 / 소문자
/*
 * 
 */

public class 선택조건문_3 {
	public static void main(String[] args) {
		int type=(int)(Math.random()*2);
		char c=' ';
		// 0 1
		if(type==0)
		{
			c=(char)((Math.random()*26)+65);
		}
		else
		{
			c=(char)((Math.random()*26)+97);
		}
		//System.out.println(c);
		if(c>='A' && c<='Z')
		{
  		 System.out.println("대문자");
		}
		
		if(c>='a' && c<='z')
		{
  		 System.out.println("소문자");
		}
	}
	
	

}
