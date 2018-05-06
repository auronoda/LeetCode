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
    
    private class pair {
        public TreeNode node;
        public int index;
        
        public pair(TreeNode node, int i){
            this.node = node;
            index = i;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        int res = 1;
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(root, 0));
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            int first = -1;
            for (int i = 0; i < n; i++) {
                pair cur = queue.poll();
                int index = cur.index;
                if (i == 0) {
                    first = index;
                }
                else if (i == n - 1) {
                    res = Math.max(res, index - first + 1);
                }
                if (cur.node.left != null) {
                    queue.add(new pair(cur.node.left, index * 2));
                }
                if (cur.node.right != null) {
                    queue.add(new pair(cur.node.right, index * 2 + 1));
                }
            }
        }
        return res;
    }
}
