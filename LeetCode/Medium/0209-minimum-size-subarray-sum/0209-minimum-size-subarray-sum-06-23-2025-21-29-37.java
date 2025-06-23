class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 브루트포스 2중 for문
        // 합을 지속적으로 계산해야하므로
        // 누적합을 미리 구해서 사용한다.
        // O(n^2)

        // 투포인터
        // nums 값을 더함
        // 총합 >= target
        // 2n
        // O(n)
        int minLen = nums.length + 1;
        int sum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            while(target <= sum){
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == nums.length+1 ? 0 : minLen;
    }
}