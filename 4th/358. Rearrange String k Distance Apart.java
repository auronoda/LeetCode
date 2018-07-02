class Solution {
    public String rearrangeString(String s, int k) {
        int[] counts = new int[26];
        for (char c: s.toCharArray()) {
            counts[c - 'a']++;
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) -> counts[b - 'a'] - counts[a - 'a']);
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            if (counts[i] > 0) {
                heap.add((char)('a' + i));
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            if (heap.isEmpty()) {
                return "";
            }
            char cur = heap.poll();
            sb.append(cur);
            counts[cur - 'a']--;
            queue.add(cur);
            if (queue.size() >= k) {
                char prev = queue.poll();
                if (counts[prev - 'a'] > 0) {
                    heap.add(prev);
                }
            }
        }
        return sb.toString();
    }
}
