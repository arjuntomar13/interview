package trie;

public class MyTrie {

	public TrieNode insert(String word, TrieNode current) {

		TrieNode root = current;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			if(current.charMap.containsKey(word.charAt(i))){
				current = current.charMap.get(word.charAt(i));
				if(i == (len-1)){
					current.endOfWord = true;
				}
			}else{
				TrieNode node = new TrieNode();
				current.charMap.put(word.charAt(i), node);
				current = node;
				if(i == (len-1)){
					node.endOfWord = true;
				}
			}
		}

		return root;
	}

	public boolean search(String word, TrieNode current) {

		boolean isFound = false;
		int len = word.length();
		for(int i = 0; i < len; i++){
			if(current.charMap.containsKey(word.charAt(i))){
				current = current.charMap.get(word.charAt(i));
				if(i == (len -1) && current.endOfWord){
					isFound = true;
				}
			}else{
				isFound = false;
			}
		}
		return isFound;
	}

	public boolean delete(String word) {

		return false;
	}

}