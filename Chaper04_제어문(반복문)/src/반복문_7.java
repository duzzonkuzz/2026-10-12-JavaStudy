
public class 반복문_7 {

	public static void main(String[] args) {
//		int sum=0;
//		for(int i=2;i<=100;i+=2)
//		{
//			sum+=i;
//		}
//		System.out.println("2+4+6+..+100까지 합:"+sum);
		// 5 10 15 20 25 30 35 .. 50
	 
		
		for(int i=5;i<=50;i+=5)
		{
			System.out.println(i);
		}
		for(char i='B';i<='N';i+=2)
		{
			if(i>'B' && i<='N')
			System.out.print(",");
			System.out.print(i);
			
		}
		
	}
}
