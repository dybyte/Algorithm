class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 3sum 
        // i + left + right
        // 4sum
        // i + j + left + right
        // 2중 for문
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < nums.length; j++){
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];
                    if(sum > target) right--;
                    else if(sum < target) left++;
                    else {
                        ans.add(List.of(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1]) left++;
                         while(left < right && nums[right] == nums[right+1]) right--;
                    }
                }
            }
        }
        return ans;
    }
}