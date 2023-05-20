import java.util.ArrayList;
import java.util.List;

public class SortingPerformance {
    private static final int[] ARRAY_SIZES = {10, 1000, 10000, 1000000};
    private static final int RANGE = 100;

    public static void main(String[] args) {
        for (int count : ARRAY_SIZES) {
            System.out.println("Array size: " + count);
            ArrayList<Integer> array = ArrayGenerator.generateArray(count, RANGE);
            array.subList(0, count > 100 ? 50 : count); // Print the first 50 elements of the array or all elements if <= 100
            for (SortingType type : SortingType.values()) {
                System.out.println("Sorting type: " + type);
                Sorter sorter = SorterFactory.getSorter(type);
                long startTime = System.currentTimeMillis();
                ArrayList<Integer> sorted = sorter.sort(array);
                long endTime = System.currentTimeMillis();
                printArray(sorted.subList(0, Math.min(50, count))); // Print the first 50 elements of the sorted array
                System.out.println("Execution time: " + (endTime - startTime) + " ms");
            }
            System.out.println();
        }
    }

    private static void printArray(List<Integer> array) {
        StringBuilder sb = new StringBuilder();
        int size = array.size();
        for (int i = 0; i < size; i++) {
            sb.append(array.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}
