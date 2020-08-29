package edu.nyideas.ecorp.webscanner;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.nyideas.ecorp.webscanner.impl.WordTrie;
import edu.nyideas.ecorp.webscanner.interfaces.Trie;
import edu.nyideas.ecorp.webscanner.jsoup.CustomJsoupURLParser;

/**
 * Hello world!
 *
 */
public class AppMain 
{
    private static Logger logger = LogManager.getLogger(AppMain.class.getSimpleName());

    //driver code to run 
    public static void main( String[] args )
    {
    	final int MAX_HEAP_SIZE=10;
    	final String userAgent = "Mozilla/5.0 (jsoup)";
    	final int timeout = 5 * 1000;
    	String url = "https://www.healthcatalyst.com/insights/";
    	if(!System.getProperty("scanURL").isEmpty()) {
    		url=System.getProperty("scanURL");
    	}
    	findTopKFrequentWordAndWordPairs(MAX_HEAP_SIZE, userAgent, timeout, url);
    }

	private static void findTopKFrequentWordAndWordPairs(final int MAX_HEAP_SIZE, final String userAgent, final int timeout,
			final String url) {
    	//Custom Jsoup Parser to scan web page
		String wordArray[]=CustomJsoupURLParser.jsoupParser(url, userAgent, timeout);
		
    	//Initialize the Trie with a MAX_HEAPSIZE of K to find out top K frequent word and wordpairs
    	Trie trie=new WordTrie(MAX_HEAP_SIZE);
    	for(String word: wordArray) {
    		trie.insert(word.toLowerCase());
    	}
    	System.out.println("\n_*_*_*_*_*_*_*_**_**_*_**_\n");
    	trie.getMinHeapWords().stream().forEach(e->{System.out.println(e);});
    	System.out.println("\n_*_*_*_*_*_*_*_**_**_*_**_\n");
    	trie.getMinHeapWordPairs().stream().forEach(e->{System.out.println(e);});
	}
    
    
}
