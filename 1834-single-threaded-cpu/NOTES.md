// 1st draft
`class Solution {
class Task {
int enqueueTime;
int processingTime;
public Task(int enq, int proc) {
this.enqueueTime = enq;
this.processingTime = proc;
}
}
public int[] getOrder(int[][] tasks) {
Map<Task, Integer> map = new HashMap<>();
for (int i = 0; i < tasks.length; i++) {
Task currentTask = new Task(tasks[i][0], tasks[i][1]);
map.put(currentTask, i);
}
Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
for (int[] t : tasks) {
System.out.print(Arrays.toString(t) + " ");
}
return null;
}
}`