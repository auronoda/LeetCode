class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Fraction> heap = new PriorityQueue<>(new Comparator<Fraction>(){
            public int compare(Fraction a, Fraction b) {
                if (a.val < b.val) {
                    return -1;
                }
                if (a.val > b.val) {
                    return 1;
                }
                return 0;
            }
        });  
        
        for (int i = 1; i < A.length; ++i) {
            heap.add(new Fraction(0, i, (double)A[0] / A[i]));
        }
        
        for (int i = 1; i < K; ++i) {
            Fraction cur = heap.poll();
            if (cur.num < cur.det - 1) {
                heap.add(new Fraction(cur.num + 1, cur.det, (double)A[cur.num + 1] / A[cur.det]));
            }
        }
        
        Fraction cur = heap.poll();
        return new int[]{A[cur.num], A[cur.det]};
    }
    
    private class Fraction {
        int det; 
        int num;
        double val;
        public Fraction(int num, int det, double val) {
            this.num = num;
            this.det = det;
            this.val = val;
        }
    }
}
