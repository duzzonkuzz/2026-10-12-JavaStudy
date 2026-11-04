	package exception;
	/*
	 *  예외처리 (Exception) 
	 *    CheckedException 
	 *      => 컴파일러가 예외처리 코드 있는지 확인 
	 *      => 반드시 예외처리 한다 
	 *         try~catch / throws 
	 *         | 직접 처리   | 간접 처리 
	 *           예외복구      예외회피
	 *      => java.io / java.net / java.sql / javax.servlet.hhtp
	 *      => 에러 
	 *         =====> 개발자 실수 / 사용자 입력 
	 *   UnCheckedException 
	 *      => 실행시 => 반드시 예외처리를 안해도 된다 
	 *      => 유효성 검사 
	 *      => 우선 => if => try~catch
	 */
	class A
	{
		
	}
	class B extends A
	{
		
	}
	public class 예외처리종류 {
		// Checked 
		public static void fff() throws Exception
		{
			
		}
		// UnChecked 
		public static void ggg() throws RuntimeException
		{
			
		}
	    public static void aaa(int a,int b)
	    {
	    	try
	    	{
	    		System.out.println(a/b); 
	    	}catch(ArithmeticException ex) 
	    	{
	    		//System.out.println(ex.getMessage()); // /by zero
	    		ex.printStackTrace();
	    	}
	    }
	    // bbb("") bbb(null) => 데이터베이스  IS NOT NULL
	    public static void bbb(String data)
	    {
	    	try
	    	{
	    		System.out.println(data.length());
	    	}catch(NullPointerException ex)
	    	{
	    		//System.out.println(ex.getMessage());
	    		ex.printStackTrace();
	    	}
	    }
	    // https://www.10000recipe.com/recipe/list.html?order=reco&page=5
	    public static void ccc(String num)
	    {
	    	try
	    	{
	    		System.out.println(Integer.parseInt(num));
	    		// 웹 => 무조건 나온다 
	    		// String , Integer , ArrayList "A" 
	    	}catch(NumberFormatException ex)
	    	{
	    		//System.out.println(ex.getMessage());
	    		ex.printStackTrace();
	    	}
	    }
	    public static void ddd()
	    {
	    	// for(int i=0;i<=arr.length;i++)
	    	try
	    	{
	    		int[] arr=new int[2];// 0 1
	    		arr[0]=100;
	    		arr[2]=200;
	    		System.out.println(arr[1]);
	    	}catch(ArrayIndexOutOfBoundsException ex)
	    	{
	    		//System.out.println(ex.getMessage());
	    		ex.printStackTrace();
	    	}
	    }
	    public static void eee()
	    {
	    	try
	    	{
	    		//A a=new A();
	    		A a=new B();
	    	
	    		/*
	    		 *     A a=new A();
	    		 *     ----this----
	    		 *       A 데이터
	    		 *     ------------
	    		 *     
	    		 *     A a=new B()
	    		 *     ----- super -----
	    		 *      A 
	    		 *     -------this----------
	    		 *      B
	    		 *     -----------------
	    		 *   
	    		 *     
	    		 */
	    		B b=(B)a;
	    	}catch(ClassCastException ex)
	    	{
	    		//System.out.println(ex.getMessage());
	    		ex.printStackTrace();
	    	}
	    }
	    // Exception -  RuntimeException 
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        //System.out.println(Integer.parseInt(" 5"));
			aaa(10,0);
			bbb(null);
			ccc(" 20");
			ddd();
			eee();
			
			//ggg();
			//fff();
		}

	}