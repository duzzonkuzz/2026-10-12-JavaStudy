package com.sist.window;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.awt.*;
import com.sist.list.*;
import javax.swing.table.*;
import java.util.*;
public class BookMain extends JFrame implements ActionListener,MouseListener{
    JLabel la,la2;
    JTextField tf;
    JButton b1,b2,b3,b4;
    JTable table;
    DefaultTableModel model;
    // 화면 UI => 생성자
    /*
     *   접근지정어 
     *   1) 클래스 => 모든 클래스에서 사용 가능 => public 
     *   2) 생성자 , 메소드 => public 
     *   3) 변수 => private / getter,setter (public)
     */
    int totalpage=0; // 총페이지
    int curpage=1; // 현재페이지 
    BookSystem bs=new BookSystem();
    JPanel p=new JPanel();
    public BookMain()
    {
    	// 변수 초기화 => 기본형 , 클래스 , 배열 
    	la=new JLabel("Book Center",JLabel.CENTER);
    	la.setFont(new Font("맑은 고딕",Font.BOLD,45));
    	setLayout(null); // 직접 배치 
    	la.setBounds(10, 15, 770, 55);
    	add(la);
    	
    	tf=new JTextField();
    	tf.setBounds(10, 80, 350, 30);
    	add(tf);
    	b1=new JButton("검색");
    	b1.setBounds(365, 80, 100, 30);
    	add(b1);
    	
    	b4=new JButton("목록");
    	b4.setBounds(470, 80, 100, 30);
    	add(b4);
    	
    	String[] col={"번호","","책제목","저자","가격"};
    	String[][] row=new String[0][5];
    	model=new DefaultTableModel(row,col)
    	{

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
    		
    	};
    	table=new JTable(model);
    	JScrollPane js=new JScrollPane(table);
    	js.setBounds(10, 115, 770, 400);
    	add(js);
    	
    	b2=new JButton("이전");
    	b3=new JButton("다음");
    	la2=new JLabel("0 page / 0 pages");
    	
    	
    	p.add(b2);p.add(la2);p.add(b3);
    	
    	p.setBounds(10, 525, 770, 35);
    	add(p);
    	
    	setSize(800,640); // 윈도우 크기 
    	setVisible(true); // 화면 출력 
    	setDefaultCloseOperation(EXIT_ON_CLOSE); // X => 종료 
    	bookPrint();
    	
    	b2.addActionListener(this);
    	b3.addActionListener(this);
    	b4.addActionListener(this);
    	b1.addActionListener(this);
    	tf.addActionListener(this);
    	table.addMouseListener(this);
    }
    public void bookPrint()
    {
    	p.setVisible(true);
    	// 테이블 => 모든 내용 지우기 
    	for(int i=model.getRowCount()-1;i>=0;i--)
    	{
    		model.removeRow(i);
    	}
    	
    	totalpage=(int)(Math.ceil(BookSystem.getBList().size()/10.0));
    	ArrayList<BookVO> list=bs.bookListData(curpage);
    	DecimalFormat df=
    			  new DecimalFormat("###,###");
    	for(BookVO vo:list)
    	{
    		String[] data={
    			String.valueOf(vo.getNo()),
    			"",
    			vo.getTitle(),
    			vo.getAuthor(),
    			df.format(vo.getPrice())+"원"
    		};
    		model.addRow(data);
    	}
    	la2.setText(curpage+" page / "+totalpage+" pages");
    	
    }
    public void findData(String fd)
    {
    	p.setVisible(false);
    	// 테이블 => 모든 내용 지우기 
    	for(int i=model.getRowCount()-1;i>=0;i--)
    	{
    		model.removeRow(i);
    	}
    	ArrayList<BookVO> list=bs.bookFindData(fd);
    	if(list.size()==0)
    	{
    		JOptionPane.showMessageDialog(this, "검색된 결과가 없습니다");
    		tf.setText("");
    		tf.requestFocus();
    		return;
    	}
    	DecimalFormat df=
    			  new DecimalFormat("###,###");
    	for(BookVO vo:list)
    	{
    		String[] data={
    			String.valueOf(vo.getNo()),
    			"",
    			vo.getTitle(),
    			vo.getAuthor(),
    			df.format(vo.getPrice())+"원"
    		};
    		model.addRow(data);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 생성자 호출 
		try
		{
		   UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");	
		}catch(Exception ex) {}
		
		new BookMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2) //이전 
		{
			if(curpage>1)
			{
				curpage--;
				bookPrint();
			}
		}
		else if(e.getSource()==b3)// 다음
		{
			if(curpage<totalpage)
			{
				curpage++;
				bookPrint();
			}
		}
		else if(e.getSource()==b4)
		{
			curpage=1;
			bookPrint();
		}
		else if(e.getSource()==b1||e.getSource()==tf)
		{
			String fd=tf.getText();
			if(fd.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "검색어 입력");
				tf.requestFocus();
				return;
			}
			findData(fd);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table)
		{
			if(e.getClickCount()==2)// 더블 클릭 
			{
				int row=table.getSelectedRow();
				String no=model.getValueAt(row, 0).toString();
				BookVO vo=bs.bookDetailData(Integer.parseInt(no));
				String msg="책제목:"+vo.getTitle()
				          +"\n저자:"+vo.getAuthor()
				          +"\n가격:"+vo.getPrice()
				          +"\n총페이지:"+vo.getPages()
				          +"\n출판일:"+vo.getPubdate();
				JOptionPane.showMessageDialog(this, msg);
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}