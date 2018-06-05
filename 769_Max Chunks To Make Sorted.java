class Solution {
    public int maxChunksToSorted(int[] arr) {
        int res = 0; 
        int max = -1;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (i == max) {
                res++;
                max = -1;
            }
        }
        
        return res;
    }
}
