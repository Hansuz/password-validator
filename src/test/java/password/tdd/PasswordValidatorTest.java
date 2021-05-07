package password.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PasswordValidatorTest {

    /*
        Test smaller lenght password
    */
    @Test
    public void SmallerLengthPassword() {
        assertFalse(PasswordValidator.isValidPassword("abc12"));
    }

    /*
        Test Uppercase password
    */
    @Test
    public void UpperCaseOnlyPassword() {
        assertFalse(PasswordValidator.isValidPassword("ABCDEF"));
    }

    /*
        Test lowercase password
    */
    @Test
    public void LowerCaseOnlyPassword() {
        assertFalse(PasswordValidator.isValidPassword("abcdef"));
    }

    /*
        Test alphabet password
    */
    @Test
    public void AlphabetOnlyPassword() {
        assertFalse(PasswordValidator.isValidPassword("abcDEF"));
    }

    /*
        Test numeric password
    */
    @Test
    public void AlphaNumericOnlyPassword() {
        assertFalse(PasswordValidator.isValidPassword("abcDEF123"));
    }

    /*
        Test lowercase missing password
    */
    @Test
    public void LowerCaseMissingPassword() {
        assertFalse(PasswordValidator.isValidPassword("ABC@DEF123"));
    }

    /*
        Test invalid special char password
    */
    @Test
    public void InvalidSpecialCharPassword() {
        assertFalse(PasswordValidator.isValidPassword("abc)@DEF123"));
    }

    /*
        Test valid password
    */
    @Test
    public void ValidPassword() {
        assertTrue(PasswordValidator.isValidPassword("abc@DEF123"));
    }

}