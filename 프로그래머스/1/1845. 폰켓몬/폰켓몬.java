class Solution {
    public int solution(int[] nums) {
        int[] arr = new int[200001];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int count = 0;
        for (int i : arr) {
            if (i > 0) count++;
        }
        int num = nums.length / 2;
        if (count >= num) {
            return num;
        } else {
            return count;
        }
    }
}