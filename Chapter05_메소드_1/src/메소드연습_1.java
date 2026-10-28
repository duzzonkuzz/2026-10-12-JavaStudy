// 1~10까지 출력하는 메소드 구현 
// 1~10까지 합을 구하는 메소드 
public class 메소드연습_1 {
	static void print()
    {
    	for(int i=1;i<=10;i++)
    	{
    		System.out.print(i+" ");
    	}
    }
    // A~Z void => 메소드 자체 처리 
    static void alpha()
    {
    	for(char c='A';c<='Z';c++)
    	{
    		System.out.print(c+" ");
    	}
    }
    // 1~10까지의 합을 구한다 
    static int sum()
    {
    	int s=0;
    	for(int i=1;i<=10;i++)
    	{
    		s+=i;
    	}
    	return s;
    }
    // 1~n까지 합을 구한다 
    // 매개변수가 다르면 다른 메소드로 인식한다 
    static int sum(int n)
    {
    	int s=0;
    	for(int i=1;i<=n;i++)
    	{
    		s+=i;
    	}
    	return s;
    }
    // 대문자를 소문자 변경  A = 65   a=97  => 32 
    static char change(char c)
    {
    	return (char)(c+32);
    }
    // 문자열을 보내고 꺼꾸로 출력 
    // **** 그림을 꺼꾸로 출력하는 프로그램을 구현 
    /*
     *    파일 읽기 
     *    byte[] buffer에 저장 
     *    
     */
    static void reverse(String msg)
    {
    	for(int i=msg.length()-1;i>=0;i--)
    	{
    		System.out.print(msg.charAt(i));
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        print();
        System.out.println();
        alpha();
        System.out.println();
        int s=sum();
        System.out.println(s);
        s=sum(100);
        System.out.println(s); 
        char c=change('A');
        System.out.println(c); 
        int k='A';
        System.out.println(k);
        reverse("Hello Java");
        
	}

}