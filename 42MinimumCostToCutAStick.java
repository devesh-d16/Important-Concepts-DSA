// Given a wooden stick of length n units. The stick is labelled from 0 to n. 
// For example, a stick of length 6 is labelled as follows:
// Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
// You should perform the cuts in order, you can change the order of the cuts as you wish.
// The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts.
// When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). 
// Please refer to the first example for a better explanation.
// Return the minimum total cost of the cuts.

// Memoization
// TC - O(N^2 * N)
// SC - O(N^2) + Stack Space
public int minCost(int n, int[] cuts) {
    int c = cuts.length;
    int temp[] = new int[c + 2];
    temp[0] = 0;
    temp[c + 1] = n;
    for(int i = 1; i < c + 1; i++){
        temp[i] = cuts[i - 1];
    }
    c += 2;
    Arrays.sort(temp);

    int dp[][] = new int[c + 1][c + 1];
    for(int row[] : dp){
        Arrays.fill(row, -1);
    }
    return mC(1, c - 2, temp, dp);
}

public int mC(int i, int j, int cuts[], int dp[][]){
    if(i > j){
        return 0;
    }
    if(dp[i][j] != -1){
        return dp[i][j];
    }
    int minm = Integer.MAX_VALUE;
    for(int k = i; k <= j; k++){
        int price = cuts[j + 1] - cuts[i - 1] + mC(i, k - 1, cuts, dp) + mC(k + 1, j, cuts, dp);
        minm = Math.min(minm, price);
    }
    return dp[i][j] = minm;
}

// Tabulation
// TC - O(N^2 * N)
// SC - O(N^2)
public int minCost(int n, int[] cuts) {
    int c = cuts.length;
    int temp[] = new int[c + 2];
    temp[0] = 0;
    temp[c + 1] = n;
    for(int i = 1; i < c + 1; i++){
        temp[i] = cuts[i - 1];
    }
    c += 2;
    Arrays.sort(temp);

    int dp[][] = new int[c + 1][c + 1];
    
    for(int i = c - 2; i >= 1; i--){
        for(int j = i; j <= c - 2; j++){
            int minm = Integer.MAX_VALUE;
            for(int k = i; k <= j; k++){
                int price = temp[j + 1] - temp[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                minm = Math.min(minm, price);
            }
            dp[i][j] = minm;
        }
    }
    return dp[1][c - 2];
}
