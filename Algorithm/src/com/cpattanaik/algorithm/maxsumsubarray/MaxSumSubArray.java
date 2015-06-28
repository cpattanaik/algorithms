package com.cpattanaik.algorithm.maxsumsubarray;

public class MaxSumSubArray {
	public static void main(String[] args){
		MaxSumSubArray mSubArray = new MaxSumSubArray();
		
		int[] array =  {-2, 3, 4, -1, 2, -5, 4}; 	
		System.out.println("Max Sub Array Sum : ");
		int result = mSubArray.maxSubArraySum(array);
		System.out.println(result);
		
		int a[] = {-2, 3, 4, -1, 2, -5, 4};
		System.out.println("Max Sub Array Multiplication: ");
		result = mSubArray.maxSubArrayMul(a);
		System.out.println(result);		
	}
	
	private int maxSubArraySum(int[] array) {
		int result = 0;
		int sum = 0;
		
		for(int i = 0; i < array.length; i++){
			sum = sum + array[i];

			if(sum < array[i]){
				sum = array[i];
			}			
			
			if(sum > result){
				result = sum;
			}
		}
		return result;
	}
	
	private int maxSubArrayMul(int[] array) {
		int negetiveMul = 1;
		int positiveMul = 1;
		int maxMul = 1;
		
		for(int i = 0; i < array.length; i++){
			if(array[i] > 0){
				positiveMul = positiveMul*array[i];
				negetiveMul = Math.min(negetiveMul * array[i], 1);   //if first element is positive
				
			}else if(array[i] == 0){
				negetiveMul = 1;
				positiveMul = 1;
				
			}else{
				int temp = positiveMul * array[i];
				positiveMul = Math.max(negetiveMul * array[i], 1);   //if first element is negative
				negetiveMul = temp; 
				
			}
			
			if(positiveMul > maxMul){
				maxMul = positiveMul;
			}
		}
		return maxMul;
	}
	
}
