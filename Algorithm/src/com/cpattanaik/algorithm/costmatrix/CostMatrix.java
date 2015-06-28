package com.cpattanaik.algorithm.costmatrix;

import com.cpattanaik.algorithm.common.Util;

public class CostMatrix {
	public static void main(String[] args){
		CostMatrix cm = new CostMatrix();
		
		int[][] cost  =  {{1, 2, 3},
                		  {4, 8, 2},
                          {1, 5, 3}};
		
		System.out.println("Optimal Cost Matrix: "+ cm.costMatrix_r(cost, cost[0].length-1, cost.length-1)); 
		System.out.println("Optimal Cost Matrix: "+ cm.costMatrix(cost, cost[0].length-1, cost.length-1)); 
	}

	private int costMatrix_r(int[][] cost, int col, int row) {
		//System.out.println(row +":" + col);
		if(col < 0 || row < 0)
			return Integer.MAX_VALUE;
		else if(col == 0 && row == 0)
			return cost[row][col];
		else
			return cost[row][col] + Util.min(costMatrix_r(cost, col-1, row-1), 
					costMatrix_r(cost, col, row-1), costMatrix_r(cost, col-1, row));
	}
	
	private int costMatrix(int[][] cost, int col, int row) {
	    int[][] table = new int[row+1][col+1];
	    
	    table[0][0] = cost[0][0]; 
	 
	    // cost for first row calculated this way
	    for(int i = 1; i <= col; i++)
	    {   
	         table[0][i] = cost[0][i] + table[0][i-1];
	         
	    }
	    //cost for first column calculated this way.
	    for(int i = 1; i < row; i++)
	    {   
	         table[i][0] = cost[i][0] + table[i-1][0];
	         
	    } 
	    
	    // cost of other destination will be calculated this way.
	    // it is based on the assumption, you can only travel right, 
	    // down and diagonally lower cells from top.
	    
	    for(int i = 1; i<=row; i++)
	    {
	         for(int j = 1; j<=col; j++)
	         {
	              table[i][j]  = cost[i][j] + Util.min(table[i-1][j], table[i][j-1], table[i-1][j-1]);
	         } 
	    }
	    return table[row][col];

	}

}
