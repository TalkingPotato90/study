package day0202.work0202;

import java.util.concurrent.CompletionException;

public class Work0202 {
    public void gugudan(int inputNum) throws NumberException { // 일 => 구현해야 할 업무
        int gugu = inputNum;
        if (gugu > 1 && gugu < 10) {
            for (int i = 1; i < 10; i++) {
                System.out.println(gugu + " X " + i + " = " + (gugu * i));
            }
        }
        if (gugu < 2 || gugu > 9) {
            throw new NumberException();
        }
    }

    public static void main(String[] args) {
        Work0202 work0202 = new Work0202();
        int input = 2;
        try {
            work0202.gugudan(input);
        } catch (NumberException e) {
            throw new CompletionException(e);
        }
    }
}
