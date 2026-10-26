/*
 * 
 */
public class 메소드_3 {
	static void display()
	{
		System.out.println("디스플레이() 진입");
		System.out.println("사용자 요청 처리");
		System.out.println("사용자 요청에 대한 결과값");
	}
static void process()
{
	System.out.println("process() 진입");
	System.out.println("사용자 요청 처리");
	display();
	System.out.println("사용자 요청에 대한 결과값");
}
public static void main(String[] args) {
	System.out.println("메인 시작");
	process();  // 메소드는 {} 종료 => 원상복귀
	System.out.println("main종료");
	// main 프로그램 시작 / 프로그램 종료
}
}
