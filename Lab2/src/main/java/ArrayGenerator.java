import java.util.ArrayList;
import java.util.Random;

public class ArrayGenerator {
    public static ArrayList<Integer> generateArray(int count, int range) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            array.add(random.nextInt(range + 1));
        }
        return array;
    }
}
