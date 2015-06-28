package com.cpattanaik.algorithm.maxsumsubmarix;

public class MaxSumSubMatrix {
	public static void main(String[] args){
	MaxSumSubMatrix client = new MaxSumSubMatrix();
	
	int[][] matrix =  {	{ 1,  2,  -1, -4, -20},
						{-8, -3,   4,  2,   1},
						{ 3,  8,  10,  1,   3},
						{-4, -1,   1,  7,  -6}
           	   		  };
	
	System.out.println(client.maxSumSubMatrix(matrix, matrix.length, matrix[0].length));

	}

	private int maxSumSubMatrix(int[][] matrix, int row, int col) {
		int[] table = new int[row];
		int maxSum  = 0;
		for(int i = 0; i < col; i++){
			clean(table);
			for(int j = i; j < col; j++){
				for(int m = 0; m < row;  m++)
				    table[m] += matrix[m][j];
	            
				int sum = maxSubArraySum(table);
				if(sum > maxSum){
					maxSum = sum;	
				}
			}
		}
		return maxSum;
	}
	
	private void clean(int[] table) {
		for(int m = 0; m < table.length;  m++)
			table[m] = 0;
	}

	private int maxSubArraySum(int[] array) {
		int result = 0;
		int sum = 0;
		
		for(int i = 0; i < array.length; i++){
			sum = sum + array[i];

			if(sum < array[i]){
				sum = array[i];
			}			
			
			if(sum > result){
				result = sum;
			}
		}
		return result;
	}
}
