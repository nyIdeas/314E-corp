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
	public void insertAndReturnFreq(String word) {
		// TODO Auto-generated method stub
		currNode=prevNode;
		TrieNode temp=null;
		for(char ch:word.toCharArray()) {
			temp=new TrieNode(ch);
			if(!currNode.getChildren().contains(temp)) {
				currNode.getChildren().add(temp);
			}
			currNode=currNode.getChildNodeOf(temp);
		}
		currNode.setWordEnds(currNode.getWordEnds()+1);
		getMinHeapWords().add(new Heap<String>(word,currNode.getWordEnds()));
		if(prevNode!=root && prevWord!=null) {
			currNode.setWordPairEnds(currNode.getWordPairEnds()+1);
			//System.out.println("Adding word pair :: "+prevWord+" "+word+". With freq :: "+currNode.getWordPairEnds());
			getMinHeapWordPairs().add(new Heap<String>(prevWord+" "+word,currNode.getWordPairEnds()));
			prevNode=root;
			insertAndReturnFreq(word);
		}
		prevNode=currNode;
		prevWord=word;
	}

	@Override
	public String search(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
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
