package com.cpattanaik.algorithm.minJump;

public class minJump {

	public static void main(String[] args) {
		minJump mj = new minJump();
	    int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
	    
	    System.out.println("Minumum Number of Jumps to reach end: ");
	    System.out.println(mj.minJump_r(a, a.length));
	    
	    System.out.println("Minumum Number of Jumps to reach end: ");
	    System.out.println(mj.minJump_dp(a));


	}

	private int minJump_dp(int[] a) {
		int[] table = new int[a.length];
		
		for(int i = 0; i<a.length; i++){
			table[i] = Integer.MAX_VALUE;
		}
		
		table[0] = 0;
		
		for(int i = 1; i < a.length; i++){
			for(int j = 0; j < i; j++){
				if(j + a[j] >= i && table[j]+1 < table[i]){
					table[i] = table[j] + 1;
				}
			}
		}
		return table[a.length-1];
		
	}

	private int minJump_r(int[] a, int n) {
		
		if(n == 0){
			return 0;
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++){
			int x =  minJump_r(a, i);
			if(i + a[i] >= n && x + 1 < result){
				result = x + 1;
			}
		}
		return result;
	}
	
}
