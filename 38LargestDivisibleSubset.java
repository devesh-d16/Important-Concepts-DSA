// Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
// answer[i] % answer[j] == 0, or
// answer[j] % answer[i] == 0
// If there are multiple solutions, return any of them.

// TC - O(N*N)
// SC - O(N)
public List<Integer> largestDivisibleSubset(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    int dp[] = new int[n];
    Arrays.fill(dp, 1);

    int hash[] = new int[n];
    int maxm = 1;
    int last_idx = 0;

    for(int i = 0; i < n; i++){
        hash[i] = i;
        for(int j = 0; j < i; j++){
            if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]){
                dp[i] = 1 + dp[j];
                hash[i] = j;
            }
        }
        if(dp[i] > maxm){
            maxm = dp[i];
            last_idx = i;
        }
    }

    List<Integer> list = new ArrayList<>();
    list.add(nums[last_idx]);
    while(hash[last_idx] != last_idx){
        last_idx = hash[last_idx];
        list.add(nums[last_idx]);
    }
    return list;
}
