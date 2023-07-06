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
// Majority Element 2
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 3⌋ times. 
// You may assume that the majority element always exists in the array.

// TC - O(n^2)
// SC - O(N)

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            // if key/element phle se hai toh key ka value store krega or new hai toh 0 
            int val = map.getOrDefault(nums[i],0);
            // value me + 1 because frequency ek increase hogyi hai
            map.put(nums[i], val + 1);
        }

        for(Map.Entry<Integer, Integer> i : map.entrySet()){
            if(i.getValue() > (n/3)){
                ans.add(i.getKey());
            }
        }
        return ans;
    }

// TC - O(N) + O(N)
// SC - O(1)
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        
        int count1 = 0;
        int count2 = 0;

        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(count1 == 0 && nums[i] != element2){
                count1 = 1;
                element1 = nums[i];
            }
            else if(count2 == 0 && nums[i] != element1){
                count2 = 1;
                element2 = nums[i];
            }
            else if(nums[i] == element1){
                count1++;
            }            
            else if(nums[i] == element2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == element1){
                count1++;
            }
            else if(nums[i] == element2){
                count2++;
            }
        }

        if(count1 > (n/3)){
            ans.add(element1);
        }
        if(count2 > (n/3)){
            ans.add(element2);
        }

        return ans;
    }
