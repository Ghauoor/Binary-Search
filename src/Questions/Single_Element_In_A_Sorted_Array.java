package Questions;

public class Single_Element_In_A_Sorted_Array {
    private int singleNonDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid % 2 == 1) mid--;

            if (arr[mid] != arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 2;
            }
        }

        return arr[start];
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[mid + 1]) {
                mid = mid - 1;
            }

            if ((mid - start + 1) % 2 != 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return nums[start];

    }
}
