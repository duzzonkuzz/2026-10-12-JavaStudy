package com.sist.client;

import java.awt.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.table.*;

import com.sist.commons.Function;
public class ClientMainForm extends JFrame
implements ActionListener,Runnable
{
    JTextArea ta;
    JTextField tf;
    JTable table;
    DefaultTableModel model;
    JButton b1,b2,b3;
    LoginForm login=new LoginForm();
    Socket s; 
    OutputStream out; 
    BufferedReader in; 
    public ClientMainForm()
    {
    	ta=new JTextArea();
    	JScrollPane js1=new JScrollPane(ta);
    	ta.setEditable(false);
    	
    	tf=new JTextField();
    	b1=new JButton("쪽지보내기");
    	b2=new JButton("정보 보기");
    	b3=new JButton("나가기");
    	
    	String[] col={"아이디","이름","성별"};
    	String[][] row=new String[0][3];
    	model=new DefaultTableModel(row,col)
    	{

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
    	   	
    	}; 
    	table=new JTable(model);
    	JScrollPane js2=new JScrollPane(table);
    	
    	////// 배치 
    	setLayout(null);
    	js1.setBounds(10, 15, 500, 450);
    	tf.setBounds(10, 470, 500, 30);
    	
    	js2.setBounds(515, 15, 250, 300);
    	JPanel p=new JPanel();
    	p.setLayout(new GridLayout(3, 1,5,5));
    	p.add(b1);p.add(b2);p.add(b3);
    	p.setBounds(515, 320, 250, 130);
    	
    	// 윈도우 추가
    	add(js1);
    	add(tf);
    	add(js2);
    	add(p);
    	
    	setSize(790, 550);
    	//setVisible(true);
    	
    	// 이벤트 => 서버로 값을 전송하는 위치 
    	login.b1.addActionListener(this);// 로그인 
    	login.b2.addActionListener(this);// 취소
    	
    	tf.addActionListener(this); // 채팅
    	b3.addActionListener(this); // 나가기 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
        new ClientMainForm();
	}
	// 서버와 연결 => 로그인 처리 
	public void connect(String id,String name,String sex)
	{
		/*
		 *   클라이언트   /   서버 
		 *   | 서버의 정보    | 클라이언트 정보 
		 */
	    try
	    {
	    	s=new Socket("192.168.0.31",11111);
	    	// s=new Socket("192.168.0.31",11111);
	    	// 송수신 
	    	out=s.getOutputStream(); // 서버 데이터 전송 
	    	in=new BufferedReader(
	    			new InputStreamReader(s.getInputStream()));
	    	// 서버에서 결과값 받기 
	    	out.write((Function.LOGIN+"|"+id+"|"
	    			+name+"|"+sex+"\n").getBytes());
	    }catch(Exception ex){}
	    // 서버로부터 결과값을 읽어 온다
	    new Thread(this).start();
	}
	// 접속자 요청 => 로그인 / 나가기 
	@Override
	public void actionPerformed(ActionEvent e) {
		// out.write()
		if(e.getSource()==login.b1)// 로그인 버튼 
		{
			// 값을 받는다 
			String id=login.tf1.getText();
			if(id.trim().length()<1)
			{
				login.tf1.requestFocus();
				return;
			}
			String name=login.tf2.getText();
			if(name.trim().length()<1)
			{
				login.tf2.requestFocus();
				return;
			}
			String sex="";
			if(login.rb1.isSelected())
			{
				sex="남자";
			}
			else
			{
				sex="여자";
			}
			// 연결 
			connect(id, name, sex);
		}
		else if(e.getSource()==login.b2) // 종료 
		{
			dispose();
			System.exit(0);
		}
		else if(e.getSource()==tf) // 채팅 
		{
			String msg=tf.getText();
			if(msg.trim().length()<1)
			{
				tf.requestFocus();
				return;
			}
			
			try
			{
				out.write((Function.CHAT+"|"+msg+"\n").getBytes());
			}catch(Exception ex) {}
			
			tf.setText("");
		}
		// 나가기 
		else if(e.getSource()==b3)
		{
			try
			{
				out.write((Function.EXIT+"|\n").getBytes());
			}catch(Exception ex) {}
		}
	}
	// 서버로부터 요청 처리한 결과값을 받는 부분
	@Override
	public void run() {
		// in.readLine()
		try
		{
			while(true)
			{
				String msg=in.readLine();
				StringTokenizer st=new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol)
				{
				  case Function.LOGIN->{
					  String[] data= {
							  st.nextToken(),
							  st.nextToken(),
							  st.nextToken()
					  };
					  model.addRow(data);
				  }
				  case Function.MYLOG->{
					  login.setVisible(false);
					  setVisible(true);
					  setTitle(st.nextToken());
				  }
				  case Function.CHAT->{
					  ta.append(st.nextToken()+"\n");
				  }
				  case Function.EXIT->{
					  String id=st.nextToken();
					  for(int i=0;i<model.getRowCount();i++)
					  {
						  String yid=model.getValueAt(i, 0).toString();
						  if(id.equals(yid))
						  {
							  model.removeRow(i);
							  break;
						  }
					  }
				  }
				  case Function.MYEXIT->{
					  dispose();
					  System.exit(0);
				  }
				}
			}
		}catch(Exception ex) {}
	}

}