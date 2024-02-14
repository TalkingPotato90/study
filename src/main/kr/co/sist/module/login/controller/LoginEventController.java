package kr.co.sist.module.login.controller;

import kr.co.sist.view.login.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 로그인의 view와 controller 연결
 */
public class LoginEventController extends WindowAdapter implements ActionListener {
    private LoginView loginView;
    /**
     * 시간 남으면 싱글톤 처리
     */
    public static String inputId, inputPassword;

    public LoginEventController(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // 로그인 버튼 클릭시 id와 password 값을 변수에 저장
        if (ae.getSource() == loginView.getLoginButton() || ae.getSource() == loginView.getUserIdField() || ae.getSource() == loginView.getPasswordField()) {
            if (ae.getSource() != loginView.getLoginButton() && ae.getModifiers() != 0) {
                return;
            }
            inputId = loginView.getUserIdField().getText();
            inputPassword = loginView.getPasswordField().getText();
            LoginController loginController = new LoginController();
            if (loginController.confirmUserPassword()) {
                loginView.dispose();
            }
        }

        // 종료 버튼 누르면 창 닫기
        if (ae.getSource() == loginView.getExitButton()) {
            loginView.dispose();
        }
    }

    @Override
    public void windowClosing(WindowEvent we) {
        loginView.dispose();
    }
}
