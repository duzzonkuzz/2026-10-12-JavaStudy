package com.sist.io;
// Files : java.nio 
/*
 *   파일 관리 => 파일 / 폴더를 쉽게 관리할 수 있게 만든 클래스 
 *   사용처 : 파일 생성 / 삭제 / 복사 / 이동 / 읽기 / 쓰기 
 *          Files를 이용해서 업로드 기능을 만들 예정 
 *   ------------------------------------------------
 *    Reader : 문자 읽기 => readLine()
 *    Writer : 문자 쓰기 => write(String)
 *    Input : 데이터 읽기 => read()
 *    Output : 데이터 쓰기 => write()
 *    Object : 객체 저장 / 읽기  readObject() / writeObject()
 *    Files  : 파일 관리 => copy() / delete() ....
 *    
 *    단어 
 *     Buffered : 데이터를 메모리에 모아서 요률적으로 관리 
 *     Serializable : 객체를 파일에 저장할 수 있게 만든 것 
 *     
 *     1) 웹 : 데이터베이스 80%
 *        => Open API => 웹에서 읽기 : 10% IO 
 *        => api key => 10%
 *    ------------------------------------------------------
 *    
 *    Files 
 *      1. Path : 파일 경로 지정 
 *           ||
 *      2. Files : 파일 생성 / 읽기 / 쓰기 
 *           ||
 *      3. 파일 시스템 
 *          실제파일 / 폴더 처리 
 *          
 *      ------------------------------
 *      Path : 파일의 위치 
 *      Files : 파일 담당 
 *      exists() : 파일 존재 여부 
 *      createFile : 파일 생성 
 *      writeString() : 문자열 저장 
 *      readString() : 문자열 읽기
 *      copy() : 파일 복사
 *      move() : 이동 ==> 파일 자체 이동 
 *      => 리눅스 
 *         sudo cp source target
 *         sudo mv source target
 *      delete() : 파일 삭제 
 *      deleteIfExists() : 파일이 있는 경우에만 삭제      
 *      
 *       * Files는 모든 메소드가 static이다 
 */
import java.nio.file.*;
public class IO_6 {
    // 1. 파일 생성 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*try
        {
        	Path path=Paths.get("test.txt");
        	Files.createFile(path);
        	System.out.println("파일 생성 완료!!");
        }catch(Exception ex) 
        {
        	ex.printStackTrace();
        }*/
		// 2. 파일에 문자열 저장 : File => FileWriter를 이용해서 저장 
		/*try
		{
			Path path=Paths.get("test.txt");
			Files.writeString(path, "Hello Files!");
			System.out.println("파일 저장 완료!!");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}*/
		// 3. 파일 읽기 
		/*try
		{
			Path path=Paths.get("c:\\java_data\\genie.txt");
			String data=Files.readString(path);
			System.out.println(data);
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}*/
		// 4. 존재 여부 
		/*try
		{
			Path path=Paths.get("c:\\java_data\\melon.txt");
			if(Files.exists(path))
			{
				System.out.println("파일이 존재합니다");
			}
			else
			{
				System.out.println("파일이 없습니다");
				Files.createFile(path);
				System.out.println("파일 생성 완료");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}*/
		// 파일 복사 
		/*try
		{
			Path source=Paths.get("test.txt");
			Path target=Paths.get("copy.txt");
			
			Files.copy(source, target);
			System.out.println("복사 완료");
		}catch(Exception ex) {
			ex.printStackTrace();
		}*/
		// 파일 이동 
		/*try
		{
			Path source=Paths.get("copy.txt");
			Path target=Paths.get("new.txt");
			Files.move(source, target);
			System.out.println("이동 완료 / 이름 변경");
		}catch(Exception ex) {
			ex.printStackTrace();
		}*/
		// 파일 삭제 
		try
		{
			Path path=Paths.get("test.txt"); 
			// 있는 그대로 : final class  
			Files.deleteIfExists(path);
			System.out.println("삭제 완료!!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		// 아직 실무 => Files(X) => BufferedReader / FileWriter
		// 업로드시에 사용 
		
	}

}