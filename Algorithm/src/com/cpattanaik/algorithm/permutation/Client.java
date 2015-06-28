package com.cpattanaik.algorithm.permutation;

import com.cpattanaik.algorithm.common.Util;

public class Client {
	public static void main(String[] args){
		Client c = new Client();
		
		String perm = "abc";
		char[] array = perm.toCharArray();
		char[] temp = new char[array.length];
		int start = 0;
		
		System.out.print("Permutation: ");
		c.permutation(array, start);
				
		System.out.println("Combination: ");
		c.combination(array, start, temp, 0);
		
		System.out.println("r_Combination: ");
		c.r_combinations(array, 0, temp, 0, 2);
		
		System.out.println("r_Combination with repetation: ");
		temp =  new char[3];
		c.r_combinations_with_repitation(array, 0, temp, 0, 3);
		
		System.out.println("combination without recursion: ");
		c.level_based_print(array);
	}
	
	public void permutation(char[] array, int start){
		if(start == array.length){
			Util.print(array, array.length);
		}
		for(int i = start; i < array.length; i++){
		   char temp = array[start];
		   array[start] = array[i];
		   array[i] = temp;
		   permutation(array,  start+1);
		   array[i] = array[start];
		   array[start] = temp;
		}
		
	}
	public void combination(char a[], int start, char b[], int lev){      
		 Util.print(b, lev);
		 
	     for(int i=start; i<a.length; i++){
	        b[lev] = a[i];
	        combination(a, i+1, b, lev+1);
	     }
	}  
	
	public void r_combinations(char[] a, int start, char[] b, int level, int r){
		if(level == r){
		   Util.print(b, level);
		   return;
		}
		
		for(int i = start; i < a.length; i++){
			b[level] = a[i];
			r_combinations(a, i+1, b, level+1, r);
		}
	  
	}
	
	public void r_combinations_with_repitation(char[] a, int start, char[] b, int level, int r){
		if(level == r){
		   Util.print(b, level);
		   return;
		}
		
		for(int i = 0; i < a.length; i++){
			b[level] = a[i];
			r_combinations_with_repitation(a, i+1, b, level+1, r);
		}
	  
	}
	
	public void level_based_print(char[] a){
		for(int L = 0; L < a.length; L++){
			for(int i =0; i < a.length - L; i++){
				int j = i + L;
				Util.print(a, i, j);
			}
		}
	}

}
