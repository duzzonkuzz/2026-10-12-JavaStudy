/*
 * 문자열 어러개를 모아서 저장 => 문자열 배열
 * 형식)
 *     String[] names={"jae","john","bill","ringo"};
 *                    names[0] names[1] ...
 *       -----------
 *       ArrayList<String> 가변형
 *       1. Apple - 사과 


2. Banana - 바나나


3. Orange - 오렌지


4. Strawberry - 딸기


5. Mango - 망고


6. Pineapple - 파인애플


7. Watermelon - 수박


8. Grape - 포도


9. Lemon - 레몬


10. Peach - 복숭아

11. Pear - 배


12. Cherry - 체리


13. Raspberry - 라즈베리


14. Blueberry - 블루베리


15. Kiwi - 키위


16. Avocado - 아보카도


17. Plum - 자두


18. Coconut - 코코넛


19. Papaya - 파파야


20. Apricot - 살구21. Fig - 무화과


22. Grapefruit - 자몽


23. Lime - 라임


24. Pomegranate - 석류


25. Cantaloupe - 칸탈루프


26. Honeydew melon - 허니듀 멜론


27. Blackberry - 블랙베리


28. Cranberry - 크랜베리


29. Lychee - 라이치


30. Nectarine - 넥타린31. Passion fruit - 패션프루트


32. Guava - 구아바


33. Persimmon - 감


34. Date - 대추


35. Jackfruit - 불초과


36. Starfruit - 별과


37. Tangerine - 귤


38. Elderberry - 엘더베리


39. Kiwifruit - 키위


40. Mulberry - 뽕
41. Pitaya (Dragon fruit) - 피타야 (드래곤프루트)


42. Raspberry - 라즈베리


43. Boysenberry - 보이센베리


44. Olive - 올리브


45. Gooseberry - 구스베리


46. Plantain - 바나나(식용품)


47. Pawpaw - 파파야


48. Clementine - 클레멘타인


49. Quince - 느타리안


50.Persimmon - 감
 */

import java.util.*;
public class 문자열배열_1 {public static void main(String[] args) {
	String[] names={"jae","john","bill","ringo"};
	for(String name:names)
	{
		System.out.println(name);
	}
	System.out.println("====split=====");
	String ms="jae,john,bill,ringo";
	String[] s=ms.split(",");
	//단어별로 나눠서 => 배열로 만드는 기능
	for(String n:s)
	{
		System.out.println(n);
	}
	System.out.println("==문자열검색==");
	
	String[] 과일명= {
			"Apple-사과",
			"Banana-바나나",
			"Orange-오렌지",
			"Strawberry-딸기",
			"Mango-망고",
			"Pineapple-파인애플",
			"Watermelon-수박",
			"Grape-포도",
			"Lemon-레몬",
			"Peach-복숭아",
			"Pear-배",
			"Cherry-체리",
			"Raspberry-라즈베리",
			"Blueberry-블루베리",
			"Kiwi-키위",
			"Avocado-아보카도",
			"Plum-자두",
			"Coconut-코코넛",
			"Papaya-파파야",
			"Apricot-살구",
			"Fig-무화과",
			"Grapefruit-자몽",
			"Lime-라임",
			"Pomegranate-석류",
			"Cantaloupe-칸탈루프",
			"Honeydew melon-허니듀 멜론",
			"Blackberry-블랙베리",
			"Cranberry-크랜베리",
			"Lychee-라이치",
			"Nectarine-넥타린",
			"Passion fruit-패션프루트",
			"Guava-구아바",
			"Persimmon-감",
			"Date-대추",
			"Jackfruit-불초과",
			"Starfruit-별과",
			"Tangerine-귤",
			"Elderberry-엘더베리",
			"Kiwifruit-키위",
			"Mulberry-뽕",
			"Pitaya-피타야",
			"Raspberry-라즈베리",
			"Boysenberry-보이센베리",
			"Olive-올리브",
			"Gooseberry-구스베리",
			"Plantain-바나나",
			"Pawpaw-파파야",
			"Clementine-클레멘타인",
			"Quince-느타리안",
			"Persimmon-감"
			};
	System.out.println("==과일명 중에 가장 긴 명칭==");
	int max=0;
	for(String f:과일명) //f= 과일명 하나 설정한 
	{
		String ss=f.substring(0,f.indexOf("-"));
		int i=ss.length();
		if(max<i)
			max=i;
	}
	for(String f:과일명)
	{
		String ss=f.substring(0,f.indexOf("-"));
		int i=ss.length();
		if(i==max)
		{
			System.out.println(ss);
		}
	}
	System.out.println("==과일명 중에 가장 짧은 명칭==");
	

System.out.println("==검색==");
Scanner scan=new Scanner(System.in);
System.out.println("검색어 입력:");
String fd=scan.next();

for(String f:과일명)
{
	String ff=f.toLowerCase();
	String fds=fd.toLowerCase();
	if(ff.contains(fds)) // 대소문자 구분
	{
		System.out.println(f.substring(0,f.indexOf("-")));
	}
}
System.out.println("===검색 autocomplete====");
System.out.println("검색어 입력:");
fd=scan.next();

for(String f:과일명)
{
	String ff=f.toLowerCase();
	String fds=fd.toLowerCase();
	if(ff.startsWith(fds))
	{
		System.out.println(f.substring(0,f.indexOf("-")));
		try
		{
			Thread.sleep(1000);
		}catch(Exception ex) {
			
		}
	}
}
System.out.println("==endswith==");
System.out.println("검색어 입력:");
fd=scan.next();
for(String f:과일명)
{
	if(f.endsWith(fd))
	{
		String ss=f.substring(0,f.indexOf("-"));
		System.out.println(ss);
		break;
	}
}





}

}
