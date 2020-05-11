package collections.list.linkedlist;

import java.util.LinkedList;

/**
 * head ------- tail
 */

public class Ex2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.offer("c");
        list.offerFirst("rr");


        System.out.println(list.element());

//        System.out.println(new LinkedList<>().element());


        LinkedList<String> empty = new LinkedList<>();

        System.out.println(list.peek());
        System.out.println(list.poll());
        System.out.println(list);
        System.out.println(empty.poll());

        // from deque
        list.pop(); // removeFirst()
        System.out.println(list);
//        empty.pop();


    }
}
