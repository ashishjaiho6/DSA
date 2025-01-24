package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMismatch {

    public static void main(String[] args) {
        int[] nums = {1,1};

        // Find all missing numbers
        int[] ans = findErrorNums(nums);

        // Print the result
        System.out.println("Your Ans is: " + Arrays.toString(ans));

    }

    static int[] findErrorNums(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int correct = nums[i] - 1; // The correct index for nums[i]
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

//        System.out.println("Sorted Array : "+ Arrays.toString(nums));


        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return new int[] {nums[j],j+1};
            }
        }

        return new int[]{-1, -1};
    }


    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}


