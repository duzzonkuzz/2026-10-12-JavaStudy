package com.sist.io;
//FileReader / FileWriter => 실제 파일 제어 => 2byte : 한글깨짐이 없다 
//movie.txt => 
import java.io.*;
//파일 
/*
*    r : read 읽기 => FileReader 
*    w : write 쓰기 => FileWriter
*        ----------------------- 덮어쓴다 
*    a : append => 이어서 쓰기 
*    
*    FileReader / FileWriter 
*                 => write(char) , write(String) => char[] 
*                                  write(byte[]) 
*    | => read() / read(char[] , int , int)
*/
import java.io.*;
public class 파일_입출력_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     try
     {
     	// InputStream / OutputStream => byte
     	// 파일 이동 / 다운로드 
     	// Reader / Writer => char  char[] => String 
     	// 실제 파일 자체 제어 => 읽기 / 쓰기 
     	FileReader fr=new FileReader("C:\\javaDev\\javaStudy\\Chapter18-입출력(IO)-1\\src\\com\\sist\\io\\IO_1.java");
     	int i=0;
     	while((i=fr.read())!=-1)
     	{
     		System.out.print((char)i);
     	}
     	fr.close();
     	
     }catch(Exception ex) {
     	ex.printStackTrace();
     }
	}

}