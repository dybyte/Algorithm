class Solution {
    public void sortColors(int[] nums) {
        //0,1,2의 개수를 저장
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }
        //count index
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while (count[j]==0) j++;
            nums[i] = j;
            count[nums[i]]--;
        }
    }
}