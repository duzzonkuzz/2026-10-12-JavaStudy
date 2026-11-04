package exception;
import java.io.*;
public class 예외처리_자원자동처리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// try - with - resource 
		// finally없이 자동 닫기 => 파일에서 가능 
        try(FileReader fr=
        		new FileReader("C:\\Users\\vcand\\git\\java-study\\Chapter11-예외처리\\src\\com\\sist\\exception\\숫자야구게임.java"))
        {
        	int i=0;
        	while((i=fr.read())!=-1)
        	{
        		System.out.print((char)i);
        	}
        	// fr.close() 
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }
	}

}