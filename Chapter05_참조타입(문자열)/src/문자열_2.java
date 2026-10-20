 // https://www.genie.co.kr/chart/top200?ditc=D&ymd=20261020&hh=14&rtm=Y&pg=1
 
import javax.swing.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
// java.lang은 생략이 가능 => 컴파일시에 자동 첨부
public class 문자열_2 {
	public static void main(String[] args) throws Exception {
		
		// 웹 연결
		String fd=JOptionPane.showInputDialog("검색어 입력:");
		for(int i=1;i<=4;i++)
		{
		Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20261020&hh=14&rtm=Y&pg="+i).get();
		// 제목
		Elements title=doc.select("table.list-wrap td.info a.title");
				// 가수명
		Elements singer=doc.select("table.list-wrap a.artist");
		
		for(int j=0;j<title.size();j++)
		{
			if(title.get(j).text().endsWith(fd))
			{
			System.out.println(
					title.get(j).text()+"("+singer.get(j).text()+")");
		}
		}
		}
	}

}
