class Solution {
        
    String sb1;

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
            
        String result = helper(strs[0], strs[1], strs, 1);
        
        return result.length() == 0 ? "" : result;
    }
    
    // pos indicates next position in strs to be parsed
    private String helper(String s1, String s2, String[] strs, int pos) {
        if (pos == strs.length) 
            return sb1;
        
        if (s1.length() == 0 || s2.length() == 0)
            return "";
        // System.out.println("processing...");
        
        StringBuilder sb = new StringBuilder();
        
        int ptr1 = 0, ptr2 = 0;
        
        while (ptr1 < s1.length() && ptr2 < s2.length()) {
            if (s1.charAt(ptr1) == (s2.charAt(ptr2))) {
                sb.append(s1.charAt(ptr1));
                ptr1++;
                ptr2++;
            } else break;
        }
          
        // System.out.println(sb);
        sb1 = sb.toString();
        
        if (pos + 1 == strs.length)
            return sb1;
        return helper(sb.toString(), strs[pos + 1], strs, pos + 1);
    }
}