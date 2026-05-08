class Solution {
    public int trap(int[] height) {
        //가장 큰 벽을 기준으로
        //양쪽에서
        //자신보다 큰 벽을 찾으면 -> 자신의 키에 맞춰 물을 채움
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i = 0; i < height.length; i++){
            if(max < height[i]){
                max = height[i];
                maxIdx = i; 
            }
        }

        int l = 0;
        int count = 0;
        for(int r = 0; r <= maxIdx; r++){
            if(height[l] <= height[r]){
                int current = height[l];
                while(l < r){
                    count += current - height[l++];
                }
            }
        }

        int r = height.length - 1;
        for(l = height.length - 1; l >= maxIdx; l--){
            if(height[l] >= height[r]){
                int current = height[r];
                while(l < r){
                    count += current - height[r--];
                }
            }
        }
        return count;
    }
}