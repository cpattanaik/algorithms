package com.cpattanaik.algorithm.matrixchainmult;

public class MatrixChainMulti {

	public static void main(String[] args) {
		MatrixChainMulti mcm = new MatrixChainMulti();
		int mc[] = {10, 30, 5, 60};
		
		System.out.println(mcm.minMatrixChainMultiCost_r(mc, 1, mc.length-1));
		System.out.println(mcm.minMatrixChainMultiCost(mc));
	}

	private int minMatrixChainMultiCost_r(int[] mc, int m, int n) {
		
		if(m == n){
			return 0;
		}
		
		int min  = Integer.MAX_VALUE;
		for(int k = m; k < n ; k++){
			int x = minMatrixChainMultiCost_r(mc, m, k) + minMatrixChainMultiCost_r(mc, k+1, n) + mc[m-1]*mc[k]*mc[n];
		    if(x < min){
		    	min = x;
		    }
		}
		return min;		
	}
	
	private int minMatrixChainMultiCost(int[] mc) {
		int len = mc.length;
		int[][] table = new int[len][len];
		
		for(int i = 0; i < len ; i++){
			table[i][i] = 0;
		}
		
		for(int L = 2; L <= len ; L++){
			for(int i = 1; i < len-L+1; i++){
				int j = i+L-1;
				table[i][j] = Integer.MAX_VALUE;
				for(int k = i; k <j; k++){
					int result = table[i][k] + table[k+1][j] + mc[i-1]*mc[k]*mc[j];
					if(result < table[i][j]){
						table[i][j] = result;
					}
				}
			}
		}
		
		return table[1][len-1];
		
	}	

}
