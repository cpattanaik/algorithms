package com.cpattanaik.algorithm.replace;
/**
 * 
 */

/**
 * @author c0p00fy
 *
 */
public class ReplaceAString {
	public static void main(String[] args) {
		String input = "xxforxx";
		String rOld = "xx";
		String rNew =  "geeks";
		replace(input, rOld, rNew);
	}

	/**
	 * @param input
	 * @param rOld
	 * @param rNew
	 */
	private static void replace(String input, String rOld, String rNew) {
		StringBuffer newStr = new StringBuffer();
		int i = 0;
		while(i <= input.length()-rOld.length()){
			if(input.substring(i, i+rOld.length()).equals(rOld)){
				newStr.append(rNew);
				i=i+rOld.length();
			}else{
				newStr.append(String.valueOf(input.charAt(i)));
				i++;
			}
		}
		newStr.append(input.substring(i, input.length()));
		System.out.println(newStr.toString());
	}
		
}
