// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. 
// You may assume that the majority element always exists in the array.

// TC - O(N) + O(N)
// SC - O(N)
    public int majorityElement(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        // storing the element and its frequency
        for(int i = 0; i < n; i++){
            int val = map.getOrDefault(nums[i],0);
            map.put(nums[i], val + 1);
        }

        // searching for the majority element
        for(Map.Entry<Integer, Integer> i : map.entrySet()){
            if(i.getValue() > (n/2)){
                return i.getKey();
            }
        } 

        return -1;
    }

// TC - O(N) + O(N)
// SC - O(1)

// Moore's Voting Algorithm

    public int majorityElement(int[] nums) {

        int n = nums.length;
        int count = 0;
        int element = 0;

      // if count 0 hai toh vo element ko store krna hai
      // if next element same ho to count ko ++ krna hai 
      // agar different ho toh count minus...if minus krte krte 0 hogya count toh jo next element tha jisse compare krre the 
      // usko store karana hai
        for(int i = 0; i < n; i++){
            if(count == 0){
                count = 1;
                element = nums[i];
            }
            else if(element == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }

      // ye check krne ke liye if the element which has the most frequency is actually a majority element or not
        int count1 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == element){
                count1++;
            }
        }

        if(count1 > (n / 2)){
            return element;
        }

        return -1;
    }
