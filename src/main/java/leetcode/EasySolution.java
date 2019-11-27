package interview.leetcode;

public class EasySolution {
    public static void main(String[] args) {
//        reverse(1534236469);
    }

//    public static int reverse(int x) {
//
//        boolean isNegative = false;
//        if (x < 0) {
//            isNegative = true;
//            x = -x;
//        }
//        String s = String.valueOf(x);
//        int length = s.length();
//        if (length == 1) {
//            return x;
//        }
//
//        double middle = length / 2.00;
//        char[] chars = new char[length];
//        s.getChars(0, length, chars, 0);
//
//        int floor;
//        if (length % 2 == 0) {
//            floor = length / 2;
//        } else {
//            floor = (int) Math.floor(middle);
//        }
//        for (int i = 0; i < floor; i++) {
//            chars[i] = (char) (chars[i] ^ chars[length - 1 - i]);
//            chars[length - 1 - i] = (char) (chars[length - 1 - i] ^ chars[i]);
//            chars[i] = (char) (chars[i] ^ chars[length - 1 - i]);
//        }
//        String result = new String(chars);
//        int i;
//        try {
//            i = Integer.parseInt(result);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            return 0;
//        }
//
//        if (isNegative) {
//            return -i;
//        } else {
//            return i;
//        }
//    }


    public int reverse(int x) {

        long result = 0;

        while (x != 0) {
            long high = x % 10;
            result = result * 10 + high;
            x /= 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }


}
