package leetcode.middle;

import java.util.List;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2021/11/25
 **/
public class Number524 {

    public String findLongestWord(String s, List<String> dictionary) {

        String result = "";
        for (String item : dictionary) {
            int i = 0, j = 0;
            while (j < s.length() && i < item.length()) {
                if (item.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
                if (i == item.length()) {
                    if (item.length() > result.length()) {
                        result = item;
                    }
                }
            }
        }
        return result;
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