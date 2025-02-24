class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        for (int i = 0; i < schedules.length; i++) {
            schedules[i] += 10;
            if ((schedules[i] / 10) % 10 >= 6) {
                schedules[i] = schedules[i] - 60 + 100;
            }                
        }
        
        int count = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int tcount = 0;
            for (int j = 0; j < 7; j++) {
                int temp = startday + j;
                if (temp % 7 == 6 || temp % 7 == 0) {
                    continue;
                }
                if (timelogs[i][j] <= schedules[i]) tcount++;
            }
            if (tcount == 5) count++;
        }
        
        return count;
    }
}