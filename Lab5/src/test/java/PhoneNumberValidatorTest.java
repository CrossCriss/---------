import org.junit.Assert;
import org.junit.Test;

public class PhoneNumberValidatorTest {
    private final PhoneNumberValidator sut = new PhoneNumberValidator();

    @Test
    public void testValidPhoneNumber() {
        String phoneNumber = "(+380)50-456-86-77";
        Assert.assertTrue(sut.validate(phoneNumber));
    }

    @Test
    public void testInvalidPhoneNumber() {
        String phoneNumber = "(+380)50-656-63-99"; // Incorrect format, 4 digits instead of 3
        Assert.assertFalse(sut.validate(phoneNumber));
    }
}
