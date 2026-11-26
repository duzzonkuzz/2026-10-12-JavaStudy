package com.sist.io;
/*
 *   파일 = 외부
 *         --- 브라우저 / 네트워크 통신 
 *   | = txt 
 *   | = xml / json / yml / html => 라이브러리가 따로 존재 
 *       | parse가 있다 
 *       
 *   1) 파일 읽기 (파일을 연결해서 파일 내용 읽기) 
 *      FileInputStream 
 *   2) 파일 쓰기 (파일을 연결해서 파일 내용 쓰기)
 *               ----------- 스트림 
 *      FileOutputStrem 
 *      => 단방향 
 *   ------------------------ 단점 : 한글자씩 읽기 / 한글자씩 전송 
 *                                  read         write
 *                                  -----------------------
 *                                  읽기 => 1byte 읽기 
 *                                  한글은 한글자 => 2byte 
 *                                  => close() 
 *     => 업로드 / 다운로드 
 *   
 */
import java.io.*;
import java.util.Arrays;
public class 파일_입출력_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try
{
//	File dir=new File("c:\\java_data");
//	if(dir.exists())
//	{
//		File file=new File("c:\\java_data\\sawon.txt");
//		file.createNewFile();
//		System.out.println("sawon.txt 파일 생성");
//	}
//	else
//	{
//		dir.mkdir();
//		File file=new File("c:\\java_data\\sawon.txt");
//		file.createNewFile();
//		System.out.println("sawon.txt 파일 생성");
//	}
	//1. 파일 스기
	FileOutputStream fos=
			new FileOutputStream("c:\\java_data\\sawon.txt",true);
	String hong="1|홍길동|개발부|대리|4000\n";
	fos.write(hong.getBytes());
	fos.close();
	System.out.println("파일 쓰기 완료");
	//2. 파일 읽기
	FileInputStream fis=
			new FileInputStream("c:\\java_data\\sawon.txt");
	int i=0; // 파일 읽기 => 한글자 => 정수형
//	while((i=fis.read())!=-1)
//	{
////		System.out.print((char)i);
//	}
	byte[] buffer=fis.readAllBytes();
	System.out.println(Arrays.toString(buffer));
	fis.close();
}catch(Exception ex)
{
	ex.printStackTrace();
}
	}

}
