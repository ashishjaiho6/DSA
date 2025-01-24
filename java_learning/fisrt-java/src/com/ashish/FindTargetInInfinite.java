package com.ashish;

public class FindTargetInInfinite {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 180;
        System.out.println(ans(arr, target));
    }

    static int ans(int[] arr, int target) {
        int start = 0;
        int end = 1;

        // Expand the range exponentially until the target is less than or equal to `arr[end]`.
        while (end < arr.length && target > arr[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;

            // Avoid going out of bounds
            if (end >= arr.length) {
                end = arr.length - 1;
            }

            start = newStart;
        }

        // If the target is outside the bounds of the array
        if (start >= arr.length) {
            return -1;
        }
        if (end >= arr.length) {
            return -1;
        }

        // Perform binary search within the determined range
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1; // Return -1 if the target is not found
    }
}
