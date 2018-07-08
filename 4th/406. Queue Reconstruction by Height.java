class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> (b[0] == a[0]? a[1] - b[1]: b[0] - a[0]));
        int n = people.length;
        int[][] res = new int[n][2];
        List<int[]> list = new ArrayList<>();
        for (int[] cur: people) {
            list.add(cur[1], cur);
        }
        for (int i = 0; i < n; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}
