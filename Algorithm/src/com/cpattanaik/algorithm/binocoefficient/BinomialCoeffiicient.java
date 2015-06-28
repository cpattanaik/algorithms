package com.cpattanaik.algorithm.binocoefficient;

public class BinomialCoeffiicient {
	public static void main(String[] args){
		BinomialCoeffiicient bc = new BinomialCoeffiicient();
		int n = 4;
		int k = 2;
		
		System.out.println(bc.binomialCoeffiicient(n, k));
		
	}

	private int binomialCoeffiicient(int n, int k) {
		if(k == 0 || k == n){
			return 1;
		}
		return binomialCoeffiicient(n-1, k-1) + binomialCoeffiicient(n-1, k);
	}

}
