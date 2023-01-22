class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<String>(), result);
        return result;
    }

    private void helper(String s, int pos, List<String> current, List<List<String>> result) {
        if (pos == s.length()) {
            if (current.size() > 0) {
                result.add(new ArrayList<>(current));
                return;
            }
            return;
        }
       
        for (int idx = pos; idx < s.length(); idx++) {
            
            if (isPalindrome(s, pos, idx)) {

                current.add(s.substring(pos, idx + 1));
                helper(s, idx + 1, current, result);
                // backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}