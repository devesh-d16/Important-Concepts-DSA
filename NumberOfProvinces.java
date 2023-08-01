// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
// and city b is connected directly with city c, then city a is connected indirectly with city c.
// A province is a group of directly or indirectly connected cities and no other cities outside of the group.
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, 
// and isConnected[i][j] = 0 otherwise.
// Return the total number of provinces.


    public int findCircleNum(int[][] isConnected) {
      // to put the graph in the form of adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < isConnected.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected.length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

      // ṭo mark node already visited
      // so in this question we will basically find the no of components of a graph using dfs
        boolean[] vis = new boolean[isConnected.length];
        vis[0] = false;
        int count = 0;
        for(int i = 0; i < isConnected.length; i++){
            if(!vis[i]){
                count++;
                dfs(i, adj, vis);
            }
        }
        return count;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for(Integer it: adj.get(node)){
            if(!vis[it]){
                dfs(it, adj, vis);
            }
        }
    }
