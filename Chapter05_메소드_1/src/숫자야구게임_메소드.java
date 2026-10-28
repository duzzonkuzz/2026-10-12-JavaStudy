import java.util.*;
/*
 *   객체지향프로그램 
 *     객체 <==> 객체 
 *           |
 *          메소드 : 메세지(통신시에 사용) 
 */
public class 숫자야구게임_메소드 {
	 static int[] rand()
	    {
	    	int[] com=new int[3];
	        // 1 ~ 9 => 중복 없이 
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
	        	System.out.print("세자리 정수를 입력하세요:");
	        	int input=scan.nextInt();
	        	
	        	if(input<100 || input>999)
	        	{
	        		System.err.println("잘못된 입력입니다. 세자리 정수만 입력해야 됩니다");
	        		continue;
	        	}
	        	/*
	        	 *    369/100  ==> 3
	        	 *    369%100 => 69/10  6
	        	 *    369%10  => 9
	        	 */
	        	user[0]=input/100;
	        	user[1]=(input%100)/10;
	        	user[2]=input%10;
	        	
	        	if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2])
	        	{
	        		System.err.println("같은 수는 사용할 수 없습니다!!");
	        		continue;
	        	}
	        	
	        	if(user[0]==0 || user[1]==0 || user[2]==0)
	        	{
	        		System.err.println("0은 사용할 수 없습니다!!");
	        		continue;
	        	}
	        	break;
	        }
	        return user;
	    }
	    static int hint(int[] com,int[] user)
	    {
	    	// 비교 
	    	int s=0,b=0;
	    	// s=> 같은 자리의 같은 수 
	    	// b=> 같은 수만 존재 
	    	for(int i=0;i<com.length;i++)
	    	{
	    		for(int j=0;j<user.length;j++)
	    		{
	    			if(com[i]==user[j])// 같은 수가 있는지 
	    			{
	    				if(i==j) // 같은 자리 
	    					s++;
	    				else     // 다른 자리
	    					b++;
	    			}
	    		}
	    	}
	    	// 힌트 
	    	System.out.printf("Input Number:%d%d%d,Result:%dS-%dB\n",
	    			user[0],user[1],user[2] , s, b);
	    	return s;
	    }
	    static boolean exit(int s)
	    {
	    	if(s==3)
	    		return true;
	    	return false;
	    }
	    static void process()
	    {
	    	int[] com=rand();
	    	//System.out.println(Arrays.toString(com));
	    	Scanner scan=new Scanner(System.in);
	    	while(true)
	    	{
	    		int[] user=userInput();
	    		int s=hint(com, user);
	    		if(exit(s))
	    		{
	    			System.out.println("Game Over!!");
	    			System.out.print("게임을 다시 할까요?(y|Y):");
	    			char c=scan.next().charAt(0);
	    			if(c=='y'||c=='Y')
	    			{
	    				System.out.println("새게임을 시작합니다!!");
	    				process();
	    			}
	    			else
	    			{
	    				System.out.println("게임을 종료합니다!!");
	    				System.exit(0);// 프로그램 종료
	    			}
	    			  
	    		}
	    	}
	    }
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        process();
		}

	}