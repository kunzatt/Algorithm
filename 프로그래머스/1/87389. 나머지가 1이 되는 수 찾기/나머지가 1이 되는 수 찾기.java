class Solution {
    public int solution(int n) {
        int ans = 1;
        while (n % ans != 1) {
            ans++;
        }
        return ans;
    }
}