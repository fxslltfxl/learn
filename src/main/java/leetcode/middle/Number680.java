package leetcode.middle;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2021/11/22
 **/
public class Number680 {
//    public boolean validPalindrome(String s) {
//        int i = 0, j = s.length();
//        while (i < j) {
//            if (isPalindrome(s)) {
//                return true;
//            } else {
//                return isPalindrome(s.substring(++i, j)) || isPalindrome(s.substring(i, --j));
//            }
//        }
//        return true;
//    }
//
//    public boolean isPalindrome(String s) {
//        int i = 0, j = s.length() - 1;
//        while (i < j) {
//            if (s.charAt(i) == s.charAt(j)) {
//                i++;
//                j--;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }


    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
//写字楼里写字间，写字间里程序员；  
//程序人员写程序，又拿程序换酒钱。  
//酒醒只在网上坐，酒醉还来网下眠；  
//酒醉酒醒日复日，网上网下年复年。  
//但愿老死电脑间，不愿鞠躬老板前；  
//奔驰宝马贵者趣，公交自行程序员。  
//别人笑我忒疯癫，我笑自己命太贱；  
//不见满街漂亮妹，哪个归得程序员？ 