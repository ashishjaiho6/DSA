package com.sorting;

public class FindMissing {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int ans = missingNumber(nums);

        System.out.println("ANS is : " + ans);
    }
    static int missingNumber(int[] nums) {
        int i =0;

        while(i < nums.length){

            int correctIndex = nums[i];

            if(nums[i]<nums.length && nums[i]!= nums[correctIndex]){
                swap(nums,i,nums[i]);
            }else{
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (j != nums[j]) {
                return j;
            }
        }

return nums.length;

    }

    static void swap(int[] array , int f,  int s){
        int temp = array[f];
        array[f]= array[s];
        array[s]= temp;
    }
}
