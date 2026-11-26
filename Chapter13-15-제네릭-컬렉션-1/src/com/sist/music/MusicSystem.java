package com.sist.music;
import java.net.URI;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import lombok.Getter;
/*
 *    ArrayList<Music> => 13장 제네릭 
 *    1. 정의 
 *        =  클래스나 메소드를 정의할때 사용하는 데이터형을 통일화해서 사용하는 기술
 *        =  데이터형의 안정성 
 *        =  가독성이 좋다  
 *           //let a:int=10 , a="" a=10.5 a=true
 *        =  재사용
 *        =  데이터형을 통일 
 *        =  소스가 간결해진다 => 형변환이 없다 
 *    2. 사용법 
 *       클래스<반드시 클래스만 설정>
 *       <int>(X) =======> <Integer>
 *       <double>(X)=====> <Double>
 *       
 *    3.
 *        T(type)
 *        E(element)
 *        ----- Class 
 *        K(key)
 *        V(value)
 *        ----------------- Box<K,V>
 *        class Box<T>
 *        {
 *           T t;
 *           public void setT(T t)
 *           {
 *              this.t=t;
 *           }
 *           public T getT()
 *           {
 *              return t;
 *           }
 *        }
 *        
 *        Box box=new Box(); ==> T:Object
 *        Box<String> box=new Box<String>() ==> T:String
 *        Box<Integer> box=new Box<Integer>(); ==> T:Integer
 *        
 *        B b=new B() => d,f , a,b,c 
 *        C c=new C() => m,n a,b,c
 *        A a=new B() => a,b,c
 *        A a=new C() => a,b,c
 *        class A
 *        {
 *            a,b,c
 *        }
 *        class B extends A
 *        {
 *            d,f , a,b,c      
 *        }
 *        class C extends A
 *        {
 *            m,n a,b,c
 *        }
 */

public abstract class MusicSystem {
   @Getter
   private static ArrayList<Music> mList=
		              new ArrayList<Music>();
   public abstract void dataCollection();
   // 공통 => 오버라이딩이 없다 
   // 1. 목록 출력 => Music[]
   public ArrayList<Music> musicList(int page){
	   
	   final int ROWSIZE=10;
	   int start=(page*ROWSIZE)-ROWSIZE;
	   int end=page*ROWSIZE;
	   /*
	    *     1page  
	    *         subList(0,10)
	    *     2page
	    *         subList(10,20)
	    */
	   ArrayList<Music> list=
			     new ArrayList<Music>(mList.subList(start, end));
	   return list;
   }
   // 2. 전체목록 
   public ArrayList<Music> musicAllData(){
	   return mList;
   }
   // 3. 상세보기 
   public Music musicDetailData(int mno)
   {
	   return mList.get(mno-1);
   }
   // 4. 검색 
   public ArrayList<Music> musicFindData(String type,String fd)
   {
	   ArrayList<Music> list=
			      new ArrayList<Music>();
	   for(Music m:mList)
	   {
		   if(type.equals("title"))
		   {
			   if(m.getTitle().contains(fd))
			   {
				   list.add(m);
			   }
		   }
		   else
		   {
			   if(m.getSinger().contains(fd))
			   {
				   list.add(m);
			   }
		   }
	   }
	   return list;
   }
   public static void main(String[] args) {
//	  try
//	  {
//		  String s=URLEncoder.encode("리센느","UTF-8");
//		  System.out.println(s);
//	  }catch(Exception ex) {}
	  youtubeFindKey("리센느");
   }
   public static String youtubeFindKey(String title)
   {
	   String key="";
	   try
	   {
		   String url="https://www.youtube.com/results?search_query="
				     +URLEncoder.encode(title,"UTF-8");
		   Document doc=
				   Jsoup.connect(url).get();
		   //System.out.println(doc.toString());
		   Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");
		   Matcher m=p.matcher(doc.toString());
		   while(m.find())
		   {
			   String s=m.group();
			   key=s.substring(s.indexOf("=")+1,
					   s.indexOf("\""));
			   key=key.substring(0,key.indexOf("\\"));
			   System.out.println(key);
			   break;
		   }
		   
	   }catch(Exception ex) {}
	   return key;
   }
}