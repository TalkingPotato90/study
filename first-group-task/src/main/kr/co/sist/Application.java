package kr.co.sist;

import kr.co.sist.view.login.LoginView;

import javax.swing.*;

/**
 * Application을 실행하는 메인 메서드를 포함하는 클래스
 */
public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginView::new);
    }
}
