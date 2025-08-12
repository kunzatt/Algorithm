class Solution {
    public long solution(int a, int b) {
        long ans = 0;
        if (a < b) {
            for (int i = a; i <= b; i++) {
                ans += i;
            }
            return ans;
        } else if (b < a) {
            for (int i = b; i <= a; i++) {
                ans += i;
            }
            return ans;
        } else {
            return a;
        }
    }
}