class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        char prevOperator = '+';
        int currNum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }
            
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                
                if (prevOperator == '+') {
                    stack.push(currNum);
                }
                else if (prevOperator == '-') {
                    stack.push(-currNum);
                }
                else if (prevOperator == '*') {
                    stack.push(stack.pop() * currNum);
                }
                else {
                    stack.push(stack.pop() / currNum);
                }
                currNum = 0;
                prevOperator = ch; // current character is operator
            }
        }
        
        // now adding all elements in stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}