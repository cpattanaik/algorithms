/**
 * 
 */
package com.pattanaik.algorithm.nqueen;

/**
 * @author c0p00fy
 *
 */
public class NQueen {
	private static int N = 8;
	private static String format = "  %d";
	public static void main(String[] args) {
		int[][] sol =  new int[N][N];
		print(sol);
		
		for(int row = 0; row<N; row++){
			boolean status = placeQeens(sol, row,  1);
			if(status == true){
				break;
			}
		}
		
		print(sol);
	}
	
	private static void print(int[][] sol) {
		for(int i =0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(String.format(format, sol[i][j]));
			}
			System.out.println("");
		}
	}
	
	private static boolean isValidPlace(int[][] sol, int row, int col) {
		if(col < 0 && col >= N){
			return false;
		}
		
        /* Check this col on top side */
		for (int i = 0; i < row; i++) 
            if (sol[i][col] != 0) 
                return false; 
  
        /* Check upper diagonal on left side */
        for (int i=row, j=col; i>=0 && j>=0; i--, j--) 
            if (sol[i][j] != 0) 
                return false; 
  
        /* Check lower diagonal on left side */
        for (int i=row, j=col; j>=0 && i<N; i++, j--) 
            if (sol[i][j] != 0) 
                return false; 
		
		return true;
	}
	
	private static boolean placeQeens(int[][] sol, int row, int QId) {
		if(row < 0 && row >= N){
			return false;
		}
		
		if(QId == N+1){
			return true;
		}
		
		for(int col=0; col < N; col++){
			if(isValidPlace(sol, row, col)){
				sol[row][col] = QId;
				if (placeQeens(sol, row+1, QId+1)){
					return true;
				}
				sol[row][col] = 0;
			}
		}
		return false;
	}
}
