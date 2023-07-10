// You are given an array consisting of n integers which denote the position of a stall. 
// You are also given an integer k which denotes the number of aggressive cows. 
// You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
// The first line of input contains two space-separated integers n and k.
// The second line contains n space-separated integers denoting the position of the stalls.

// Example 1:
// Input:
// n=5 
// k=3
// stalls = [1 2 4 8 9]
// Output:
// 3
// Explanation:
// The first cow can be placed at stalls[0], 
// the second cow can be placed at stalls[2] and 
// the third cow can be placed at stalls[3]. 
// The minimum distance between cows, in this case, is 3, 
// which also is the largest among all possible ways.

// TC - O(N * log(max[stalls[i])
// SC - O(1)


    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        
        int left = 1;
        int right = stalls[n - 1] - stalls[0];
      // this is the max distance between them 
        
        while(left <= right){
            int mid = (left + right)/2;

          // if we can able to make them sit with distance = mid, we will try to maximize the distance
            if(canSeat(stalls, n, k, mid)){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return right;
    }
    
    public static boolean canSeat(int stalls[], int n, int cows, int dist){
        int noOfCows = 1;
        int sit = stalls[0];
        
        for(int i = 1; i < n; i++){
            if(stalls[i] - sit >= dist){
                noOfCows++;
                sit = stalls[i];
            }
        }      
        if(noOfCows >= cows){
            return true;
        }
        return false;
    }
