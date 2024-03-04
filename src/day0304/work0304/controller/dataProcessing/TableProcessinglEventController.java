package day0304.work0304.controller.dataProcessing;

import day0304.work0304.view.dataProcessing.TableProcessingView;
import day0304.work0304.view.dataProcessing.TableSelectView;
import day0304.work0304.view.login.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TableProcessinglEventController extends WindowAdapter implements ActionListener {
    private TableProcessingView tableProcessingView;

    public TableProcessinglEventController(TableProcessingView tableProcessingView) {
        this.tableProcessingView = tableProcessingView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tableProcessingView.getCreateButton()) {
            System.out.println(1);
        }
        if (e.getSource() == tableProcessingView.getSelectButton()) {
            SwingUtilities.invokeLater(() -> {
                TableSelectView tableSelectView = new TableSelectView();
            });
        }
        if (e.getSource() == tableProcessingView.getAlterButton()) {
            System.out.println(3);
        }
        if (e.getSource() == tableProcessingView.getDropButton()) {
            System.out.println(4);
        }
        if (e.getSource() == tableProcessingView.getLogoutButton()) {
            SwingUtilities.invokeLater(() -> {
                LoginView loginView = new LoginView();
            });
            tableProcessingView.dispose();
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        tableProcessingView.dispose();
    }
}
