package com.sist.emp;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class Login extends JPanel{
    JLabel la1,la2;
    JTextField tf1,tf2;
    JButton b1,b2;
    public Login()
    {
    	la1=new JLabel("사번");
    	la2=new JLabel("이름");
    	tf1=new JTextField();
    	tf2=new JTextField();
    	b1=new JButton("로그인");
    	b2=new JButton("취소");
    	
    	// 배치 
    	setLayout(null);
    	la1.setBounds(10, 15, 50, 30);
    	tf1.setBounds(65, 15, 150, 30);
    	la2.setBounds(10, 50, 50, 30);
    	tf2.setBounds(65, 50, 150, 30);
    	
    	JPanel p=new JPanel();
    	p.add(b1);p.add(b2);
    	
    	p.setBounds(10, 90, 205, 35);
    	
    	add(la1);add(tf1);
    	add(la2);add(tf2);
    	add(p);
    	
    }
}