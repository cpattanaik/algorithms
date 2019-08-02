package com.pattanaik.ds;

public class ArrayRotation {
	public static void main(String[] args) {
		int [] array =  {3, 5, 8, 9, 10, 11, 1, 2};
		System.out.println(find(array, 0,  7));
	}

	private static Integer find(int[] array, int start, int end) {
		System.out.println(start + ":" + end);
		if(start >= end) {
			return -1;
		}
		
		int mid =  start + (end -start)/2;
		if(array[mid] > array[mid+1]){
			return mid+1;
		}else if(array[mid] < array[mid-1]){
			return mid;
		}
		
		if(array[end] > array[mid]){
			return find(array, start, mid-1);
		}
		return find(array, mid+1, end);
	}
}
