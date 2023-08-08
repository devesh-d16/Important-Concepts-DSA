// Kahn's Algo
// if cycle hoga toh queue khali hojayega 
// toh ek count variable rakhenge 
// and if count == V hua toh cycle ni hai
// ni toh hai

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int indeg[] = new int[V];
        for(int i = 0; i < V; i++){
            for(int it: adj.get(i)){
                indeg[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            count++;
            for(int it: adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }
        
        if(count == V){
            return false;
        }
        
        return true;
    }
