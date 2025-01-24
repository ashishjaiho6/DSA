package com.ashish;

import org.w3c.dom.ls.LSOutput;

public class PivotInRotatedarray {

    public static void main(String[] args) {
       int[] rotatedArray =  {3,4,5,6,7,2};

       int pivot = findPivotInArray(rotatedArray);

               System.out.println("Pivot is : " + pivot);

    }

    private static int findPivotInArray(int[] array) {
        int start = 0;
        int end = array.length-1;

        while(start <=  end){
            int mid =  start + (end-start)/2;

            if (mid < end && array[mid]>array[mid+1]){
               return mid;
            }
            if( mid < end && array[mid]<array[mid-1]){
                return  mid-1;
            }

            if (array[start] >= array[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }

        }
        return -1;
    }


}
