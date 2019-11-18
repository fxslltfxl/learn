package interview.algorithm;

import java.util.Arrays;

public class test1 {


    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int length = A.length;
        boolean isOdd = length % 2 == 1;
        int mid = length / 2;
        if (length <= 1) {
            return -2;
        } else {
            if (isOdd) {
                int resBefore = A[mid] - A[mid - 1];
                int resAfter = A[mid + 1] - A[mid];
                return Math.min(resAfter,resBefore);
            } else {
                return A[mid] - A[mid - 1];
            }
        }
    }


    public static int test(){
        try {
            return 1;
        }finally {
            System.out.println("method of test");

        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,8,4,5};

        try {
            test();
            return;
        }finally {
            System.out.println("test");
        }


//        System.out.println(solution(A));
    }
}
