package day0304.work0304.controller.dataProcessing;

import day0304.work0304.model.TableDAO;
import day0304.work0304.view.dataProcessing.TableProcessingView;
import day0304.work0304.view.dataProcessing.TableSelectView;
import day0304.work0304.view.login.LoginView;
import kr.co.sist.prepared.dao.preparedStatementDAO;
import kr.co.sist.statement.vo.EmployeeVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

public class TableProcessingEventController extends WindowAdapter implements ActionListener {
    private TableProcessingView tableProcessingView;

    public TableProcessingEventController(TableProcessingView tableProcessingView) {
        this.tableProcessingView = tableProcessingView;
        loadTableName();
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

    private void loadTableName(){
        TableDAO tableDAO = TableDAO.getInstance();

        try {
            List<String> listAllTab = tableDAO.selectAllTab();

            if (listAllTab.isEmpty()) {
                JOptionPane.showMessageDialog
                        (null,"데이터가 없습니다. 'ㅁ'",
                                "ERROR",JOptionPane.ERROR_MESSAGE);

            } else {
                for (String tableName : listAllTab) {
                    tableProcessingView.setTable(listAllTab);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
