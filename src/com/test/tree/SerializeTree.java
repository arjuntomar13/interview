package com.test.tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SerializeTree {

	private static final String MARKER = "# ";
	
	private Node root;

	void serialize(Node node, PrintWriter printWriter){

		if(node == null){
			printWriter.print(MARKER);
			return;
		}else{
			printWriter.print(node.data + " ");
		}
		serialize(node.left, printWriter);
		serialize(node.right, printWriter);
	}
	
	Node deSerialize(String [] tempArr, int index){
		if((index) == tempArr.length){
			return null;
		}
		if(tempArr[index].equals("#")){
			return null;
		}
		
		Node node = new Node(Integer.parseInt(tempArr[index]));
		index++;
		node.left = deSerialize(tempArr, index);
		node.right = deSerialize(tempArr, index);
		return node;
	}
	
	void printTree(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data + " ");
		printTree(node.left);
		printTree(node.right);
	}

	public static void main(String[] args) throws IOException {
		PopulateBST populateBST = new PopulateBST();
		populateBST.insert(20);
		populateBST.insert(12);
		populateBST.insert(32);
		populateBST.insert(78);
		populateBST.insert(18);
		populateBST.insert(43);
		populateBST.insert(11);
		populateBST.insert(1);
		populateBST.insert(98);
		Node root = populateBST.insert(345);

		String treeFile = "D:\\study\\TreeFile.txt";
		SerializeTree serializeTree = new SerializeTree();
		PrintWriter printWriter = new PrintWriter(treeFile);
		serializeTree.serialize(root, printWriter);
		printWriter.close();
		
		FileReader fileReader = new FileReader(treeFile);
		BufferedReader br = new BufferedReader(fileReader);
		
		String line = br.readLine();
		
		System.out.println(line);
		
		String [] tempArr = line.split(" ");
		
		Node root1 = serializeTree.deSerialize(tempArr, 0);
		
		System.out.println("#####################################");
		serializeTree.printTree(root1);
	}
}
