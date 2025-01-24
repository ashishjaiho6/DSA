package com.sorting;

import java.util.ArrayList;
import java.util.List;

public class DuplicateInArray {
    public static void main(String[] args) {
        int[] nums = {3,3,3,3,3};

        // Find all missing numbers
       int ans = findDuplicate(nums);

        // Print the result
        System.out.println("Your Ans is: " + ans);
    }


    static int findDuplicate(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int correct = nums[i] - 1; // The correct index for nums[i]
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        int ans = -1;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans = nums[j] ; // Add the missing number to the result list
            }
        }

        return ans;


    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
