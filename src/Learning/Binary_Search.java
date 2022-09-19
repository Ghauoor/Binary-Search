package Learning;

public class Binary_Search {
    public static void main(String[] args) {

        int[] arr = {-18,-12,3,4,5,6,7,45,89};

        int target = 45;

        int ans = binarySearchInAscendingOrderArray(arr,target);

        System.out.println("This is Ascending Order: "+ans);

    }
    //return the index
    //return -1 if it does not exit

    static int binarySearchInAscendingOrderArray(int[] arr, int target){

        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            //find the  middle element
            /*
            int middle = (start + end) / 2;

            Prob is might be a chance (start + end) exceeds int range in java

             */
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
}
