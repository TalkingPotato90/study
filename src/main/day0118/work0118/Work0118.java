package day0118.work0118;

public class Work0118 {
    public static final int MZ_LENGTH = 8;
    public static final int PASSWORD_RANGE = 75;
    public static final int PASSWORD_RANGE_CORRECTION = 48;
    public static final int START_NUMBER_CODE_CORRECTION = 58;
    public static final int START_UPPERCASE_CODE_CORRECTION = 64;
    public static final int END_UPPERCASE_CODE_CORRECTION = 91;
    public static final int START_LOWERCASE_CODE_CORRECTION = 96;
    public static final int END_LOWERCASE_CODE_CORRECTION = 123;
    public static final int LOTTO_RANGE = 45;
    public static final int LOTTO_RANGE_CORRECTION = 1;

    public static void generateArray() {
        String[] mz = "어쩔티비,저쩔티비,뇌절티비,안물티비,안궁티비,때리고싶쥬~,못때리쥬~,개킹받쥬~".split(",");
        int randIndex = (int) (Math.random() * MZ_LENGTH);
        System.out.println(mz[randIndex]);
    }

    public static char validateRandomNum() {
        char inRangeChar;
        while (true) {
            char temp = (char) ((Math.random() * PASSWORD_RANGE) + PASSWORD_RANGE_CORRECTION);
            if ((temp < START_NUMBER_CODE_CORRECTION)
                    || (temp > START_UPPERCASE_CODE_CORRECTION && temp < END_UPPERCASE_CODE_CORRECTION)
                    || (temp > START_LOWERCASE_CODE_CORRECTION && temp < END_LOWERCASE_CODE_CORRECTION)) {
                inRangeChar = temp;
                break;
            }
        }
        return inRangeChar;
    }

    public static void generatePassword() {
        char[] password = new char[8];
        for (int i = 0; i < password.length; i++) {
            password[i] = validateRandomNum();
        }
        System.out.println(password);
    }

    private static int generateRandomLottoNumber() {
        return (int) ((Math.random() * LOTTO_RANGE) + LOTTO_RANGE_CORRECTION);
    }

    public static int[] generateLottoFormat() {
        int[] lottoNum = new int[6];
        for (int i = 0; i < lottoNum.length; i++) {
            lottoNum[i] = generateValidRandomNumber(lottoNum);
        }
        return lottoNum;
    }

    private static boolean checkNum(int[] lotto, int num) {
        for (int value : lotto) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

    private static int generateValidRandomNumber(int[] randLotto) {
        int randomNumber = generateRandomLottoNumber();
        while (checkNum(randLotto, randomNumber)) {
            randomNumber = generateRandomLottoNumber();
        }
        return randomNumber;
    }

    public static void printLotto(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        generateArray();
        generatePassword();
        printLotto(generateLottoFormat());
    }
}