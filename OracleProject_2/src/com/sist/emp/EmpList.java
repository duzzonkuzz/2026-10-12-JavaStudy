package com.sist.emp;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
//empno,ename,job,hiredate,deptno
// => Group By / Having / JOIN / SubQuery 
// => DDL => DML 
// View / Sequence / 시노님 / Index / PL/SQL
// 요구사항 분석 / 트랜잭션 / 보안 
public class EmpList extends JPanel{
   JTable table;
   JComboBox<Integer> box;
   DefaultTableModel model;
   public EmpList()
   {
	   String[] col={"사번","이름","직위","입사일","부서번호"};
	   String[][] row=new String[0][5];
	   model=new DefaultTableModel(row,col);
	   table=new JTable(model);
	   JScrollPane js=new JScrollPane(table);
	   box=new JComboBox<Integer>();
	   box.addItem(10);
	   box.addItem(20);
	   box.addItem(30);
	   box.addItem(40);
	   box.addItem(50);
	   box.addItem(60);
	   box.addItem(70);
	   box.addItem(80);
	   
	   setLayout(null);
	   box.setBounds(10, 15, 120, 30);
	   js.setBounds(10, 55, 610, 360);
	   
	   add(box);
	   add(js);
   }
}