package edu.nyideas.ecorp.webscanner.interfaces;

import edu.nyideas.ecorp.webscanner.trie.heap.PriorityTrieQueue;

public interface Trie {

	public void insert(String word);
	
	public String search(String word);
	
	public boolean remove(String word);
	
	public PriorityTrieQueue getMinHeapWords();
	
	public PriorityTrieQueue getMinHeapWordPairs();
	

}
