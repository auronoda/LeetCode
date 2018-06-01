class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();
        int start = 0, end = arr.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                break;
            }
            if (arr[mid] < x) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        mid = Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)? start: end;
        
        int left = mid, right = mid;
        for (int i = 1; i < k; ++i) {
            if (left == 0) {
                right++;
            }
            else if (right == arr.length - 1 || Math.abs(arr[left - 1] - x) <= Math.abs(arr[right + 1] - x)) {
                left--;
            }
            else {
                right++;
            }
        }
        
        for (int i = left; i <= right; ++i) {
            res.add(arr[i]);
        }
        
        return res;
    }
}
