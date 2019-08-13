package interview.leetcode;

public class ZigZagPattern {
    public static void main(String[] args) {
        System.out.println(convertZigZagString("PAYPALISHIRING",3));
    }

    /**
     * 类似 组相联
     * 思路：一个V 字为 一组  每组对应位置间距是一样的 每组个数为2*（N-1）（N为行数）
     * <p>
     * 当前组的第一个字符所在位置为 j - i (i为第几行 )
     * 所以倒数第 i 个就是 size-i（每组 i行上 {i!=0 i!=N-1} 对应 "V" 的向上部分的位置）
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convertZigZagString(String s, int numRows) {

        int length = s.length();
        int sizeOfPerGroup = (numRows - 1) * 2;
        if (numRows == 1 || numRows >= length) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < length; j += sizeOfPerGroup) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && ((j - i) + (sizeOfPerGroup - i)) < length) {
                    sb.append(s.charAt((j - i) + (sizeOfPerGroup - i)));
                }
            }
        }

        return sb.toString();
    }


}
