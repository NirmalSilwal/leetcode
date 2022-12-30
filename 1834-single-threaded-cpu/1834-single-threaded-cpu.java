class Solution {    
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        Task[] taskWithIndex = new Task[n];
        
        for (int i = 0; i < n; i++) {
            taskWithIndex[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        Arrays.sort(taskWithIndex, (a, b) -> a.enqueueTime - b.enqueueTime);
        // Arrays.sort(taskWithIndex, (a, b) -> {
        //     return Integer.compare(a.enqueueTime, b.enqueueTime);
        // });
        
        PriorityQueue<Task> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.processingTime == b.processingTime) 
                return Integer.compare(a.index, b.index);
            return Integer.compare(a.processingTime, b.processingTime);
        });
        
        int[] ans = new int[n];
        int ansIndex = 0;
        int taskIndex = 0; // task being processed
        int currentTime = 0;
        
        while (ansIndex < n) {
            
            while (taskIndex < n && taskWithIndex[taskIndex].enqueueTime <= currentTime) {
                minHeap.add(taskWithIndex[taskIndex++]);
            }
            
            if (minHeap.isEmpty()) {
                currentTime = taskWithIndex[taskIndex].enqueueTime;
            } else {
                currentTime += minHeap.peek().processingTime;
                ans[ansIndex++] = minHeap.poll().index;
            }
        }
        
        return ans;
    }
    
    class Task {
        int index;
        int enqueueTime;
        int processingTime;

        public Task(int idx, int enq, int proc) {
            this.index = idx;
            this.enqueueTime = enq;
            this.processingTime = proc;
        }
    }
}