//package day0112.game;
//
//import java.io.IOException;
//
//public class Hangman {
//    String hiddenString;
//    StringBuffer outputString;
//    StringBuffer inputString;
//    int remainder;
//    int failed;
//
//    public Hangman() throws IOException {
//        hiddenString = "hello";
//    }
//
//    public int playGame() throws IOException {
//        outputString = new StringBuffer();
//
//        for (int i = 0; i < hiddenString.length(); i++) {
//            outputString.append('_');
//        }
//        inputString = new StringBuffer();
//
//        remainder = hiddenString.length();
//        failed = 0;
//
//        System.out.println("\n 단어 ( " + hiddenString.length() + "글자"
//                + ") : " + outputString);
//        drawMan();
//
//        do {
//            checkChar(readCahr());
//            System.out.println("\n 단어 ( " + hiddenString.length() + "글자"
//                    + ") : " + outputString);
//            drawMan();
//        } while ((remainder > 0) && (failed < 6));
//
//        return failed;
//    }
//
//    public void checkChar(char guess) {
//        boolean already = false;
//        for (int i = 0; i < inputString.length(); i++) {
//            if (inputString.charAt(i) == guess) {
//                System.out.println("\n이미 입력한 문자입니다! 다시 입력해주세요.");
//                already = true;
//            }
//        }
//        if (!already) {
//            inputString.append(guess);
//
//            boolean success = false;
//            for (int i = 0; i < hiddenString.length(); i++) {
//                if (hiddenString.charAt(i) == guess) {
//                    outputString.setCharAt(i, guess);
//                    remainder--;
//                    success = true;
//                }
//            }
//            if (!success) failed++;
//        }
//    }
//
//    public void drawMan(){
//        System.out.println("┌────────┐");
//        System.out.println("│        │");
//
//        switch (failed){
//            case 0:
//                System.out.println("         │");
//                System.out.println("         │");
//                System.out.println("         │");
//                System.out.println("         │");
//                System.out.println("         │");
//                System.out.println("         │");
//                break;
//            case 1 :
//
//        }
//    }
//
//}
