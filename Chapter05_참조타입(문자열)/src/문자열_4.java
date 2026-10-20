/*
 *  *****String substring(int index)
 *  String substring(int start,int end)
 *  
 *  int indesxOf(찾는문자)
 *  int lastIndexOf(찾는문자)
 */
public class 문자열_4 {

	public static void main(String[] args) {
		String msg="hello Java";
		System.out.println(msg.substring(6));
		System.out.println(msg.substring(0,5)); //0~4
		String s="자바.java";
		System.out.println(s.substring(s.indexOf(".")+1));
		String path="c:\\javaDev\\MainClass.java";
		System.out.println(path.substring(path.lastIndexOf("\\")+1));
	}
}
