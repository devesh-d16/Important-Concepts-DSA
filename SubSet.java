 // Given an array print all the sum of the subset generated from it, in the increasing order.


    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        subSum(0, 0, num, ans);
        Collections.sort(ans);
        return ans;
    }
    public static void subSum(int idx, int sum, int num[], ArrayList<Integer> ans){
        if(idx == num.length){
            ans.add(sum);
            return;
        }

      // take element
        subSum(idx + 1, sum + num[idx], num, ans);
      // take no element
        subSum(idx + 1, sum, num, ans);
    }
