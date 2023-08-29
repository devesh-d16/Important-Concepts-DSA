// Given an integer array nums, return the length of the longest strictly increasing subsequence
// 
// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

// Recursion
// TC - O(2^N)
// SC - O(N)
public int lengthOfLIS(int[] nums) {
    int n = nums.length;

    return lis(0, -1, nums, n);
}

public int lis(int idx, int prev, int nums[], int n){
    if(idx == n){
        return 0;
    }

    int len = lis(idx + 1, prev, nums, n);
    if(prev == -1 || nums[idx] > nums[prev]){
        len = Math.max(len, 1 + lis(idx + 1, idx, nums, n));
    }

    return len;
}

// Memoization
// TC - O(N*N)
// SC - O(N*N) + O(N)
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int dp[][] = new int[n][n + 1];
    for(int arr[] : dp){
        Arrays.fill(arr, -1);
    }
    return lis(0, -1, nums, n, dp);
}

public int lis(int idx, int prev, int nums[], int n, int dp[][]){
    if(idx == n){
        return 0;
    }
    if(dp[idx][prev + 1] != -1){
        return dp[idx][prev + 1];
    }

    int len = lis(idx + 1, prev, nums, n, dp);
    if(prev == -1 || nums[idx] > nums[prev]){
        len = Math.max(len, 1 + lis(idx + 1, idx, nums, n, dp));
    }

    return dp[idx][prev + 1] = len;
}

// Tabulation
// TC - O(N*N)
// SC - O(N*N)

public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int dp[][] = new int[n + 1][n + 1];
    for(int i = n - 1; i >= 0; i--){
        for(int j = i - 1; j >= -1; j--){
            int len = dp[i + 1][j + 1];
            if(j == -1 || nums[i] > nums[j]){
                len = Math.max(len, 1 + dp[i + 1][i + 1]);
            }

            dp[i][j + 1] = len;
        }
    }
    return dp[0][-1 +1];
}

// Space Optimization
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int next[] = new int[n + 1];
    int curr[] = new int[n + 1];
    for(int i = n - 1; i >= 0; i--){
        for(int j = i - 1; j >= -1; j--){
            int len = next[j + 1];
            if(j == -1 || nums[i] > nums[j]){
                len = Math.max(len, 1 + next[i + 1]);
            }

            curr[j + 1] = len;
        }
        next = curr;
    }
    return next[-1 + 1];
}

// Another Method - (required to trace back the lis)
// TC - O(N*N)
// SC - O(N)
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n];
    Arrays.fill(dp, 1);

    int maxm = 1;
    for(int i = 0; i < n; i++){
        for(int prev = 0; prev < i; prev++){
            if(nums[prev] < nums[i]){
                dp[i] = Math.max(dp[i], 1 + dp[prev]);
            }
        }
        maxm = Math.max(maxm, dp[i]);
    }
    return maxm;
}

// Print the lis
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n];
    Arrays.fill(dp, 1);

    int hash[] = new int[n];

    int maxm = 1;
    int last_idx = 0;
    for(int i = 0; i < n; i++){
        hash[i] = i;
        for(int prev = 0; prev < i; prev++){
            if(nums[prev] < nums[i] && 1 + dp[prev] > dp[i]){
                dp[i] = 1 + dp[prev];
                hash[i] = prev;
            }
        }
        if(dp[i] > maxm){
            maxm = dp[i];
            last_idx = i;
        }
    }
    
    int lis[] = new int[maxm];
    lis[0] = nums[last_idx];
    int idx = 1;
    while(hash[last_idx] != last_idx){
        last_idx = hash[last_idx];
        lis[idx] = nums[last_idx];
        idx++;
    }
    return maxm;
}

// using binary search
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    ArrayList<Integer> list = new ArrayList<>();
    list.add(nums[0]);

    for(int i=1;i<n;i++){
        if(nums[i]>list.get(list.size()-1)){
            list.add(nums[i]);
        }
        else{
            list.set(upperBound(list,nums[i]),nums[i]);
        }
    }
    return list.size();
}

private int upperBound(ArrayList<Integer> list,int target){
    int i = 0;
    int j = list.size()-1;
    while(i<=j){
        int mid = (i+j)/2;

        if(list.get(mid)<=target){
            i=mid+1;
        }
        else{
            j=mid-1;
        }
    }
    return list.get(Math.max(j,0)) == target ? j : i;
}
