package com.dsaPrep.BinarySearch;

public class BookAllocation {
    public static int findPages(int[] arr, int k) {
        //Arrays.sort(arr);
        int length = arr.length;
        if(k > length){
            return -1;  //students are more than the no.of books
        }
        int totalPages = 0;
        int maxPages = 0;
        for(int i = 0 ; i < length; i++){
            totalPages += arr[i];
            maxPages = Math.max(maxPages,arr[i]);
        }
        if(k == 1){
            return totalPages;
        }
        int left = maxPages;
        int right = totalPages;
        int possiblePages = 0;
        while(left <= right){
            int mid = (left+right)/2;
            if(canAllocate(arr,mid,k)){
                possiblePages = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return possiblePages;
    }
    static boolean canAllocate(int arr[],int maxPages,int students){
        int totalPagesForEachStudent = 0;
        int totalStudents = 1;
        for(int i = 0; i < arr.length; i++){
            if(totalPagesForEachStudent+arr[i] <= maxPages){
                totalPagesForEachStudent += arr[i];
            }
            else{
                totalPagesForEachStudent = arr[i];
                totalStudents++;
                if(totalStudents > students) return false;
            }
        }
        return true;
    }
}
