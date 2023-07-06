
// TC - O(N*N)
// SC - O(N)

public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int arr[] = new int[n];

        for(int i = 1; i <= n; i++){
            List<Integer> a = new ArrayList<>();
            a.add(1);
            if(i > 1){
                int j = 2;
                while(j <= i){
                    a.add(arr[j - 1] + arr[j - 2]);
                    j++;
                }
            }
            ans.add(a);
            for(int k = 0; k < a.size(); k++){
                arr[k] = a.get(k);
            }
        }
        return ans;
    }
