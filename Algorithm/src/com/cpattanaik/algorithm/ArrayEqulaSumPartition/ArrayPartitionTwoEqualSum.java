package com.cpattanaik.algorithm.ArrayEqulaSumPartition;

public class ArrayPartitionTwoEqualSum {
	public static void main(String[] args) {
		ArrayPartitionTwoEqualSum client =  new ArrayPartitionTwoEqualSum();
		int[] array = {2, 1, 5, 9, 12, 6,  3};
		int [] result = new int[array.length];
		System.out.println(client.equalSumPartition(array, result));
		for(int i = 0; i < array.length; i++){
			System.out.println(result[i]);
		}
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
		
		return checkEqualSumPartition(array, array.length, sum, result);
	}

	private boolean checkEqualSumPartition(int[] array, int length, int sum, int[] result) {
		System.out.println("hi");
		if(sum == 0){
			return true;
		}
		
		if(sum != 0 && length == 0){
			return false;
		}
		
		if(array[length-1] > sum){
			
			boolean x = checkEqualSumPartition(array, length-1, sum, result);
			result[length-1] = 0;
			return x;
		}
		
		boolean x = checkEqualSumPartition(array, length-1, sum, result);
		result[length-1] = 0;
		
		boolean y = checkEqualSumPartition(array, length-1, sum-array[length-1], result);
		if(y){
			result[length-1] = array[length-1];
		}
		
		return x || y;
	}
}
