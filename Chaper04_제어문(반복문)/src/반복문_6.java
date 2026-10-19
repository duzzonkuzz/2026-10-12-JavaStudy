// => 로또 => 6 (1~45) => 중복이 될 수 있다
public class 반복문_6 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<6;i++)
		{
			int lotto=(int)(Math.random()*45)+1;
			Thread.sleep(1000);
			System.err.println(lotto+" ");
		}

	}

}
