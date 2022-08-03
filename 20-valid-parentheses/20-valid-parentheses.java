class Solution {
    // idea- push in stack for open paranthesis and pop for closed ones
    
    public boolean isValid(String s) {
        
        if (s == null || s.length() < 1) return false;
        
        char ch1 = s.charAt(0);
        if (ch1 == ')' || ch1 == '}' || ch1 == ']') return false;
                
        Stack<Character> stack = new Stack<>();
        
        for (Character ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); // push opening paranthesis in the stack
            
            } else {
                if (!stack.empty()) {

                    char top = stack.peek();

        if ( (ch == ')' && top == '(' ) || (ch == '}' && top == '{' ) || (ch == ']' && top == '[' ) ) {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                } else return false; // if stack is already empty and you get closing paranthesis
            }
            
        }
        
        if (!stack.empty()) return false;
        
        return true;
    }
}