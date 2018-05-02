class Solution {
    public boolean canCross(int[] stones) {
        int target = stones[stones.length - 1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone:stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(1);
        for (int stone: stones) {
            if (map.get(stone).isEmpty()) {
                return false;
            }
            for (int unit: map.get(stone)) {
                if (stone + unit == target) {
                    return true;
                }
                Set<Integer> next = map.get(stone + unit);
                if (next != null) {
                    next.add(unit);
                    next.add(unit + 1);
                    if (unit > 1) {
                        next.add(unit - 1);
                    }
                }
            }
        }
        return false;
    }
}
