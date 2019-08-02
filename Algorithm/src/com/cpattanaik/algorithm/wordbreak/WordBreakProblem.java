/**
 * 
 */
package com.cpattanaik.algorithm.wordbreak;

import java.util.HashSet;
import java.util.Set;

/**
 * @author c0p00fy
 *
 */
public class WordBreakProblem {
	private static HashSet<String> dict = new HashSet<String>();
	
	public static void main(String[] args) {
		dict.add("i");
		dict.add("like");
		dict.add("samsung");
		dict.add("sam");
		dict.add("sung");
		WordBreakProblem wp = new WordBreakProblem();
		String input = "ilikesamsung";
		boolean x = wp.WordBreak(input);
		//boolean x = wp.WordBreakAll(input, "");
		//System.out.println(x);
	}
	
	private boolean WordBreak(String word){
		//System.out.println(word);
		if (word.length() == 0) 
	        return true;
		
		for(int i = 1; i <= word.length(); i++){
			if(dict.contains(word.substring(0, i))
					&& WordBreak(word.substring(i, word.length()))){
				System.out.println(word.substring(0, i));
				return true;
			}
		}
		return false;
	}
	
	private boolean WordBreakAll(String word, String result){
		//System.out.println(word);
		if (word.length() == 0) 
	        return true;
		
		for(int i = 1; i <= word.length(); i++){
			if(dict.contains(word.substring(0, i))){
				result = result + word.substring(0, i);
				if(i == word.length()){
					System.out.println(result);
					return true;
				}
				WordBreakAll(word.substring(i, word.length()), result+" ");
			}
		}
		return false;
	}
}	



