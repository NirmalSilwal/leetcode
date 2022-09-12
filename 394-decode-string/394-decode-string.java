class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        StringBuilder sb = new StringBuilder(); // hold temporary string
        int num = 0;
        
        for (char ch : s.toCharArray()) {
            // 4 types of character - digits, alphabets, open and closed brackets
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
                          
            } else if (ch == '[') {
                strStack.push(sb);    
                sb = new StringBuilder();
                
                numStack.push(num);
                num = 0;
                
            } else if (ch == ']') {
                StringBuilder temp = sb;
                sb = strStack.pop();
                int count = numStack.pop();
                
                while (count-- > 0) {
                    sb.append(temp);
                }
            
            } else {
                // if it is a character 
                sb.append(ch);
            }
        }
     
        return sb.toString();
    }
}