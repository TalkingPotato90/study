package day0304.work0304.view.login;

import day0304.work0304.controller.login.LoginEventController;

import javax.swing.*;

public class LoginView extends JFrame {
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JTextField idField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton exitButton;
    public LoginView() {
        initialize();
        setIdArea();
        setPasswordArea();
        setLoginButton();
        setExitButton();
        setEvent();
    }

    /**
     * 로그인 창의 기본 프레임 초기화
     */
    private void initialize() {
        setTitle("데이터베이스 로그인");
        setBounds(550, 350, 300, 190);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setVisible(true);
    }

    /**
     * 아이디 입력창 설정
     */
    private void setIdArea(){
        idLabel = new JLabel("ID : ");
        idLabel.setBounds(30, 30, 80, 20);
        getContentPane().add(idLabel);

        idField = new JTextField();
        idField.setBounds(120, 30, 130, 20);
        getContentPane().add(idField);
        idField.setColumns(10);
    }

    /**
     * 비밀번호 입력창 설정
     */
    private void setPasswordArea(){
        passwordLabel = new JLabel("PASSWORD : ");
        passwordLabel.setBounds(30, 60, 80, 20);
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 60, 130, 20);
        getContentPane().add(passwordField);
    }

    /**
     * 로그인 버튼 설정
     */
    private void setLoginButton(){
        loginButton = new JButton("로그인");
        loginButton.setBounds(50, 100, 80, 25);
        getContentPane().add(loginButton);
    }

    /**
     * 종료 버튼 설정
     */
    private void setExitButton(){
        exitButton = new JButton("종료");
        exitButton.setBounds(150, 100, 80, 25);
        getContentPane().add(exitButton);
    }

    /**
     * 이벤트 등록
     */
    private void setEvent(){
        LoginEventController loginEventController = new LoginEventController(this);
        loginButton.addActionListener(loginEventController);
        exitButton.addActionListener(loginEventController);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}

