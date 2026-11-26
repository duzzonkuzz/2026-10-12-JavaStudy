package com.sist.io;
import java.io.*;
public class IO_4 {
public static void main(String[] args) {
	try
	{
//		File dir=new File("c:\\upload");
//		if(!dir.exists()) // 존재여부확인
//		{
//			dir.mkdir();
//		}
//		else
//		{
//			System.out.println("이미 존재하는 폴더입니다.");
//		}
//		File file=new File("c:\\upload\\student.txt");
//		if(!file.exists())
//		{
//			file.createNewFile();
//			System.out.println("파일 생성 완료");
//		}
//		else
//		{
//			System.out.println("파일이 존재합니다.");
//		}
//		File dir=new File("c:\\upload\\data\\data1\\data2");
//		if(!dir.exists())
//		{
//			dir.mkdirs();
//			System.out.println("폴더 생성 완료");
//				
//		}
//		else
//		{
//			
//		}
		File dir=new File("c:\\upload");
//		if(dir.exists())
//		{
//			dir.delete();
//			System.out.println("폴더 삭제 완료!");
//		}
//		else
//		{
//			System.out.println("폴더존재하지않습니다");
//		}
		File[] list=dir.listFiles();
		
		for(File f:list)
		{
			f.delete();
		}
		dir.delete();
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
