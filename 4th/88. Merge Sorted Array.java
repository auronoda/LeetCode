class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            int tmp1 = nums1[i];
            int tmp2 = nums2[j];
            if (tmp1 < tmp2) {
                nums1[k] = tmp2;
                j--;
            }
            else {
                nums1[k] = tmp1;
                i--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
