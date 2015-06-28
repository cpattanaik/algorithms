package com.cpattanaik.algorithm.coinchange;

public class CoinChange {
	public static void main(String[] args) {
		CoinChange coin = new CoinChange();
		
//		//Solution should be 4
//	    int a[] = {1, 2, 3};
//	    int sum = 4;
	    
		//Solution should be 5
	    int a[] = {2, 5, 3, 6};
	    int sum = 10;
	    
	    System.out.println("Coin Change Number Of Solutions Using Recursion....");
	    System.out.println(coin.coinChange_r(a, a.length, sum));
	    
	    System.out.println("Coin Change Number Of Solutions Using DP....");
	    System.out.println(coin.coinChange(a, a.length, sum));


	}
	public int coinChange_r(int[] coinSet, int setLength, int coinToChange){
		if(coinToChange == 0)
			return 1;
		if(coinToChange != 0 && setLength == 0)
			return 0;
		
		if(coinSet[setLength-1] > coinToChange)
			return coinChange_r(coinSet, setLength-1, coinToChange);
		else{
			return coinChange_r(coinSet, setLength-1, coinToChange) + 
				   coinChange_r(coinSet, setLength, coinToChange-coinSet[setLength-1]);
		}
	}
	
	public int coinChange(int[] coinSet, int setLength, int coinToChange){
		int[][] table =  new int[coinToChange+1][setLength+1];
		
		for(int i = 0; i<=setLength; i++){
			table[0][i] = 1;
		}
		
		for(int i = 1; i<=coinToChange; i++){
			table[i][0] = 0;
		}
		
		for(int i = 1; i <= coinToChange; i++){
			for(int j = 1; j <= setLength; j++){
				
				if(coinSet[j-1] > i)
					table[i][j] = table[i][j-1];
				else{
					table[i][j] = table[i][j-1] + table[i-coinSet[j-1]][j];
				}
			}
				
		}
		return table[coinToChange][setLength];
	}
	
	
}
