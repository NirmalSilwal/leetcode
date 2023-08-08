class Solution {
    public int lengthOfLastWord(String s) {
        String trimmed = s.trim();
        String[] splits = trimmed.split(" ");
        return splits[splits.length - 1].length();
    }
}