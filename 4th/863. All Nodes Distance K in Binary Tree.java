/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, null, map);
        
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        queue.add(target);
        visited.add(target);
        
        for (int i = 1; i <= K; ++i) {
            int n = queue.size();
            for (int j = 0; j < n; ++j) {
                TreeNode cur = queue.poll();
                List<TreeNode> tmp = new ArrayList<>();
                tmp.add(cur.left);
                tmp.add(cur.right);
                tmp.add(map.get(cur));
                for (TreeNode next: tmp) {
                    if (next == null || visited.contains(next)) {
                        continue;
                    }
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        
        while (!queue.isEmpty()) {
            res.add(queue.poll().val);
        }
        return res;
    }
    
    private void dfs(TreeNode cur, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (cur == null) {
            return;
        }
        map.put(cur, parent);
        dfs(cur.left, cur, map);
        dfs(cur.right, cur, map);
    }
}
