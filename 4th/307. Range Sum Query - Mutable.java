class NumArray {
    private class TreeNode {
        int start;
        int end;
        int sum;
        TreeNode left;
        TreeNode right;
        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    TreeNode root;

    public NumArray(int[] nums) {
        root = new TreeNode(0, nums.length - 1);
        for (int i = 0; i < nums.length; ++i) {
            update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        updateHelper(root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return sumHelper(root, i, j);
    }
    
    private void updateHelper(TreeNode cur, int i, int val) {
        if (cur == null || i < cur.start || i > cur.end) {
            return;
        }
        if (i == cur.start && i == cur.end) {
            cur.sum = val;
            return;
        }
        int mid = cur.start + (cur.end - cur.start) / 2;
        if (i <= mid) {
            if (cur.left == null) {
                cur.left = new TreeNode(cur.start, mid);
            }
            updateHelper(cur.left, i, val);
        }
        else {
            if (cur.right == null) {
                cur.right = new TreeNode(mid + 1, cur.end);
            }
            updateHelper(cur.right, i, val);
        }
        cur.sum = (cur.left == null? 0: cur.left.sum) + (cur.right == null? 0: cur.right.sum);

        return;
    }
    
    private int sumHelper(TreeNode cur, int i, int j) {
        if (cur == null || i > cur.end || j < cur.start) {
            return 0;
        }
        i = Math.max(i, cur.start);
        j = Math.min(j, cur.end);
        if (i == cur.start && j == cur.end) {
            return cur.sum;
        }
        return sumHelper(cur.left, i, j) + sumHelper(cur.right, i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
