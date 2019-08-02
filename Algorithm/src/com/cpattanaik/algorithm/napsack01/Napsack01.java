package com.cpattanaik.algorithm.napsack01;

public class Napsack01 {

	public static void main(String[] args) {
		Napsack01 client =  new Napsack01();
		
//	    int v[] = {60, 100, 120};
//	    int w[] = {10,  20,  30};
//	    int W   = 50;

		int v[] = {10, 20, 30};
		int w[] = {1, 1, 1};
	    int W = 2;

	    
	    int length = v.length;
	    
		//System.out.println(client.knapsack(v, w, length, W));
		
		System.out.println(client.knapsack_dp(v, w, length, W));
	}

	private int knapsack(int[] v, int[] w, int length, int W) {
		
		if(length == 0 || W == 0)
			return 0;

		System.out.println(v[length-1] + ":" + w[length -1] + ":" + length + ":" + W);
		
		if(w[length-1] > W){
			return knapsack(v, w, length-1, W);
		}else{
			return Math.max(v[length-1] + knapsack(v, w, length-1/*use only 'length' for unbounded knapsack*/, W-w[length-1]) ,    
					knapsack(v, w, length-1, W));
					
		}	
	}
	
	private int knapsack_dp(int[] v, int[] w, int length, int W) {
		int[][] table = new int[length+1][W+1];
		
		for(int i = 0; i<=W; i++){
			table[0][i] = 0;
		}
		
		for(int i = 0; i<=length; i++){
			table[i][0] = 0;
		}
		
		for(int i = 1 ; i <= length; i++){
			for(int j = 1; j <= W; j++){
				if(w[i-1] > j){  //for case w[n] > W
					table[i][j] = table[i-1][j];
				}
				else{
					table[i][j] = Math.max(table[i-1][j], v[i-1] + table[i-1][j - w[i-1]]);
				}	
			}
		}
		
		print(table, length, W);
		return table[length][W];
	}

	private void print(int[][] table, int length, int w) {
		for(int i = 1 ; i <= length; i++){
			for(int j = 1; j <= w; j++){
				System.out.print(table[i][j] + "    ");
			}
			System.out.println();
		}
	}

}
