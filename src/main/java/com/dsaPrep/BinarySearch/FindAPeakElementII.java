package com.dsaPrep.BinarySearch;

public class FindAPeakElementII {
    int findMaxRowIndex(int mat[][],int n,int m,int col){
        int index = -1;
        int maxElement = -1;
        for(int i = 0 ; i < n; i++){
            if(mat[i][col] > maxElement){
                maxElement = mat[i][col];
                index = i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int result[] = new int[2];
        int low = 0;
        int high = m-1;
        while(low <= high){
            int mid = (low+high)/2;
            int maxRowIndex = findMaxRowIndex(mat,n,m,mid);
            int left = (mid-1) >= 0 ? mat[maxRowIndex][mid-1] : -1;
            int right = (mid+1) <= m-1 ? mat[maxRowIndex][mid+1] : -1;
            if(mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right){
                result[0] = maxRowIndex;
                result[1] = mid;
                return result;
            }
            else if(mat[maxRowIndex][mid] < left){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return result;
    }
}
