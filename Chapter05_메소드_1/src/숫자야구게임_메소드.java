import java.util.*;
/*
 * 객체지향프로그램
 * 객체 <==> 객체
 *      
 */
public class 숫자야구게임_메소드 {
static int[] rand()
{
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
	return com;
}
static int[] userInput()
{
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
		break;
}
	return user;
}
static void hint(int[] com,int[] user)
{
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
	System.out.printf("Input Number:%d%d%d,Result:%ds-%db\n",user[0],user[1],user[2],s,b);

	if(s==3)
	{
		System.out.println("game over");
		break;
	}
}

static int exit(int s)
{
	return 1;
}
	
static void process()
{
	int[] com=rand();
	//System.out.println(Arrays.toString(com));
	Scanner scan=new Scanner(System.in);
	while(true)
	{
		
	}
}
	public static void main(String[] args) {
		process();
		
		
	}
}
