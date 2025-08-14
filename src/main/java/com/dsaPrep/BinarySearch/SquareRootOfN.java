package com.dsaPrep.BinarySearch;

public class SquareRootOfN {
    //TC : O(sqrt(n))
    int perfectSquare(int n){
        int index = -1;

        for(int i = 1; i <= n; i++){
            if(i * i == n){
                index = i;
                break;
            }
            else if(i * i > n){
                index = i-1;
                break;
            }
        }
        return index;
    }

    int perfectSquare1(int n){
        int left = 1;
        int right = n;
        int index = -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(mid*mid == n){
                index = mid;
                break;
            }
            else if(mid * mid < n){
                index = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        SquareRootOfN squareRootOfN = new SquareRootOfN();
        int n = 28; // Example input
        int result = squareRootOfN.perfectSquare1(n);
        if (result != -1) {
            System.out.println("The largest integer whose square is less than or equal to " + n + " is: " + result);
        } else {
            System.out.println("No perfect square found for " + n);
        }
    }
}
