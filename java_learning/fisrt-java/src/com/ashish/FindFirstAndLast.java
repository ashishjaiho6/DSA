package com.ashish;

import java.util.Arrays;
import java.util.Scanner;

public class FindFirstAndLast {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Define the input array
        int[] array = {5, 7, 7, 8, 8, 10};

        // Prompt user for the target value
        System.out.println("Enter the target:");
        int target = input.nextInt();

        // Call the method to find the first and last occurrence of the target
        int[] ans = searchRange(array, target);

        // Output the result
        System.out.println("Answer: " + Arrays.toString(ans));
    }

    /**
     * Finds the first and last occurrence of a target in the sorted array.
     *
     * @param nums   The sorted input array.
     * @param target The value to search for.
     * @return An array with two integers: the first and last occurrence of the target. Returns [-1, -1] if not found.
     */
    static int[] searchRange(int[] nums, int target) {
        // Handle edge case: empty array
        if (nums.length < 1) {
            return new int[]{-1, -1};
        }

        // Find the first and last occurrence
        int firstOcc = findFirstOccurrence(nums, target);
        int lastOcc = findLastOccurrence(nums, target);

        return new int[]{firstOcc, lastOcc};
    }

    /**
     * Finds the first occurrence of a target in the sorted array.
     *
     * @param nums   The sorted input array.
     * @param target The value to search for.
     * @return The index of the first occurrence, or -1 if not found.
     */
    static int findFirstOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        // Edge cases: target out of bounds
        if (target > nums[nums.length - 1] || target < nums[0]) {
            return -1;
        }

        // Binary search for first occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid; // Update answer and continue searching in the left half
                end = mid - 1;
            }
        }

        return ans;
    }

    /**
     * Finds the last occurrence of a target in the sorted array.
     *
     * @param nums   The sorted input array.
     * @param target The value to search for.
     * @return The index of the last occurrence, or -1 if not found.
     */
    static int findLastOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        // Edge cases: target out of bounds
        if (target > nums[nums.length - 1] || target < nums[0]) {
            return -1;
        }

        // Binary search for last occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                ans = mid; // Update answer and continue searching in the right half
                start = mid + 1;
            }
        }

        return ans;
    }
}
