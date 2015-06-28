package com.cpattanaik.algorithm.fibonacci;

public class Client {
	public static void main(String[] args){
		Client c = new Client();
		
		int n = 10;	
		System.out.print("Fibonacci Non Recursive: " + c.fib_nr(n)+"\n");
		System.out.print("Fibonacci Recursive: " + c.fib(n)+"\n");
		
		//Implementing recursive version with optimization
		int[] table = new int[11];
		for(int i = 0; i < table.length; i++){
			table[i]  = -1;
		}
		System.out.print("Fibonacci Recursive with Memory: " + c.fib(n, table)+"\n");
		
		
	}
	
	/*
	 * F(n) = F(n-1) + F(n-2);   F(0) = 0 , F(1) = 1;
	 * 
	 *   0 1 1 2 3 5 8 13 21 34 55......
	 *   
	 *   
	 */
	
	
	private int fib_nr(int n) {
		int a = 1;
		int b = 1;

		for(int index = 2; index < n; index++){
			int temp = a + b;
			a = b;
			b = temp;
		}
		return b;
	}
	
	private int fib(int n) {
		//System.out.println("recursiv");
		if(n == 1 || n ==2){
			return 1;
		}else{
				return fib(n-1) +  fib(n-2);
		}
	}
	
	private int fib(int n, int[] table) {
		//System.out.println("Hi");
		if(n == 1 || n ==2){
			table[n] = 1;
			return table[n];
		}else{
			if(table[n] != -1){
				return table[n];
			}else{
				int result1 = fib(n-1, table);
				int result2 = fib(n-2, table);
				table[n] = result1 + result2;
				return table[n];
			}
		}
	}
}
