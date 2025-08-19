class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(true, nums, target);
        int end = binarySearch(false, nums, target);
        return new int[]{start, end};
    }

    public int binarySearch(boolean isStart, int[] nums, int target){
        int ans = -1;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                if(isStart) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                } 
            }
        }
        return ans;
    }
}