package heap;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * https://www.geeksforgeeks.org/priority-queue-class-in-java/
 */
public class PriorityQueueDemo {
    public static void main(String args[]) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("10");
        pq.add("20");
        pq.add("30");

        System.out.println("Initial PriorityQueue " + pq);

        // using the method
        pq.remove();

        System.out.println("After Remove - " + pq);

        System.out.println("Poll Method - " + pq.poll());

        System.out.println("Final PriorityQueue - " + pq);

        Iterator iterator = pq.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
