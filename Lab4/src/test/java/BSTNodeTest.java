import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class BSTNodeTest {
    private BSTNode bst;
    private Map<Integer, String> map;

    @Before
    public void setUp() {
        bst = new BSTNode();
        map = new HashMap<>();
        int groupNumber = 10; // My group number
        int end = groupNumber + 20;

        List<Integer> keys = new ArrayList<>();
        for (int i = groupNumber; i < end; i++) {
            keys.add(i);
        }
        Collections.shuffle(keys); // Shuffle the keys

        for (int key : keys) {
            String value = "Value " + key;
            map.put(key, value);
        }
    }

    @After
    public void tearDown() {
        bst = null;
        map.clear();
        map = null;
    }

    @Test
    public void testBSTNode_InsertElements() {
        fillBSTNode();

        int expectedNodeCount = map.size();
        int actualNodeCount = bst.getNodeCount();
        Assert.assertEquals(expectedNodeCount, actualNodeCount);
    }

    @Test
    public void testBSTNode_SearchExistingElements() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            String expectedValue = entry.getValue();
            bst.insert(key, expectedValue);
            String actualValue = bst.search(key);
            Assert.assertEquals(expectedValue, actualValue);
        }
    }

    @Test
    public void testBSTNode_SearchNonExistentElement() {
        String actualValue = bst.search(-1);
        Assert.assertNull(actualValue);
    }

    @Test
    public void testBSTNode_InsertAndUpdateElements() {
        fillBSTNode();

        int keyToRemove = map.keySet().stream().skip(map.size() / 2).findFirst().orElse(null);
        map.remove(keyToRemove);
        bst.remove(keyToRemove); // Remove the key from the BSTNode structure as well

        String newValue = "New Value";
        bst.insert(keyToRemove, newValue);
        Assert.assertEquals(newValue, bst.search(keyToRemove));

        int existingKey = map.keySet().stream().findFirst().orElse(null);
        String updatedValue = "Updated Value";
        bst.insert(existingKey, updatedValue);
        Assert.assertEquals(updatedValue, bst.search(existingKey));

        int expectedNodeCount = map.size() + 2; // Account for the removed key and the updated key
        int actualNodeCount = bst.getNodeCount();
        Assert.assertEquals(expectedNodeCount, actualNodeCount);

        Assert.assertEquals(updatedValue, bst.search(existingKey));
    }

    @Test
    public void testBSTNode_RemoveElement() {
        fillBSTNode();

        int keyToRemove = map.keySet().stream().skip(map.size() / 2).findFirst().orElse(null);
        map.remove(keyToRemove);
        bst.remove(keyToRemove); // Remove the key from the BSTNode structure as well

        int expectedNodeCount = map.size();
        int actualNodeCount = bst.getNodeCount();
        Assert.assertEquals(expectedNodeCount, actualNodeCount);

        Assert.assertNull(bst.search(keyToRemove));
    }

    private void fillBSTNode() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            bst.insert(key, value);
        }
    }
}
