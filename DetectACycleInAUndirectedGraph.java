// Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 
// Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.
// Expected Time Complexity: O(V + E)
// Expected Space Complexity: O(V)

// BFS
   public class Pair{
        int first;
        int second;
        
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(checkCycle(i, V, adj, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkCycle(int i, int V, ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        
        vis[i] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));
        
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            
            for(int adjNode: adj.get(node)){
                if(vis[adjNode] == false){
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, node));
                }
                else if(parent != adjNode){
                    return true;
                }
            }
        }
        return false;
    }

// DFS
    public class Pair{
        int first;
        int second;
        
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(dfs(i, -1, vis, adj) == true){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        vis[i] = true;
        
        for(int adjNode : adj.get(i)){
            if(vis[adjNode] == false){
                if(dfs(adjNode, i, vis, adj) == true){
                    return true;
                }
            }
            else if(adjNode != parent){
                return true;
            }
        }
        return false;
    }
