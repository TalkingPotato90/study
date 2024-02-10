package kr.co.sist.view.login;

import javax.swing.*;
import java.awt.*;

/**
 * 로그인 정보를 받기 위한 화면
 */
public class LoginView extends JFrame {
    private JPanel panel;
    private JLabel userIdLabel, passwordLabel;
    private JTextField userIdField, passwordField;
    private JButton loginButton, exitButton;

    public LoginView() {
        setFrame();
        inputId();
        inputPassword();
        setLoginButton();
        setExitButton();
    }

    /**
     * JFrame 창 셋팅
     */
    private void setFrame(){
        setTitle("sist 로그 분석기");
        setSize(300, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        setVisible(true);
    }

    /**
     * 아이디 입력창
     */
    private void inputId() {
        userIdLabel = new JLabel("아이디:");
        userIdLabel.setBounds(20, 20, 60, 25);
        panel.add(userIdLabel);

        userIdField = new JTextField(20);
        userIdField.setBounds(90, 20, 180, 25);
        panel.add(userIdField);
    }

    /**
     * 패스워드 입력창
     */
    private void inputPassword() {
        passwordLabel = new JLabel("비밀번호:");
        passwordLabel.setBounds(20, 50, 60, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(90, 50, 180, 25);
        panel.add(passwordField);
    }

    /**
     * 로그인 버튼
     */
    private void setLoginButton() {
        loginButton = new JButton("로그인");
        loginButton.setBounds(40, 90, 100, 25);
        panel.add(loginButton);
    }

    /**
     * 종료 버튼
     */
    private void setExitButton() {
        exitButton = new JButton("종료");
        exitButton.setBounds(160, 90, 100, 25);
        panel.add(exitButton);
    }

}
