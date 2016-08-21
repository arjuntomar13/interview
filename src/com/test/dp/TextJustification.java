package com.test.dp;

public class TextJustification {

	void justify(String[] words, int max){
		
		int[][] cost = new int[words.length][words.length];
		/*for(int i = 0; i < cost.length; i ++){
			cost[i][cost.length-1] = Integer.MAX_VALUE;
		}*/
		int costLen = cost.length;
		for (int i = 0; i < costLen; i++) {
			cost[i][i] = (int)Math.pow(max - words[i].length(),2);
			for(int j = i; j < costLen; j++){
				int len = 0;
				for(int k = i ; k<= j; k++){
					len = len + words[k].length();
				}
				len = len + j-i;
				if(len > max){
					cost[i][j] = Integer.MAX_VALUE;
				}else{
				cost[i][j] = (int)Math.pow((max - len), 2);
				}
			}
		}
		int len = words.length;
		int i=len -1;;
		int[] finalCost = new int[len];
		int[] lineBreak = new int[len];
		while(i >=0){
			finalCost[i] = cost[i][len-1];
			lineBreak[i] = len;
			for(int j = costLen -1 ; j > i ; j--){
				if(cost[i][j-1] == Integer.MAX_VALUE){
					continue;
				}else{
					if(finalCost[i] > finalCost[j] + cost[i][j-1]){
						finalCost[i] = finalCost[j] + cost[i][j-1];
						lineBreak[i] = j-1;
					}
				}
			}
			i--;
		}
		System.out.println("Put line breaks after following words :");
		for (int j = 0; j < lineBreak.length; j++) {
				System.out.print(lineBreak[j] + " ");
		}
		
		System.out.println("\n");
		System.out.println("Total Badness is : " + finalCost[0]);
		
	}
	
	public static void main(String[] args) {
		String words[] = {"Jack","likes","to","write","code","at", "free", "time"};
        TextJustification tj = new TextJustification();
        tj.justify(words, 12);
	}
}
