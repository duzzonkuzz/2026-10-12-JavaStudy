import java.util.Scanner;
public class 다중조건문_2 {
public static void main(String[] args) {
	int menu=0;
	Scanner scan=new Scanner(System.in);
	
	while(true)
	{
		System.out.println("===menu=====");
		System.out.println("1. 사원 목록");
		System.out.println("2. 사원 상세보기");
		System.out.println("3. 사원 등록");
		System.out.println("4. 사원 수정");
		System.out.println("5. 사원 삭제");
		System.out.println("6. 사원 검색");
		System.out.println("7. 프로그램 종료");
		System.out.println("=========");
	    System.out.println("메뉴 선택:");
	    menu=scan.nextInt();
	
	    if(menu==1)
	    {
	    	System.out.println("사원 목록 출력");
	    }
	    else if(menu==2)
	    {System.out.println("사원 상세보기 출력");
	    }
	    else if(menu==3)
	    {System.out.println("사원 목록 출력");
	    }
	    else if(menu==4)
	    {System.out.println("사원 정보 수정");
	    }
	    else if(menu==5)
	    {System.out.println("사원 탈퇴");
	    }
	    else if(menu==6)
	    {System.out.println("사원 검색 결과 출력");
	    }
	    else if(menu==7)
	    {
	    	System.out.println("프로그램 종료합니다");
	    	System.exit(0);
	    	
	    }
	    else
	    {
	    	System.out.println("없는 메뉴입니다. 다시 입력하세요.");
	    }
	    
	    
	}
}
}
