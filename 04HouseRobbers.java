// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. 
// All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
// Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// in this quesion we will apply the same logic like the last one
// as one thing we know that if the first element is taken -> last element is not taken and vice versa
// so we will make to two temporary array, first with NO last element and other with NO first element
// and apply the same logic of pick and non pick 
public int rob(int[] nums) {
    int n = nums.length;
    int num1[] = new int[n - 1];
    int num2[] = new int[n - 1];

    if(n == 1){
        return nums[0];
    }
  
    for(int i = 0; i < n - 1; i++){
        num1[i] = nums[i + 1];
    }
    for(int i = 0; i < n - 1; i++){
        num2[i] = nums[i];
    }

    return Math.max(rob1(num1),rob1(num2));
}
public int rob1(int[] nums) {
    int n = nums.length;
    int prev = nums[0];
    int prev2 = 0;

    for(int i = 1; i < n; i++){
        int pick = nums[i];
        if(i > 1){
            pick += prev2;
        }
        int notPick = prev;

        int curri = Math.max(pick,notPick);
        prev2 = prev;
        prev = curri; 
    }
    return prev;
}
