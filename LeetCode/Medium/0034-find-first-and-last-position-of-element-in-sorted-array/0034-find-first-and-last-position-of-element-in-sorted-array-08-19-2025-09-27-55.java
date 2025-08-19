class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int start = -1;
        int end = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                start = mid;
                end = mid;
                for(int i = mid; i >= 0; i--){
                    if(nums[i] != target) break;
                    start = i;
                }
                for(int i = mid; i < nums.length; i++){
                    if(nums[i] != target) break;
                    end = i;
                }
                break;
            }
        }
        return new int[]{start, end};
    }
}