**1st thought draft but it's not correct**
```
class Solution {
public String addBinary(String a, String b) {
int pos1 = b.length() - 1;
int pos2 = a.length() - 1;
int carry = 0;
StringBuilder sb = new StringBuilder();
while (pos1 >= 0 || pos2 >= 0) {
int val1 = (pos1 >= 0) ? Integer.valueOf(a.charAt(pos1)+"") : 0;
int val2 = (pos2 >= 0) ? Integer.valueOf(a.charAt(pos2)+"") : 0;
​
int currentSum = 0;
if (val1 == 1 && val2 == 1) {
if (carry == 1){
currentSum = 1;
carry = 0;
}
else {
currentSum = 0;
carry = 1;
}
}
else if (val1 == 0 && val2 == 1 || val1 == 1 && val2 == 0) {
if (carry == 1){
currentSum = 1;
carry = 1;
}
else {
currentSum = 1;
carry = 0;
--------