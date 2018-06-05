class Solution {
    public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int[] point: points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            set.add(encode(point[0], point[1]));           
        }
        for (int[] point: points) {
            if (!set.contains(encode(max + min - point[0], point[1]))) {
                return false;
            }          
        }
        return true;
    }
    
    private String encode(int x, int y) {
        return "" + x + ',' + y;
    }
}
