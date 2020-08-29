package edu.nyideas.ecorp.webscanner.trie.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PriorityTrieQueue extends PriorityQueue<Heap> {


	private final int MAX_SIZE;

	//a custom priorityqueue to implement a Min Heap with MAX SIZE.
	public PriorityTrieQueue(int MAX_SIZE) {
		super(Comparator.comparing(Heap::getFreq));
		this.MAX_SIZE = MAX_SIZE;
	}

	@Override
	public boolean add(Heap e) {
		// if the heap contains the word or word pair already remove and add new Heap object
		if (this.contains(e)) {
			this.remove(e);
		}
		//check whether heap reached the Max capacity of K : 
		if (size() < MAX_SIZE) {
			return super.add(e);
		} 
		// this ensures new word/word pair to be added as higher frequency that the existing in the Min Heap
		else if (this.peek().getFreq() < e.getFreq()) {
			this.remove();
			return super.add(e);

		}
		return false;
	}

}
