package chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Gugudan {
    public static void main(String[] args) throws IOException {
        int x, y;
        Random r = new Random();

        if (args.length == 1) {
            // x = Integer.valueOf(args[0]).intValue();
            x = Integer.parseInt(args[0]);
        } else {
            x = Math.abs(r.nextInt() % 9) + 1;
        }

        y = Math.abs(r.nextInt() % 9) + 1;

        int num = x * y;

        System.out.println();
        System.out.println("* 구구단 " + x + "단에 대한 문제입니다");
        System.out.println();

        System.out.println(x + " X " + y + " = ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String user;
        user = in.readLine();

        //int inputNum = new Integer(user).intValue();
        int inputNum = Integer.parseInt(user);

        if (num == inputNum) {
            System.out.println("맞았습니다!");
        } else {
            System.out.println("틀렸습니다. 정답은 " + num + "입니다.");
        }


    }
}
