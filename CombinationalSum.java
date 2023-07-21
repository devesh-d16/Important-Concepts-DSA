// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. 
// You may return the combinations in any order.
// The same number may be chosen from candidates an unlimited number of times.
// Two combinations are unique if the frequency
//  of at least one of the chosen numbers is different.
// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.

// TC - O(N)
// SC - O(N)

public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        cS(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public void cS(int idx, int cand[], int target, List<List<Integer>> ans, List<Integer> a){
      // if we reach the end of array
        if(idx == cand.length){
          // if target is equal to sum...push the arraylist to the "ans"
            if(target == 0){
                ans.add(new ArrayList<>(a));
            }
            return;
        }

      // if the element of candidate array is less than target
      // we will add the element to the arraylist and call function again...
      // !!!!! remember we can take same element again so we dont have to increase the idx
        if(cand[idx] <= target){
            a.add(cand[idx]);
            cS(idx, cand, target - cand[idx], ans, a);
            a.remove(a.size() - 1);
        }
      // here if same element se target sum achieve noi hua toh idx increase krenge
        cS(idx + 1, cand, target, ans, a);
    }


// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. 
// The list must not contain the same combination twice, and the combinations may be returned in any order.
        
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        cS(ans, new ArrayList<>(), k, 1, n);
        return ans;
    }

    public void cS(List<List<Integer>> ans, List<Integer> a, int k, int i, int n){
        if(a.size() == k && n == 0){
            ans.add(new ArrayList<>(a));
            return;
        }
      
        for(int j = i; j <= 9; j++){
            a.add(j);
            cS(ans, a, k, j + 1, n - j);
            a.remove(a.size() - 1);
        }
    }
