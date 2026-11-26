package com.sist.server;
import java.io.*;
import java.net.*;
import java.util.Vector;
public class Server implements Runnable {
	private Vector<Client> waitVc=
			new Vector<Client>();
	private ServerSocket ss;
	private final int PORT=3355;
	private Server()
	{
		try
		{
			ss=new ServerSocket(PORT);
			System.out.println("Server Start");
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// 접속시 처리
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
			Socket s=ss.accept();
			Client client=new Client(s);
			waitVc.add(client);
			client.start();
			}
		}catch(Exception ex) {}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Server server=new Server();
new Thread(server).start();

	}
	
	class Client extends Thread
	{
		// 
		Socket s;
		OutputStream out;
		BufferedReader in;
		public Client(Socket s)
		{
			try
			{
				this.s=s;
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream())); 
				// 요청 받는 통로
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		public void run()
		{
			try
			{
				while(true)
				{
					// 접속자의 요청사항
					String msg=in.readLine();
					for(Client c:waitVc)
					{
						c.out.write((msg+"\n").getBytes());
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

	

}
