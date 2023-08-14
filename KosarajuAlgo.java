// this algo is for counting of strongly connected components
// here we will ->
// sort all the edges according to the finishing time
// reverse the graph
// again traverse to dfs and count scc and store it too
// scc mtlb aise components jinke kisi bi nodes se dusre node tk jaa skte hai

class Solution
{
    public void dfs(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }
    // O(V + E)
    public void dfsR(int node, int vis[], ArrayList<ArrayList<Integer>> adjR, ArrayList<Integer> sccNode){
        vis[node] = 1;
        sccNode.add(node);
        for(Integer it: adjR.get(node)){
            if(vis[it] == 0){
                dfsR(it, vis, adjR, sccNode);
            }
        }
    }
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        // O(V + E)
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, vis, adj, st);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjR = new ArrayList<>();
        // O(V + E)
        for(int i = 0; i < V; i++){
            adjR.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
            vis[i] = 0;
            for(Integer it : adj.get(i)){
                // i -> it
                // it -> i
                adjR.get(it).add(i);
            }
        }
        
        int scc = 0;
        // O(V + E)
        ArrayList<ArrayList<Integer>> sccNodes = new ArrayList<>();
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            if(vis[node] == 0){
                scc++;
                ArrayList<Integer> sccNode = new ArrayList<>();
                dfsR(node, vis, adjR, sccNode);
                sccNodes.add(sccNode);
            }
        }
        
        for(int i = 0; i < sccNodes.size(); i++){
            for(int j = 0; j < sccNodes.get(i).size(); j++){
                System.out.print(sccNodes.get(i).get(j) + " ");
            }
            System.out.println();
        }
        return scc;
    }
}
