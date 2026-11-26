package com.sist.thread;
import java.util.*;
class MusicVO{
	private int mno;
	private String title;
	public MusicVO(int mno,String title)
	{
		this.mno=mno;
		this.title=title;
	}
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
	// => 오버라이딩 가장 많은 메소드 => 객체 주소 (변수의 초기화)
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return mno+":"+title;
	}
	
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<MusicVO> list=
        		new ArrayList<MusicVO>();
        list.add(new MusicVO(1, "아이유"));
        list.add(new MusicVO(2, "리센느"));
        list.add(new MusicVO(3, "아일릿"));
        
        System.out.println(list);
        
        list.sort(Comparator.comparingInt(MusicVO::getMno));// 올림
        System.out.println(list);
        // MusicVO::getTitle => 메소드 참조
        list.sort(Comparator.comparing(MusicVO::getTitle));
        System.out.println(list);
        list.sort(Comparator.comparingInt(MusicVO::getMno).reversed());
        // 내림차순 
        System.out.println(list);
	}

}