package com.sist.emp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class UserMain extends JFrame implements ActionListener{
    CardLayout card=new CardLayout();
    Login login=new Login();
    EmpList eList=new EmpList();
    // DB 
    EmpDAO dao=EmpDAO.newInstance();
    public UserMain()
    {
    	setLayout(card);
    	
    	add("LOGIN",login);
    	add("LIST",eList);
    	setSize(640, 480);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	login.b1.addActionListener(this);
    	login.b2.addActionListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}catch(Exception ex) {}
        new UserMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.b1)
		{
			//1. 사번을 읽는다 
			String empno=login.tf1.getText();
			if(empno.trim().length()<1)
			{
				login.tf1.requestFocus();
				return;
			}
			String ename=login.tf2.getText();
			if(ename.trim().length()<1)
			{
				login.tf2.requestFocus();
				return;
			}
			
			String res=dao.isLogin(Integer.parseInt(empno), ename);
			
			if(res.equals("NOSABUN"))
			{
				JOptionPane.showMessageDialog(this, "사번이 없습니다");
				login.tf1.setText("");
				login.tf2.setText("");
			}
			else if(res.equals("NONAME"))
			{
				JOptionPane.showMessageDialog(this, "이름이 없습니다");
				login.tf2.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "로그인 되었습니다");
				List<EmpVO> list=
						   dao.empAllData();
				for(EmpVO vo:list)
				{
					String[] data= {
						String.valueOf(vo.getEmpno()),
						vo.getEname(),
						vo.getJob(),
						vo.getHiredate().toString(),
						String.valueOf(vo.getDeptno())
					};
					eList.model.addRow(data);
				}
				card.show(getContentPane(), "LIST");
				
			}
		}
		else if(e.getSource()==login.b2)
		{
			System.exit(0);
		}
	}

}