package interview.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args) {


        longestSubString("abcda");
    }

    public static String longestSubString(String s) {


        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }
        int startIndex = 0, endIndex = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            Integer start = hashMap.get(aChar);
            if (start == null) {
                hashMap.put(aChar, i);
            } else {
                int lengthLessOne = i - start;
                if (lengthLessOne > endIndex - startIndex && lengthLessOne + 1 < s.length()) {
                    endIndex = i;
                    startIndex = start;
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }


    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
