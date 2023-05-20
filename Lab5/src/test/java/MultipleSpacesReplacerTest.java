import org.junit.Assert;
import org.junit.Test;

public class MultipleSpacesReplacerTest {
    private final MultipleSpacesReplacer sut = new MultipleSpacesReplacer();

    @Test
    public void testReplaceMultipleSpaces() {
        String text = "Я хочу    бути     адвокатом";
        String expectedText = "Я хочу бути адвокатом";
        String replacedText = sut.replace(text);
        Assert.assertEquals(expectedText, replacedText);
    }
}
