package com.sist.io;
/*
 *   문자 데이터 처리 (텍스트관리) => 2byte 
 *   ***BufferedReader / BufferedWriter
 *        읽기                쓰기 
 *        | readLine() / close()
 *   바이트 데이터 = 1byte 
 *   BufferedInputStream / BufferedOutputStream 
 *        | 바이크 읽기        | 바이트 쓰기 
 *   => 이미지 / 동영상 / 파일 => 업로드 / 다운로드 
 *   
 *   객체 데이터 처리 => Application => WebApplication
 *   ObjectInputStream / ObjectOutputStream 
 *     | 객체 읽기          | 객체 쓰기 
 *       readObject()       writeObject(list)
 *    
 *   파일 / 폴더 관리 
 *   File /     Files 
 *   java.io    java.nio
 *              파일 생성 / 복사 / 삭제 / 읽기 / 쓰기 
 *   -------------------------------------------------
 *   IO 클래스 (웹에서 필요한 클래스 정리)
 *   
 *   네트워크 : ServerSocket / Socket / Thread 사용법 
 *   ---------------------------------------------
 *     흐름 파악 : Oracle 서버 / 웹 서버 
 *               AWS 서버 
 *               -------------------- 네트워크 통신 
 *   1) ***BufferedReader 
 *      = 메모리 / 파일 / 네트워크 
 *      = 파일에 저장된 글자를 한줄씩 읽어오는 클래스 
 *      = 사용처 : txt파일 , 로그파일 , 텍스트 데이터 읽기 
 *      = 주요 메소드 
 *        readLine() : 한줄 읽기 
 *        close() : 닫기 
 *        
 *   2) BufferedWriter 
 *      = 글자를 효율적으로 파일에 저장하는 클래스 
 *      = 사용처 : 메모장 , 로그 , 게시물 
 *      = 주요 메소드 
 *        write() : 문자 저장 
 *        newLine() : 줄바꿈 
 *        close() : 닫기 
 *        
 *   3) BufferedInputStream
 *      = 이미지 / 음악 / 동영상 파일을 바이크단위로 읽는다 
 *      = 업로드 / 다운로드 
 *      = 주요 메소드 
 *        read() : 1byte 읽기 
 *        read(byte[]) : 여러 바이트 읽기 
 *        close() 
 *   4) BufferedOutputStream
 *      = 바이트 데이터를 모아서 파일에 저장 
 *      = 이미지 복사 , 파일 다운로드 
 *      = 주요 메소드 
 *        write() 
 *        close() 
 */
import java.io.*;
public class IO_1 {
    // Only => 아래로 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	File file=new File("c:\\java_data\\student.txt");
        	// 파일 읽기 
        	if(!file.exists()) // 파일이 없는 경우 
        	{
        		// 파일 만들기 
        		file.createNewFile();
        	} // 사전에 에러 방지 
        	/*
        	 *    에러 방지 
        	 *    1) if 
        	 *    2) try~catch 
        	 */
        	FileWriter fw=
        			new FileWriter(file,true); // append
        	String msg="Hello IOStream\r\n";
        	fw.write(msg);
        	//fw.close();
        	msg="Hello Oracle!!";
        	// 객체 생성 방법 => 매개변수 
        	BufferedWriter bw=
        			new BufferedWriter(fw);
        	                 // FileWriter
        	bw.write(msg);
        	System.out.println("저장 완료!!");
        	bw.close();
        	
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
        
	}

}