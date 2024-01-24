package day0124;

import javax.swing.*;
import java.awt.*;

/**
 * 1. 윈도우 컴포넌트 (JWindow, JFrame)을 상송
 *
 */
public class TestSwing extends Window {
    public TestSwing(Frame f) {

        super(f);
        f.setSize(300,300);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new TestSwing(new Frame());
    }
}
