class Solution {
    public int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            int l = mid == 0 ? Integer.MIN_VALUE : arr[mid-1];
            int r = mid == arr.length - 1 ? Integer.MIN_VALUE : arr[mid+1];
            if(l < arr[mid] && arr[mid] < r) left = mid + 1;
            else if(l > arr[mid] && arr[mid] > r) right = mid - 1;
            else if(l < arr[mid] && arr[mid] > r) return mid;
            else left = mid + 1;
        }
        return 0;
    }
}