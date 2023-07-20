// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// TC - O(2^n)
// SC - O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ss(0, ans, nums, new ArrayList());
        return ans;
    }

    public void ss(int i,List<List<Integer>> ans, int nums[], List<Integer> sub){
        if(i == nums.length){
            ans.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        ss(i + 1, ans, nums, sub);
        sub.remove(sub.size() - 1);
        ss(i + 1, ans, nums, sub);
    }

// TC - O(n*2^n)
// SC - O(1)

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < (1 << n); i++){
            List<Integer> a = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    a.add(nums[j]);
                }
            }
            ans.add(a);
        }
        return ans;
    }
