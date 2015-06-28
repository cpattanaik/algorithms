package com.cpattanaik.algorithm.maxsumnoadjacency;

public class MaxSumNoTwoAdjacent {
	public static void main(String[] args) {
		MaxSumNoTwoAdjacent client = new MaxSumNoTwoAdjacent();
		
		int[] a = {5,  5, 10, 40, 50, 35};//Ans:- 80  
		//int[] a = {3, 2, 7, 10}; // Ans:- 13
		
		System.out.println(client.maxSum(a));
		
		int num = 5;
		int[] dup  = {num};
		System.out.println(client.checkNumberIsPalindrom(num, dup));

	}

	private boolean checkNumberIsPalindrom(int num, int[] dup) {
		if(num/10 == 0){
			return (num == dup[0]%10);
		}
		
		if(!checkNumberIsPalindrom(num/10, dup)){
			return false;
		}
		
		dup[0] = dup[0]/10;
		return (num %10 == dup[0] %10);
		
	}

	private int maxSum(int[] a) {
		int excludingCurrent = 0;
		int includingCurrent = 0;
		
		for(int i = 0; i < a.length; i++){
			int prevexcludingCurrent = excludingCurrent;   
			excludingCurrent = Math.max(excludingCurrent, includingCurrent);
			includingCurrent = prevexcludingCurrent + a[i];
		}
		
		return Math.max(excludingCurrent, includingCurrent); 
	}

}
