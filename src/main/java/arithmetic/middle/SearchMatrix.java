package arithmetic.middle;


//Write an efficient algorithm that searches for a target value in an m x n inte
//ger matrix. The matrix has the following properties:
//
//
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
//
//
//
// Example 1:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
//
//
// Example 2:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= n, m <= 300
// -109 <= matrix[i][j] <= 109
// All the integers in each row are sorted in ascending order.
// All the integers in each column are sorted in ascending order.
// -109 <= target <= 109
//
// Related Topics Array Binary Search Divide and Conquer Matrix
// 👍 5796 👎 102

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2021/10/11
 **/
public class SearchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int m = 0;
        int n = col - 1;
        while (m < row && n >= 0) {
            if (matrix[m][n] > target) {
                n--;
            } else if (matrix[m][n] < target) {
                m++;
            } else {
                return true;
            }
        }
        return false;
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