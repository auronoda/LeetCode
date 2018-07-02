class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1, end = num;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (num / mid >= mid) {
                start = mid + 1;
            } 
            else {
                end = mid;
            }
        }
        if ((start- 1) * (start - 1) == num) {
            return true;
        }
        if (start * start == num) {
            return true;
        }
        return false;
    }
}
