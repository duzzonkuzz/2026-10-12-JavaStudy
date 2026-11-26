package com.sist.thread;
/*
 *     일반 프로그램    쓰레드 비교 
 *     일반(싱글 쓰레드) :병렬          멀티쓰레드 직렬
 *     작업 하나씩 실행            여러 작업을 동시에 실행 가능 
 *     처리 순차적                동시 수행 
 *     구조가 간단                작업 처리의 효율성 
 *     작업 오래 걸릴 수 있다       동기화 문제 발생 가능 => 충돌 
 *     ------------------------------------------------
 *     게임 
 *       비행기 / 총알 
 *       비행기가 종료 
 *       총알...
 *       
 *     쓰레드 사용 
 *     start() : 새로운 쓰레드 생성 => 실행 시작 명령 
 *                                -------- run()
 *     run()  : 실제 쓰레드 동작 => run()을 직접 호출 => 일반 메소드 
 *     sleep() : 지정된 시간 동안 실행을 멈춘다 
 *     join() : 다른 쓰레드의 종료를 기다림
 *     ------- 크롤링 
 *     
 *     ----------------------------
 *          Main Thread (main())
 *             프로그램 시작 
 *     -------------------------------
 *                 |
 *     -------------------------------
 *      Thread 1   Thread 2  Thread 3
 *       작업실행     작업실행    작업실행 
 *       => 지니 1   지니 2     지니 3
 *     -------------------------------
 *                 |
 *              작업 결과 출력 
 *              
 *     운영체제와 CPU가 Thread 실행 시간 관리 
 *     ------------
 *     CPU => 쓰레드가 여러개면 시간을 나눠서 동작 
 *     실행 순서가 매번 달라질 수 있다 
 *     
 *     ----------------------------------------
 *     여러 작업을 동시에 처리  => 코드가 복잡할 수 있다 
 *     작업 대기 시간을 활용   => 쓰레드 생성 비용의 문제 
 *     사용자 응답 최적화     => 공유 데이터가 충돌 
 *     CPU 자원 활용        => 디버깅 어렵다 
 *     ** 데이터 충돌 
 *     ----------------------------------------
 *     Thread Pool 
 *            ----- 저장 장소 
 *     => 쓰레드를 미리 만들어 놓고 필요시마다 빌려서 사용 
 *        => 사용후에 반환 (재사용)
 *     => 일반 쓰레드는 작업시마다 새로운 쓰레드 생성 : 메모리 부족 
 *     -----------------------------------------------
 *         Thread       ThreadPool
 *       작업마다 생성      미리 생성 / 관리 
 *       재사용(X)        재사용(O)
 *       직접 관리         Executer가 관리 
 *       생성시마다 비용 발생 반복 작업시 효율적 
 *       단순한 Thread 이해  실제 서버에서 주로 사용 
 *    Thread Pool의 동작 순서 
 *    ---------------------
 *    1) ThreadPool 생성 => 저장 장소 확보 
 *    2) 쓰레드 필요한 갯수만큼 생성 => POOL에 저장 
 *    3) 대기열에서 기다림 
 *    4) 쓰레드가 다음 작업을 수행
 *    5) 사용이 끝나면 => 반환 
 *      
 *    interface  A
 *    {
 *        public void aaa();
 *        //public void bbb();
 *    }
 *    
 *    new A(){
 *       public void aaa(){}
 *       //public void bbb(){}
 *    }
 *    
 *    ()->{}
 *    
 */
import java.util.concurrent.*;
public class Thread_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //System.out.println(Thread.currentThread());
		ExecutorService pool=
				Executors.newFixedThreadPool(3);
		// pool => thread 3개 저장 
		// 작업 
		for(int i=1;i<=5;i++)
		{
			int no=i;
			//pool.execute(()->{});
			pool.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(
					  "작업 "+no+
					  " 실행:"+Thread.currentThread().getName()
					);
					try
					{
						Thread.sleep(1000);
					}catch(Exception ex) {
						Thread.currentThread().interrupt();
					}
					System.out.println(" 작업 "+no+" 완료");
				}
				
			});
		}
		pool.shutdown();
		
	}

}