class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        // 시작점 -> 가장 작은 수, nums.length - k 보다 큰 Idx는 시작점이 될 수 없다.
        int start = 0;
        for(int i = 0; i <= nums.length - k; i++){
            if(nums[i] < nums[start]) {
                start = i;
            }
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = start; i < nums.length; i++){
            while(!stack.isEmpty() && stack.peek() > nums[i]){
                if(nums.length - i == k - stack.size()) break;
                stack.pop();
            }
            stack.push(nums[i]);
        }
        int[] ans = new int[k];
        for(int i = 0; i < ans.length; i++){
            ans[i] = stack.pollLast();
        }
        return ans;
    }
}