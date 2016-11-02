package chap01;

import static helpers.Printer.*;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the original
 * string, your method should return the original string.
 */
public class Q5 {
  public static String compress(String sample) {
		String result="";
		int[] array = new int[256];
		for(int i = 0; i < sample.length(); i++){
			int val = sample.charAt(i);
			array[val]++;
		}
		
		for(int i = 0; i < sample.length(); i++){
			int val = sample.charAt(i);
			if(!result.contains(""+sample.charAt(i))){
				result = result+sample.charAt(i)+array[val];
			}

		}

		return result;
	}

    //TEST----------------------------------
    public static void main(String[] args) {
        println(compress("aabcccccaaa"));
        println(compress("aabbcc"));
        println(compress("aaaaaaaaaaaaaaaaaaaaa"));
        println(compress("abcdefg"));
        println(compress("a"));
    }
}
