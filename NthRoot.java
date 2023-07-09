
// TC - O(Nlogm)
// SC - O(1)

public int NthRoot(int n, int m){
        int left = 1;
        int right = m;
        
        while(left <= right){
            int mid = (left + right)/2;
            int ans = f(mid, n, m);
            
            if(ans == 1){
                return mid;
            }
            else if(ans == 0){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public int f(int mid, int n, int m){
        long ans = 1;
      // we are doing this to avoid overflow
      // if ans > m => we will return 2 which means ans is in left half
      // if ans == m => we will return 1 which means ans is the mid
      // if ans < m => we will return 0 which means ans is in the right half
        for(int i = 1; i <= n; i++){
            ans = ans * mid;
            if(ans > m){
                return 2;
            }
        }
        if(ans == m){
            return 1;
        }
        return 0;
    }
