package com.problem.solving;

public class SquareRoot {

    public static int mySqrt(int x) {
        int low = 0, high = x;
        while (low<= high)  {
            var mid = low + (high - low) /2;
            if(mid * mid == x)  {
                return mid;
            }
            if(mid > x/mid)  {
                high = mid - 1;
            }   else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
