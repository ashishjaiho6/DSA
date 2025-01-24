package com.sorting;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissing {

    public static void main(String[] args) {
        // Input array
        int[] nums = {1, 1};

        // Find all missing numbers
        List<Integer> ans = findDisappearedNumbers(nums);

        // Print the result
        System.out.println("Your Ans is: " + ans);
    }

    /**
     * Definition:
     * This function finds all the missing numbers in the range [1, n] from an input array of size n.
     * The array is assumed to contain integers in the range [1, n] with some numbers possibly repeated.
     * It uses a cyclic sort approach to place each number at its correct index, and then identifies
     * the missing numbers based on misplaced indices.
     *
     * Time Complexity: O(n)
     * - The while loop iterates through the array, performing constant-time swaps, so it runs in linear time.
     *
     * Space Complexity: O(1)
     * - The sorting is done in place, with the only additional space being the list to store missing numbers.
     *
     * @param nums the input array
     * @return a list of all missing numbers in the range [1, n]
     */
    static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;

        // Cyclic sort to place each number at its correct index
        while (i < nums.length) {
            int correct = nums[i] - 1; // The correct index for nums[i]
            if (nums[i] != nums[correct]) {
                // Swap nums[i] with the number at its correct index
                swap(nums, i, correct);
            } else {
                // Move to the next index if the number is already in the correct place
                i++;
            }
        }

        // Initialize a list to store missing numbers
        List<Integer> ans = new ArrayList<>();

        // Find all indices where the number is not in its correct position
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans.add(j + 1); // Add the missing number to the result list
            }
        }

        return ans;
    }

    /**
     * Helper function to swap two elements in the array.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param arr the array
     * @param first the index of the first element
     * @param second the index of the second element
     */
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
