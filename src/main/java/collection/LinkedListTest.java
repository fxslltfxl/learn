package collection;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();

        SetTest setTest = new SetTest();
        setTest.protectedMethod();
        setTest.friendlyMethod();
        //queue
        for (int i = 0; i < 10; i++) {
            strings.offer(i + "");
        }
        //Deque
        strings.offerFirst("offerFirst");
        strings.pollLast();
        strings.peekLast();


        //stack
        strings.pop();
        strings.push("Stack Push");

        //list
        strings.add("Add");
        strings.remove();

        //LinkNode


        System.out.println();
    }
}
