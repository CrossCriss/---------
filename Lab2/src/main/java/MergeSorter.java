import java.util.ArrayList;

public class MergeSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> array = new ArrayList<>(input); // Create a copy of the input array
        mergeSort(array, 0, array.size() - 1);
        return array;
    }

    private void mergeSort(ArrayList<Integer> array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid); // Sort the left half
            mergeSort(array, mid + 1, right); // Sort the right half
            merge(array, left, mid, right); // Merge the sorted halves
        }
    }

    private void merge(ArrayList<Integer> array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            leftArray.add(array.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightArray.add(array.get(mid + 1 + j));
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                array.set(k, leftArray.get(i));
                i++;
            } else {
                array.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            array.set(k, leftArray.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            array.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }
}
