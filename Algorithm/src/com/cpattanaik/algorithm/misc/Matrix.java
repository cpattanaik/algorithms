package com.cpattanaik.algorithm.misc;

public class Matrix {
	public static void main(String[] args) {
		int [][] matrix = { {1,  2,  3,  4,  5},
							{6,  7,  8,  9,  10},
							{11, 12, 13, 14, 15},
							{16, 17, 18, 19, 20},
							{21, 22, 23, 24, 25}
						  };
		int m = 5;
		int n = 5;
//		spiral(matrix, m, n);
//		spirall(matrix, m, n);
		digonal(matrix, m, n);
		
	}

	private static void digonal(int[][] matrix, int m, int n) {
		int x = 0;
		for(int i=n-1; i>=0; i--){
			for(int j=0; j<=x; j++){
				System.out.print(matrix[i+j][j]+ " ");
			}
			x++;
		}
		
		x = n-1;
		for(int j = 0; j <= m-1; j++){
			for(int i=0; i <= x; i++){
				System.out.print(matrix[i][i+j]+ " ");
			}
			x--;
		}
	}
	
	private static void spirall(int[][] matrix, int m, int n) {
		for(int i=0; i<n; i++){
			if(i%2 == 0){
				for(int j=0; j<m; j++){
					System.out.print(matrix[i][j]+ " ");
				}
			}else{
				for(int j=m-1; j>=0; j--){
					System.out.print(matrix[i][j]+ " ");
				}
			}
		}
	}


	private static void spiral(int[][] matrix, int m, int n) {
		int srow = 0; int scol=0;
		int erow = n;   int ecol =m;
		while(srow < erow && scol < ecol){
			int row = srow; int col=scol;
			for( ;col< ecol; col ++){
				System.out.print(matrix[row][col] + " ");
			}
			ecol--;
			
			row ++; col--;
			for( ; row<erow; row ++){
				System.out.print(matrix[row][col]+ " ");
			}
			erow--;
			
			row--; col--;
			for( ;col>= scol; col --){
				System.out.print(matrix[row][col]+ " ");
			}
			scol++;
			
			
			row--; col++;
			for( ; row > srow; row --){
				System.out.print(matrix[row][col]+ " ");
			}
			srow++;

		}
	}
}


