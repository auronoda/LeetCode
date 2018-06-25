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
    public List<List<Integer>> findLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> out = new HashMap<>();
        Map<TreeNode, Integer> in = new HashMap<>();
        preorder(root,out, in);
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        for (TreeNode cur: in.keySet()) {
            if (in.get(cur) == 0) {
                queue.add(cur);
            }
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; ++i) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (out.containsKey(cur)) {
                    in.put(out.get(cur), in.get(out.get(cur)) - 1);
                    if (in.get(out.get(cur)) == 0) {
                        queue.add(out.get(cur));
                    }
                }
            }
            res.add(list);
        }
        
        return res;
    }
    
    private void preorder(TreeNode root, Map<TreeNode, TreeNode> out, Map<TreeNode, Integer> in) {
        if (root == null) {
            return;
        }
        if (!in.containsKey(root)) {
            in.put(root, 0);
        }
        if (root.left != null) {
            preorder(root.left, out, in);
            out.put(root.left, root);
            in.put(root, in.get(root) + 1);
        }
        if (root.right != null) {
            preorder(root.right, out, in);
            out.put(root.right, root);
            in.put(root, in.get(root) + 1);
        }
    }
}
