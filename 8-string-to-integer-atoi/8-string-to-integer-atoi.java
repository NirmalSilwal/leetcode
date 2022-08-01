class Solution {
    // note: be careful with 3rd test condition
    
    public int myAtoi(String s) {
        
        int result = 0;
        boolean isNegative = false;
        int index = 0;
        
        // ignore whitespaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
           
        if (index < s.length() && s.charAt(index) == '-') {
            isNegative = true;
            index++;
        } else if (index < s.length() && s.charAt(index) == '+') {
            index++;
        }
         
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int currVal = s.charAt(index) - '0';

            if ((Integer.MAX_VALUE - currVal) / 10 < result) {
                if (isNegative)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }

            result = result * 10 + currVal;
            index++;
        } 

        return isNegative ? (-1 * result) : result;
    }
}