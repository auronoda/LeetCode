class Solution {
    
     private class Uf {
        Map<Integer, Integer> map;
        public Uf(){
            map = new HashMap<>();
        }
        public int find(int p){
            int cur = p;
            if (!map.containsKey(cur)){
                map.put(cur, cur);
                return cur;
            }
            int parent = map.get(cur);
            while (cur != parent){
                cur = parent;
                parent = map.get(cur);
            }
            int root = cur;
            cur = p;
            while (cur != root) {
                parent = map.get(cur);
                map.put(cur, root);
                cur = parent;
            }
            return root;
        }
            
        public boolean join(int p, int q){
            int rp = find(p);
            int rq = find(q);
            if (rp == rq) {
                return false;
            }
            map.put(rp,rq);
            return true;
        }            
    }
    public int[] findRedundantConnection(int[][] edges) { 
        
        Uf uf = new Uf();
        for (int[] edge: edges) {
            if (!uf.join(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[]{-1,-1};
    }
}
