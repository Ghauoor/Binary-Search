package Questions;

import java.util.Arrays;

public class First_Occ_Last_Occ_total_Occ {
    public static void main(String[] args) {

        int[] arr = {1,2,3,3,3,3,3,3,6};
        int key = 3;

        int firstIndex = firstOcc(arr,key);
        int lastIndex =  lastOcc(arr,key);

        int totalNoOfOcc = (lastIndex - firstIndex) + 1;

        System.out.println("First and Last index of "+key+": "+Arrays.toString(searchRange(arr,key)));


        System.out.println("The first Occurrence of 3 is at index: "+firstIndex);
        System.out.println("The last Occurrence of 3 is at index: "+lastIndex);
        System.out.println("Total Occurrence of "+key+" is : "+totalNoOfOcc);

    }
    static int firstOcc(int[] arr, int key){
        int start = arr[0];
        int end = arr.length - 1;

        int ans = -1;

        while (start <= end) {

           int mid = start + (end - start) / 2;

           if (key == arr[mid]){
               ans = mid;
               end = mid - 1;
           } else if (key > arr[mid]) {
               end = mid - 1;
           } else {
               start = mid + 1;
           }

        }
        return ans;
    }
    static int lastOcc(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;

        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (key == arr[mid]){

                ans = mid;
                start = mid + 1;

            } else if (key > arr[mid]) {

                end = mid - 1;

            } else {

                start = mid + 1;
            }

        }
        return ans;
    }

    //Potentially Another way to solve this Problem

    public static int[] searchRange(int[] nums, int target) {

        int[] ans = {-1,-1};
        ans[0]= search(nums,target,true);
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }
        return ans;
    }

    public static int search(int[] nums, int target, boolean findFirstIndex){

        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){

            int mid = start + (end - start) / 2;

            if(target > nums[mid]){

                start = mid + 1;

            } else if(target < nums[mid]){

                end = mid - 1;
            } else {

                ans = mid;

                if(findFirstIndex){

                    end = mid - 1;
                } else{

                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
