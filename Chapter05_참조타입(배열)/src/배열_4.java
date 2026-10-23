
public class 배열_4 {
public static void main(String[] args) {
	char[] ap=new char[10]; //선언
	for(int i=0;i<ap.length;i++) // 초기화
	{
		ap[i]=(char)((Math.random()*26)+65); // 65=A
		
	}
	for(char c:ap)
	{
		System.out.print(c+" ");
	}
}
}
