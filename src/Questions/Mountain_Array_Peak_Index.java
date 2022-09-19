package Questions;

public class Mountain_Array_Peak_Index {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,4,3,2,1};

        System.out.println(peakIndexInMountainArr(arr));

    }
    public static int peakIndexInMountainArr(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start < end){

            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]){
                //Decreasing Part of Array
                //Might be Answer so end != mid - 1
                end = mid;
            } else {
                //Ascending Part of Array
                start = mid + 1;
            }
        }
        return start;
    }
}
