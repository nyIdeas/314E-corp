package edu.nyideas.ecorp.webscanner.trie.heap;

import org.omg.CORBA.FREE_MEM;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(exclude = "freq")

public class Heap<T> {
private T t;
private int freq;
public Heap(T t, int freq) {
	super();
	this.t = t;
	this.freq = freq;
}

}
