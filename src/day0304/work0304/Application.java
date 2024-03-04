package day0304.work0304;

import day0304.work0304.view.login.LoginView;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
        });
    }
}
