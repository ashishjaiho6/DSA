package com.sorting;

import java.util.Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
        // Input array
        int[] nums = {3,4,-1,1};

        // Find the first missing positive number
        int ans = firstMissingPositive2(nums);

        // Print the result
        System.out.println("The first missing positive is: " + ans);
    }

    static int firstMissingPositive2(int[] nums) {
        int n = nums.length;

        // Step 1: Mark numbers out of range (nums[i] <= 0 or nums[i] > n) as `n + 1`
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        System.out.println("After Step 1 => " + Arrays.toString(nums));

        // Step 2: Mark the presence of numbers by negating the value at the corresponding index
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]); // Get the absolute value
            if (num <= n) { // If the number is within the valid range
                nums[num - 1] = -Math.abs(nums[num - 1]); // Mark the index as negative
            }
        }

        System.out.println("After Step 2 => " + Arrays.toString(nums));

        // Step 3: Find the first positive index, which represents the missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1; // Return the missing positive number
            }
        }

        // Step 4: If all numbers are present, the missing number is n + 1
        return n + 1;
    }

    /**
     * Finds the first missing positive integer in the array.
     *
     * Algorithm: Cyclic Sort
     * - Place each number at its correct index (nums[i] should be at index nums[i] - 1).
     * - Iterate through the array to find the first index where nums[i] != i + 1.
     * - If all numbers are at their correct indices, return nums.length + 1.
     *
     * Time Complexity: O(n)
     * - Each number is moved to its correct position at most once.
     *
     * Space Complexity: O(1)
     * - Sorting is done in place without using extra space.
     *
     * @param nums The input array
     * @return The first missing positive integer
     */
    static int firstMissingPositive(int[] nums) {
        int i = 0;

        // Step 1: Cyclic sort to place each number in its correct index
        while (i < nums.length) {
            int correct = nums[i] - 1; // The correct index for nums[i]

            // Check if the number is within the valid range and not already in the correct position
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct); // Swap nums[i] with the number at its correct index
            } else {
                i++; // Move to the next index if the current number is already in the correct position
            }
        }

        // Print the sorted array for debugging purposes
        System.out.println("Sorted Array is: " + Arrays.toString(nums));

        // Step 2: Find the first missing positive number
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1; // The first missing positive integer
            }
        }

        // If all numbers are in their correct positions, return nums.length + 1
        return nums.length + 1;
    }

    /**
     * Helper method to swap two elements in the array.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param arr The array
     * @param first The index of the first element
     * @param second The index of the second element
     */
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
