// Given an array containing N integers and an integer K., 
//Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

public static int lenOfLongSubarr (int A[], int N, int K) {

    // Map to store key : presum and value : index
    HashMap<Integer,Integer> preSum = new HashMap<>();
    int sum = 0;
    int maxLength = 0;
        
    for(int i = 0; i < N; i++){
        //calculate the prefix sum till index i:
        sum += A[i];

        // if the sum = k, update the maxLen:
        if(sum == K){ 
            maxLength = Math.max(maxLength,i + 1);
        }

        // calculate the sum of remaining part i.e. x-k:
        int rem = sum - K;

        //Calculate the length and update maxLen
        // if sum till index i = x and sum - K = an element of array...this means this subarray sum is equal to K
        // so we have to calc the length and update the max length
        // eg - [2,0,0,3], k = 3, here ans should be (3) as [0,0,3] is maxLength of subarray sum equal to K
        if(preSum.containsKey(rem)){
            int length = i - preSum.get(rem);
            maxLength = Math.max(maxLength, length);
        }

        // put the sum and index if it is not present
        if(!preSum.containsKey(sum)){
            preSum.put(sum,i);
        }
    }  
    return maxLength;
}
