/*
 *  전체 => for / while 주력
 *        do while 형식 / 실행 순서
 */
public class 반복문_do_while_2 {
	public static void main(String[] args) {
		
		
		
		System.out.println("\n==for===");
		for(int i=1;i<=10;i++) // 변수가 for문 안에 있는 것임 끝나면 사라짐
		{
			System.out.println(i+" ");
		}
		// 화면 UI / 배열 처리 / 컬렉션 처리
		// 여러개 데이터를 한번에 저장하는 공간
		// 갯수를 아는 경우 주로 사용
		
		
		
		
		System.out.println("\n==while===");
		int i=1;
		while(i<=10)
		{
			System.out.println(i+" ");
			i++;
		}
		//갯수를 모르는 경우 (가변) 
		// **파일 입출 / **데이터 베이스 / 네트워크 서버
		
		
		
		System.out.println("\n==dowhile===");
		i=1;
		do
		{
			System.out.println(i+" ");
			i++;
		}while(i<=10);
		// 게임 / 로그인 처리 => while
		// 반드시 1번 이상 수행
		
	}

}
