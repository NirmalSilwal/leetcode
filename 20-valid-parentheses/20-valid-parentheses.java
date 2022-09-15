class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;
                char curr = stack.pop();
                
                if ((ch == ')' && curr == '(') || (ch == '}' && curr == '{') || (ch == ']' && curr == '[') )
                    continue;
                else
                    return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }
}