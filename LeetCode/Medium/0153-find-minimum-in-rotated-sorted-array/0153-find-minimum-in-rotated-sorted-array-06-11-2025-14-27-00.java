class Solution {
    public int findMin(int[] nums) {
        // 1. nums[left] + nums[right]
        // 2. nums[mid] * 2
        // 1 > 2  mid 값 부터는 흐름이 다르다. right는 그럴수도 있고 아닐 수도 있다. right = mid - 1;
        // 1 < 2  right 부터는 흐름이 다르다. left = mid + 1;
        // 1 == 2 left 부터 right까지 동일한 흐름 안에 있다. right = mid - 1;
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