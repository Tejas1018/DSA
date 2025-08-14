package com.dsaPrep.BinarySearch;

public class MedianInARowWiseSortedMatrix {
    int median(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int i = 0 ; i < n; i++){
            left = Math.min(left,mat[i][0]);
            right = Math.max(right,mat[i][m-1]);
        }
        int required = (n*m+1)/2;
        while(left <= right){
            int mid = (left+right)/2;
            int smallerElements = findNoOfElementsLesser(mat,mid);
            if(smallerElements <= required){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return right;
    }
    int findNoOfElementsLesser(int mat[][],int mid){
        int count = 0;
        for(int i = 0 ;i < mat.length; i++){
            count += upperBound(mat[i],mid);
        }
        return count;
    }
    int upperBound(int mat[],int target){
        int low = 0;
        int high = mat.length-1;
        int ans = mat.length;
        while(low <= high){
            int mid = (low+high)/2;
            if(mat[mid] <= target){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
}
