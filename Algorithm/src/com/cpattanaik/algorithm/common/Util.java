package com.cpattanaik.algorithm.common;

public class Util {
	public static void print(char[] array, int length){
		for(int i = 0; i < length; i++){
			System.out.print(array[i]);
		}
		System.out.print("\n");
	}
	public static boolean compare(int x, int y){
		return x>y?true:false;
	}
	public static void print(char[] array, int i, int j) {
		for(int index = i; index <= j; index++){
			System.out.print(array[index]);
		}
		System.out.print("\n");	
	}
	public static void print(int[] a, int i, int length) {
		for(int index = i; index <= length; index++){
			System.out.print(a[index]);
		}
		System.out.print("\n");	
	}
	public static int min(int a, int b, int c){
		int x = Math.min(a, b);
		return Math.min(x, c);		
	}
}
