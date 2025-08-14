package com.dsaPrep.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // LeetCode 54 - Spiral Matrix
    // TC O(m*n) | SC O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(n == 0){
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = m-1;
        int dir = 0;
        while(top <= bottom && left <= right){
            if(dir == 0){
                // DIRECTION : left-right
                // CONSTANT :  Top
                for(int i = left; i <= right; i++){
                    ans.add(matrix[top][i]);
                }
                top++;
            }
            if(dir == 1){
                // DIRECTION : top - bottom
                // CONSTANT :  right
                for(int i = top; i <= bottom; i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }
            if(dir == 2){
                //  DIRECTION : right - left
                // CONSTANT :  bottom
                for(int i = right; i >= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(dir == 3){
                //DIRECTION :  bottom-top
                // CONSTANT : left
                for(int i = bottom; i >= top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            dir++;
            if(dir == 4){
                dir = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        System.out.println("Spiral Order: " + result);
    }
}
