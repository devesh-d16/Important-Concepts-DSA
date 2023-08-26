// Given an array ‘ARR’, partition it into two subsets (possibly empty) such that their union is the original array. 
// Let the sum of the elements of these two subsets be ‘S1’ and ‘S2’.
// Given a difference ‘D’, count the number of partitions in which ‘S1’ is greater than or equal to ‘S2’ and the difference between ‘S1’ and ‘S2’ is equal to ‘D’. 
// Since the answer may be too large, return it modulo ‘10^9 + 7’.

// If ‘Pi_Sj’ denotes the Subset ‘j’ for Partition ‘i’. Then, two partitions P1 and P2 are considered different if:
// 1) P1_S1 != P2_S1 i.e, at least one of the elements of P1_S1 is different from P2_S2.
// 2) P1_S1 == P2_S2, but the indices set represented by P1_S1 is not equal to the indices set of P2_S2. 
// Here, the indices set of P1_S1 is formed by taking the indices of the elements from which the subset is formed.
// Refer to the example below for clarification.
// Note that the sum of the elements of an empty subset is 0.

// Memoization
// TC - O(N * target)
// SC - O(N * target) + O(N)
static int mod =(int)(Math.pow(10,9)+7);
static int countPartitionsUtil(int ind, int target,int[] arr, int[][] dp){

     if(ind == 0){
        if(target==0 && arr[0]==0)
            return 2;
        if(target==0 || target == arr[0])
            return 1;
        return 0;
    }
    
    if(dp[ind][target]!=-1)
        return dp[ind][target];
        
    int notTaken = countPartitionsUtil(ind-1,target,arr,dp);
    
    int taken = 0;
    if(arr[ind]<=target)
        taken = countPartitionsUtil(ind-1,target-arr[ind],arr,dp);
        
    return dp[ind][target]= (notTaken + taken)%mod;
}

static int countPartitions(int d,int[] arr){
    int n = arr.length;
    int totSum = 0;
    for(int i=0; i<arr.length;i++){
        totSum += arr[i];
    }
    
    //Checking for edge cases
    if(totSum-d<0) return 0;
    if((totSum-d)%2==1) return 0;
    
    int s2 = (totSum-d)/2;
    
    int dp[][] = new int[n][s2+1];
    
    for(int row[]: dp)
    Arrays.fill(row,-1);
    
    return countPartitionsUtil(n-1,s2,arr,dp);
}

// Tabulation
// TC - O(N * target)
// SC - O(N * target)
static int mod =(int)(Math.pow(10,9)+7);

static int findWays(int[] num, int tar){
     int n = num.length;

    int dp[][] = new int[n][tar+1];
    
    if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
    else dp[0][0] = 1;  // 1 case - not pick
    
    if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;  // 1 case -pick
    
    for(int ind = 1; ind<n; ind++){
        for(int target= 0; target<=tar; target++){
            
            int notTaken = dp[ind-1][target];
    
            int taken = 0;
                if(num[ind]<=target)
                    taken = dp[ind-1][target-num[ind]];
        
            dp[ind][target]= (notTaken + taken)%mod;
        }
    }
    return dp[n-1][tar];
}

static int countPartitions(int n, int d,int[] arr){
    int totSum = 0;
    for(int i=0; i<n;i++){
        totSum += arr[i];
    }
    
    //Checking for edge cases
    if(totSum-d <0 || (totSum-d)%2==1 ) return 0;
    
    return findWays(arr,(totSum-d)/2);
}

// Space Optimization
// TC - O(N * target)
// SC - O(target)
static int mod =(int)(Math.pow(10,9)+7);

static int findWays(int[] num, int tar){
     int n = num.length;

    int prev[] = new int[tar+1];
    
    if(num[0] == 0) prev[0] =2;  // 2 cases -pick and not pick
    else prev[0] = 1;  // 1 case - not pick
    
    if(num[0]!=0 && num[0]<=tar) prev[num[0]] = 1;  // 1 case -pick
    
    for(int ind = 1; ind<n; ind++){
        int cur[]=new int[tar+1];
        for(int target= 0; target<=tar; target++){
            int notTaken = prev[target];
    
            int taken = 0;
                if(num[ind]<=target)
                    taken = prev[target-num[ind]];
        
            cur[target]= (notTaken + taken)%mod;
        }
        prev = cur;
    }
    return prev[tar];
}

static int countPartitions(int n, int d,int[] arr){
    int totSum = 0;
    for(int i=0; i<n;i++){
        totSum += arr[i];
    }
    
    //Checking for edge cases
    if(totSum-d <0 || (totSum-d)%2 ==1) return 0;
    
    return findWays(arr,(totSum-d)/2);
}
