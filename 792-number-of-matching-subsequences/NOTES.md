```
class Solution {
// approach 1- using recursion, but got TLE
public int numMatchingSubseq(String s, String[] words) {
Map<String,Boolean> map = new HashMap<String,Boolean>();
findSubsequences(0, "", s, map);
int count = 0;
for (String word : words) {
if (map.containsKey(word))
count++;
}
return count;
}
private void findSubsequences(int index, String ans, String s, Map<String,Boolean> subseqMap) {
if (index == s.length()) {
subseqMap.put(ans, true);
return;
}
ans = ans + s.charAt(index);
// take current index character