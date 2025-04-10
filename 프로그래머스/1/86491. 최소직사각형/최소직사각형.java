class Solution {
    public int solution(int[][] sizes) {
        int v = 0;
        int h = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        for (int i = 0; i < sizes.length; i++) {
            v = Math.max(v, sizes[i][0]);
            h = Math.max(h, sizes[i][1]);
        }
        return v * h;
    }
}