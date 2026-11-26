package com.sist.thread;
/*
 *    Thread => 한개의 프로그램안에 여러개의 기능이 동시에 수행 
 *                            ---------------------
 *                                쓰레드 
 *             ----------- 프로세스  
 *      | = 게임 / 서버 / 크롤링 
 *    => java.lang => 생략이 가능 
 *    사용처 
 *      ***1) 데이터 수집 
 *      ***2) 네트워크 서버 (여러명 => 접속시 => 통신을 따라)
 *      3) 게임 (비행기 , 몬스터) => 배경 스크롤 
 *      4) 웹 서버 / ***오라클 서버
 *    => 시분할 => CPU가 작업을 나눠서 작업을 수행할 수 있게 만든다 
 *    
 *    사용자 정의 쓰레드 
 *    --------------
 *    1. 쓰레드 상속 
 *       class MyThread extends Thread
 *       {
 *           자원 공유 
 *           반드시 처리 
 *           public void run(){
 *             쓰레드 작업 내용 => 한가지일만 수행 
 *           }
 *       }
 *    2. 인터페이스 
 *       class MyThread implements Runnable
 *       {
 *           public void run(){
 *             쓰레드 작업 내용 => 한가지일만 수행 
 *           }
 *       }
 *       
 *    3. 익명의 함수 
 *       new Runnable()->{
 *         => 람다 
 *       }
 *    4. 쓰레드 생명주기 
 *                    start()
 *       new Thread() ====== 대기(쓰레드에 필요한 자원 확보)
 *         쓰레드 생성                 |
 *                                  |  run()
 *                                 쓰레드 동작 ======== 일시정지(sleep(),wait())
 *                                   |
 *                                   |
 *                                   |
 *                                 쓰레드 소멸 => join(),interrupt()
 *     5. 동작 방식 
 *        = ***비동기화 : 웹 (여러가지 일을 동시에 처리)
 *        = 동기화 : 은행 (한번씩 수행)
 *     6. 주요 메소드 
 *        start() : 대기상태 => run()을 호출하는 경우 
 *        run() : 쓰레드 동작 
 *        sleep() : 일시 정지
 *        interrupt() : 쓰레드 종료 
 *        currentThread() : 현재 실행중인 Thread의 이름 
 *        getName / setName() : 쓰레드 이름 / 쓰레드 이름 변경 
 *           => Thread-0 .... 
 *        getPriority() / setPriority() :  우선 순위 결정 
 *           => 1~10 
 *              10 = MAX_PRIORITY : main
 *              1  = MIN_PRIORITY : GC
 *              5  = NORM_PRIORITY : 사용자 정의 
 *        wait() / join()
 *                 | 모든 쓰레드 종료 => 게임 종료 
 *        |  대기상태  
 *        
 */
// 한가지만 수행 
// 비행기 => 날라간다 / 총알 
class MyThread extends Thread
{
	// 동작 
	public void run()
	{
		for(int i=1;i<=1000;i++)
		{
			System.out.println(getName()+":"+i);
			try
			{
				Thread.sleep(100); // MS  1/1000 => 동작을 멈추다
			}catch(Exception ex) {}
		}
	}
}
/*
 *    쓰레드 생성 
 *    MyThread m1=new MyThread();
 *            ---- JVM 
 *            1) 이름 부여 
 *               Thread-0  Thread-1 .....  이름 변경 : setName()
 *                                          | getName()
 *            2) 우선 순위 배정 
 *               사용자 정의 => NORM_PRIORITY => 5 
 *               1~10   => 변경 ==> setPriority(1~10)
 *    실행 
 *    m1.start() ==> run() 호출 
 */
public class Thread_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyThread m1=new MyThread();
        MyThread m2=new MyThread();
        MyThread m3=new MyThread();
        // CPU에서 시간을 분할해서 => thread가 한번씩 수행 
        System.out.println("m1 정보:"+m1.getName()+","+m1.getPriority());
        System.out.println("m2 정보:"+m2.getName()+","+m2.getPriority());
        System.out.println("m3 정보:"+m3.getName()+","+m3.getPriority());
        // 이름 변경 
        m1.setName("홍길동");
        m2.setName("박문수");
        m3.setName("심청이");
        // 우선순위 변경 ==> 거의 비슷 
        m1.setPriority(10);
        m2.setPriority(3);
        m3.setPriority(1);
        m1.start(); // run()호출 
        m2.start();
        m3.start();
	}

}