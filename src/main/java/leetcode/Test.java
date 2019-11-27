package leetcode;

public class Test {
    public static void main(String[] a) {

//        int[] ints = {1, 2, 3, 4, 4, 4, 5};
//        //TwoSum
//        int[] ints1 = TwoSum.twoSum(ints, 5);
//
//        for (int i : ints1) {
//            System.out.println(i);
//        }
        Solution solution = new Solution();
        Solution.ListNode node1 = solution.new ListNode(3);
        node1.next = solution.new ListNode(4);
        node1.next.next = solution.new ListNode(2);

        Solution.ListNode node2 = solution.new ListNode(4);
        node2.next = solution.new ListNode(6);
        node2.next.next = solution.new ListNode(5);

        solution.addTwoNumbers(node1, node2);

    }

    int[] arr = new int[100];

    int index1 = 0;

    int index2 = arr.length - 1;

    public boolean push1(int i) {
        if (index1 < 0 || index1 > arr.length - 1) {
            return false;
        }
        if (index1 > index2) {
            throw new RuntimeException("");
        }
        arr[index1] = i;
        index1++;
        return true;
    }


    public void push2() {

    }
}
