package com.sist.io;
/*
 *    IO => Input / Output
 *                  | 출력  
 *          | 입력 
 *    입력 / 출력 
 *    ---------
 *    1. 메모리 
 *    2. 파일 
 *        Input  : 파일 읽기 
 *        Output  : 파일 쓰기 
 *        ------------------
 *        1) 한글이 있는 파일 => txt / doc ....
 *           char 단위 (2) =>  FileReader / FileWriter
 *                                ------       ------
 *        2) zip / image 파일 
 *           byte 단위 (1) => FileInputStream / FileOutputStream
 *                               -----------       ------------
 *    3. 네트워크 : 다른 컴퓨터와 연동  => 오라클 / 웹 서버 / 게임 서버 
 *       서버 => 쓰레드 / 입출력 
 *            | read 
 *       send |
 *       클라이언트 => 쓰레드 / 입출력 
 *       
 *    4. IO => 프로그램에서 데이터를 읽기/쓰기 기능 
 *       Input => 외부 데이터를 프로그램으로 가져 오기 
 *                키보드 읽기 
 *                파일 읽기 
 *                클라이언트가 보낸값 읽기 
 *                크롤링 => 서버 값 읽기
 *                System.in 
 *       Output => 프로그램 데이터를 외부로 보내기 
 *                브라우저 보내기 
 *                도스창으로 보내기 
 *                파일 보내기 
 *                System.out
 *    5. Stream 
 *       단방향 => 데이터 이동 통로 => 절대 손실할 염려가 없다 
 *       => 빨대   -----------
 *                | 1byte => ByteStream => InputStream / OutputStream
 *                | 2byte => CharStream => Reader / Writer
 */
import java.io.*;
public class IO_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	//FileInputStream fis=
        			//new FileInputStream("C:\\javaDev\\javaStudy\\Chapter18-입출력(IO)-1\\src\\com\\sist\\io\\IO_1.java");
        	FileReader fis=new FileReader("C:\\javaDev\\javaStudy\\Chapter18-입출력(IO)-1\\src\\com\\sist\\io\\IO_1.java");
        	int i=0;
        	while((i=fis.read())!=-1)
        	{
        		System.out.print((char)i);
        	}
        	fis.close();
        }catch(Exception ex) {}
	}

}