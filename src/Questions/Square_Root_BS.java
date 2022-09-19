package Questions;

public class Square_Root_BS {
    public static void main(String[] args) {
        int n = 25;

        System.out.println(mySqrt(n));

    }

  static int binarySearchSQRT(int n){
        int start = 0;
        int end = n;

        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int square = mid * mid;

            if (square == n)
                return mid;

            if (square < n){
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
    static int mySqrt(int n){
        if(n < 2) return n;

        int start = 1;
        int end = n / 2;

        while (start <= end){
            int mid  = start + (end - start) / 2;

            if (mid == n / mid) return mid;

            if(mid > n / mid) end = mid - 1;

            else start = mid + 1;
        }
        return end;
    }
}
