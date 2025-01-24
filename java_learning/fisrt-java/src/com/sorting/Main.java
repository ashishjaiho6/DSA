package com.sorting;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Array to be sorted
        int[] arr = {5, 3, 4, 1, 2};

        // Calling the insertion sort method
        insertion(arr);

        // Printing the sorted array
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Insertion Sort Algorithm
     * Definition:
     *   Insertion sort builds the sorted array one element at a time.
     *   It picks an element from the unsorted portion and places it in its correct position in the sorted portion.
     *
     * Time Complexity:
     *   - Best Case: O(n) (when the array is already sorted)
     *   - Worst Case: O(n^2) (when the array is sorted in reverse order)
     *   - Average Case: O(n^2)
     * Space Complexity: O(1) (in-place sorting)
     */
    static void insertion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Start checking from the current element backwards
            for (int j = i + 1; j > 0; j--) {
                // Swap if the current element is smaller than the previous element
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    // If no swap is needed, the inner loop breaks early
                    break;
                }
            }
        }
    }

    /**
     * Selection Sort Algorithm
     * Definition:
     *   Selection sort repeatedly selects the smallest (or largest) element
     *   from the unsorted portion of the array and places it at the correct position.
     *
     * Time Complexity:
     *   - Best Case, Worst Case, Average Case: O(n^2)
     * Space Complexity: O(1) (in-place sorting)
     */
    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Find the index of the maximum element in the unsorted part of the array
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);

            // Swap the maximum element with the last element in the unsorted part
            swap(arr, maxIndex, last);
        }
    }

    /**
     * Bubble Sort Algorithm
     * Definition:
     *   Bubble sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.
     *   After each pass, the largest element "bubbles up" to its correct position in the array.
     *
     * Time Complexity:
     *   - Best Case: O(n) (when the array is already sorted)
     *   - Worst Case: O(n^2) (when the array is sorted in reverse order)
     *   - Average Case: O(n^2)
     * Space Complexity: O(1) (in-place sorting)
     */
    static void bubble(int[] arr) {
        boolean swapped;

        // Perform the sorting for (n-1) passes
        for (int i = 0; i < arr.length; i++) {
            swapped = false;

            // Push the maximum element to its correct position in this pass
            for (int j = 1; j < arr.length - i; j++) {
                // Swap adjacent elements if they are in the wrong order
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swapped = true; // Mark that a swap has occurred
                }
            }

            // If no swaps occurred during this pass, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Swap Method
     * Definition:
     *   Swaps two elements in the array.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    /**
     * Get Max Index Method
     * Definition:
     *   Finds the index of the maximum element in a given range of the array.
     *
     * Time Complexity: O(n) (where n is the size of the range)
     * Space Complexity: O(1)
     */
    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;

        // Iterate through the array to find the maximum element
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
