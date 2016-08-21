package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	public Map<Character, TrieNode> charMap;
	public boolean endOfWord;
	
	public TrieNode(){
		charMap = new HashMap<Character, TrieNode>();
		endOfWord = false;
	}
}