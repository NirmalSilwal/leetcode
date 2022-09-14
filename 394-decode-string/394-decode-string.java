class Solution {
    // approach 1 - using two Stacks
    public String decodeString(String s) {
        
        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        int ptr = 0;
        String result = "";
        
        while (ptr < s.length()) {
            char curr = s.charAt(ptr);
            
            if (Character.isDigit(curr)) {
                int num = 0; // iterate till that number ends, like 3435[aa]
                while (Character.isDigit(s.charAt(ptr))) {
                    num = num * 10 + s.charAt(ptr) - '0';
                    ptr++;
                }
                intStack.push(num);
                
            } else if (curr == '[') {
                strStack.push(result);
                result = "";
                ptr++;
                
            } else if (curr == ']') {
                StringBuilder sb = new StringBuilder(strStack.pop());
                int count = intStack.pop();
                while (count-- > 0) {
                   sb.append(result); 
                }
                result = sb.toString();
                ptr++;
                
            } else {
                // if alphabets
                result += curr; // append current character to result
                ptr++; // move to next index in given string
            }
        }
        
        return result;
    }
}