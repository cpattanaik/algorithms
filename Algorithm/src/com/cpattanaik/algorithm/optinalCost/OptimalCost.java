package com.cpattanaik.algorithm.optinalCost;

public class OptimalCost {
	
	static int count = 0 ;
	public static void main(String[] args){
		OptimalCost oC = new OptimalCost();
		
		@SuppressWarnings("unused")
		int[] key  = {10, 12, 20}; 	
		int[] cost = {34,  8, 50};
		
		System.out.println("Optimal Cost : " + oC.optimalCost_r(cost, 0, cost.length-1));	
		//System.out.println("Count : "+ count);
		System.out.println("Optimal Cost : " + oC.optimalCost(cost));
	}

	private int optimalCost_r(int[] cost, int m, int n) {
		count++;
		if(m == n)
			return cost[m];
		
		if(n < m){
			return 0;
		}
		
		int sum = getSum(cost, m, n);
		int min =  Integer.MAX_VALUE;
		
		for(int r = m; r <= n; r++){
			int x =  optimalCost_r(cost, m, r-1) + optimalCost_r(cost, r+1, n);
		    if(x < min){
		    	min = x;
		    }
		}
		return sum + min;
	}

	private int optimalCost(int[] cost) {
		int len = cost.length;
		int[][] table = new int[len][len];
		
	    for(int i = 0; i < len; i++)
			table[i][i] =  cost[i];
	    
	    for(int L = 2; L <= len; L++){
	    	for(int i = 0; i <len-L+1; i++){
	    		int j = i+L-1;
	    		table[i][j] = Integer.MAX_VALUE;
	    		for(int r = i; r <= j; r++){
	    		    int result = ((r > i)? table[i][r-1]:0)+
	    		    		     ((r < j)? table[r+1][j]:0) + getSum(cost, i, j);
	    		    if (result < table[i][j]){
	    		    	table[i][j] =  result;
	    		    }
	    		}
	    	}
	    }			
	    return table[0][len-1];
	}
	
	private int getSum(int[] cost, int m, int n) {
		int sum = 0;
		for(int i = 0; i <= n; i++){
			sum = sum + cost[i];
		}
		return sum;
	}
	

}
