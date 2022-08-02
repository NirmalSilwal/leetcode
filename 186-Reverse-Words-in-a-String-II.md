![Leetcode 186](https://user-images.githubusercontent.com/31946761/182474764-129b7649-d268-49aa-b740-6760789a7eb5.jpg)

```

// my approach with 2ms runtime in leetcode submission

class Solution {
    public void reverseWords(char[] s) {
        
        // let's first reverse array with two pointer and 
        // later reverse each word starting from 1st index
        
        int low = 0, high = s.length - 1;
        
        reverseChars(s, low, high);

        // now reversing each word from beginning till space is found
        
        int start = 0;
        int ptr = 0; // to track current word till space is found
        int wordStartIndex = 0;

        while (start != s.length) {
            if (s[start] != ' ') {
                if (wordStartIndex == -1) {
                    wordStartIndex = start;
                }
                ptr++;
                start++;
                continue;
            }
            
            low = wordStartIndex;
            high = ptr - 1;

            reverseChars(s, low, high);
            
            wordStartIndex = -1;
            start++;
            ptr++;
        }
        
        // last word is left after loop terminates
        low = wordStartIndex;
        high = ptr - 1;

        reverseChars(s, low, high);
    }
    
    private void reverseChars(char[] s, int low, int high) {
        while (low <= high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;

            low++;
            high--;
        }        
    }
}
```
