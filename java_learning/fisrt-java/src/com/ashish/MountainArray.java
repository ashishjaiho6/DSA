package com.ashish;

import java.util.Scanner;

public class MountainArray {
    public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,5,4,3,2,1};
int  ans =  peakIndexInMountainArray(arr);
        System.out.println("Ans is " + ans  );
    }
    static int peakIndexInMountainArray (int[] array ){
        int start = 0;
        int end = array.length-1;

        while(start<end){
            int mid = start + (end-start)/2;

            if (array[mid] > array[mid+1]){
                end = mid;
            }
            else{
                start = mid +1;
            }
        }

        return  start ;
    }
}
