class Solution {
    public boolean canJump(int[] nums) {
        /*
            2, 3, 1, 1, 4
                  o     o         

            3, 2, 1, 0, 4

        */
        boolean[] answer = new boolean[nums.length];
        answer[0] = true;
        for(int i = 0; i < nums.length; i++){
            if(!answer[i]) return false;
            for(int j = i + 1; j <= i + nums[i]; j++){
                if(j >= nums.length) break;
                answer[j] = true;
            }
        }
        return true;
    }
}