package com.dsaPrep.BinarySearch;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = (n*m)-1;    //Hipothetically think 2d matrix is 1d matrix
        while(left <= right){
            int mid = (left+right)/2;
            int row = mid/m; //for finding the mid element in the row wise 2-d matrix
            int col = mid%m; //For finding the mid ele in the col wise 2d matrix
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return false;
    }
}
