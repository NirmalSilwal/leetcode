class Solution {
     // 1st approach - using two pointers
    /*
    public String reverseWords(String s) {
        
        // replace two or more spaces with single space, then trim leading/trailing space and split 
       
       String[] arr = s.replaceAll("\\s{2,}", " ").trim().split(" ");
        
       int low = 0, high = arr.length - 1;
        
        while(low < high) {
            String temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            
            low++; 
            high--;
        }
        
        String result = String.join(" ", arr);
        
        return result.trim();
    }
    */
    
    // 2nd approach -  using Collections reverse functionality
    public String reverseWords(String s) {
        
        String[] words = s.trim().split(" +");
        
        Collections.reverse(Arrays.asList(words));
        
        return String.join(" ", words);
    }
}