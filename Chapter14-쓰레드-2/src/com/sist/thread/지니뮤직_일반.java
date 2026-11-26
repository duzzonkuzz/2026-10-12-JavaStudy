package com.sist.thread;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class 지니뮤직_일반 {
    private static List<Music> list=
    		    new ArrayList<Music>();
    public void dataCollection()
    {
       int k=1;
       for(int i=1;i<=4;i++)
       {
	    	try
	        {
	            Document doc = Jsoup.connect(
	                "https://www.genie.co.kr/chart/top200?ditc=D&ymd=20261117&hh=14&rtm=Y&pg="
	                + i
	            ).get();
	
	            Elements title =
	                doc.select("table.list-wrap a.title");
	            Elements singer =
	                doc.select("table.list-wrap a.artist");
	            Elements poster =
	                doc.select("table.list-wrap a.cover img");
	            Elements album =
	                doc.select("table.list-wrap a.albumtitle");
	
	            for(int j = 0; j < title.size(); j++)
	            {
	                Music music = new Music();
	
	                music.setTitle(title.get(j).text());
	                music.setSinger(singer.get(j).text());
	                music.setPoster(poster.get(j).attr("src"));
	
	                // 페이지별 순위 계산
	                music.setMno(k);
	
	                music.setAlbum(album.get(j).text());
	
	                list.add(music);
	                k++;
	            }
	
	            System.out.println(
	                (i+1) + "페이지 수집 완료 : " + list.size()
	            );
	        }
	        catch(Exception ex)
	        {
	            System.out.println((i+1) + "페이지 오류");
	            ex.printStackTrace();
	        }
       }
       
       for(Music m:list)
       {
    	   System.out.println(m.getMno()+" "
    			   +m.getTitle()+" "
    			   +m.getSinger());
       }

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		지니뮤직_일반 m=new 지니뮤직_일반();
        long start=System.currentTimeMillis();
        m.dataCollection();
        long end=System.currentTimeMillis();
        System.out.println("총 걸린시간:"+(end-start)+"MS");
	}

}