/**
 * 
 */
package com.cpattanaik.algorithm.napsack01;

import java.util.Arrays;

/**
 * @author c0p00fy
 *
 */
public class V2Napsack01 {
	public static void main(String[] args) {
	    int v[] = {60, 100, 120};
	    int w[] = {10,  20,  30};
	    int W   = 50;
	
	    int value = napsack(W, v, w, w.length-1);
	    System.out.println(value);
	}

	
	private static int napsack(int W, int[] v, int[] w, int index) {
		if(W == 0 || index < 0){
			return 0;
		}
		
		if(w[index] > W){
			return napsack(W, v, w, index-1);
		}
		return Math.max(v[index] + napsack(W-w[index], v, w, index-1), napsack(W, v, w, index-1));
	}

}
