class Solution {
    public List<String> restoreIpAddresses(String s) {
       
        int n = s.length();
        List<String> ips = new ArrayList<>();        
        
        if (n < 4 || n > 12) return ips;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= 3; i++) { // length of network id part1
           
            for (int j = 1; j <= 3; j++) { // network id part2
            
                for (int k = 1; k <= 3; k++) { // network id part3
                  
                    int host = n - i - j - k; // host length
                    
                    if (host >= 1 && host <= 3) {
                        // trying all valid length of each sub network and host id
                        int net1 = Integer.parseInt(s.substring(0, i));
                        int net2 = Integer.parseInt(s.substring(i, i + j));
                        int net3 = Integer.parseInt(s.substring(i + j, i + j + k));
                        int net4 = Integer.parseInt(s.substring(i + j + k));
                        
                        // see if they are in range 0 - 255
                        if (net1 <= 255 && net2 <= 255 && net3 <= 255 && net4 <= 255) {
                            
                            // form the one valid ip address now
                                sb.append(net1).append(".").append(net2).append(".").append(net3).append(".")
                                    .append(net4);
                            
                            // check for leading zero case
                            if (sb.length() == n + 3) { // +3 for three dots we inserted
                                ips.add(sb.toString());
                            }
                            sb = new StringBuilder();
                        }
                    }
                }
            }
        }
        
        return ips;
    }
}