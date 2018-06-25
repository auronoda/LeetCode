class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int minIdx = -1;
        int secondMinIdx = -1;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int maxIdx = -1;
        int secondMaxIdx = -1;
        for (int i = 0; i < arrays.size(); ++i) {
            List<Integer> list = arrays.get(i);
            if (list.get(0) <= min) {
                secondMin = min;
                secondMinIdx = minIdx;
                min = list.get(0);
                minIdx = i;
            }
            else if (list.get(0) <= secondMin) {
                secondMin = list.get(0);
                secondMinIdx = i;
            }
            
            if (list.get(list.size() - 1) >= max) {
                secondMax = max;
                secondMaxIdx = maxIdx;
                max = list.get(list.size() - 1);
                maxIdx = i;
            }
            else if (list.get(list.size() - 1) >= secondMax) {
                secondMax = list.get(list.size() - 1);
                secondMaxIdx = i;
            }
        }

        return minIdx != maxIdx? max - min: Math.max(secondMax - min, max - secondMin);
    }
}
