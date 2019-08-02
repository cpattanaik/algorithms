package com.cpattanaik.algorithm.eggdrop;

import java.util.AbstractMap;
import java.util.Map;

public class EggDrop {
	public static void main(String[] args){
		EggDrop ed = new EggDrop();
		 
		int nEggs = 3;
		int nFloor = 20;
		
		System.out.println("Minimum Steps to Find Exact Floor Number: ");
		System.out.println(ed.eggDrop_r(nEggs, nFloor));
		
		System.out.println("Minimum Steps to Find Exact Floor Number: ");
		System.out.println(ed.eggDrop_DP(nEggs, nFloor));
	}

	
	private int eggDrop_DP(int nEggs, int nFloor) {
		int[][] table = new int[nEggs+1][nFloor+1];

		Map.Entry<String , String>  entry  =  new AbstractMap.SimpleEntry<String, String>("exmpleString", ""); 

		//One Egg and N Floor
		for(int i = 1; i <= nFloor; i++)
			table[1][i] = i;
		
		//N eggs and 0/1 Floor
		for(int i = 1; i <= nEggs; i++){
			table[i][0] = 0;
			table[i][1] = 1;
		}
		
		for(int i = 2; i <= nEggs; i++ ){
			for(int j = 2; j <= nFloor; j++){
				
				table[i][j] = Integer.MAX_VALUE;
				for(int x = 1; x <= j; x++){
					int m =  Math.max(table[i-1][x-1], table[i][j-x]); 
					if(m < table[i][j])
						table[i][j] = 1 + m ;  // It will store min value
				}
			}
		}
//For this test scenario of 3 eggs and 36 floors the table matrix shows 6 is the minimum step to find the exact floor. 
//But to understand where to start with dropping, check the number of 6 in last row and it is 11, hence we will 
//start from 11th floor, if did not broke, then add number of 5 is 11, hence 2nd try should be from 22th floor and so on
//Exact Dropping Floors if the egg did not break:
//
//   11(no. of 6)+11(no. of 5)+7(no. of 4)+4(no. of 3)+2(no. of 2)+1(no. of 1) =  36 
//	 11th floor   22nd Floor   29th Floor  33th floor  35th floor  36th floor
//   1 try       +1 try       +1 try      +1 try      +1 try      +1 try   = 6 tries in worst case
//
// if in first try egg broke , to figure out from 2 remaining eggs and 11th floors , it will take 5 tries 
// and in this case, total will be 6 tries. Similarly it can be explained for others.
//
//   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
//
//   0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31  32  33  34  35  36
//
//   0   1   2   2   3   3   3   4   4   4   4   5   5   5   5   5   6   6   6   6   6   6   7   7   7   7   7   7   7   8   8   8   8   8   8   8   8
//
//   0   1   2   2   3   3   3   3   4   4   4   4   4   4   4   5   5   5   5   5   5   5   5   5   5   5   6   6   6   6   6   6   6   6   6   6   6
//
/////////////////////////////////////////////

		//thThe number of highest number in a row, is the floor to start droping the eg
		for(int i = 0; i <= nEggs; i++ ){
			for(int j = 0; j <= nFloor; j++){
						System.out.format("%4d", table[i][j]);
			}
			System.out.println("\n");
		}		
		
		return table[nEggs][nFloor];
		
	}

	// eggDrop(n, k) = 1 + Min { Max(eggDrop(n-1, x-1), eggDrop(n, k-x))}
	// k - number of floors, n- number of eggs
	private int eggDrop_r(int n, int k) {
		//if 0th or 1st floor
		if(k == 0 || k == 1)
			return k;
		
		//if only one egg given
		if(n == 1)
			return k;
		
		int min  = Integer.MAX_VALUE;
		for(int x=1; x <= k; x++){
			int worseCase = 1 + Math.max(eggDrop_r(n-1, x-1), eggDrop_r(n, k-x));
			if(worseCase < min){
				min = worseCase;
			}
		}
		return min;
	}

}
