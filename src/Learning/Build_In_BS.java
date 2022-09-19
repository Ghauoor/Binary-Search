package Learning;

import java.util.Arrays;

public class Build_In_BS {
    public static void main(String[] args) {
        int[] arr = {2,4,5,67,89,};
        int target = 89;

        int index = bS(arr,target);
        System.out.println(index);
        System.out.println(Arrays.binarySearch(arr,target));
    }
    static int bS(int[] arr, int target){
        int start = arr[0];
        int end = arr.length;


        while (start <= end) {


            int mid = start + (end - start) / 2;

            if (target < arr[mid]){
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }


        }
        return -1;
    }
}
