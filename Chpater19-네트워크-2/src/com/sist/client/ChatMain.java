package com.sist.client;
import java.util.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatMain extends JFrame implements ActionListener,Runnable{
JTextArea ta;
JTextField tf;
JButton b1,b2;
String name;
JScrollBar bar;
Socket s;
BufferedReader in;
OutputStream out;
/*
 *   데이터베이스
 *   -------
 *   Connection Socket
 *   PreparedStatement 
 *   ResultSet
 */
public ChatMain()
{
	ta=new JTextArea();
	ta.setEditable(false);
	JScrollPane js=new JScrollPane(ta);
	bar=js.getVerticalScrollBar();
	tf=new JTextField(25);
	tf.setEnabled(false);
	b1=new JButton("접속");
	b2=new JButton("종료");
	
	JPanel p=new JPanel();
	p.add(tf);
	p.add(b1);
	p.add(b2);
	
	add("Center", js);
	add("South",p);
	
	setSize(450, 400);
	setVisible(true);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	tf.addActionListener(this);
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public static void main(String[] args) {
new ChatMain();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==b2)
	{
		dispose();
		System.exit(0);
		
	}
	else if(e.getSource()==b1)
	{
		name=JOptionPane.showInputDialog("이름 입력:");
		try
		{
			s=new Socket("192.168.0.31",11111);
			
			out=s.getOutputStream(); // 서버러 전 송
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			//요청에 대한 응답값을 받는다
		}catch(Exception ex) {}
		new Thread(this).start();
		//run() 호출
		tf.setEnabled(true);
		tf.requestFocus();
		b1.setEnabled(false);
		
	}
	else if(e.getSource()==tf)
	{
		String msg=tf.getText();
		if(msg.length()<1)
			return;
	}
	try
	{String msg=tf.getText();
		out.write(("["+name+"]"+msg+"\n").getBytes());
	}catch(Exception ex) {}
	
	tf.setText("");
	tf.requestFocus();
}
// 서버에서 응답한 결과값을 받아서 출력 => Thread
// 클라이언트 => 본인
// 서버 => 쓰레드 ==== 두개가 동시에 처리
@Override
public void run() {
	// TODO Auto-generated method stub
	try
	{
		while(true)
		{
			// 서버로부터 값을 받는다
			String msg=in.readLine();
			ta.append(msg+"\n");
			bar.setValue(bar.getMaximum());
		}
	}catch(Exception ex)
	{
		
	}
}
}
