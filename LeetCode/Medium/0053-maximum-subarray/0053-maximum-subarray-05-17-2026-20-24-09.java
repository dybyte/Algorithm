class Solution {
    public int maxSubArray(int[] nums) {
        // 왼쪽 포인터: 오른쪽 포인터가 음수를 만나게되면, 증가시킴
        int left = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int right = 0; right < nums.length; right++){
            if(sum < 0){
                while(left < right){
                    max = Math.max(max, sum);
                    sum -= nums[left];
                    left++;
                }
            }
            sum += nums[right];
            max = Math.max(max, sum);
        }
        return max;
    }
}