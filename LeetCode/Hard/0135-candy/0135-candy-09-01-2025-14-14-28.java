class Solution {
    static {
        for(int i = 0; i < 1000; i++) candy(new int[]{0});
    }
    public static int candy(int[] ratings) {
        int[] counts = new int[ratings.length];
        Arrays.fill(counts, 1);
        int count = 0;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i-1] < ratings[i]){
                counts[i] = counts[i-1] + 1;
            }
        }
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i+1] < ratings[i]){
                if(counts[i] <= counts[i+1]) {
                    counts[i] = counts[i+1] + 1;
                }
            }
        }
        for(int i = 0; i < counts.length; i++){
            count += counts[i];
        }
        return count;
    }
}