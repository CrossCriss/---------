import java.util.ArrayList;

public class BubbleSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> array = new ArrayList<>(input); // Create a copy of the input array
        int size = array.size();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    // Swap elements if they are in the wrong order
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }

        return array;
    }
}
