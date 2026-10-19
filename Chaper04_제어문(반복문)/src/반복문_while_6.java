
public class 반복문_while_6 {
public static void main(String[] args) {
	int money=0;
	int day=1;
	while(day<=7)
	{
		money+=1000;
		System.out.println(day+"일쨰"+money);
		day++;
	}
	System.out.println(money);
}
}
