//열거형은 상수



enum Day{
	월요일,화요일,수요일,목요일,금요일,토요일,일요일
}
public class 열거형_1 {
public static void main(String[] args) {
	Day today=Day.금요일;
	System.out.println(today);
	System.out.println(today==Day.월요일);
	
	
}
}
