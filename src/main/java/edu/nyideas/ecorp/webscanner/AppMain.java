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

    public static void main( String[] args )
    {
    	final int MAX_HEAP_SIZE=10;
    	final String userAgent = "Mozilla/5.0 (jsoup)";
    	final int timeout = 5 * 1000;
    	final String url = "https://www.healthcatalyst.com/insights/";
    	String wordArray[]=CustomJsoupURLParser.jsoupParser(url, userAgent, timeout);
    	
    	//String wordArray[]="Insights Key healthcare thought leadership healthcare thought Submit healthcare thought a Demo  COVID19  COVID19 Products and Services  COVID19 Capacity Planning Tool  Our Offerings Data Platform Data Operating System DOS DOS Marts Rapid Response Analytics AI  Machine Learning Cloud Services Interoperability Analytics Applications Foundational Software Applications Registries  Measures Benchmarking Dashboards  Reporting Tailored Analytic Accelerators Clinical Patient Safety ACO Operational Financial DomainSpecific Software Applications Quality  Regulatory Measures ActivityBased Costing Care Management Suite Patient Safety Monitor Suite Population Health Management Services Expertise Care Management Services ClosedLoop Analytics Executive Advisory Group Financial Advisory Services Readiness Assessment Opportunity Analysis Our Partner Program Outcomes Improvement Population Health Management Services User Experience Design  Solutions  Analytics Adoption Model  Data Operating System DOS  Healthcare Analytics  Healthcare Mergers Acquisitions and Partnerships  LateBinding Data Warehouse  Life Sciences ".
    	//		split("[\\W]+");
    	
    	
    	//System.out.println("words count "+wordArray.length);
    	//Arrays.asList(wordArray).stream().forEach(e->System.out.print(" "+e));
    	//System.exit(0);
    	//Trie trie=new WordTrie2(10);
    	Trie trie=new WordTrie(MAX_HEAP_SIZE);
    	for(String word: wordArray) {
    		trie.insertAndReturnFreq(word.toLowerCase());
    	}
    	System.out.println("\n_*_*_*_*_*_*_*_**_**_*_**_\n");
    	trie.getMinHeapWords().stream().forEach(e->{System.out.println(e);});
    	System.out.println("\n_*_*_*_*_*_*_*_**_**_*_**_\n");
    	trie.getMinHeapWordPairs().stream().forEach(e->{System.out.println(e);});
    }
}
