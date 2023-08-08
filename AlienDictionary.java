
// Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. 
// Find the order of characters in the alien language.
// Note: Many orders may be possible for a particular test case, 
// thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.

// input
// N = 5, K = 4
// dict = {"baa","abcd","abca","cab","cad"}
// Output:
// 1
// Explanation:
// Here order of characters is 
// 'b', 'd', 'a', 'c' Note that words are sorted 
// and in the given language "baa" comes before 
// "abcd", therefore 'b' is before 'a' in output.
// Similarly we can find other orders.
// Example 2:

// Input: 
// N = 3, K = 3
// dict = {"caa","aaa","aab"}
// Output:
// 1
// Explanation:
// Here order of characters is
// 'c', 'a', 'b' Note that words are sorted
// and in the given language "caa" comes before
// "aaa", therefore 'c' is before 'a' in output.
// Similarly we can find other orders.

// we will use kahn's algo to solve this
// consecutive words compare krenge and if jo word different hua toh first string ka jo alphabet hai vo dict me phle aayega second ke alphabet se
// aise hi ek graph bnayenge
// phir iska topological sort nikal denge
    public String findOrder(String [] dict, int N, int K){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < K; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N - 1; i++){
            String s1 = dict[i];
            String s2 = dict[i + 1];
            
            int len = Math.min(s1.length(), s2.length());
            for(int j = 0; j < len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        
        List<Integer> topo = topoSort(K, adj);
        String ans = "";
        for(int it : topo){
            ans = ans + (char)(it + (int)('a'));
        }
        
        return ans;
    }
    
    public List<Integer> topoSort(int K, List<List<Integer>> adj){
        
        int indeg[] = new int[K];
        for(int i = 0; i < K; i++){
            for(int it : adj.get(i)){
                indeg[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < K; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);
            
            for(int it: adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }
        return topo;
    }
