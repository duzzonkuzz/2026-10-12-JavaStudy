package com.sist.io2;
// FileReader => read() : BufferedReader => readLine()
import java.io.*;
public class MusicData {
public static void main(String[] args) {
	try
	{
		StringBuffer sb=new StringBuffer();
		FileReader fr=new FileReader("c:\\java_data\\genie.txt");
		int i=0;
		while((i=fr.read())!=-1)
		{
//			System.out.print((char)i);
			sb.append((char)i);
		}
		fr.close();
		System.out.println(sb.toString());
		String[] musics=sb.toString().split("\n");
		for(String m:musics)
		{
			String[] music=m.split("\\|");
			System.out.println("번호:"+music[0]);
			System.out.println("곡:"+music[1]);
			System.out.println("가수:"+music[2]);
			System.out.println("앨범:"+music[3]);
			System.out.println("이미지:"+music[4]);
			System.out.println("=========");
			
			
		}
	}catch(Exception ex)
	{
		
	}
}
}
