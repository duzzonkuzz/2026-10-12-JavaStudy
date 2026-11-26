package com.sist.client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// 전화기 => 서버에 연결 
        	Socket s=new Socket("192.168.0.31",11111);
        	System.out.println("서버 접속 완료");
        	OutputStream out=s.getOutputStream();
        	// Socket : 서버
        	BufferedReader in=
					new BufferedReader(
							new InputStreamReader(s.getInputStream()));
        	out.write("Hi Server!!\n".getBytes());
        	String msg=in.readLine();
        	System.out.println("서버 응답:"+msg);
        }catch(Exception ex) {}
	}

}