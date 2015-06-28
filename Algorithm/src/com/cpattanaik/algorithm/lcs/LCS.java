package com.cpattanaik.algorithm.lcs;

public class LCS {
	public static void main(String[] args){
		LCS c = new LCS();
		
		String textx = "AGGTAB";
		String texty = "GXTXAYB";
		
		char[] X = textx.toCharArray();
		char[] Y = texty.toCharArray();
	  
		System.out.println("Length of LCS is:" + c.lcs_r( X, Y, X.length, Y.length) );
		System.out.println("Length of LCS is:" + c.lcs( X, Y, X.length, Y.length) );
	}

	private int lcs_r(char[] X, char[] Y, int m, int n) {
		if(m == 0 || n == 0){
			return 0;
		}
		
		if(X[m-1] == Y[n-1])
			return 1 + lcs_r( X, Y, m-1, n-1);
		else
			return Math.max(lcs_r( X, Y, m-1, n), lcs_r( X, Y, m, n-1));
	}
	
	private int lcs(char[] X, char[] Y, int m, int n) {
	    int[][] table =  new int[m+1][n+1];
	    
	    for(int i = 0; i <= m; i++){
	    	table[i][0]  = 0;
	    }
	    
	    for(int i = 0; i <= n; i++){
	    	table[0][i]  = 0;
	    }
	    
	    for(int i = 1; i <= m; i++){
	    	for(int j = 1; j <= n; j++){
	    		if(X[i-1] == Y[j-1]){
	    			table[i][j] =  1 + table[i-1][j-1];
	    		}else{
	    			table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
	    		}
	    	}
	    }
		return table[m][n];
	}
}
