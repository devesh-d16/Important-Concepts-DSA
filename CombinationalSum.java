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
