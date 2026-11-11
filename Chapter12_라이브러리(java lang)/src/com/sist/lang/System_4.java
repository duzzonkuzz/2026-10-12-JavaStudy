package com.sist.lang;
//520page 
public class System_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String osName=System.getProperty("os.name");
     System.out.println("OSName:"+osName);
     String userName=System.getProperty("user.name");
     System.out.println("UserName:"+userName);// 컴퓨터명 
     String userHome=System.getProperty("user.home");
     System.out.println("UserHome:"+userHome);
     //java => version => CI / CD => docker(버전이 동일)
     String java=System.getProperty("java.version");
     System.out.println("Java:"+java);
	}

}