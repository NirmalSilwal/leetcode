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
    /*
    public String reverseWords(String s) {
        
        String[] words = s.trim().split(" +");
        
        Collections.reverse(Arrays.asList(words));
        
        return String.join(" ", words);
    }
    */
    
    // 3rd approach
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            
            // if space is found, keep moving pointer i
            if (s.charAt(i) == ' ') continue;
            
            // now since we encounter some character rather than space, we track this as start index
            int start = i;
            
            // now tracking where our word ends till next space is found, 
            // as our start of word is tracked by start pointer, now end of word will be tracked by i
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            
            // now word is found, so add in our result - but for 1st word result will be empty 
            // remember - our word is in position from start to i position like we calculated above
            if (result.length() == 0) {
                result.insert(0, s.substring(start, i));
            } else {
                // initially add one space in front of result and then add new word
                result.insert(0, " ");
                result.insert(0, s.substring(start, i));
            }
        }
        
        return result.toString();
    }
}