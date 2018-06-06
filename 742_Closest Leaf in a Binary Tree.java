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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<Integer, int[]> map = new HashMap<>();
        List<TreeNode> path = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int res = 0;
        dfs(root, k, path);
        for (int i = 0; i < path.size(); ++i) {
            TreeNode cur = path.get(i);
            int[] tmp = getLeaf(cur, map);
            if (tmp[0] + path.size() - 1 - i < min) {
                min = tmp[0] + path.size() - 1 - i;
                res = tmp[1];
            }
        }
        
        return res;
    }
    
    private boolean dfs(TreeNode cur, int k, List<TreeNode> list) {
        if (cur == null) {
            return false;
        }
        if (cur.val == k) {
            list.add(cur);
            return true;
        }
        
        list.add(cur);
        if (dfs(cur.left, k, list)) {
            return true;
        }        
        if (dfs(cur.right, k, list)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }
    
    private int[] getLeaf(TreeNode cur, Map<Integer, int[]> map) {
        if (cur == null) {
            return new int[]{Integer.MAX_VALUE, 0};
        }
        if (cur.left == null && cur.right == null) {
            return new int[]{0, cur.val};
        }
        if (map.containsKey(cur.val)) {
            return map.get(cur.val);
        }
        int[] left = getLeaf(cur.left, map);
        int[] right = getLeaf(cur.right, map);
        if (left[0] < right[0]) {
            map.put(cur.val, new int[]{left[0] + 1, left[1]});
            return new int[]{left[0] + 1, left[1]};
        }
        else {
            map.put(cur.val, new int[]{right[0] + 1, right[1]});
            return new int[]{right[0] + 1, right[1]};
        }
    }
}
