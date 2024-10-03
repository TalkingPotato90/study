package chap06;

import java.io.IOException;

public class PlayHangman {
    public static void main(String[] args) throws IOException {
        Hangman hangman = new Hangman();

        int result = hangman.playGame();

        System.out.println();
        if (result <= 2) {
            System.out.println("참 잘했어요!");
        } else if (result <= 3) {
            System.out.println("잘했어요!");
        } else if (result <= 4) {
            System.out.println("보통이네요!");
        } else {
            System.out.println("분발하세요!");
        }
    }
}
