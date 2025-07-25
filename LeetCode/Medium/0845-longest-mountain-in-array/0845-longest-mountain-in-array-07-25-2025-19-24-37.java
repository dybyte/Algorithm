class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length < 3) return 0;
        //array 2개
        //
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1]) left[i] = left[i-1] + 1;
            else left[i] = 1;
        }

        right[arr.length - 1] = 1;
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] > arr[i+1]) right[i] = right[i+1] + 1;
            else right[i] = 1;
        }
        int idx = -1;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(left[i] != 1 && right[i] != 1){
                int sum = left[i] + right[i];
                if(max < sum){
                    max = sum;
                    idx = i;
                }
            }
        }
        if(idx == -1) return 0;
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return right[idx] + left[idx] - 1;
    }
}