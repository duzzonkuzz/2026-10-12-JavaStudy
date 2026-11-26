package com.sist.io;
/*
 *    입출력 => IO 
 *    Input / Output 
 *    -----   ------ => 반드시 입출력 통로 따로 만들어서 제어 
 *                           --------------------
 *                            Stream  => 단방향 
 *                            ----------------
 *                            | => 1byte (바이트 스트림) => 이미지,PDF...
 *                                 InputStream / OutputStream
 *                            | => 2byte (문자 스트림) 
 *                                 => 한글이 포함 (txt , csv ...)
 *                                 Reader / Writer
 *    InputStream / OutputStream 
 *      = FileInputStream / FileOutputStream 
 *        | 파일 읽기         | 파일 쓰기
 *      = ObjectInputStream / ObjectOutputStream 
 *        | 객체단위 읽기        | 객체 단위 저장 
 *    Reader  / Writer 
 *      = FileReader / FileWriter
 *      
 *      단점 : 한글자 읽기 => 성능 저하
 *    --------------------------------------------
 *    보조 스트림 
 *    BufferedInputStream / BufferedOutputStream 
 *    BufferedReader / BufferedWriter 
 *    --------------------------------------------
 *    변환하는 클래스 : 1byte 송신 => 2byte 수신 
 *                  브라우저전송    브라우저에서 읽기
 *                  | 인코딩      | 디코딩 
 *                  --------------------------
 *                  | InputStreamReader 
 *                    -----------------
 *                     1byte => 2byte로 변환 (한글 깨짐 방지)
 *    --------------------------------------------------
 *    File   /   Files 
 *    java.io    java.nio
 *    --------------------------------------------------
 *     입출력 
 *       = 메모리 입출력 => 키보드 입력 / 화면에 출력 
 *         System.in / System.out 
 *         Scanner / BufferedReader(*****)
 *       = 파일 입출력 => 읽기 / 쓰기 
 *       = 네트워크 입출력 
 *         | 저장하는 공간 : Socket
 *    --------------------------------------------------
 *    File / Files => 메소드 
 *    입출력 : read/write()/close()
 *    --------------------------------------------------
 *    파일 읽기 / 쓰기 
 *    FileReader / FileWriter 
 *    -----------------------
 *    파일읽기 => 다른 폴더 / 다른 컴퓨터 
 *    FileInputStream / FileOutputStream
 *    ----------------------------------
 *    객체 단위 저장 
 *    ObjectInputStream / ObjectOutputStream
 *    -----------------------------------------
 *    외부에서 데이터 읽기 
 *    BufferedReader / BufferedWriter
 *    -----------------------------------------
 *    File : file 정보 / Files : file 전송 
 *    -----------------------------------------
 *    브라우저 => JSON파일 전송 
 *    ------ PrintWriter 
 *    최근 => 숨기는 데이터 
 *           공통 IP / user / password 
 *           ------------------------
 *           API Key : AI / AWS
 *    
 *    File : file에 대한 정보 
 *           file / directory 
 *           ----------------- 동시에 제어 
 *           예)
 *              new File("c:\\javaDev") ==> Directory 정보
 *              new File("c:\\javaDev\\a.jpg") => 파일 정보 
 *    1. 목적 
 *       메모리 저장 / 메모리 값 읽기 
 *       파일의 종류 
 *       1) xml : 다른 프로그램에서 연동 => 설정 파일 
 *                Spring / MyBatis 
 *       2) json : JavaScript와 연동 (전송하는 파일)
 *       3) yml , properties => SpringBoot 설정파일 
 *       4) txt / csv / doc ...
 *       파일의 단점 
 *         1) 데이터 노출 
 *         2) 파일 깨짐 
 *         3) 삭제될 가능성 
 *         4) 구분자가 없다 
 *         --------------------- 오라클 (구분:컬럼) 
 *                               이미지파일로 저장 => 보안 
 *                               사용하기 편리 
 *      임시 저장 => 오라클 전송 
 *   2. 파일 정보 확인 
 *      ----------- 메소드 
 *      new File("c:\\javaDev") ==> Directory 정보
 *      new File("c:\\javaDev\\a.jpg") => 파일 정보
 *      
 *      주요 메소드 
 *      1) **getName() : 파일명만 가지고 온다 
 *      2) **getPath() : 경로 ~ 파일명까지 
 *      3) getParent() : 경로명면 
 *      4) **length() : long => 파일 크기 
 *      5) lastModified => long => new Date() => 최종 수정일 
 *      6) isHidden() : 숨긴 파일 
 *         canRead() : 읽기 전용 
 *         canWrite() : 쓰기 전용 
 *         -------------------- boolean 
 *      7) **isFile() / isDirectory()
 *      ---------------------------- 파일 정보 
 *      8) 파일 제어 
 *         = **listFile() => 지정된 폴더안에 있는 모든 파일/폴더 정보 
 *           File[] => 폴더에서 사용 
 *         = **mkdir() / mkdirs()
 *           폴더 생성 
 *         = **createNewFile() 
 *           파일 생성 
 *         = **delete() : 파일 삭제 
 *         = **exists() : 파일 존재 여부 
 *    --------------------------------------------------------
 *    중요시 : java.io는 반드시 예외처리 
 *                          ------- CheckException                         
 */
import java.io.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IO_2 {
public static void main(String[] args) {
	try
	{
		//파일 정보 읽기
		File file=new File("C:\\javaDev\\javaStudy\\Chapter18_입출력IO-1\\src\\com\\sist\\io\\IO_2.java"); // 경로 \\
		// 파일명 확인
		System.out.println("파일명:"+file.getName());
		//파일경로명
		System.out.println("경로명"+file.getParent());
		// 파일 경로+파일명
		System.out.println("경로+파일:"+file.getPath());
		//속성
		//1. 숨긴 파일 
		System.out.println("숨김 파일:"+file.isHidden());
		//2. 읽기 전용
		System.out.println("읽기 전용:"+file.canRead());
		System.out.println("쓰기 전용:"+file.canWrite());
		//4. 파일 / 폴더
		System.out.println("파일인지:"+file.isFile());
		System.out.println("폴더 인지:"+file.isDirectory());
		//5. 수정일
		//simpledateformat java.text
		//Date java.util
		System.out.println("수정일:"+
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()))
				);
		/*
		 *   isXxx() : 존재 여부 -> boolean
		 *   값설정
		 *   setXxx()
		 *   값읽기
		 *   setXxx()
		 *   ----
		 *   데이터값 한개 삭제 => remove()
		 *   통으로 삭제 => delete()
		 *   => 라이브러리 메소드
		 *  
		 */
	}catch(Exception ex)
	{
		ex.printStackTrace(); // 오류 정보 확인
	}
}
}
