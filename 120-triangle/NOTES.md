first approach - **WRONG ANSWER**
​
```
public int minimumTotal(List<List<Integer>> triangle) {
if (triangle.size() == 1) {
return triangle.get(0).get(0);
}
int sum = triangle.get(0).get(0);
int prevIndex = 0;
for (int i = 1; i < triangle.size(); i++) {
List<Integer> currentList = triangle.get(i);
int ith = currentList.get(prevIndex);
int ithplusone = currentList.get(prevIndex + 1);
if (ith < ithplusone) {
sum += ith;
} else {
prevIndex++;
sum += ithplusone;
}
}
return sum;
}
```