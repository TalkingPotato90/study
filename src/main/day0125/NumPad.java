package day0125;

import javax.swing.*;
import java.awt.*;

public class NumPad extends JFrame {
    public NumPad() {
        super("번호");
        String[] numArr={"1","2","3","4","5","6","7","8","9","*","0","#"};
        JButton[] jrbArr = new JButton[numArr.length];
        setLayout(new GridLayout(4,3));

        for (int i = 0; i < numArr.length; i++) {
            jrbArr[i] = new JButton(numArr[i]);
            add(jrbArr[i]);
        }

        setSize(300,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new NumPad();
    }
}
