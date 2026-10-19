
public class 반복문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		for(char c='A';c<='Z';c++)
			System.out.println(c);
		
		char c='A';  // A가 괄호 안에 들어가면 계속 초기화 되기에 계속 AAAAA만 나옴
		for(int i=0;i<26;i++)
		{
			
			System.out.println(c++);
		}
		
		//=> i, j 사용하지 않는다
	}

}
