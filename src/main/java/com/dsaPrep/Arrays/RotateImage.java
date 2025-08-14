package com.dsaPrep.Arrays;

public class RotateImage {
    // TC O(n^2) | SC O(1)
    // LeetCode 48 - Rotate Image
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //Insert row - col && col - row
        for(int i = 0 ; i < n; i++){
            for(int j = i ; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reverse each row
        for(int i = 0 ; i < n; i++){
            int left = 0;
            int right = n-1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotateImage.rotate(matrix);

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
