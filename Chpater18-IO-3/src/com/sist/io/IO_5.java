package com.sist.io;
import java.util.*;
import java.io.*;
/*
 *    ArrayList<Music> 객체 생성 
 *          |
 *      ObjectOutputStream => FileOutputStream
 *          => writeObject() => ArrayList<Music> 통으로 저장 
 *          |
 *       music.txt
 *          |
 *      ObjectInputStream  => FileInputStream
 *          => readObject() => ArrayList<Music> 읽기
 *          |
 *        화면 출력
 *        
 *      => 데이터베이스가 없는 상태 
 *         --------- 무료 
 */
public class IO_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	FileInputStream fos=
        			new FileInputStream("c:\\java_data\\music.txt");
        	ObjectInputStream ois=
        			new ObjectInputStream(fos);
        	ArrayList<Music> list=(ArrayList<Music>)ois.readObject();
        	ois.close();
        	
        	for(Music m:list)
        	{
        		System.out.println("번호:"+m.getMno());
        		System.out.println("곡명:"+m.getTitle());
        		System.out.println("가수명:"+m.getSinger());
        		System.out.println("앨범:"+m.getAlbum()); 
        		System.out.println("포스터:"+m.getPoster());
        	}
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
	}

}