package com.dsaPrep.BinarySearch;

public class KthElementInTwoSortedArrays {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n1 = a.length;
        int n2 = b.length;
        if(n1 > n2){
            return kthElement(b,a,k);
        }
        int low = Math.max(0,k-n2);
        int high = Math.min(k,n1);
        int totalLength = n1+n2;
        while(low <= high){
            int partitionX = (low+high) /2;
            int partitionY = k - partitionX;
            int l1 = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX-1];
            int l2 = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY-1];
            int r1 = (partitionX == n1) ? Integer.MAX_VALUE : a[partitionX];
            int r2 = (partitionY == n2) ? Integer.MAX_VALUE : b[partitionY];
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }
            else if(l1 > r2){
                high = partitionX-1;
            }
            else{
                low = partitionX+1;
            }
        }
        return 0;
    }
}
