package com.sist.lang;

//메모리 주소 => 배열 / 클래스 => 참조 데이터형 
class Member
{
	private int mno;
	private String name;
	private String address;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void print()
	{
		System.out.println("======= 회원 정보 ======");
		System.out.println("회원번호:"+mno);
		System.out.println("이름:"+name);
		System.out.println("주소:"+address);
	}
	// 예외 => String
	public void memberUpdate(Member m)// Member m=mm
	{
		m.setMno(1);
		m.setName("홍길동");
		m.setAddress("서울시 마포구");
	}
	
}
public class 라이브러리_4 {
	public static void arrayUpdate(int[] arr) // arr=a
	{
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Member mm=new Member();
     mm.memberUpdate(mm);
     mm.print();
     
     int[] a=new int[5]; // int[] a=arr
     arrayUpdate(a);
     System.out.println("\n=============");
     for(int i:a)
		{
			System.out.print(i+" ");
		}
     
	}

}