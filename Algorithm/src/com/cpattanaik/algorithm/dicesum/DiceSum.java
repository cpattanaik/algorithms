package com.cpattanaik.algorithm.dicesum;

public class DiceSum {

	public static void main(String[] args) {
		DiceSum ds = new DiceSum();
		
//		System.out.println(ds.diceSum_dp(1, 2, 4)); //0
//		System.out.println(ds.diceSum(3, 2, 2)); 	//2
		System.out.println(ds.diceSum(8, 3, 6)); 	//21
//		System.out.println(ds.diceSum(5, 2, 4)); 	//4
//		System.out.println(ds.diceSum(5, 3, 4)); 	//6
//		System.out.println(ds.diceSum_dp(4, 2, 3)); //3 
	}

	private int diceSum(int sum, int numberOfDice, int numberOfFace) {
		if(sum <= 0)
			return 0;
		
		if(numberOfDice == 1 && sum <= numberOfFace){
			return 1;
		}
			
		int result =  0;
		for(int i = 1; i <= numberOfFace; i++){
			result += diceSum(sum-i, numberOfDice-1, numberOfFace);
		}
        return result;
	} 
	
	
	private int diceSum_dp(int sum, int dice, int face){
		int[][] table =  new int[dice+1][sum+1];
		
		for(int j =1; j <= sum && j <= face; j++)
			table[1][j] = 1;
		
		for(int i = 2; i <= dice; i++){
			for(int j = 1; j <= sum; j++){
				for(int m = 1; (m <= j && m <= face); m++){
					table[i][j]  += table[i-1][j-m];
				}
			}
		}
		
//		for(int i = 0; i <= dice; i++){
//			for(int j = 1; j <= sum; j++){
//				System.out.format("%4d", table[i][j]);
//			}
//			System.out.println("\n");
//		}
		return table[dice][sum];
	}
	
	

}

