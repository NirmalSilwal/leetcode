// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        findSubsets(arr, 0, N, 0, answer);
        
        Collections.sort(answer);
        
        return answer;
    }
    
    private void findSubsets(ArrayList<Integer> arr, int index, int N, int currentSum, ArrayList<Integer> answer) {
        if (index == N) {
            answer.add(currentSum);
            return;
        }
        
        // take
        currentSum += arr.get(index);
        findSubsets(arr, index+1, N, currentSum, answer);
        
        // not take
        currentSum -= arr.get(index);
        findSubsets(arr, index+1, N, currentSum, answer);

    }
}