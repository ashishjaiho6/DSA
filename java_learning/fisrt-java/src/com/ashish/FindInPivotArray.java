package com.ashish;

public class FindInPivotArray {
    public static void main(String[] args) {
        int[] nums = {5, 1, 2, 3, 4};
        int target = 4;
        int ans = search(nums, target);
        System.out.println("Ans: " + ans);
    }

    static int search(int[] nums, int target) {
        // Find the pivot index where the array is rotated
        int pivotIndex = findPivotInArray(nums);

        System.out.println("pivotIndex: " + pivotIndex);

        // If no pivot, do a binary search on the entire array
        if (pivotIndex == -1) {
            return orderAgnosticBS(nums, target, 0, nums.length - 1);
        }

        // If the target is the pivot element
        if (nums[pivotIndex] == target) {
            return pivotIndex;
        }

        // If the pivot is at the start, search the right part
        if (pivotIndex == 0) {
            return orderAgnosticBS(nums, target, 1, nums.length - 1);
        }

        // Decide which part of the array to search
        if (target >= nums[0]) {
            return orderAgnosticBS(nums, target, 0, pivotIndex - 1);
        }
        return orderAgnosticBS(nums, target, pivotIndex + 1, nums.length - 1);
    }

    static int findPivotInArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is the pivot point
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // Check if mid-1 is the pivot point
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // If mid is less than start, move to the left part
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                // Otherwise, move to the right part
                start = mid + 1;
            }
        }
        return -1; // No pivot found
    }

    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is the pivot point
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // Check if mid-1 is the pivot point
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Skip duplicates and adjust the search range
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                // If left side is sorted, search the right part
                start = mid + 1;
            } else {
                // Otherwise, search the left part
                end = mid - 1;
            }
        }
        return -1; // No pivot found
    }

    static int orderAgnosticBS(int[] arr, int target, int start, int end) {
        // Check if array is sorted in ascending order
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If target is found
            if (arr[mid] == target) {
                return mid;
            }

            // Adjust search range based on sorting order
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
        return -1; // Target not found
    }
}
