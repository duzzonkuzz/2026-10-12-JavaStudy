package com.sist.thread;
import java.util.concurrent.*;
/*
 *     ExecutorService pool=
				Executors.newFixedThreadPool(3);
 *     -------------------
 *      직원1  직원2   직원3
 *     -------------------
 *     직원1 -> 주문 1 "볶음밥"
 *     직원2 -> 주문 2 "짜장면"
 *     직원3 -> 주문 3 "울면"
 *     ---------------------
 *     직원1 -> 주문 4 "탕수육"
 *     직원2 -> 주문 5 "짬뽕"
 *     ---- 배정 CPU에 따라 다를 수 있다  => 우선 순위가 높은 쓰레드 배치 
 *     
 *     작업시간을 줄일 수 있다 / 쓰레드를 재사용이 가능 
 *     동시에 여러 데이터를 가지고 올 수 있다 
 *     
 *     => 내부 클래스 
 *        --------- 쓰레드 (데이터 공유) , 네트워크 , 윈도우 
 *                  Application용 
 *        웹 서버 => 동작하는 과정 
 *        
 */
public class Thread_4 {
    // 직원 3명 ==> 작업 5개 (음식 요청) 
	// 3-3개 ==> 반환 3명 => 2개 
	//           ------ 1명 정지 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 직원 3명 ==> 4페이지 6680 
		ExecutorService pool=
				Executors.newFixedThreadPool(3);
		// 주문한 음식 제작 
		String[] food={"볶음밥","짜장면","울면","탕수육","짬뽕","만두"};
		for(int i=0;i<6;i++)
		{
			int no=i;
			pool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(
					  Thread.currentThread().getName()
					  +": 주문 "+food[no]+" 요리시작"
					);
					try
					{
						Thread.sleep(2000);
					}catch(Exception ex)
					{
						Thread.currentThread().interrupt();
						// 쓰레드 종료 
					}
					System.out.println("주문 "+food[no]+" 완료");
					
				}
			});
			
		}
		// 새로운 주문 중단 
		pool.shutdown();
		
	}

}