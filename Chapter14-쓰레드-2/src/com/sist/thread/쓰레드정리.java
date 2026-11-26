package com.sist.thread;

/*
 *    Thread 
 *      => 하나의 프로그램안에서 여러개 작업을 동시을 수행할때 사용되는
 *         ----------- 프로세스  
 *         작은 단위 프로그램 
 *      => 장점 
 *         여러 작업을 동시에 처리 
 *         CPU 활용도를 증가 (속도 최적화) 
 *         작업 대기 시간이 감소 
 *      => 단점 
 *         코드가 복잡하다 => 중첩 클래스 
 *         충돌 가능성이 많다 => 동기화 
 *         동기화 => 속도가 늦다 
 *      => 주로 사용처 
 *         네트워크 서버 (사용자 정의,오라클 서버,웹 서버)
 *         ***크롤링 나눠서 수집 
 *         게임
 *      => 주요 메소드 
 *         start() : 쓰레드 실행 시작 => run()을 호출하고 있다 
 *         run() : 실제 쓰레드 작업 내용 
 *         sleep() : 지정 기간동안 대기
 *         join()  : 다른 쓰레드 종료시까지 대기 
 *         interrupt() : 현재 쓰레드를 종료 
 *         currentThread() : 현재 사용되는 쓰레드 확인 
 *         isAlive() : 실행중인지 확인 
 *                     => 비행기 / 총알 
 *      => 실행 
 *                 Thread 객체 생성 
 *                 Thread t=new Thread()
 *                 ---------------------
 *                        |
 *                     start() 호출 => 작업 시작 
 *                        |
 *                      run() => 작업 
 *                        |
 *                     작업 완료 
 *      => 쓰레드 사용법 
 *         1) Thread를 상속 (클래스)
 *            class MyThread extends Thread
 *            {
 *               public void run(){} => 오버라이딩 
 *            }
 *         2) Runnable 구현 (인터페이스)
 *            class MyThread implements Runnable
 *            {
 *               public void run(){}
 *            }
 *         3) 익명의 클래스 
 *            Runable r=new Runnable(){
 *                public void run(){}
 *            }
 *         4) 람다
 *            Runnable r=()->{
 *               구현 
 *            }
 *            
 *           => Runnable 권장 
 *           
 *         ** run()을 직접 호출시는 새로운 쓰레드가 생성되지 않는다 
 *            ----- start()를 이용해서 호출 
 *         ** Application => Web Application 
 *                           => 자체에서 쓰레드를 사용하기 때문에 
 *                              Thread를 이용하면 프로그램이 동작하지 않는다 
 *                              
 *      ThreadPool 
 *        쓰레드를 미리 만들어서 저장후에 작업이 있는 경우 재사용하는 방법을 사용 
 *        장점 
 *         쓰레드를 재사용(메모리 절약) 
 *         생성 => 비용이 감소 
 *         안정적으로 작업이 가능 => 자체관리 
 *        단점 
 *         풀 크기 관리 필요 
 *         직업이 많으면 => 대기 발생 
 *         잘못 설정하면 => 성능이 저하 
 *       -----------------------------------------------------
 *       주요 메소드 
 *         nexFixedThreadPool() : 쓰레드 생성 
 *         execute() : 작업 실행 (결과값 없다)
 *         submit() : 작업 실행 (실행 결과)
 *         shutdown() : 종료 
 *         
 *       실행 과정 
 *            ExecuteService 생성 => 쓰레드 몇개?
 *                 |
 *              작업 등록 
 *              execute()/submit()
 *                 |
 *              작업 대기 => Queue
 *                 |
 *               작업 처리 
 *                 |
 *               작업이 종료시에는 재사용 
 *                 |
 *               종료 
 *       ----------------------------------
 *       Thread : 직접 만들어서 생성 
 *       ThreadPool : 쓰레드 재사용 
 *       start : 쓰레드 시작 
 *       run : 실제 작업 
 *       execute : ThreadPool에 작업 전달 
 *       shutdown: 종료 
 *         
 */
public class 쓰레드정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}