package com.sist.abs1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class MelonMusic extends MusicSystem {

	@Override
	public void datacollection() {
		// TODO Auto-generated method stub
		Music[] musics=getMusics();
		
		 try
		  {
			 Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			 Elements title=doc.select("tr#lst50 div.rank01 a");
			 Elements singer=doc.select("tr#lst50 div.rank02  span.checkEllipsis");
			 Elements album=doc.select("tr#lst50 div.rank03 a");
			 
			 //Elements rank=doc.select("table.list-wrap td.number");
			 Elements etc=doc.select("tr#lst50 div.wrap span.rank_wrap");
			 
			 for(int i=0;i<title.size();i++)
			 {
				 System.out.println(title.get(i).text());
				 System.out.println(singer.get(i).text());
				
				 System.out.println(album.get(i).text());
				 System.out.println(i+1);
				 String temp=etc.get(i).text();
				 System.out.println(temp.replaceAll("[^0-9]", ""));
				 System.out.println(temp.replaceAll("[^가-힣]", ""));
				 System.out.println("==============================================");
				 musics[i]=new Music();
				 musics[i].setTitle(title.get(i).text());
				 musics[i].setSinger(singer.get(i).text());
				
				 musics[i].setAlbum(album.get(i).text());
				 musics[i].setMno(i+1);
				 String state="";
				 int id=0;
				 if(temp.equals("순위 동일"))
				 {
					 id=0;
					 state="순위 동일";
				 }
				 else
				 {
					 id=Integer.parseInt(temp.replaceAll("[^0-9]", ""));
					 state=temp.replaceAll("[^가-힣]", "");
				 }
				 musics[i].setState(state);
				 musics[i].setIdcrement(id);
			 }
		  }catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
	}

}
