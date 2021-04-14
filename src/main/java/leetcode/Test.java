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
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        AddTwoNumbers.ListNode node1 = addTwoNumbers.new ListNode(3);
        node1.next = addTwoNumbers.new ListNode(4);
        node1.next.next = addTwoNumbers.new ListNode(2);

        AddTwoNumbers.ListNode node2 = addTwoNumbers.new ListNode(4);
        node2.next = addTwoNumbers.new ListNode(6);
        node2.next.next = addTwoNumbers.new ListNode(5);

        addTwoNumbers.addTwoNumbers(node1, node2);

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
