**First try**
```
public int maxEnvelopes(int[][] envelopes) {
if (envelopes.length <= 1) return 1;
int max = 1;
for (int i = 0; i < envelopes.length; i++) {
​
int currLen = 1;
int currWidth = envelopes[i][0];
int currHeight = envelopes[i][1];
for (int j = i+1; j < envelopes.length; j++){
if (envelopes[j][0] < currWidth && envelopes[j][1] < currHeight){
currLen++;
}
max = Math.max(max, currLen);
}
for (int k = 0; k < i; k++){
if (envelopes[k][0] < currWidth && envelopes[k][1] < currHeight){
currLen++;
}
max = Math.max(max, currLen);
}
}
return max;
}
```