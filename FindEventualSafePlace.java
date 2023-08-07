// There is a directed graph of n nodes with each node labeled from 0 to n - 1. 
// The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, 
// meaning there is an edge from node i to each node in graph[i].
// A node is a terminal node if there are no outgoing edges. 
// A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
// Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

class Solution {

    public List<Integer> eventualSafeNodes(int graph[][]){
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < graph[i].length; j++){
                list.add(graph[i][j]);
            }
            adj.add(list);
        }

        int vis[] = new int[n]; // for traversing
        int pathVis[] = new int[n]; // to traverse path
        int check[] = new int[n]; // check safe node

        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, pathVis, check);
            }
        }

        List<Integer> safeNode = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(check[i] == 1){
                safeNode.add(i);
            }
        }
        
        return safeNode;
    }

    public boolean dfs(int node, List<List<Integer>> adj, int vis[], int pathVis[], int check[]){
        // we will mark vis and pathVis as 1 when we are traversing a path
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for(int i : adj.get(node)){
            if(vis[i] == 0){
                if(dfs(i, adj, vis, pathVis, check) == true){
                    return true;
                }
            }
            else if(pathVis[i] == 1){
                return true;
            }
        }
      // if there is no neighbour or outgoing edge we will be at terminal node, so we will mark it on check array as 1
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
} 
