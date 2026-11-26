package com.sist.server;
import java.util.*;

import com.sist.commons.Function;

import java.net.*;
import java.io.*;
/*
 *    class A 
 *    class B => A가 가지고 있는 모든 것을 공유 (변수/메소드)
 *                                        ---------- static
 *    class A
 *    {
 *       class B => 중첩 
 *       {
 *       }
 *    } 
 */
public class Server implements Runnable{
    // 연결 대기 => 연결 수락 => ServerSocket 
	// Scoket => 클라이언트 연결 
	// 송수신 => 수신 : BufferedReader / 송신 : OutputStream 
	// 서버구동 => 접속자 연결 승락 => 데이터 입출력 => 종료 
	private ServerSocket ss;
	private final int PORT=3355;
	private Vector<Client> waitVc=new Vector<Client>();
	// 0~65535 => 0~1023 (사용중) => http 80 / smpt 25 / ftp 21 / telnet 23
	// 1521 / 1433 / 3306 / 5687 / 8080 / 4000
	// 오라클  MS-SQL MySQL   PostgreSQL  프록시  머드
	// 20000(음성) / 30000(화상)
	// 1. 서버 구동 
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);
			// 서버 PORT => 고정 / 고정 IP 
			// 개통 => 대기 
			// bind => listen 
			System.out.println("Server Start...");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// 2. 접속시 => 독립적으로 접속자마다 통신이 가능하게 => thread를 생성 
	public void run() // 쓰레드 동작 
	{
		try
		{
		  while(true)
		  {
			Socket s=ss.accept();
			// 발신자 정보 => Client와 연결되는 소켓
			// 쓰레드 => 통신 => 접속자의 소켓 전송 
			Client client=new Client(s);
			// 통신 시작 
			client.start();
		  }
		}catch(Exception ex) {}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server(); // 서버 구동 
        new Thread(server).start();
        // server클래스에 있는 run()을 호출한다 
	}
	class Client extends Thread
	{
		// 접속자 정보 
		String id,name,sex;
		// 접속자 통신 정보 
		Socket s;// 연결 기기
		OutputStream out; // 송신 
		BufferedReader in;// 수신 
		// 소켓을 받는다
		public Client(Socket s)
		{
			try
			{
				this.s=s;
				out=s.getOutputStream(); // 접속자 송신
				in=new BufferedReader(
						new InputStreamReader(s.getInputStream())); 
				// 접속자 수신
			}catch(Exception ex) {}
		}
		// 통신 시작 
		public void run() 
		{
			try
			{
				// 로그인 => 100|id|name|sex
				while(true)
				{
					// 사용자 요청 
					String msg=in.readLine();
					StringTokenizer st=
							new StringTokenizer(msg,"|");
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol)
					{
					  case Function.LOGIN->{
						  id=st.nextToken();
						  name=st.nextToken();
						  sex=st.nextToken();
						  
						  //1. 접속되어 있는 사람들 처리 
						  messageAll(Function.LOGIN+"|"+id+"|"+name+"|"+sex);
						  messageAll(Function.CHAT+"|[알림 ☞] "+name+"님 입장하셨습니다");
						  // Function.LOGIN => table에 출력 
						  waitVc.add(this);
						  //2. 접속하는 사람 처리 
						  messageTo(Function.MYLOG+"|"+id);
						  // 로그인 종료 => 채팅창을 열어준다 
						  for(Client c:waitVc)
						  {
							  messageTo(Function.LOGIN+"|"+c.id+"|"
						                +c.name+"|"+c.sex);
						  }
						  
					  }
					  case Function.CHAT->{
						  messageAll(Function.CHAT+"|["+name+"]"+st.nextToken());
					  }
					  case Function.EXIT->{
						  messageAll(Function.EXIT+"|"+id);
						  messageAll(Function.CHAT+"|[알림 ☞] "+name+"님 퇴장하셨습니다");
						  
						  for(Client c:waitVc)
						  {
							  if(c.id.equals(id))
							  {
								  messageTo(Function.MYEXIT+"|");
								  waitVc.remove(c);
								  
								  in.close();
								  out.close();
								  break;
							  }
						  }
					  }
					}
					
				}
			}catch(Exception ex) {}
		}
		// 1. 접속자 개인 synchronized : 동기화 
		// 일반 쓰레드 => 비동기 
		public synchronized void messageTo(String msg)
		{
			try
			{
			    out.write((msg+"\n").getBytes());	
			}catch(Exception ex) {}
		}
		// 2. 접속자 전체 
		public synchronized void messageAll(String msg)
		{
			try
			{
				for(Client c:waitVc)
				{
					c.messageTo(msg);
				}
			}catch(Exception ex) {}
		}
	}

}