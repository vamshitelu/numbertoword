package com.example.numbertoword;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NumberToWord {

	public static final String THOUSAND = "Thousand";
	public static final String MILLION = "Million";
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		 System.out.print("Enter the value :");
		String number = reader.readLine();
		
		//String number =  ""435345;
		
		boolean status = validateNumber(number);
		
		if(status) {
			convertToWord(number);
		}else {
			throw new Exception("Given string is not a numeric string.");
		}
	}
	
	/**
	 * Validate given string contains only numbers
	 * @param number
	 * @return
	 */
	public static boolean validateNumber(String number) {
		
		return (number.matches("[0-9]+") && number.length() > 0);
	}
	/**
	 * Convert given number to word
	 * @param number
	 */
	
	private static void convertToWord(String number) {
		
		String result = "";
		
		char[] numberArr = number.toCharArray();
		
		int remainder = numberArr.length / 3;
		
		int divided = numberArr.length % 3;
		
		int j =0;
		
		if(remainder == 3 && divided == 0) {
			remainder --;
		}else if(remainder == 2 && divided == 0) {
			remainder --;
		}
		
		for(int a = remainder; a > 0; a--) {
			
			if(a >= 0 && numberArr.length > 3) {
				
				int leng = 0;
				
				if(divided == 0) {
					leng = 3;
				}else if(divided == 1) {
					leng = 1;
				}else if(divided == 2) {
					leng = 2;
				}
				
				for(int i= leng; leng > 0; leng --) {
					if(leng == 3) {
						result += firstPosToWord(convertCharToInt(numberArr[j])) + " Hundrad and ";
					}
					
					if(leng == 1) {
						result += firstPosToWord(convertCharToInt(numberArr[j]))+ " ";
					}
					
					if(leng == 2) {
						result += secondPosToWord(convertCharToInt(numberArr[j]))+ " ";
					}
					j++;
				}
			}
			
			if(a == 1 && number.length() > 3) {
				result += NumberToWord.THOUSAND+" ";
			}else if(a ==2 && number.length() > 6) {
				result += NumberToWord.MILLION+" ";
			}
			divided = 0;
		}
		
		result += convertToHundard(numberArr);
		
		System.out.println(result);
	}
	
	/**
	 * Convert hundrad position to word
	 * @param numberArr
	 * @return string
	 */
	private static String convertToHundard(char[] numberArr) {

		String result = "";
		
		int length = numberArr.length;
		
		for(int k =0; k < numberArr.length; k++) {
			
			if(length == 3) {
				result+= firstPosToWord(convertCharToInt(numberArr[k]))+" Hundard and ";
			}
			
			if(length == 2) {
				result += secondPosToWord(convertCharToInt(numberArr[k]))+" ";
			}
			
			if(length == 1) {
				result += firstPosToWord(convertCharToInt(numberArr[k]))+" ";
			}
			length --;
			
		}
		
		return result;
	}

	/**
	 * Convert character to int value
	 * @param a
	 * @return int
	 */
	private static int convertCharToInt(char a) {
		return Character.getNumericValue(a);
	}
	/**
	 * Get the first position in number(1 - 9) in words
	 * @param n
	 * @return string
	 */
	private static String firstPosToWord(int n) {
		
		Map<Integer,String> firstPlaceWord = new HashMap<>();
		
		firstPlaceWord.put(1, "One");
		firstPlaceWord.put(2, "Two");
		firstPlaceWord.put(3,  "Three");
		firstPlaceWord.put(4, "Four");
		firstPlaceWord.put(5, "Five");
		firstPlaceWord.put(6, "Six");
		firstPlaceWord.put(7, "Seven");
		firstPlaceWord.put(8, "Eight");
		firstPlaceWord.put(9, "Nine");
		firstPlaceWord.put(0, "");
		
		return firstPlaceWord.get(n);
	}
	
	/**
	 * Get the second position in number(20 - 90) in words
	 * @param n
	 * @return string
	 */
	private static String secondPosToWord(int n) {
		
		Map<Integer,String> secondPlaceWord = new HashMap<>();
		
		secondPlaceWord.put(1, "Ten");
		secondPlaceWord.put(2, "Twenty");
		secondPlaceWord.put(3, "Thirty");
		secondPlaceWord.put(4, "Fourty");
		secondPlaceWord.put(5, "Fifty");
		secondPlaceWord.put(6, "Sixty");
		secondPlaceWord.put(7, "Seventy");
		secondPlaceWord.put(8, "Eighty");
		secondPlaceWord.put(9, "Ninty");
		return secondPlaceWord.get(n);
		
	}

}
