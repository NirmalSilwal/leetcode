class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack();
        int currNum = 0;
        int sign = 1;
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';
            }
            
            if (!Character.isDigit(ch) && ch != ' ') {
                
                if (ch == '+' || ch == '-') {
                    result += currNum * sign;
                    currNum = 0;
                    sign = ch == '-' ? -1 : 1;
                }
                
                else if (ch == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0; // reset for current paranthesis calculation, previous result was stored in stack
                    sign = 1;
                } 
                
                else if (ch == ')') {
                    result += currNum * sign; // add currently captured number also
                    currNum = 0;
                    result *= stack.pop(); // pop and multiply with sign for this current paranthesis first
                    result += stack.pop(); // add previous result
                }
            }
        }
        
        if (currNum != 0) result += currNum * sign;
        
        return result;
    }
}