package com.sist.io;
import java.io.*;
public class 파일_입출력_2 {
public static void main(String[] args) {
	try
	{
		// 파일 카피 => 웹(업로ㅛ드 , 다운로드) 파일 이동
		// Files 
		FileInputStream fis=
				new FileInputStream("C:\\javaDev\\lombok-1.18.48.jar");
		FileOutputStream fos=
				new FileOutputStream("C:\\java_data\\lombok-1.18.48.jar");
		
		// 파일을 읽어서 => 복사
		int i=0;
		byte[] buffer=new byte[1024];// => 지정된 바이트 크기를 모아서 한번에 전송 
    	// i = 읽은 바이트 수
    	// 
    	/*
    	 *   read() => 한글자씩 읽기 
    	 *   => 리턴 => 문자 번호 : A(65) , B(66)
    	 *   
    	 *   523   1048 ==> 1024  24 1024 => 
    	 *         ----  2048
    	 */
		while((i=fis.read(buffer,0,1024))!=-1)
		{
			System.out.println(i);
			fos.write(buffer,0,i);
		}
		fis.close();
		fos.close();
		System.out.println("파일 복사 완료");
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
	
}
}
