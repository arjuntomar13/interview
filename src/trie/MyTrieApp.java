package trie;

public class MyTrieApp {

	public static void main(String[] args) {
		MyTrie myTrie = new MyTrie();
		TrieNode root = myTrie.insert("arjun", new TrieNode());
		System.out.println(myTrie.search("arjun", root));
		myTrie.insert("arkun", root);
		System.out.println(myTrie.search("arkun", root));
		myTrie.insert("ar", root);
		System.out.println(myTrie.search("ar", root));
		
		myTrie.insert("bhokal", root);
		System.out.println(myTrie.search("bhokal", root));
	}
}