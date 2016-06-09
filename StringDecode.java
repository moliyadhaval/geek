/* package whatever; // don't place package name! */

/*
You are given a string "abc" which is encoded like "123" where alphabets are mapped like a => 1 to z => 26. Now find out how many string can be formed by reverse engineering encode string "123". 

For ex. given string "123" we can form 3 string "abc"(1,2,3), "lc" (i.e 12,3), "aw"(1,23).

for string "1234" we have following possible combinations, I might be missing some of them but you get the idea

{12, 3, 4}
{1, 23, 4}
{1, 2, 3, 4}

below solution doesnt handle edge case of '0' - i.g. zero
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static char[] arr={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public static int process(String s, String aux, int index){
		int len = s.length();
		if(len == index){
			System.out.println(aux+arr[Character.getNumericValue(s.charAt(index-1))-1]);
			return 1;
		} else if(len == index-1){
			return process(s, aux+arr[Character.getNumericValue(s.charAt(index-1))-1] ,index+1);
		}else{
			int c = Integer.parseInt(s.substring(index-1, index+1));
			if(c > 26){
				return process(s, aux+arr[Character.getNumericValue(s.charAt(index-1))-1] ,index+1);
			} else{
				return process(s, aux+arr[Character.getNumericValue(s.charAt(index-1))-1] ,index+1) +
						process(s, aux+arr[c-1] ,index+2);
			}
		}
		//return 0;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		System.out.println(process("1234", "", 1));
	}
}
