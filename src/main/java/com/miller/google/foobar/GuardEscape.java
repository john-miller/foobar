package com.miller.google.foobar;

public class GuardEscape {
    
	/**
	 * Adds the digits in a number together recursively until
	 * 
	 * @param x
	 * @return
	 */
    public static int answer(int x) {
    	
    	/* Convert number to character array */
    	char[] numbers = String.valueOf(x).toCharArray();
    	
    	/* Sum the character arrays by parsing them from strings */
    	int sum = 0;
    	for(char number : numbers) 
    		sum += Integer.parseInt(String.valueOf(number));
    	
    	/* return when the sum is less that 10 */
    	if(sum < 10)
    		return sum;
    	
    	/* Otherwise recall the function */
    	else
    		return answer(sum);
    }
}
