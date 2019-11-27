package leetcode;

import java.util.Stack;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/11/26
 **/
public class DecodeString {
    public static void main(String[] args) {
        StringBuilder test = new StringBuilder("sd2[f2[e]g]i");


        String s = decodeString(test.toString());

        System.out.println(s);


    }

    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //'['
            if (c == 0x5D) {
                StringBuilder sb = new StringBuilder();
                while (!characters.peek().equals('[')) {
                    sb.insert(0, characters.pop());
                }
                //去除  '['
                characters.pop();
                StringBuilder sbNum = new StringBuilder();
                while (!characters.isEmpty() && characters.peek() >= 0x30 && characters.peek() <= 0x39) {
                    sbNum.insert(0, characters.pop());
                }
                int num = Integer.parseInt(sbNum.toString());
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    stringBuilder.append(sb);
                }
                if (characters.contains('[')) {
                    for (int j = 0; j < stringBuilder.length(); j++) {
                        characters.push(stringBuilder.charAt(j));
                    }
                } else {
                    while (!characters.isEmpty()) {
                        stringBuilder.insert(0, characters.pop());
                    }
                    res.append(stringBuilder);
                }
            } else {
                characters.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!characters.isEmpty()) {
            stringBuilder.insert(0, characters.pop());
        }
        res.append(stringBuilder);
        return res.toString();
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