class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i++){
            int left = 0;
            int right = nums.length - 1;
            while(left < i && i < right){
                int sum = nums[left] + nums[i] + nums[right];
                if(sum == 0) {
                    ans.add(List.of(nums[left], nums[i], nums[right]));
                    left++;
                    right--;
                }
                if(sum > 0) right--;
                if(sum < 0) left++;
            }
        }
        return ans.stream().toList();
    }
}