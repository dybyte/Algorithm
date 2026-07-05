class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       /**
       오름차순
       nums1[i], nums2[j] 와 크기를 비교
        1) nums1[i] <= nums2[j]
        2) nums1[i] > nums2[j] 
        -> 2의 조건을 처음 충족했을 때 그 전의 위치에 nums2[j]

        */ 
        int[] nums = new int[nums1.length];
        int numsIdx = 0;

        int j = 0;
        for(int i = 0; i < nums1.length; i++){
            int n1 = i < m ? nums1[i] : Integer.MAX_VALUE;
            int n2 = j < n ? nums2[j] : Integer.MAX_VALUE;
            if(numsIdx == nums1.length) break;
            if(n1 <= n2){
                nums[numsIdx++] = n1;
            } else {
                nums[numsIdx++] = n2;
                i--;
                j++;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            nums1[i] = nums[i];
        }
    }
}