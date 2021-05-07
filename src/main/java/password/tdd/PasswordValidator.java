package password.tdd;

import java.util.Arrays;
import java.util.List;

public class PasswordValidator {

    /*
     * Valid password :
     *   - 6 characters minimum
     *   - 1 lowercase character at least
     *   - 1 uppercase character at least
     *   - 1 numeric character at least
     *   - 1 of these special characters (!, @, #, $, %, ^, &) at least
     */

    public static boolean isValidPassword(final String myPassword) {
        if(myPassword.length()<6) {
            return false;
        }

        boolean LowerCaseCharacter = false;
        boolean UpperCaseCharacter = false;
        boolean NumericCharacter = false;
        boolean SpecialCharacter = false;
        final List<Character> specialCharacters = Arrays.asList('!', '@', '#', '$', '%', '^', '&');

        for(int i=0;i<myPassword.length();i++) {
            char currentChar = myPassword.charAt(i);
            if(Character.isLowerCase(currentChar) && !LowerCaseCharacter) {
                LowerCaseCharacter = true;
            }
            if(Character.isUpperCase(currentChar) && !UpperCaseCharacter) {
                UpperCaseCharacter = true;
            }
            if(Character.isDigit(currentChar) && !NumericCharacter) {
                NumericCharacter = true;
            }

            if(!Character.isLowerCase(currentChar) && !Character.isUpperCase(currentChar) && !Character.isDigit(currentChar)) {
                if(specialCharacters.contains(currentChar) && !SpecialCharacter) {
                    SpecialCharacter = true;
                }
                else {
                    return false;
                }
            }

            if(LowerCaseCharacter && UpperCaseCharacter && NumericCharacter && SpecialCharacter) {
                return true;
            }
        }

        return false;
    }
}
