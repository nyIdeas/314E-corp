package edu.nyideas.ecorp.webscanner.trie.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PriorityTrieQueue extends PriorityQueue<Heap> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7941054932801111532L;
	private final int MAX_SIZE;

	public PriorityTrieQueue(int MAX_SIZE) {
		// TODO Auto-generated constructor stub
		super(Comparator.comparing(Heap::getFreq));
		this.MAX_SIZE = MAX_SIZE;
	}

	@Override
	public boolean add(Heap e) {
		// TODO Auto-generated method stub
		if (this.contains(e)) {
			this.remove(e);
		}
		// System.out.println("Size " + size());
		if (size() < MAX_SIZE) {
			return super.add(e);
		} else if (this.peek().getFreq() < e.getFreq()) {
			//System.out.println("Freq of this.peek :" + this.peek() + " < Freq of new insert e " + e);
			this.remove();
			return super.add(e);

		}
		return false;
	}

}
