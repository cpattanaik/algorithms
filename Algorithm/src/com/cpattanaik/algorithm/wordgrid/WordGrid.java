/**
 * 
 */
package com.cpattanaik.algorithm.wordgrid;

/**
 * @author c0p00fy
 *
 */
public class WordGrid {
	private static volatile int x = 5;
	public static void main(String[] args) {
		char grid[][] = {
							{'a','x','m','y'},
							{'b','g','d','f'},
							{'x','e','e','t'},
							{'r','a','k','s'}
						};
		
		findWord(grid, "", 4, 4);
	}

	
	/**
	 * @param grid
	 * @param string
	 * @param nrow
	 * @param ncol
	 */
	private static boolean findWord(char[][] grid, String mat, int nrow, int ncol) {
		for(int i=0; i < nrow; i++){
			for(int j=0; j < ncol; j++){
				if(findMatch(grid, "", i, j, nrow, ncol)){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @return
	 */
	private static boolean findMatch(char[][] grid, String mat, int ix, int jx, int nrow, int ncol) {
		if(ix < 0 || ix >= nrow || jx < 0 || jx >= ncol){
			return false;
		}
		
		if(mat.length() > "geeks".length()){
			return false;
		}
		
		if(mat.equals("geeks")){
			System.out.println(mat);
			return true;
		}
		
		if(!mat.isEmpty() && mat.charAt(0) != "geeks".charAt(0)){
			return false;
		}
		
		mat = mat + String.valueOf(grid[ix][jx]);
		if(findMatch(grid, mat, ix+1, jx, nrow, ncol) 
				|| findMatch(grid, mat, ix-1, jx, nrow, ncol)  
				|| findMatch(grid, mat, ix, jx+1, nrow, ncol) 
				|| findMatch(grid, mat, ix, jx-1, nrow, ncol)){
			return true;
		}else{
			return false;
		}
	}
}
