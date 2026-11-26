package com.sist.music;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MelonMusic extends MusicSystem{

	@Override
	public void dataCollection() {
		// TODO Auto-generated method stub
		ArrayList<Music> list=getMList();
		try
		  {
			 Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			 Elements title=doc.select("tr#lst50 div.rank01 a");
			 Elements singer=doc.select("tr#lst50 div.rank02  span.checkEllipsis");
			 Elements poster=doc.select("tr#lst50 div.wrap img");
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