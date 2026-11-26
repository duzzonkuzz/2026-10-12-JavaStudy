package com.sist.music;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class GenieMusic extends MusicSystem{
	@Override
	public void dataCollection() {
		// TODO Auto-generated method stub
		ArrayList<Music> list=getMList();
		try
		  {
			 Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			 Elements title=doc.select("table.list-wrap a.title");
			 Elements singer=doc.select("table.list-wrap a.artist");
			 Elements poster=doc.select("table.list-wrap a.cover img");
			 for(int i=0;i<title.size();i++)
			 {
				 Music musics=new Music(); 
				 musics.setTitle(title.get(i).text());
				 musics.setSinger(singer.get(i).text());
				 musics.setPoster(poster.get(i).attr("src"));
				 musics.setMno(i+1);
				 list.add(musics);
				 
			 }
		  }catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
	}
}