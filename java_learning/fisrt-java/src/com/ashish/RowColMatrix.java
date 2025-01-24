package com.ashish;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class RowColMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix = {
                {10,20,30,40,},{15,25,35,45},{28,29,37,49},{33,34,38,50}
        };

        System.out.println("type number to search");
        int target =  input.nextInt();
        int[] ans =  findTargetInMatrix(matrix,target);
        System.out.println("Ans is :: "+ Arrays.toString(ans));



    }

    static int[]  findTargetInMatrix(int[][] matrix, int target){
        int r= 0;
        int c = matrix.length-1;

        while(r < matrix.length-1 && c >=0){
            if (matrix[r][c] == target){
                return new  int[]  {r, c};
            }

            if (matrix[r][c] < target){
                r++;
            }else{
                c--;
            }
        }
        return new int[] {-1,-1};
    }
}
