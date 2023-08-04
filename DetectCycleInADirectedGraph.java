// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, 
// check whether it contains any cycle or not.

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];

      // here we made two boolean array visited and pathVisited
      // cycle will be detected only jab humlog ek path pe traverse krre hai and wapis same node me aajaye
      // so if visited hai phle se but pathvisited ni hai toh no cycle
      // if visited hai and path visited bi hai then cycle detect true krna hai
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(i, vis, pathVis, adj) == true){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(int i, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adj){
        vis[i] = true;
        pathVis[i] = true;
        
        for(int it : adj.get(i)){
            if(vis[it] == false){
                if(dfs(it, vis, pathVis, adj) == true){
                    return true;
                }
            }
            else if(pathVis[it] == true){
                return true;
            }
        }
        
        pathVis[i] = false;
        return false;
    }
