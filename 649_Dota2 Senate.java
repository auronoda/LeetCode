class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> qR = new LinkedList<>();
        Queue<Integer> qD = new LinkedList<>();
        for (int i = 0; i < senate.length(); ++i) {
            if (senate.charAt(i) == 'R') {
                qR.add(i);
            }
            else {
                qD.add(i);
            }
        }
        
        while (!qR.isEmpty()&& !qD.isEmpty()) {
            int r = qR.poll(), d = qD.poll();
            if (r < d) {
                qR.add(r + senate.length()) ;
            }
            else {
                qD.add(d + senate.length());
            }
        }
        return qR.isEmpty()? "Dire": "Radiant";
    }
}
