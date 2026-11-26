package com.sist.io;
/*
 *    라이브러리
 *    java.lang 
 *    Object : toString() / clone() / hashCode() / equals()
 *             문자열 변환     복제        객체 구분자     객체 비교 
 *    String : length() / trim() / substring() /
 *             문자 갯수    공배 제거   원하는 위치 문자 자르기  
 *             replace() / indexOf() / lastIndexOf() 
 *             문바 변경      문자위치 찾기 (앞)  
 *             valueOf() / split() 
 *                         구분자별로 나눠주는 
 *             모든 데이터형을 문자열 변경
 *    StringBuffer : append() : 문자열 결합 
 *    System : gc() / exit()
 *             메모리 회수 프로그램 종료 
 *    Math : ceil() / random()
 *           올림       난수 발생
 *    Wrapper : 제네릭 
 *       Integer : parseInt() : 문자열 정수형 변경 
 *       Long    : parseLong()
 *       Boolean : parseBoolean()
 *       Double : parseDouble()
 *    java.text
 *       SimpleDateFormat : 날짜 변경 
 *           yyyy-MM-dd HH:mm:ss
 *       DecimalFormat : 숫자 변경
 *           ##,###,###
 *    java.util
 *       Date / Calendar : 날짜 관련 
 *       ArrayList : add() / size() / get() 
 *       HashSet : add() / size() / get() 
 *       HashMap : push() / get() 
 *       StringTokenizer : 문자 자르기 
 *                 nextToken() / hasMoreTokens() / countTokens()
 *    -----------------------------------------------------
 *    
 *    IO => FileInputStream / FileOutputStream 
 *          BufferedInputStream / BufferedOutputStream
 *          BufferedReader / FileReader / FileWriter 
 *          File / Files 
 *    -------------------------------------------------
 *    ObjectInputStream / ObjectOutputStream
 *    | 객체 저장           | 객체 읽기 
 *      readObject()        writeObject()
 *      close()             close()
 *    ** 객체 단위로 저장이 가능
 *    
 *    ** 직렬화 이용 
 *       객체 : 병렬로 저장 => 메모리는 직렬 
 *       ----------------------------
 *        객체 저장
 *       ---name----
 *         홍길동       
 *       ---sex----             메모리 저장 
 *         남자       ==>    -----------------------
 *       ---age----           홍길동  남자   20
 *         20               -----------------------
 *       -------
 *       
 *       Sawon sa=new Sawon() ==> sa저장 
 *       
 */
import java.util.*;
import java.io.*;
// 캡술화 => 데이터 보호 : 직접적으로 접근이 불가능 => 메소드를 이용해서 접근 
class Music implements Serializable
{
	private int mno;
	private String title;
	private String singer;
	private String album;
	private String poster;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
}
public class IO_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	ArrayList<Music> list=
        			    new ArrayList<Music>();
        	FileReader fr=new FileReader("c:\\java_data\\genie.txt");
        	BufferedReader br=
        			       new BufferedReader(fr);
        	String musics="";
        	while(true)
        	{
        		String m=br.readLine();
        		if(m==null)
        			break;
        		musics+=m+"\n";
        	}
        	br.close();
        	System.out.println(musics);
        	String[] mm=musics.split("\n");
        	for(String music:mm)
        	{
        		String[] s=music.split("\\|");
        		Music mu=new Music();
        		mu.setMno(Integer.parseInt(s[0]));
        		mu.setTitle(s[1]);
        		mu.setSinger(s[2]);
        		mu.setAlbum(s[3]);
        		mu.setPoster(s[4]);
        		list.add(mu);
        	}
        	for(Music m:list)
        	{
        		System.out.println("번호:"+m.getMno());
        		System.out.println("곡명:"+m.getTitle());
        		System.out.println("가수명:"+m.getSinger());
        		System.out.println("앨범:"+m.getAlbum()); 
        		System.out.println("포스터:"+m.getPoster());
        	}
        	
        	ObjectOutputStream oos=
        		 new ObjectOutputStream(new FileOutputStream("c:\\java_data\\music.txt"));
        	oos.writeObject(list);
        	oos.close();
        	System.out.println("저장 완료!!");
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
	}

}






