
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceComparison {
    private static final int LIST_SIZE = 100000;
    private static final int INSERT_SIZE = 1000;
    private static long startTime;

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("List size: " + LIST_SIZE);
        System.out.println("Elements to insert: " + INSERT_SIZE);

        // Fill list
        startTimer();
        fill(arrayList, LIST_SIZE, "ArrayList");
        printExecutionTime("Fill ArrayList");
        fill(linkedList, LIST_SIZE, "LinkedList");
        printExecutionTime("Fill LinkedList");

        // Random access
        startTimer();
        randomAccess(arrayList, "ArrayList");
        printExecutionTime("Random access in ArrayList");

        randomAccess(linkedList, "LinkedList");
        printExecutionTime("Random access in LinkedList");

        // Sequential access
        startTimer();
        sequentialAccess(arrayList, "ArrayList");
        printExecutionTime("Sequential access in ArrayList");

        sequentialAccess(linkedList, "LinkedList");
        printExecutionTime("Sequential access in LinkedList");

        // Insert at the beginning
        startTimer();
        insertAtBeginning(arrayList, INSERT_SIZE, "ArrayList");
        printExecutionTime("Insert at beginning of ArrayList");

        insertAtBeginning(linkedList, INSERT_SIZE, "LinkedList");
        printExecutionTime("Insert at beginning of LinkedList");

        // Insert at the end
        startTimer();
        insertAtEnd(arrayList, INSERT_SIZE, "ArrayList");
        printExecutionTime("Insert at end of ArrayList");

        insertAtEnd(linkedList, INSERT_SIZE, "LinkedList");
        printExecutionTime("Insert at end of LinkedList");

        // Insert in the middle
        startTimer();
        insertInMiddle(arrayList, INSERT_SIZE, "ArrayList");
        printExecutionTime("Insert in middle of ArrayList");

        insertInMiddle(linkedList, INSERT_SIZE, "LinkedList");
        printExecutionTime("Insert in middle of LinkedList");
    }

    private static void fill(List<Integer> list, int count, String listType) {
        for (int i = 0; i < count; i++) {
            list.add((int) (Math.random() * count));
        }
    }

    private static void randomAccess(List<Integer> list, String listType) {
        for (int i = 0; i < LIST_SIZE; i++) {
            list.get((int) (Math.random() * LIST_SIZE));
        }
    }

    private static void sequentialAccess(List<Integer> list, String listType) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private static void insertAtBeginning(List<Integer> list, int count, String listType) {
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
    }

    private static void insertAtEnd(List<Integer> list, int count, String listType) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
    }

    private static void insertInMiddle(List<Integer> list, int count, String listType) {
        int middle = LIST_SIZE / 2;
        for (int i = 0; i < count; i++) {
            list.add(middle, i);
        }
    }

    private static void startTimer() {
        startTime = System.currentTimeMillis();
    }

    private static void printExecutionTime(String name) {
        System.out.printf("%s: %d ms\n", name, System.currentTimeMillis() - startTime);
    }
}