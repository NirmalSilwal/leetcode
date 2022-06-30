first draft of thoughts from combination sum 1 problem -
​
**TLE solution**
```
class Solution {
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
List<List<Integer>> result = new ArrayList<>();
​
Set<List<Integer>> set = new HashSet<>();
​
Arrays.sort(candidates);
findCombinations1(0, candidates, target, set, new ArrayList<>());
result.addAll(set);
return result;
}
private void findCombinations1(int index, int[] candidates, int target,  Set<List<Integer>> set, List<Integer> ds) {
if (index == candidates.length) {
if (target == 0) {
set.add(new ArrayList<>(ds));
}
findCombinations1(index + 1, candidates, target - candidates[index], set, ds); // take