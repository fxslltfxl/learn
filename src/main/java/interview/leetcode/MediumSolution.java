package interview.leetcode;


import org.jetbrains.annotations.NotNull;

public class MediumSolution {

    public static void main(String[] args) {
        char c = '-';
        System.out.println(c);
    }

    //TODO 还没有写完
    public int myAtoi(@NotNull String str) {

        long res = 0;
        String trim = str.trim();
        int length = trim.length();
        char[] chars = str.toCharArray();

        char first = chars[0];
        if (first == '-' || (first >= 48 && first <= 57)) {

        } else {
            return 0;
        }

        return (int) res;
    }

}
