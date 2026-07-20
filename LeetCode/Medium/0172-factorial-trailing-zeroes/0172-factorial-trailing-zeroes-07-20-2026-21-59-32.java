class Solution {
    public int trailingZeroes(int n) {
        int five = 5, byFive = 0;
        while(five <= n){
            byFive += n/five;
            five*=5;
        }
        return byFive;
    }
}