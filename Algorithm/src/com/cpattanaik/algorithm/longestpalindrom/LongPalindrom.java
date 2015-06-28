package com.cpattanaik.algorithm.longestpalindrom;

public class LongPalindrom {
	public static void main(String[] args){
		LongPalindrom lp = new LongPalindrom();
		String text = "taacdd";
		char[] array = text.toCharArray();
		
		System.out.println("Long Palindrom:" + lp.longPalindron_r(array, 0, array.length-1));
		System.out.println("Long Palindrom:" + lp.longPalindron(array, array.length));
	}

	private int longPalindron_r(char[] array, int start, int end) {
		if(start > end)
			return 0;
		if(start == end)
			return 1;
		if(array[start] == array[end]){
			return longPalindron_r(array, start+1, end-1) + 2;
		}else{
			return Math.max(longPalindron_r(array, start, end-1) , longPalindron_r(array, start+1, end));
		}
	}
	
	private int longPalindron(char[] array, int len) {
		  //Table creation
		  boolean[][] table = new boolean[len+1][len+1];
		   
		  for(int i = 0; i < len; i++)
		     for(int j = 0; j < len; j++)
		         table[i][j] = false;
		         
		  int length = 1; 
		  for(int i = 0; i < len; i++)
		  {
		     table[i][i] = true;
		     if(i < len -1 && array[i] == array[i+1]){
		         table[i][i+1] = true;
		    	 length = 2;
		     }
		  }
		  
		  for(int L=3; L < len; L++)
		  {
		     for(int i=0; i < len-L+1; i++)
		     {    
		         int j=i+L-1;
		         if(table[i+1][j-1] && array[i] == array[j])
		         {
		             table[i][j] = true;
		             if(L > length)
		             {
		                length = L;
		             }
		          }
		     }
		  }
		  return length;
	}
	
}
