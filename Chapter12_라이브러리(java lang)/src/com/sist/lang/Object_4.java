package com.sist.lang;

//객체 구분자 : hashCode()
import java.util.*;
class Sawon
{
	private int sabun;
	private String name;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// 초기화 
	public Sawon(int sabun,String name)
	{
		this.sabun=sabun;
		this.name=name;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Sawon)
		{
			Sawon s=(Sawon)obj;
			return sabun==s.sabun && name.equals(s.name);
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(sabun,name);
	}
	
	
}
public class Object_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Sawon s1=new Sawon(1, "박문수");
     Sawon s2=new Sawon(1, "박문수");
     System.out.println(s1.hashCode());
     System.out.println(s2.hashCode());
     // hashCode() 객체의 구분자 
     // equals() 값 비교 
     Set<Sawon> set=new HashSet<Sawon>();
     set.add(s1);
     set.add(s2);
     
     for(Sawon s:set)
     {
     	System.out.println(s.getSabun());
     	System.out.println(s.getName());
     }
     
     
	}

}