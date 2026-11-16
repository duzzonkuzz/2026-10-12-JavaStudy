package com.sist.list;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class ArrayList_3 {
    public ArrayList<String> genieData()
    {
    	ArrayList<String> list=new ArrayList<String>();
    	try
    	{
    		 Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			 Elements title=doc.select("table.list-wrap a.title");
			 for(int i=0;i<title.size();i++)
			 {
				 list.add(title.get(i).text());
			 }
    	}catch(Exception ex){}
    	return list;
    }
    public ArrayList<String> melonData()
    {
    	ArrayList<String> list=new ArrayList<String>();
    	try
    	{
    		Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements title=doc.select("tr#lst50 div.rank01 a");
			for(int i=0;i<title.size();i++)
			 {
				 list.add(title.get(i).text());
			 }
    	}catch(Exception ex) {}
    	return list;
    }
    // Collections 
    /*
     *   sort() 
     *   => removeAll() : 없는 데이터 
     *   => retainAll() : 교집합 
     *   => containsAll() : UNION
     *   => addAll() : UNION ALL
     *   ----------------------------
     *   
     *   제네릭 
     *     = 정의 
     *       클래스나 메소드를 정의할때 사용할 데이터형을 표준화해서 사용 
     *                                -------- 미리 정하지 않고 사용시 변경
     *       1) 재사용성 / 데이터형의 안정성 
     *       2) 데이터형을 통일화 시킨다 
     *       3) 형변환을 하지 않는다 => 오류(X) / 간결한 소스 
     *       4) 어떤 데이터를 사용하는지 확인 : 가독성이 좋다 
     *       5) 사용시 
     *          클래스<클래스형> : 기본형은 사용이 불가능 
     *               ------- 기본형 => 반드시 Wrapper이용한다 
     *       6) 사용시 전체 클래스의 데이터형이 변경
     *          ---------------------------- 사용자 정의 클래스로도 변경
     *       ** 와일드카드 <?> : 클래스형이 명확하지 않는 경우 
     *          ------------- Object
     *          <? extends Number> => 제한 (숫자만 가능)
     *          --- Long / Integer / Double / Float / Byte
     *       --------------------- 거의 사용빈도는 없다 : 라이브러리
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("====== 지니뮤직 출력 ======");
        ArrayList_3 a=new ArrayList_3();
        ArrayList<String> genie=a.genieData();
        for(int i=0;i<genie.size();i++)
        {
        	System.out.println((i+1)+"."+genie.get(i));
        }
        System.out.println("======= 멜론 뮤직 ========");
        ArrayList<String> melon=a.melonData();
        for(int i=0;i<melon.size();i++)
        {
        	System.out.println((i+1)+"."+melon.get(i));
        }
        // 지니뮤직에만 있는 노래
        System.out.println("===== 지니뮤직에만 있는 노래 =====");
        genie.removeAll(melon); // minus
        // 1 2 3 4 5 - 4 5 6 7 8  => 1 2 3
        for(int i=0;i<genie.size();i++)
        {
        	System.out.println((i+1)+"."+genie.get(i));
        }
        // 복구
        genie=a.genieData();
        melon.removeAll(genie);
        System.out.println("===== 메론에만 있는 노래 =====");
        for(int i=0;i<melon.size();i++)
        {
        	System.out.println((i+1)+"."+melon.get(i));
        }
        //-----------------------------------------------
        // 복구
        melon=a.melonData();
        // 공통으로 가지고 있는 곡
        System.out.println("====== 공통으로 가지고 있는 곡 (교집합)====");
        genie.retainAll(melon);
        for(int i=0;i<genie.size();i++)
        {
        	System.out.println((i+1)+"."+genie.get(i));
        }
        
        genie=a.genieData();
        // 지니뮤직+ 멜론 
        System.out.println("===========멜론+지니뮤직=======");
        genie.addAll(melon);
        //  1 2 3 4 5   4 5 6 7 8  => 1 2 3 4 5 4 5 6 7 8
        for(int i=0;i<genie.size();i++)
        {
        	System.out.println((i+1)+"."+genie.get(i));
        }
        System.out.println("===========멜론+지니뮤직=======");
        genie=a.genieData();
        genie.containsAll(melon);
         //  1 2 3 4 5   4 5 6 7 8  => 1 2 3  4 5 6 7 8
        for(int i=0;i<genie.size();i++)
        {
        	System.out.println((i+1)+"."+genie.get(i));
        }
        // 게시물 + 댓글  ==> 맛집 + 댓글 
        /*
         *   => 오라클 : 크롤링 (데이터저장) => List로 받아서 처리 
         *      => 크롤링 
         */
	}

}