package Learning;

public class BS_Sorted_Matrix {
    public static void main(String[] args) {

    }
    //Search in the row provided between the cols provided

    //TODO: This method isn't working... -->
    static int[] simpleBinarySearch(int[][] matrix, int target, int row, int cStart, int cEnd){
        while (cStart <= cEnd){
            int mid = cStart + (cEnd - cStart) / 2;

           if(matrix[row][mid] == target){
               return new int[]{row, mid};
           }
           if (matrix[row][mid] < target){
               cStart = mid + 1;
           } else {
               cEnd = mid - 1;
           }

        }
        return new int[] {-1, -1};
    }

    static int[] search(int[][] matrix, int target){
        int row = matrix.length; // Matrix can be one dimensional
        int col = matrix[0].length;

        if (row == 1){
            return simpleBinarySearch(matrix,target,0,0,col-1);
        }
        int rStart = 0;
        int rEnd = row - 1;

        int cMid = col / 2;
        //Run Loop till two rows ramming...
        while (rStart < (rEnd - 1)){ // While this true it will have more than 2 rows...
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target)
                return new int[]{mid,cMid};

            if (matrix[mid][cMid] < target)
                rStart = mid;
            else
                rEnd = mid;

        }
        //Now Two rows left
        // *check for target in two rows -->

        if (matrix[rStart][cMid] == target)
            return new int[] {rStart, cMid};

        if (matrix[rStart + 1][cMid] == target)
            return new int[]{rStart + 1, cMid};


        //Now search in to first half
        if (target <= matrix[rStart][cMid - 1])
            return simpleBinarySearch(matrix,target,rStart,0,cMid - 1);

        //Now search in to second half
        if (target >= matrix[rStart][cMid + 1] && target  <= matrix[rStart][col - 1]);
            return simpleBinarySearch(matrix,target,rStart,cMid + 1,col - 1);

        //Now search in to third half
//        if (target <= matrix[rStart + 1][cMid - 1])
//            return simpleBinarySearch(matrix,target,rStart + 1,0,cMid - 1);
//
//        //Now search in to fourth half
//        else
//            return simpleBinarySearch(matrix,target,rStart + 1,cMid + 1,col - 1);




    }
}
