class Solution {
    public int candy(int[] ratings) {
        int[] counts = new int[ratings.length];
        Arrays.fill(counts, 1);
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                counts[i] = counts[i-1] + 1;
            }
        }
        // 1 2 3 4 1
        for(int i = ratings.length - 2; i >=0; i--){
            if(ratings[i] > ratings[i+1]){
                if(counts[i] <= counts[i+1]) counts[i] = counts[i+1] + 1;
            }
        }
        // 
        int ans = 0;
        
        for(int i : counts) {
            System.out.println(i);
            ans += i;
        }
        return ans;
    }
    // 1 3 4 5 2
    // 1 2 3 4 1 answer
    // 1 2 3 2 1
}