package bitmap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FileSort {

	void sort(String filePath, int n, String sortedFilePath) throws IOException {

		System.out.println("Sorting started..!!!!" + System.currentTimeMillis());
		BitSet bitSet = new BitSet();
		for (int i = 0; i < n; i++) {
			bitSet.set(i, false);
		}

		FileReader file = new FileReader(filePath);
		BufferedReader br = new BufferedReader(file);

		for(int i =0; i < n; i++){
			String line = br.readLine();
			bitSet.set(Integer.parseInt(line), true);
		}
		br.close();

		PrintWriter printWriter = new PrintWriter(sortedFilePath);
		for(int i =0; i< n; i++){
			if(bitSet.get(i)){
				printWriter.println(i);
			}
		}
		System.out.println("Sorting finished..!!!!" + System.currentTimeMillis());
		printWriter.close();
	}

	void sort1(String filePath, int n, String sortedFilePath) throws IOException {

		System.out.println("Sorting started..!!!!" + System.currentTimeMillis());
		BitArray bitArray = new BitArray(n);
		for (int i = 0; i < n; i++) {
			bitArray.setBit(i, false);
		}

		FileReader file = new FileReader(filePath);
		BufferedReader br = new BufferedReader(file);

		for(int i =0; i < n; i++){
			String line = br.readLine();
			bitArray.setBit(Integer.parseInt(line), true);
		}
		br.close();

		PrintWriter printWriter = new PrintWriter(sortedFilePath);
		for(int i =0; i< n; i++){
			if(bitArray.getBit(i)){
				printWriter.println(i);
			}
		}
		System.out.println("Sorting finished..!!!!" + System.currentTimeMillis());
		printWriter.close();
	}

	void createFIle(String filePath, int n) throws FileNotFoundException {

		PrintWriter printWriter = new PrintWriter(filePath);
		
		Random random = new Random();

        Set set = new HashSet<Integer>(n);

        System.out.println("Creating File..!!!!" + System.currentTimeMillis());
        /*while(set.size()< n) {
        	int randNum = random.nextInt(n);
            while (set.add(randNum) == true){
            	printWriter.println(randNum);
            }
        }*/
        for (int i = n ; i > 0; i--) {
        	printWriter.println(i);
		}
        System.out.println("File created..!!!!" + System.currentTimeMillis());
		printWriter.close();
	}

	public static void main(String[] args) throws IOException {
		FileSort fileSort = new FileSort();

		//fileSort.createFIle("D:\\study\\FileToSort.txt", 10000000);
		fileSort.sort("D:\\study\\FileToSort.txt", 10000000, "D:\\study\\SortedFile.txt");

		//		System.out.println(0 | (1 << 6));
	}

}
