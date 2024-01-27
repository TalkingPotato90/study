package baseball.validation;

public class InputValidation {
    public boolean checkInputnumber(String str) {
        char inputChar;
        int num;

        if (str.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < str.length(); i++) {
            inputChar = str.charAt(i);
            num = Character.getNumericValue(inputChar);
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException();
            }
        }

        return true;
    }
}
