package in.cdac.pract;

import java.io.File;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class parsingAndExtracting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String getTranslatedHtmlInput(String htmlFileContent)
	{
		
		
		Document doc = Jsoup.parse(htmlFileContent, "utf-8");
		// Document doc = Jsoup.parse(new File(htmlhtmlFileName),"utf-8");
//	//Document doc = Jsoup.parse(new File(htmlhtmlFileName),"utf-8");
		int count = 0;
		int outerCount = 0;
		Elements elements = doc.select("*");
	}

}
