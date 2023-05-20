import java.util.ArrayList;

public class ShellSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> array = new ArrayList<>(input); // Create a copy of the input array
        int size = array.size();

        // Start with a large gap and reduce it until gap is 1
        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                int temp = array.get(i);
                int j;
                for (j = i; j >= gap && array.get(j - gap) > temp; j -= gap) {
                    // Shift elements that are greater than temp to the right
                    array.set(j, array.get(j - gap));
                }
                array.set(j, temp);
            }
        }

        return array;
    }
}
