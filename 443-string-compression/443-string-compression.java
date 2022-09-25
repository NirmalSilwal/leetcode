class Solution {
    public int compress(char[] chars) {
     
        StringBuilder sb = new StringBuilder(chars[0]+"");

        int count = 1;
        
        for (int i = 1; i < chars.length; i++) {
            char curr = chars[i], prev = chars[i - 1];    
            
            if (curr == prev) {
                count++;
            } else {          
            // if nebhoring character are different, store previous result
            int oldcount = count;
            if (count >= 10) {  
                int totaltens = 0, tens = 0;
                while (count > 0) {
                    tens++;
                    if (tens == 10) {
                        totaltens++;
                        tens = 0;
                    }
                    count--;
                }  
                sb.append(totaltens+"");
                int val = oldcount - (totaltens * 10);
                sb.append(val+"");
                count = 1;
            }     
             else if (count > 1) {
                sb.append(count); // add count of current character
                count = 1; // reset counter for next character counts
            } 
                // if group's length is 1
                sb.append(curr);
            }
        }

        int oldcount = count;
        if (count >= 10) {  
            int totaltens = 0, tens = 0;
            while (count > 0) {
                tens++;
                if (tens == 10) {
                    totaltens++;
                    tens = 0;
                }
                count--;
            }  
            sb.append(totaltens+"");
            int val = oldcount - (totaltens * 10);
            sb.append(val+"");
            count = 1;
        }     
         else if (count > 1) {
            sb.append(count); // add count of current character
            count = 1; // reset counter for next character counts
        }
          
        String str = sb.toString();
        int idx = 0;
        while(idx<str.length()){
            chars[idx] = str.charAt(idx);
            idx++;
        }
        return str.length();
    }
}