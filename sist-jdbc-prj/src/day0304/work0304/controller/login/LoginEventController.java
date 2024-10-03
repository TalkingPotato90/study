package day0304.work0304.controller.login;

import day0304.work0304.view.dataProcessing.TableProcessingView;
import day0304.work0304.view.login.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginEventController extends WindowAdapter implements ActionListener {
    private LoginView loginView;

    public LoginEventController(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        loginView.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginView.getLoginButton()) {
            SwingUtilities.invokeLater(() -> {
                TableProcessingView tableProcessingView = new TableProcessingView();
            });
        }
        if (e.getSource() == loginView.getExitButton()) {
            loginView.dispose();
        }
    }

}
