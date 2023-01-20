**first thought process**
```
public List<List<Integer>> findSubsequences(int[] nums) {
Set<List<Integer>> result = new HashSet<>();
for (int i = 0; i < nums.length; i++) {
for (int j = i + 1; j < nums.length; j++) {
List<Integer> temp = new ArrayList<>();
temp.add(nums[i]);
for (int k = i + 1; k <= j; k++) {
if (nums[k] >= temp.get(temp.size() - 1))
temp.add(nums[k]);
}
if (temp.size() > 1)
result.add(new ArrayList<>(temp));
}
}
return new ArrayList<>(result);
}
```