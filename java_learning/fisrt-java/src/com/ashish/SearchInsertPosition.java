package com.ashish;

public class SearchInsertPosition {
    public static void main(String[] args) {
       int[] nums = {1,3,5,6};
       int target = 2;
        int is = binary(nums,target);
        System.out.println("ans "+ is);
    }


    static int binary(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;

        if(target > nums[nums.length - 1]){
            return nums.length;
        }

        if(target < nums[0]){
            return 0;
        }

        while (st < end) {

            int mid = st + (end - st) / 2;



            if (target == nums[mid]) {
                return mid;
            }

            if (target > nums[mid]) {
                st = mid + 1;

            } else {
                end = mid;
            }

        }
        return st;
    }
}
