package Questions;

public class Rotated_BS {
    public static void main(String[] args) {

        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findPivot(arr));

        System.out.println(search(arr,5));

    }
    static int search(int[] nums, int target){
        int pivot = findPivot(nums);

        //if pivot isn't found means array is not rotated
        // So do simple binary Search
        if (pivot == -1){
            return bS(nums,target,0,nums.length - 1);
        }
        //if pivot is found...
        if (nums[pivot] == target ){
            return pivot;
        }

        if (target >= nums[0]){
           return bS(nums,target,0,pivot - 1);
        }
        return  bS(nums,target,pivot + 1, nums.length - 1);
    }
    static int bS(int[] arr, int target,int start, int end){

        while (start <= end){

            int middle = start + (end - start) / 2;

            if (target < arr[middle]){
                end = middle - 1;
            } else if (target > arr[middle]){
                start =  middle + 1;
            } else {
                //answer found
                return middle;
            }
        }
        return -1;
    }
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            //mid < end --> indexOutOfBound Error edge case
            if (mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            if (arr[mid] <= arr[start]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }
    static int findPivotWithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            //mid < end --> indexOutOfBound Error edge case
            if (mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            if (arr[mid] == arr[start] && arr[mid] == arr[end]){
                //skip the duplicate
                if (arr[start] > arr[start + 1]){
                    return start;
                }
                start++;
                if (arr[end] < arr[end - 1]){
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if (arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]) {
                   return start + 1;
            } else {
                end = mid + 1;
            }
        }
        return -1;
    }
}
