import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class 중첩클래스_2 extends JFrame implements ActionListener{
    JButton b1,b2;
    JProgressBar[] bar=new JProgressBar[5];
    
    public 중첩클래스_2()
    {
    	b1=new JButton("시작");
    	b2=new JButton("종료");
    	Color[] colors={
    		Color.cyan,
    		Color.yellow,
    		Color.pink,
    		Color.orange,
    		Color.magenta
    	};
    	JPanel p=new JPanel();
    	p.setLayout(new GridLayout(5,1,5,5));
    	for(int i=0;i<bar.length;i++)
    	{
    		bar[i]=new JProgressBar();
    		bar[i].setMinimum(0);
    		bar[i].setMaximum(100);
    		bar[i].setBackground(Color.white);
    		bar[i].setForeground(colors[i]);
    		bar[i].setStringPainted(true);
    		p.add(bar[i]);
    	}
    	JPanel p1=new JPanel();
    	p1.add(b1); p1.add(b2);
    	add("Center",p);
    	add("South",p1);
    	setSize(450, 350);
    	setVisible(true);
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    }
    public void go()
    {
    	for(int i=0;i<=100;i++)
    	{
    		bar[0].setValue(i);
    		try
    		{
    			Thread.sleep(100);
    		}catch(Exception e) {}
    	}
    	for(int i=0;i<=100;i++)
    	{
    		bar[1].setValue(i);
    		try
    		{
    			Thread.sleep(100);
    		}catch(Exception e) {}
    	}
    	for(int i=0;i<=100;i++)
    	{
    		bar[2].setValue(i);
    		try
    		{
    			Thread.sleep(100);
    		}catch(Exception e) {}
    	}
    	for(int i=0;i<=100;i++)
    	{
    		bar[3].setValue(i);
    		try
    		{
    			Thread.sleep(100);
    		}catch(Exception e) {}
    	}
    	for(int i=0;i<=100;i++)
    	{
    		bar[4].setValue(i);
    		try
    		{
    			Thread.sleep(100);
    		}catch(Exception e) {}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new 중첩클래스_2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			BarThread b=new BarThread();
			b.start();
		}
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
	}
    class BarThread extends Thread
    {
    	public void run()
    	{
    		go();
    	}
    }
}