package com.ashish;

public class SqrtOfX {
    public static void main(String[] args) {
        System.out.println(mySqrt(0));
    }

    static int mySqrt (int x){


        if(x==0){
            return 0 ;
        }
        int st = 1;
        int end = x;
        while (st<end){
            int mid =  st + (end-st)/2;

            if(mid==x/mid){
                return mid;

            }

            if(mid < x/mid){
                st =  mid +1;
            }else{
                end=mid-1;
            }
        }

        return end;



    }
}

