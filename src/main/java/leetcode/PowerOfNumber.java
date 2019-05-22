package leetcode;

public class PowerOfNumber {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(32));
        System.out.println(isPowerFourOneLine(32));
        System.out.println(isPowerOfTwo(6));

    }

    private static boolean isPowerOfFour(Integer num) {
        String binary = Integer.toString(num, 2);
        char one = '1';
        int count = 0, index = 0, length = binary.length();
        for (int i = length-1; i >= 0; i--) {
            if (binary.charAt(i) == one) {
                count++;
                index = length-i-2;// binary `val`
            }
        }
        return count == 1 && index % 2 != 0;
    }

    private static boolean isPowerFourOneLine(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }

    private static boolean isPowerOfTwo(int num) {
        return (num & (num - 1)) == 0;
    }

    private static boolean isPowerThree(int num) {
        return false;
    }

}
