package com.pattanaik.ds;

public class FindKthSmallest {
	public static void main(String[] args) {
		int[] array = {5, 2, 18 , 23 , 16, 11, 7, 25, 9};
		int k = 4;
		System.out.println(find(array, k));
	}

	private static Integer find(int[] array, int k) {
		int[] heap = new int[k];
		
		for(int i = 0; i<k; i++){
			heap[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i<array.length; i++){
		   if(heap[0] > array[i]){
			   heap[0] = array[i] ;
			   heapify(heap);
		   }
		}
		
		return heap[0];
	}

	private static void heapify(int[] heap) {
		int mid = heap.length/2;
		while(mid >= 0){
			int left  =  2*mid+1;
			int right =  2*mid+2;
			int swap = mid;
			
			if(left < heap.length){
				 swap =  left;
			}
			
			if (right < heap.length){
				if (heap[left] < heap[right]){
					swap = right;
				}
			}
			
			if(heap[swap] > heap[mid]){
				int temp = heap[swap];
				heap[swap] =  heap[mid];
				heap[mid] = temp;
			}
		    mid = mid -1;
		}	
	}
}
