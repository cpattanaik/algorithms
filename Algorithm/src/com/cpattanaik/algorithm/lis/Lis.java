/**
 * 
 */
package com.cpattanaik.algorithm.lis;

/**
 * @author Chandra
 *
 */

/*
 * L(i) = { 1 + Max ( L(j) ) } where j=0, ....j < i and a[j] < a[i] and if there is no such j then L(i) = 1
 */
public class Lis {

	public static void main(String[] args) {
		Lis lis = new Lis();
		
		int[] a = {2,9,1,4,5,10,22,6,7,8,11};	
		System.out.println("LIS : ");
		

		int result = lis.lis(a);
		System.out.println(result);
		
		result = lis.lis_r(a, a.length-1);
		System.out.println(result);
		

	}

	//Bottom up approach (On2 - solution). 
	private int lis(int[] a) {
		int[] lis = new int[a.length];
		int maxLis = 1;
		
		lis[0] = 1;   // Base condition for i = 0;
		
		for(int i = 1; i<a.length; i++){
			lis[i] = 1;
			for(int j = 0; j <= i; j++){
				if((a[i] > a[j]) && (lis[i] < lis[j]+1)){
					lis[i] = lis[j]+1;
				}
			}
		}
		
		for(int i = 0; i<lis.length; i++){
			if(maxLis < lis[i]){
				maxLis = lis[i];
			}
		}
		
		return maxLis;
	}

	//Polynomial Solution  LIS(N) = 1 + Max{LIS(N-1), LIS(N-2)...LIS(2), LIS(1)}
	
	private int lis_r(int[] a, int n) {
		if(n == 0){
			return 1;
		}
		
		int result = 1;
		for(int i = 0; i < n; i++){
			int lis = lis_r(a, i);
			if(a[i] < a[n] && result < lis +1){
				result = 1 + lis;
			}
		}
		return result;
	}

}
