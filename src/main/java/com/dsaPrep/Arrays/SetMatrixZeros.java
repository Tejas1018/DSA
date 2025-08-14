package com.dsaPrep.Arrays;

public class SetMatrixZeros {
    //LeetCode 73 - Set Matrix Zeros
    //TC O(m*n) | SC O(m*n)
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int visited[][] = new int[row][col];
        for(int i = 0 ;i < row; i++){
            for(int j = 0 ; j < col; j++){
                if(matrix[i][j] == 0){
                    rowMark(visited,i,j);
                    colMark(visited,i,j);
                }
            }
        }

        //set to 0 those cells which have value -1
        for(int i = 0 ; i < row; i++){
            for(int j = 0 ; j < col; j++){
                if(visited[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    void rowMark(int a[][],int i,int j){
        for(int k = 0 ; k < a[0].length; k++){

            a[i][k] = -1;

        }
    }

    void colMark(int a[][],int i,int j){
        for(int k = 0 ; k < a.length; k++){

            a[k][j] = -1;

        }
    }

    public static void main(String[] args) {
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setMatrixZeros.setZeroes(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
