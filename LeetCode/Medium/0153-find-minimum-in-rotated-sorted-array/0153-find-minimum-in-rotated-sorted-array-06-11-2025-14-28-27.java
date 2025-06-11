class Solution {
    public int findMin(int[] nums) {
        int answer = Integer.MAX_VALUE;

        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else if(nums[mid] <= nums[right]){
                right = mid - 1;
                answer = Math.min(answer, nums[mid]);
            }
        }
        return answer;
    }
}