package Learning;

public class Order_Agnostic_Binary_Search {
    public static void main(String[] args) {

        int[] arr = {-18,-12,3,4,5,6,7,45,89};
        int target = 45;

        int[] desArr = {90,75,18,12,6,4,3,1};
        int desTarget = 1;


        int ans = orderAgnosticBS(arr, target);
        int answer = orderAgnosticBS(desArr,desTarget);

        System.out.println(ans);
        System.out.println(answer);

    }

    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        //Find Array sorted in ascending or Descending...

        boolean isAsc = arr[start] < arr[end];
        /*
        Because this is an expression so this can assign directly
        if (arr[start] < arr[end]){
            isAsc = true;
        } else {
            isAsc = false;
        }
         */
        while (start <= end) {

            int mid = start + (end - start) / 2;

            //Same for both order's
            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }
}
