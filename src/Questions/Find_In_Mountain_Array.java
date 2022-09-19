package Questions;
//https://leetcode.com/problems/find-in-mountain-array/

public class Find_In_Mountain_Array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        System.out.println(search(arr,3));
    }
    static int binarySearch(int[] arr, int target, int start, int end){

        while (start <= end) {

            int mid = start + (end - start) / 2;

            boolean isAsc = arr[start] < arr[end];

            if (arr[mid] == target){
                return mid;
            }
            if (isAsc){
                if (target < arr[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
    static int peakInArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start < end){

            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int search(int[] arr, int target){
        int peak = peakInArray(arr);
        int firstTry = binarySearch(arr,target,0,peak);

        if (firstTry != -1){
            return firstTry;
        }
        //Try to search in second half
        return binarySearch(arr,target,peak + 1,arr.length - 1);

    }
}
