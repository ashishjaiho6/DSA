package com.ashish;

public class FindInMountainArray {
    public static void main(String[] args) {
        // Define a mountain array and the target element to find
        int[] mountainArr = {1, 2, 3, 4, 5, 7, 6, 3, 1};
        int target = 6;

        // Call the function to find the target in the mountain array
        int ans = findInMountainArray(mountainArr, target);

        // Print the result
        System.out.println("Answer: " + ans);
    }

    /**
     * Finds the target in a mountain array.
     * A mountain array has an increasing sequence followed by a decreasing sequence.
     */
    static int findInMountainArray(int[] mountainArr, int target) {
        // Find the peak index in the mountain array
        int peak = peakIndexInMountainArray(mountainArr);

        // Search for the target in the ascending part of the array
        int ans = orderAgnosticBS(mountainArr, target, 0, peak);
        if (ans != -1) {
            return ans; // Return if the target is found
        }

        // If not found, search in the descending part of the array
        int end = mountainArr.length - 1;
        return orderAgnosticBS(mountainArr, target, peak + 1, end);
    }

    /**
     * Finds the peak index in a mountain array.
     * The peak is the largest element, where the values increase then decrease.
     */
    static int peakIndexInMountainArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        // Binary search for the peak
        while (start < end) {
            int mid = start + (end - start) / 2;

            // If mid is greater than the next element, peak is in the left half
            if (array[mid] > array[mid + 1]) {
                end = mid;
            } else { // Otherwise, peak is in the right half
                start = mid + 1;
            }
        }

        // Start and end converge to the peak index
        return start;
    }

    /**
     * Performs a binary search to find the target in a sorted array.
     * Handles both ascending and descending order arrays.
     */
    static int orderAgnosticBS(int[] arr, int target, int start, int end) {
        // Determine if the array segment is sorted in ascending or descending order
        boolean isAsc = arr[start] < arr[end];

        // Binary search loop
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if the target is found
            if (arr[mid] == target) {
                return mid;
            }

            // Adjust the search range based on the order
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        // Return -1 if the target is not found
        return -1;
    }
}
