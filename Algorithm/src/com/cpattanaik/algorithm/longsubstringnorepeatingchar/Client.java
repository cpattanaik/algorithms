package com.cpattanaik.algorithm.longsubstringnorepeatingchar;

public class Client {
    public static final int MAX_LEN = 256;
	public static void main(String[] args) {
		Client c = new Client();
		//String text = "geeksforgeeks";
		String text = "ABDEFGABEF";
		char[] array = text.toCharArray();
		
		System.out.println(c.getLongSubStringNoRepeatingChar(array));
	}

	private int getLongSubStringNoRepeatingChar(char[] array) {
		int start_index = 0;
		int current_index = 0;
		int lenght = 0;
		int max_lenght = 0;
		
		int[] table = new int[MAX_LEN];
		
		for(int i = 0; i < MAX_LEN; i++){
			table[i] = -1;
		}
		
		for(int i = 0; i < array.length; i++){
			if(table[array[i]] != -1){
				if(table[array[i]] < start_index){
					table[array[i]] = i;
					current_index++;
				}else{
					table[array[i]] = i;
					lenght = current_index - start_index;
					start_index = current_index + 1;
					current_index++;
				}
			}else{
				table[array[i]] = i;
				current_index++;	
			}
			if(lenght > max_lenght){
				max_lenght = lenght;
			}
		}
		return max_lenght;
	}

}
