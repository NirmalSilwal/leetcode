to check if string is valid parenthesis
​
```
private boolean isValidParanthesis(String str) {
if (str.length == 0) return true;
Stack<Character> stack = new Stack<>();
boolean valid = false;
for (char ch : str.toCharArray()){
if (ch == '(')
stack.push('(');
else {
if (stack.isEmpty())
return false;
char top = stack.pop();
if (top == '('){
valid = true;
}
}
}
if (!stack.isEmpty()) valid = false;
return valid;
}
```