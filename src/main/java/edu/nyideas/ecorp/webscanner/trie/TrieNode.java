package edu.nyideas.ecorp.webscanner.trie;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(exclude = {"wordEnds","wordPairEnds","children"})
public class TrieNode {
	char letter;
	List<TrieNode> children;
	int wordEnds;
	int wordPairEnds;


	public TrieNode(char alphanum) {
		letter=alphanum;
		wordEnds = 0;
		wordPairEnds=0;
		children=new ArrayList<TrieNode>();
	}
	
	public TrieNode getChildNodeOf(TrieNode node) {
		return this.getChildren().stream().filter(e->e.equals(node)).findFirst().get();
	}
}