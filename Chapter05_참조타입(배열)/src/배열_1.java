/*
 * 데이터를 모아서 관리
 *   = 배열 : 같은 유형의 데이터
 *   = 클래스 : 다른 유형의 데이터
 * 배열 : 같은 유형의 데이터를 여러개 모아서 관리할 목적
 *   => 배열 (고정)
 *   => ArrayList / LinkedList / Vector / Map / Set
 *           --------------------- 컬렉션 (가변) => 2권
 *  1) 특징
 *    = 연속적인 메모리 할당 => 인덱스를 이용한 접근이 가능
 *    = 고정된 크기
 *      배열 크기는 선언시에 정해진다 => 동적으로 변경 (메소드를 사용)
 *      한번 선언하면 => 변경이 불가능
 *                    => 배열 복사 => 더 크게 만든다 (메모리에 문제가 있을 수 있다)
 *    = 같은 데이터형만 모아서 관리가 가능
 *  2) 장점
 *     = 빠른 접근 속도 => 인덱스번호를 이용한다
 *     = CPU를 자주 사용시에 데이터를 cache 에 저장 후 사용이 가능
 *     = 간단한 구현 => 배열의 데이터 저장 구조가 단순하다
 *     = 고정된 크기 => 메모리의 사용량을 예측
 *  3) 단점
 *    = 고정된 크기 => 추가, 삭제시에 어렵다. (비용이 많이 투자)
 *    = 메모리 낭비 => 크게 만들면 사용이 안되는 메모리가 존재
 *    = 같은 데이터형만 저장 = 유연성이 떨어진다
 *  4) 배열 선언
 *     데이터형[] 배열명
 *               | 식별자
 *     ----int/double/.../string
 *      데이터형 배열명[]; => c언어
 *  5) 배열 초기화
 *     = 선언과 동시에 초기화
 *       데이터형[] 배열명 = {값,값,값,..] => 명시적 초기화 : int a=10
 *                        ---------- 파일 / 데이터베이스
 *     = default 생성 => 가장 많이 사용
 *       데이터형[] 배열명 = new 데이터형[생성갯수]
 *          1) int = 0
 *          2) double - 0.0
 *          3) char - '0'
 *          4) string null(참조타입 : 메모리 주소가 없느 경우)
 *                    ----- NullPointerException
 *          5) long => 0L
 *          6) boolean - false
 *           = 선언 => 나중에 초기화
 *           데이터형[] 배열명;
 *           배열명=new 데이터형[]{값...}
 *  6) 배열에 저장된 데이터 출력 : for-each
 *      int[] arr={값..};
 *      for(int i=0;i<arr.lengtht;i++)
 *      {
 *           System.out.println(arr[i])
 *      }
 *       -일반 for - 배열의 인덱스를 이용해서 값을 가지고 온다
 *       - for-each - 실제 배열에 저장된 실제 데이터를 읽어온다 => 웹이서 주로 출력
 *       for(int a:arr)
 *            |      |---배열 / 컬렉션만 사용이 가능 
 *           배열에 저장된 데이터형
 *           {
 *           
 *           }
 *           배열의 데이터를 변경 => 일반 for
 *           데이터만 출력 => for-each
 *  7) 메모리 구조
 *  int[] arr={10,20,30}
 *  -------------
 *  
 *  -----stack------  -------heap---------
 *                         10 20 30 
 *  -----------        ----------------	
 *  
 *  배열의 필요성 
 *  ---------
 *  3명의 학생 => 국어 영어 수학 => 총점, 평균, 학점
 *  => 관련된 데이터끼리 묶어서 사용
 *   
 */
 import java.util.Scanner;
 
public class 배열_1 {
public static void main(String[] args) {
//	int kor1,kor2,kor3;
//	int eng1,eng2,eng3;
//	int math1,math2,math3;
//	int total1,total2,total3;
//	double avg1,avg2,avg3;
//	char score1,score2,score3;
//	
//	Scanner scan=new Scanner(System.in);
//	// 1st
//	System.out.println("첫번째 학생 국어 점수");
//	kor1=scan.nextInt();
//	
//	System.out.println("첫번째 학생 영어 점수");
//	eng1=scan.nextInt();
//	
//	System.out.println("첫번째 학생 수학 점수");
//	math1=scan.nextInt();
//	
//	total1=kor1+eng1+math1;
//	avg1=total1/3.0;
//	
//	switch((total1/30))
//	{
//	case 10,9 -> score1='a';
//	case 8,7 -> score1='b';
//	case 6,5 -> score1='c';
//	case 4,3 -> score1='d';
//	default -> score1='f';
//	}
//	
//	
//	
//	// 2nd
//		System.out.println("두번째 학생 국어 점수");
//		kor2=scan.nextInt();
//		
//		System.out.println("두번째 학생 영어 점수");
//		eng2=scan.nextInt();
//		
//		System.out.println("두번째 학생 수학 점수");
//		math2=scan.nextInt();
//		
//		total2=kor2+eng2+math2;
//		avg2=total2/3.0;
//		
//		switch((total1/30))
//		{
//		case 10,9 -> score2='a';
//		case 8,7 -> score2='b';
//		case 6,5 -> score2='c';
//		case 4,3 -> score2='d';
//		default -> score2='f';
//		}
//		
//		System.out.printf("%-5d%-5d%-5d%-7d%-5.2f%-5c\n",
//				kor1,eng1,math1,total1,avg1,score1);
//		System.out.printf("%-5d%-5d%-5d%-7d%-5.2f-%5c\n",
//				kor2,eng2,math2,total2,avg2,score2);
		
	int[] kor=new int[3]; //int kor1,kor2,kor3
	int[] eng=new int[3];
	int[] math=new int[3];
	int[] total=new int[3];
	double[] avg=new double[3];
	char[] score=new char[3];
	Scanner scan=new Scanner(System.in);
	// new 배열의초기화 ( 초기값 0) 따라서 new를 써야함 입력값을 받아와야하기 때문 , 입력값을 안다면 new x {0,0,0}
	// new int[3] = {0,0,0}

	// 점수 입력
	for(int i=0;i<3;i++)
	{
		System.out.println((i+1)+"번째 국어입력:");
		kor[i]=scan.nextInt();
		System.out.println((i+1)+"번째 영어입력:");
		eng[i]=scan.nextInt();
		System.out.println((i+1)+"번째 수학입력:");
		math[i]=scan.nextInt();
		
		total[i]=kor[i]+eng[i]+math[i];
		avg[i]=total[i]/3.0;
		switch((total[i]/30))
		{
		case 10,9 -> score[i]='a';
		case 8,7 -> score[i]='b';
		case 6,5 -> score[i]='c';
		case 4,3 -> score[i]='d';
		default -> score[i]='f';
		}
	}
		for(int i=0;i<3;i++)
		{
			System.out.printf("%-5d%-5d%-5d%-7d%-7.2f%-5c\n",
					kor[i],eng[i],math[i],total[i],avg[i],score[i]);
		}
	
	
		
}
}




