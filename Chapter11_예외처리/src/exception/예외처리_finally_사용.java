package exception;

import java.io.FileReader;

public class 예외처리_finally_사용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileReader fr=null;
        try
        {
        	// CheckedException 
        	fr=new FileReader("C:\\Users\\vcand\\git\\java-study\\Chapter11-예외처리\\src\\com\\sist\\exception\\숫자야구게임.java");
            int i=0;
            while((i=fr.read())!=-1) // -1 => EOF
            {
            	System.out.print((char)i);
            }
        }catch(Exception ex)
        {
        	System.out.println(ex.getMessage());
        	// 에러 메세지 확인 
        }
        finally
        {
        	try
        	{
        		if(fr!=null)
        			fr.close();
        	}catch(Exception ex) {}
        }
	}

}

