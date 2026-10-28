// 정수 입력
   //index=15 index--
import java.util.Scanner;
public class 배열_3 {
	public static void main(String[] args) {
		
	



int[] binary=new int[16];
int index=15;
Scanner scan=new Scanner(System.in);
System.out.println("정수입력:");
int input=scan.nextInt();

while(true)
{
	binary[index]=input%2;
	input/=2;
	if(input==0)
		break;
	index--;
}

// 출력
		for(int i=0;i<binary.length;i++)
		{
			if(i%4==0 && i!=0)
				System.out.print(" ");
			System.out.print(binary[i]);
		}
		
	}

}
