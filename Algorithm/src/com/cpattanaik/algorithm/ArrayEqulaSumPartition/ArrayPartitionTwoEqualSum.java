package com.cpattanaik.algorithm.ArrayEqulaSumPartition;

import java.util.Arrays;

public class ArrayPartitionTwoEqualSum {
	public static void main(String[] args) {
		ArrayPartitionTwoEqualSum client =  new ArrayPartitionTwoEqualSum();
		int[] array = {2, 1, 5, 9, 12, 6,  3};
		int [] result = new int[array.length];
		System.out.println(client.equalSumPartition(array, result));
//		for(int i = 0; i < array.length; i++){
//			System.out.println(result[i]);
//		}
		
		//System.out.println(client.equalSumPartitionDP());
	}

	private Boolean equalSumPartitionDP() {
		int[] arr = {2, 1, 5, 9};
		int sum = 6;
		return checkEqualSumPartitionDP(arr, arr.length, sum);
	}

	private Boolean checkEqualSumPartitionDP(int[] array, int length, int sum) {
		int[][] table  = new int[length+1][sum+1];
		for(int i=1; i<=length; i++){
			for(int j =1; j<=sum; j++){
				if(array[i-1] > j){
					table[i][j] =  table[i-1][j];
				}else{
					table[i][j] = Math.max((array[i-1]+table[i-1][j-array[i-1]]), (table[i-1][j]));
					if(table[i][j] == sum ){
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean equalSumPartition(int[] array, int[] result) {
		int sum = 0;
		for(int i = 0; i < array.length; i++){
			sum  = sum + array[i];
		}
		
		if(sum % 2 != 0){
			return false;
		}
		
		sum = sum / 2;
		System.out.println("Sum:"+ sum);
		return checkEqualSumPartition(array, array.length, sum, result);
	}


	
	private boolean checkEqualSumPartition(int[] array, int length, int sum, int[] result) {
		if(sum == 0){
			System.out.println(Arrays.toString(result));
			return true;
		}
		
		if(sum != 0 && length == 0){
			return false;
		}
		
		if(array[length-1] > sum){
			boolean x = checkEqualSumPartition(array, length-1, sum, result);
			return x;
		}
		
		boolean x = checkEqualSumPartition(array, length-1, sum, result);
		
		result[length-1] = array[length-1];
		boolean y = checkEqualSumPartition(array, length-1, sum-array[length-1], result);
		result[length-1] = 0;
		
		return x || y;
	}
}
