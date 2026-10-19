/*
 *  1~100까지 사이의 3배수 / 5배수 / 7의 배수 출력
 */
public class 반복문_while_2 {
	public static void main(String[] args) {
		int i=1;
		while(i<=100)
		{
			if(i%3==0)
			{
				System.out.print(i+"3의 배수");
			}
			else if(i%5==0)
			{
				System.out.print(i+"5의 배수 ");
			}
			else if(i%7==0)
			{
				System.out.print(i+"7의 배수 ");
			}
			i++;
		}
//		
//		while(i<=100)
//		{
//			if(1%3==0)
//				System.out.println(i+" ");
//			i++;
//		}
	}

}
