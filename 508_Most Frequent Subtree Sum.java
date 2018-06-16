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
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i: map.keySet()) {
            if (map.get(i) < max) {
                continue;
            }
            if (map.get(i) > max) {
                max = map.get(i);
                list = new ArrayList<>();
            }
            list.add(i);
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    private int helper(TreeNode root, Map<Integer, Integer> map) {
        int tmp = root.val;
        if (root.left != null) {
            tmp += helper(root.left, map);             
        }
        if (root.right != null) {
            tmp += helper(root.right, map);             
        }
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        return tmp;
    }
}
