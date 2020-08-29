package edu.nyideas.ecorp.webscanner.trie.heap;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(exclude = "freq")

public class Heap<T> {
	//to hold the String- a word or a word pair
	private T t;
	private int freq;

	public Heap(T t, int freq) {
		super();
		this.t = t;
		this.freq = freq;
	}

}
