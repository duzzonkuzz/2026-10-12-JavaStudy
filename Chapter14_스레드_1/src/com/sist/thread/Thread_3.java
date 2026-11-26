package com.sist.thread;
/*
 *   Thread => 일하는 직원 
 *   => 식당 => 손님이 3명 
 *   1=짜장면
 *   2=짬뽕
 *   3=볶음밥 
 */
public class Thread_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("직원 1:짜장면 만들기");
			}
		});
        Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("직원 2:짬뽕 만들기");
			}
		});
        Thread t3=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("직원 3:볶음밥 만들기");
			}
		});
        
        
        t1.start();
        t2.start();
        t3.start();
	}

}