// Given an undirected connected graph with V vertices and adjacency list adj. 
// You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components.
// Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

class Solution{
    public int timer = 1;
    
    public void dfs(int node, int parent, int vis[], int tin[], int low[], int mark[], ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for(Integer it: adj.get(node)){
            if(parent == it){
                continue;
            }
            if(vis[it] == 0){
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                
                // node--it
                if(low[it] >= tin[node] && parent != -1){
                    mark[node] = 1;
                }
                child++;
            }
            else{
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        if(child > 1 && parent == -1){
            mark[node] = 1;
        }
    }
    
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[V];
        int low[] = new int[V];
        int tin[] = new int[V];
        int mark[] = new int[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(mark[i] == 1){
                ans.add(i);
            }
        }
        
        if(ans.size() == 0){
            ans.add(-1);
        }
        
        return ans;
    }
}
