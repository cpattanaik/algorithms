package com.cpattanaik.algorithm.subsetsum;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {
    public static void main(String[] args){
		SubSetSum client =  new SubSetSum();
		
		int[] set = {3, 4, 4, 12, 5, 2};
		int sum = 10;
		List<Integer> list =  new ArrayList<Integer>();
		client.subSetSum(set, set.length, sum, list);
		System.out.println(list.toString());
		System.out.println( client.subSetSum_dp(set, set.length, sum) );
    }

	private void subSetSum(int[] set, int length, int sum, List<Integer> list) {
		if(sum == 0){
			System.out.println(list.toString());
			return;
		}
		
		if(sum != 0  && length == 0){
			return;
		}
		
		if(set[length -1] > sum){
			subSetSum(set, length-1, sum, list);
		}else{
			list.add(set[length-1]);
			subSetSum(set, length-1, sum-set[length-1], list);
			list.remove(list.size()-1);
			subSetSum(set, length-1, sum, list);
		}
		
	}
	
	private boolean subSetSum_dp(int[] set, int length, int sum) {
		boolean [][] table = new boolean[sum+1][length+1];
		
		for(int i=0; i<=length; i++){
			table[0][i] = true;
		}
		
		for(int i=1; i<=sum; i++){
			table[i][0] = false;
		}
		
		for(int i=1; i<=sum; i++){
			for(int j = 1; j <= length; j++){
				if(set[j-1] > i )
					table[i][j] = table[i][j-1];
				else
					table[i][j] = table[i][j-1] || table[i-set[j-1]][j-1];
			}
		}		
		return table[sum][length];
	}
	
}
