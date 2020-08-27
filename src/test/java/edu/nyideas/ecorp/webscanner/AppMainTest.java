package edu.nyideas.ecorp.webscanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.nyideas.ecorp.webscanner.impl.WordTrie;
import edu.nyideas.ecorp.webscanner.interfaces.Trie;
import edu.nyideas.ecorp.webscanner.jsoup.CustomJsoupURLParser;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppMainTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppMainTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppMainTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Logger logger=LogManager.getLogger(AppMainTest.class.getSimpleName());
    	
    	final String userAgent = "Mozilla/5.0 (jsoup)";
    	final int timeout = 5 * 1000;
    	final String url = "https://www.healthcatalyst.com/insights/";
    	String wordArray[]=CustomJsoupURLParser.jsoupParser(url, userAgent, timeout);
    	
    	Trie trie=new WordTrie(10);
    	for(String word: wordArray) {
    		trie.insertAndReturnFreq(word);
    	}
    	
    	trie.getMinHeapWords().stream().forEach(e->{System.out.println("Word -> "+e.getT()+" | Count -> "+e.getFreq());});
    	trie.getMinHeapWords().stream().forEach(e->{logger.info("Word -> "+e.getT()+" | Count -> "+e.getFreq());});

    	System.out.println("---------------");
    	trie.getMinHeapWordPairs().stream().forEach(e->{System.out.println("Word Pair -> "+e.getT()+" | Count -> "+e.getFreq());});
    	trie.getMinHeapWordPairs().stream().forEach(e->{logger.info("Word Pair -> "+e.getT()+" | Count -> "+e.getFreq());});

        assertTrue( true );
    }
}
