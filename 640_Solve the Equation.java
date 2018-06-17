class Solution {
    public String solveEquation(String equation) {
        int right = 1;
        int a = 0, b = 0;
        int cur = 0;
        int minus = 1;
        for (int i = 0; i < equation.length(); ++i) {
            char c = equation.charAt(i);
            
            if (c == 'x') {
                if (i == 0 || !Character.isDigit(equation.charAt(i - 1))) {
                    cur = 1;
                }
                a += minus * right * cur;
                minus = 1;
                cur = 0;
            }
            else if (c == '+') {
                b += minus * right * cur;
                minus = 1;
                cur = 0;
            }
            else if (c == '-') {
                b += minus * right * cur;
                minus = -1;
                cur = 0;
            }
            else if (c == '=') {
                b += minus * right * cur;
                minus = 1;
                cur = 0;
                right = -1;
            }
            else if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            }
        } 
        b += minus * right * cur;
        if (a == 0 && b == 0) {
            return "Infinite solutions";
        }
        if (a == 0) {
            return "No solution";
        }
        return "x=" + -b / a;
    }
}
