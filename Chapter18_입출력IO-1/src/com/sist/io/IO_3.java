package com.sist.io;
import java.io.*;
public class IO_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try
{
	//폴더 지정 => 모든 파일 정보를 읽는다
	File dir=new File("c:\\javaDev");
	//폴더 안에 있는 모든 파일을 읽어 와라
	File[] list=dir.listFiles();
	for(File f:list)
	{
		if(f.isFile())
		{
			String len=f.length()/1000>0?
					(f.length()/1000)+"KB"
					: f.length()+"Bytes";
			System.out.println(f.getName()+" "+len);
		}
		if(f.isDirectory())
		{
			System.out.println(f.getName()+"DIR");
		}
	}
	
}catch(Exception ex)
{
	ex.printStackTrace();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
