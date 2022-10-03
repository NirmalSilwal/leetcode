class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> paren = new ArrayList<>();
    
        helper(paren, n, 0, 0, new StringBuilder());
        
        return paren;
    }
    
    private void helper(List<String> paren, int n, int opened, int closed, StringBuilder sb) {
        
        if (closed > opened) return;
        
        if (opened == closed && sb.length() == 2 * n) {
            paren.add(sb.toString());
            return;
        }
        
        if (opened < n) {
            sb.append("(");
            helper(paren, n, opened + 1, closed, sb);
            // backtrack
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (closed < n) {
            sb.append(")");
            helper(paren, n, opened, closed + 1, sb);
            // backtrack
            sb.deleteCharAt(sb.length() - 1);    
        }
    }
}