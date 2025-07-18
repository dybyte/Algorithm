class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;

        // 첫 방향: 상승
        int ans = 1;
        int pre = nums[0];
        boolean pos = true;

        for (int i = 1; i < nums.length; i++) {
            if (pos) {
                if (pre < nums[i]) {
                    ans++;
                    pre = nums[i];
                    pos = !pos;
                } else {
                    pre = Math.min(pre, nums[i]);
                }
            } else {
                if (pre > nums[i]) {
                    ans++;
                    pre = nums[i];
                    pos = !pos;
                } else {
                    pre = Math.max(pre, nums[i]);
                }
            }
        }

        // 두 번째 시도: 하강부터 시작
        int ans1 = 1;
        pre = nums[0];
        pos = false;

        for (int i = 1; i < nums.length; i++) {
            if (pos) {
                if (pre < nums[i]) {
                    ans1++;
                    pre = nums[i];
                    pos = !pos;
                } else {
                    pre = Math.min(pre, nums[i]);
                }
            } else {
                if (pre > nums[i]) {
                    ans1++;
                    pre = nums[i];
                    pos = !pos;
                } else {
                    pre = Math.max(pre, nums[i]);
                }
            }
        }

        return Math.max(ans, ans1);
    }
}
