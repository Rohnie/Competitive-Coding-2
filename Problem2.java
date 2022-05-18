// Time Complexity : O(c*n)
// Space Complexity : O(c*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
       int[] w={1, 2, 3, 4};
       int[] v={10, 15, 40, 100};
       int c=6;
       int[][] dp = new int[w.length+1][c+1];
        //Initialize dummy row with '0' since the maximum value that can be robbed with weight=value=0 is '0'
        for(int j=0; j<dp[0].length; j++){
            dp[0][j]=0;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
            //if the weight of the element > capacity, then the maximum value than can robbed is the max value that can be robbed without choosing that element (i.e dp[i-1][j]);
            if(w[i-1]>j){
                dp[i][j]=dp[i-1][j];
            }
            //if the weight of the element = capacity, then the maximum value than can robbed is the maximum of either the max value that can be robbed without choosing that element (i.e dp[i-1][j]) or by choosing that element only (i.e v[i-1]);
            else if(w[i-1]==j){
                dp[i][j]=Math.max(dp[i-1][j], v[i-1]);
            }
            //if the weight of the element < capacity, then the maximum value than can robbed is the maximum of either the max value that can be robbed without choosing that element (i.e dp[i-1][j]) or the sum of the value of the choosen element (i.e v[i-1]) and the max amount that can robbed without choosing that element having capacity = capacity - weight of the choosen element (i.e dp[i-1][j-w[i-1]])
            else{
                dp[i][j]=Math.max(dp[i-1][j], v[i-1]+dp[i-1][j-w[i-1]]);
            }
            }
        }
        //Finally print the max amount robbed with max capacity and max elements
        System.out.println(dp[w.length][c]);
        //To print Array
        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length; j++){
        //         System.out.print(dp[i][j]);
        //         System.out.print(" ");
        //     }
        //     System.out.println();
        // }
    }
}
