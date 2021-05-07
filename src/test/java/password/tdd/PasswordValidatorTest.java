package password.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PasswordValidatorTest {

    private String user = "user";
    private String admin = "admin";

    /*
        Test smaller lenght password User
    */
    @Test
    public void SmallerLengthPasswordUser() {
        assertFalse(PasswordValidator.isValidPassword("abc12", user));
    }

    /*
        Test smaller lenght password Admin
    */
    @Test
    public void SmallerLengthPasswordAdmin() {
        assertFalse(PasswordValidator.isValidPassword("abcd1234", admin));
    }

    /*
        Test Uppercase password
    */
    @Test
    public void UpperCaseOnlyPassword() {
        assertFalse(PasswordValidator.isValidPassword("ABCDEF", user));
    }

    /*
        Test lowercase password
    */
    @Test
    public void LowerCaseOnlyPassword() {
        assertFalse(PasswordValidator.isValidPassword("abcdef", user));
    }

    /*
        Test alphabet password
    */
    @Test
    public void AlphabetOnlyPassword() {
        assertFalse(PasswordValidator.isValidPassword("abcDEF", user));
    }

    /*
        Test numeric password
    */
    @Test
    public void AlphaNumericOnlyPassword() {
        assertFalse(PasswordValidator.isValidPassword("abcDEF123", user));
    }

    /*
        Test lowercase missing password
    */
    @Test
    public void LowerCaseMissingPassword() {
        assertFalse(PasswordValidator.isValidPassword("ABC@DEF123", user));
    }

    /*
        Test invalid special char password
    */
    @Test
    public void InvalidSpecialCharPassword() {
        assertFalse(PasswordValidator.isValidPassword("abc)@DEF123", user));
    }

    /*
        Test valid password User
    */
    @Test
    public void ValidPasswordUser() {
        assertTrue(PasswordValidator.isValidPassword("abc@DEF123", user));
    }

    /*
        Test valid password Admin
    */
    @Test
    public void ValidPasswordAdmin() {
        assertTrue(PasswordValidator.isValidPassword("abc@DEF123", admin));
    }

}