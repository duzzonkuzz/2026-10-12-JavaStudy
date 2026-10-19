import java.io.*;
public class 반복문_while_실무_1 {
public static void main(String[] args) throws Exception {
	FileReader fr=
	new FileReader("C:\\Users\\sist-40\\eclipse-workspace\\Chaper04_제어문(반복문)\\src\\반복문_while_6.java");
	int i=0;
	while((i=fr.read())!=-1)
	{
		System.out.print((char)i);
	}
}
}
