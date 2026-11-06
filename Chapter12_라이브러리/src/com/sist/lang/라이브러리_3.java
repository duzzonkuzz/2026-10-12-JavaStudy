package com.sist.lang;
class Sawon implements Cloneable
{
	private int sabun;
	private String name;
	private String dept;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void print()
	{
		System.out.println("==사원 정보==");
		System.out.println("사번"+sabun);
		System.out.println("이름"+name);
		System.out.println("부서"+dept);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	/*
	 *    public void display(Sawon s=ss)
	 *    {
	 *       s.setName("");
	 *    }
	 *    
	 *    Sawon ss=new Sawon();
	 *    display(ss)
	 */

}

public class 라이브러리_3 {
public static void main(String[] args) throws Exception {
	Sawon hong=new Sawon();
	hong.setSabun(1);
	hong.setName("홍길동");
	hong.setName("개발부");
	hong.print();
	System.out.println("hong메모리주소"+hong);
	
	// 복제 => 같은 메모리를 새롭게 생성
	Sawon shim=(Sawon)hong.clone();
	// Sawon 은 클래스 hong 을 클래스로 형변환 object 는 Sawon 보다 크기에 형변환이 안됨
	shim.print();
	System.out.println("shim 메모리 주소:"+shim);
    
    Sawon park=new Sawon();
    park.print();
    System.out.println("park 메모리 주소:"+park);
    
    Sawon kim=shim;
    System.out.println("kim 메모리 주소:"+kim);
    kim.print();
    kim.setName("김두한");
    kim.setDept("총무부");
    kim.setSabun(2);
    kim.print();
    shim.print();
}
	
}
