class Solution {
    public boolean canJump(int[] nums) {
        /*
            2, 3, 1, 1, 4
               o   o     o

            1  1  0  0  1  2


            3, 2, 1, 0, 4

        */
        boolean[] answer = new boolean[nums.length];
        answer[0] = true;
        int idx = 0;

        for(int i = 0; i < nums.length - 1; i++){
            if(answer[i] && nums[i] != 0) {
                idx = i;
                int reach = Math.min(nums.length - 1, idx + nums[idx]);
                answer[reach] = true;
                continue;
            }
            if(idx + nums[idx] >= i) {
                answer[i] = true;
                int reach = Math.min(nums.length - 1, i + nums[i]);
                answer[reach] = true;
                if(idx + nums[idx] < reach) {
                    idx = i;
                }
                continue;
            }
            return false;
        }
        return answer[nums.length - 1];
    }
}