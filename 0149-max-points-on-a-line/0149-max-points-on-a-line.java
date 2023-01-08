class Solution {
    public int maxPoints(int[][] points) {
        
        int n = points.length; 
        if (n <= 2) return n;
        
        int max = 2;
        
        // (x1, y1) point
        for (int i = 0; i < n; i++) {
            // test for every possible two points as edge points
            // so that we find slope of 3rd point and compare with these two edge points slope
            
            for (int j = i + 1; j < n; j++) { // (x2, y2) point
                
                int currMax = 2; // for i and jth points
                
                // see all these 3rd point (x3, y3) have same slope as edge point
                for (int k = 0; k < n; k++) {
                                    
                    // now checking every other points rather that those two edge points
                    if (k != i && k != j) {
                       
                        // using this formula ( (y2 - y1) * (x3 - x1) ) == ((x2 - x1) * (y3 - y1))
                        
                        if (((points[j][1] - points[i][1]) * (points[k][0] - points[i][0])) ==
                             ((points[j][0] - points[i][0]) * (points[k][1] - points[i][1]))) {
                            
                            currMax++;
                        }
                    }
                }
                
                max = Math.max(currMax, max);
            }
        }
        
        return max;
    }
}

/* idea

using concept of slope in a line
if two points have same slope in xy coordinates, they lie in same st.line

for three points, (x1, y1), (x2, y2), (x3, y3) let's consider
two edge points be (x1, y1), (x2, y2) and we check if (x3, y3)
lie in same line by calculating and comparing their slopes

(y2 - y1 / x2 - x1) == (y3 - y1 / x3 - x1)

while dividing the digits get truncated so we do cross multiplication and solve
as follows

( (y2 - y1) * (x3 - x1) ) == ((x2 - x1) * (y3 - y1))
*/