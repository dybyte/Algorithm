class Solution {
    {
        for(int i = 0; i < 100; i++){
            threeSum(new int[]{0,0,0});
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < len; ++i) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = len - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum > 0) {
                    right--;
                }else if(sum < 0) {
                    left++;
                }else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;

                    while(nums[left] == nums[left - 1] && left < right) left++;
                }
            }
        }
        return ans;
    }
}