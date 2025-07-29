class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while(count[j] == 0) {
                j++;
                if(j>3)return;
            }
            nums[i] = j;
            count[j]--;
        }
    }
}