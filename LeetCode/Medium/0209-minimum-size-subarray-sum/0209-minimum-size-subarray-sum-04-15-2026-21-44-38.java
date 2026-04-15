class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        /**
        연속된 최소 부분배열.(target 이상)

        nums를 순회하면서 누적합을 계산한다.
        합이 target보다 같거나 클때, left를 줄인다.
        target보다 작아지면 right를 늘린다.
        right가 nums의 끝에 도달하면 종료한다.

        left right 사이의 조건이 문제.
        left를 포함하고, right를 포함.
         */
        
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];        

        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }


        // 2 5 6 8 12 15
        int left = 0;
        int answer = Integer.MAX_VALUE;

        for(int right = 0; right < prefixSum.length; right++){
            if(prefixSum[right] >= target) answer = Math.min(answer, right + 1);
            while(prefixSum[right] - prefixSum[left] >= target){
                answer = Math.min(answer, right - left++);
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}