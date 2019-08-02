/**
 * 
 */
package com.cpattanaik.algorithm.knightstour;

/**
 * @author c0p00fy
 *
 */
public class KnightsTour {
	private static int N = 8;

	public static void main(String[] args) {
		int[][] sol = new int[N][N];
		boolean status = KnightsTourSol(sol, 0, 0, 1);
		if(status == true){
			print(sol);
		}
	}

	/**
	 * @param sol
	 */
	private static void print(int[][] sol) {
		for(int i= 0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.println(sol[i][j]); 
			}
		}
	}

	private static boolean KnightsTourSol(int[][] sol, int row, int col, int step) {
		if (!isValidStep(sol, row, col)) {
			return false;
		}
		
		if(step == N*N){
			return true;
		}

		sol[row][col] = step;
		if(KnightsTourSol(sol, row+2, col+1, step+1)){
			return true;
		}
		
		if(KnightsTourSol(sol, row+2, col-1, step+1)){
			return true;
		}
		
		if(KnightsTourSol(sol, row-2, col+1, step+1)){
			return true;
		}
		
		if(KnightsTourSol(sol, row-2, col-1, step+1)){
			return true;
		}
		
		if(KnightsTourSol(sol, row+1, col+2, step+1)){
			return true;
		}
		
		if(KnightsTourSol(sol, row+1, col-2, step+1)){
			return true;
		}
		
		if(KnightsTourSol(sol, row-1, col+2, step+1)){
			return true;
		}
		
		if(KnightsTourSol(sol, row-1, col-2, step+1)){
			return true;
		}
		
		sol[row][col] = 0;
		return false;
	}

	/**
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean isValidStep(int[][] sol, int row, int col) {
		if ((row >= 0 && row < N) && (col >= 0 && col < N)) {
			if (sol[row][col] == 0) {
				return true;
			}
		}
		return false;
	}

}
