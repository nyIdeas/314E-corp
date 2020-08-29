package edu.nyideas.ecorp.webscanner.impl;

import edu.nyideas.ecorp.webscanner.interfaces.Trie;
import edu.nyideas.ecorp.webscanner.trie.TrieNode;
import edu.nyideas.ecorp.webscanner.trie.heap.Heap;
import edu.nyideas.ecorp.webscanner.trie.heap.PriorityTrieQueue;

public class WordTrie implements Trie {
	
	private TrieNode root;
	private TrieNode prevNode,currNode;
	private String prevWord=null;
	private static PriorityTrieQueue minHeapWords;
	private static PriorityTrieQueue minHeapWordPairs;

	
	public WordTrie(int MAX_HEAP_SIZE) {
		// TODO Auto-generated constructor stub
		root=new TrieNode('/');
		prevNode=root;
		minHeapWords=new PriorityTrieQueue(MAX_HEAP_SIZE);
		minHeapWordPairs=new PriorityTrieQueue(MAX_HEAP_SIZE);
	}

	@Override
	public void insert(String word) {
		// each charcter from the word is inserted as each Node of the Trie.
		currNode=prevNode;
		TrieNode temp=null;
		for(char ch:word.toCharArray()) {
			temp=new TrieNode(ch);
			if(!currNode.getChildren().contains(temp)) {
				currNode.getChildren().add(temp);
			}
			currNode=currNode.getChildNodeOf(temp);
		}
		//when a word ends increment the node frequency by 1 and add it to the minHeapWords.
		currNode.setWordEnds(currNode.getWordEnds()+1);
		getMinHeapWords().add(new Heap<String>(word,currNode.getWordEnds()));
		if(prevNode!=root && prevWord!=null) {
			//when a word pair ends increment the node frequency by 1 and add it to the minHeapWordPairs.
			currNode.setWordPairEnds(currNode.getWordPairEnds()+1);
			getMinHeapWordPairs().add(new Heap<String>(prevWord+" "+word,currNode.getWordPairEnds()));
			prevNode=root;
			insert(word); // this enables every word is also inserted at the root level always.
		}
		prevNode=currNode;
		prevWord=word;
	}

	@Override
	public String search(String word) {
		// TODO later for prefix search or word search in the Trie structure
		return null;
	}

	@Override
	public boolean remove(String word) {
		// TODO later for removal of  word in the Trie structure
		return false;
	}
	@Override
	public PriorityTrieQueue getMinHeapWordPairs() {
		return minHeapWordPairs;
	}
	@Override
	public PriorityTrieQueue getMinHeapWords() {
		return minHeapWords;
	}
	

}
