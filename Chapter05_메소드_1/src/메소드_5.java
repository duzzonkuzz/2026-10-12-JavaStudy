import java.util.*;
//1. 난수 발생
/*
 * 2, 사용자 입력
 * 3. 힌트
 * 4. 종료엽
 */
public class 메소드_5 {
public static void main(String[] args) {
	int[] com=new int[3];
	for(int i=0;i<com.length;i++)
	{
		com[i]=(int)(Math.random()*9)+1;
		// 중복
		for(int j=0;j<i;j++)
		{
			if(com[i]==com[j])
			{
				i--;
				break;
			}
		}
	}
	//System.out.println(Arrays.toString(com));
	//사용자 입력 => 정답을 맞춘다
	Scanner scan=new Scanner(System.in);
	int[] user=new int[3];
	while(true)
	{
		System.out.println("세자리 정수를 입력");
		int input=scan.nextInt();
		
		if(input<100 || input>999)
		{
			System.err.println("잘못된 입력");
			continue;
			
		}
		user[0]=input/100;
		user[1]=(input%100)/10;
		user[2]=input%10;
		
		if(user[0]==user[1] || user[1]==user[2] || user[1]==user[2])
		{
			System.err.println("같은 수를 사용할 수 없음");
			continue;
		}
		if(user[0]==0 || user[1]==0 || user[2]==0)
				{
			System.err.println("0을 사용할 수 없음");
			continue;
				}
		int s=0,b=0;
		for(int i=0;i<com.length;i++)
		{
			for(int j=0;j<user.length;j++)
			{
				if(com[i]==user[j])
				{
					if(i==j)
						s++;
					else
						b++;
				}
			}
		}
		System.out.printf("Input Number:%d,Result:%ds-%db\n",input,s,b);
		if(s==3)
		{
			System.out.println("game over");
			break;
		}
	}
}
}
