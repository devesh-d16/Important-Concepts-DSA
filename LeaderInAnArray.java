// Given an array A of positive integers. Your task is to find the leaders in the array.
// An element of array is leader if it is greater than or equal to all the elements to its right side.
// The rightmost element is always a leader.

// TC - O(N + N)
// SC - O(N)
    static ArrayList<Integer> leaders(int arr[], int n){
        
        ArrayList<Integer> ans = new ArrayList<>();
        int max = arr[n - 1];
      // last element is always leader
        ans.add(arr[n - 1]);

      
        for(int i = n - 2; i >= 0; i--){
          // if element max se greater hai toh vo leader hoga if we iterate from back
          // phir max ko update kr denge
            if(arr[i] >= max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }
      // answer reverse order me hoga obv because last se start kiye humlog so reverse krna pdega array ko
        Collections.reverse(ans);
        return ans;
    }
