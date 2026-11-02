package com.sist.abs1;
// 같은 종류의 클래스 => 추상클래스 / 인터페이스를 이용해서 묶어서 한개의 객체로 사용
/*
 * 추상클래스
 *   => 공통 기반 => 다른 내용으로 사용 : 선언만
 *   => 같은 기능 => 구현
 */
public class UserMain {
public static void main(String[] args) {
	MusicSystem ms=new GenieMusic();
	ms.datacollection();
	Music[] musics=ms.musicList();
	for(Music m:musics)
	{
		System.out.println(m.getMno()+"."+m.getTitle());
	}
	
	System.out.println("======");
	ms=new MelonMusic();
	ms.datacollection();
	musics=ms.musicList();
	for(Music m:musics)
	{
		System.out.println(m.getMno()+"."+m.getTitle());
	}
}
}
