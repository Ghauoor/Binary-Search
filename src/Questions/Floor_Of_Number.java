package Questions;

public class Floor_Of_Number {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int key = 4;

        int index = floorOfNum(arr,key);

        System.out.println(index);
    }
    static int floorOfNum(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){

            int mid = start + (end - start) / 2;

            if (arr[mid] > key){
                end = mid - 1;

            } else if (arr[mid] < key){
                start = mid + 1;

            } else {

                return mid;
            }
        }
        return end;
    }
}
