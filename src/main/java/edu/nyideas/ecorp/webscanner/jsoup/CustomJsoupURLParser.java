package edu.nyideas.ecorp.webscanner.jsoup;

import java.io.IOException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CustomJsoupURLParser {
	
	static Logger logger=LogManager.getLogger(CustomJsoupURLParser.class.getSimpleName());
	
	public static String[] jsoupParser(String url, String userAgent, int timeout) {
		
		Document doc = null;
		try {
			doc = SSLHelper.getConnection(url).userAgent(userAgent).timeout(timeout).get();
		} catch (IOException e) {
			logger.error("Exception while fetching data from the URL");
		}
		String htmlStr = new HtmlToPlainText().getPlainText(doc);
		String plainText = Jsoup.parse(htmlStr).text().replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase().trim();
		String[] stringArr=plainText.split("[\\W]+");
		logger.info("Data from web scan of URL :: "+url);
		logger.info(Arrays.asList(stringArr));
		return stringArr;
	}

}
