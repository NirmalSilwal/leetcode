**brute force - 140 / 140 test cases passed, but took too long**
​
```
class Solution {
public String longestPalindrome(String s) {
// find all combinations and check
int maxlen = 0;
String result = "";
for (int i = 0; i < s.length(); i++) {
for (int j = i; j < s.length(); j++) {
if (isPalindrome(s, i, j)) {
String palindromeStr = s.substring(i, j+1);
if (palindromeStr.length()  > maxlen) {
maxlen = palindromeStr.length();
result = s.substring(i, j+1);
}
}
}
}
return result;
}
private boolean isPalindrome(String s, int i, int j) {
int low = i, high = j;
while (low < high) {
if (s.charAt(low) != s.charAt(high))
return false;
low++;
high--;
}
return true;
}
}
```