package collectaions;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<String>  priorityQueueST = new PriorityQueue<>();

        List<Integer> ints = Arrays.asList(1,2,3,24,5,2,5,6,6,54,74,111);

        priorityQueue.addAll(ints);
        System.out.println(priorityQueue);

        /**
         *  public PriorityQueue(int initialCapacity,
         *                          Comparator<? super E> comparator)
         */
        priorityQueue = new PriorityQueue(ints.size(),Collections.reverseOrder());
        priorityQueue.addAll(ints);
        System.out.println(priorityQueue);

        String notice = "EDUCATION SHOULD ESCHEW OBFUSCATION";

        List<String> strings = Arrays.asList(notice.split(" "));

        //reverseOrder() sort
        PriorityQueue<String> stringPQ = new PriorityQueue<>(strings);
        priorityQueueST=new PriorityQueue<>(strings.size(),Collections.reverseOrder());
        priorityQueueST.addAll(stringPQ);
        System.out.println(priorityQueueST);

        QueueDemo.printQ(stringPQ);

        //
        Set<Character> charSet = new HashSet<>();
        for(char c:notice.toCharArray())
            charSet.add(c); //Autoboxing

        //?消除重复的 char
        PriorityQueue<Character> characterPQ = new PriorityQueue<>(charSet);
        QueueDemo.printQ(characterPQ);



    }
}
