import java.util.ArrayList;

public class QuickSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> array = new ArrayList<>(input); // Create a copy of the input array
        quickSort(array, 0, array.size() - 1);
        return array;
    }

    private void quickSort(ArrayList<Integer> array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1); // Sort the elements before the pivot
            quickSort(array, pivotIndex + 1, high); // Sort the elements after the pivot
        }
    }

    private int partition(ArrayList<Integer> array, int low, int high) {
        int pivot = array.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array.get(j) <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(ArrayList<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
