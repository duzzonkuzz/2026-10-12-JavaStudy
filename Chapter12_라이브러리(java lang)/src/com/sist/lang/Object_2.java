package com.sist.lang;

//재정의 => toString : 객체 주소값을 출력 
//| 오버라이딩 => 객체의 실제 값을 출력 
class Member
{
private String name;
private String sex;
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getSex() {
return sex;
}
public void setSex(String sex) {
this.sex = sex;
}
// 여기 부분 => 변수의 값
@Override
public String toString() {
// TODO Auto-generated method stub
//return super.toString(); // 주소값
return "이름:"+name+",성별:"+sex;
}

}
public class Object_2 {

public static void main(String[] args) {
// TODO Auto-generated method stub
Member m1=new Member();
m1.setName("홍길동");
m1.setSex("남자");

System.out.println("m1 주소:"+m1);//.toString()
System.out.println("m1 주소:"+m1.toString());
}

}