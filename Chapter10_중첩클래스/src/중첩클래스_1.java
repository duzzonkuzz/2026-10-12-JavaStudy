// 멤버클래스 (접근방식)
//    데이터 수집 
class Outer{
	private String name="홍길동";
	// 데이터 분석 / 통계 / 확률 
	class Inner{
		int a=10;
		public void print()
		{
			System.out.println(a+":"+name);
		}
	}
}
// 정적 멤버클래스 
class Outer2{
	static class Inner{
		public void print()
		{
			System.out.println("static Inner:print() Call...");
		}
	}
}
// 지역클래스 
class Outer3{
	public void print() {
		class Inner{
			public void print() {
				System.out.println("지역클래스:Inner:print() Call...");
			}
		}
		Inner i=new Inner();
		i.print();
	}
}
//  익명의 클래스
class Outer4{
	Inner in=new Inner() {
		public void print() {
			System.out.println("Outer4에서 print() 오버라이딩됨");
		}
	};
}
class Inner{
	public void print()
	{
		System.out.println("Inner:print() Call...");
	}
}
//    Server
class Outer5{
	int value=10;
	public void display() {
		Inner i=new Inner();
		i.method();
	}
	// Client 
	class Inner{
		int value=20;
		public void method() {
			int value=30;
			System.out.println("value="+value);
			System.out.println("value="+this.value);
			System.out.println("value="+Outer5.this.value);
		}
	}
}
public class 중첩클래스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("****======= 인스턴스 멤버 ======");
        Outer p=new Outer();
        Outer.Inner c=p.new Inner();
        c.print();
        
        System.out.println("======= 정적 멤버 ========");
        Outer2.Inner c1=new Outer2.Inner();
        c1.print();
        
        System.out.println("======= 지역 클래스 ========");
        Outer3 o=new Outer3();
        o.print();
        
        System.out.println("****======= 익명의 클래스 ======");
        Inner i=new Inner();
        i.print();
        
        Outer4 o4=new Outer4();
        o4.in.print();
        
        Outer5 o5=new Outer5();
        o5.display();
	}

}