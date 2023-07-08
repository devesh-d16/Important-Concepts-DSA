// Given an integer x, find the square root of x. If x is not a perfect square, then return floor(√x).

// TC - O(logn)
// ṢC - O(1)

long floorSqrt(long x){
        long left = 1;
        long right = x;
        
        while(left <= right){
            long mid = (left + right)/2;
            long ans = mid*mid;
            
            if(ans <= x){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return right;
	}
