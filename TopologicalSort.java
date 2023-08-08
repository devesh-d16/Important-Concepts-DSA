// Only applicable on DAG => Directed Acyclic Graph
// linear ordering of vertices such that if there is an edge between u & v, u appears before v in that ordering
//  O(V + E) - TC
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, vis, s, adj);
            }
        }
        
        int ans[] = new int[V];
        int i = 0;
        while(!s.isEmpty()){
            ans[i++] = s.peek();
            s.pop();
        }
        
        return ans;
    }
    
    public static void dfs(int i, int vis[], Stack<Integer> s, ArrayList<ArrayList<Integer>> adj){
        vis[i] = 1;
        for(int it : adj.get(i)){
            if(vis[it] == 0){
                dfs(it, vis, s, adj);
            }
        }
        s.push(i);
    }
