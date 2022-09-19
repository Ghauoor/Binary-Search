package Questions;

public class Smallest_Letter {
    public static void main(String[] args) {
    }
    static int smallestLetterThenTarget(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return arr[start % arr.length];
    }
}
