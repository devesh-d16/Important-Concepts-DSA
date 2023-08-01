
public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
  // to store the node
        ArrayList<Integer> ans = new ArrayList<>();
  // this will make sure a node can be visited once only
        boolean vis[] = new boolean[V];
  // queue will be used to traverse the neighbour node
        Queue<Integer> q = new LinkedList<>();

  // add the first element in the queue
        q.add(0);
  // mark it visited
        vis[0] = true;
        
        while(!q.isEmpty()){
          // remove the node from queue
            Integer node = q.poll();
          // add it in answer
            ans.add(node);

          // now iterate and push the neigbouring 
            for(Integer it : adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return ans;
    }
