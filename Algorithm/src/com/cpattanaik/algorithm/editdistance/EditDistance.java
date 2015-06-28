package com.cpattanaik.algorithm.editdistance;

import com.cpattanaik.algorithm.common.Util;

public class EditDistance {
	public static void main(String[] args){
		EditDistance ed =  new EditDistance();
		String textx = "AGGTAB";
		String texty = "GXTXAYB";
		
		char[] X = textx.toCharArray();
		char[] Y = texty.toCharArray();
	  
		System.out.println("Length of Edit Distance:" + ed.editDistance_r( X, Y, X.length, Y.length));
		System.out.println("Length of Edit Distance:" + ed.editDistance( X, Y, X.length, Y.length));
	}
	
	private int editDistance_r(char[] X, char[] Y, int m,int n) {
		if(m == 0 && n == 0){
			return 0;
		}
		
		if(m == 0 ){
			return n;
		}
		
		if(n == 0){
			return m;
		}
		
		if(X[m-1] != Y[n-1]){
			return Util.min(1 + editDistance_r( X, Y, m-1, n),
				       1 + editDistance_r( X, Y, m, n-1),
				       1 + editDistance_r( X, Y, m-1, n-1));
		}
		else{
			return editDistance_r( X, Y, m-1, n-1);
		}
	}
	
	private int editDistance(char[] X, char[] Y, int m,int n) {
	    int[][] table = new int[m+1][n+1];
	    
	    table[0][0] = 0;
	    
	    for(int i = 0; i <= m; i++)
	    {  
	         table[i][0] = i;
	    }
	    
	    for(int i = 0; i <= n; i++)
	    {  
	         table[0][i] = i;
	    }
	    
	    for(int i = 1; i <= m; i++)
	    {
	        for(int j = 1; j <= n; j++)
	        {
	        	if(X[i-1] != Y[j-1]){
	        		table[i][j] = Util.min( table[i-1][j]  + 1, table[i][j-1]  + 1, table[i-1][j-1]+ 1);
	            }else{
	            	table[i][j] = table[i-1][j-1];
	            }
	        }
	    }
	    return table[m][n];
	}
}
