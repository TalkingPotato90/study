package day0304.work0304.view.dataProcessing;

import day0304.work0304.controller.dataProcessing.TableProcessinglEventController;

import javax.swing.*;

/**
 * 로그인에 성공했을 때 계정이 가진 테이블에 대한 create,select,alter,drop 수행할 수 있는 view
 */
public class TableProcessingView extends JFrame {
    private JButton createButton;
    private JButton selectButton;
    private JButton alterButton;
    private JButton dropButton;
    private JButton logoutButton;
    private JTable table;

    public TableProcessingView() {
        ininitialize();
        setTable();
        setCreateButton();
        setSelectButton();
        setAlterButton();
        setDropButton();
        setLogoutButton();
        setEvent();
    }

    /**
     * 기본 프레임 설정
     */
    private void ininitialize() {
        setTitle("테이블 관리");
        setBounds(500, 150, 500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setVisible(true);
    }

    /**
     * 테이블 생성 버튼 설정
     */
    private void setCreateButton() {
        createButton = new JButton("테이블 생성");
        createButton.setBounds(350, 50, 120, 30);
        getContentPane().add(createButton);

    }

    /**
     * 테이블 조회 버튼 설정
     */
    private void setSelectButton() {
        selectButton = new JButton("테이블 조회");
        selectButton.setBounds(350, 100, 120, 30);
        getContentPane().add(selectButton);
    }

    /**
     * 테이블 수정 버튼 설정
     */
    private void setAlterButton() {
        alterButton = new JButton("테이블 수정");
        alterButton.setBounds(350, 150, 120, 30);
        getContentPane().add(alterButton);
    }

    /**
     * 테이블 삭제 버튼 설정
     */
    private void setDropButton() {
        dropButton = new JButton("테이블 삭제");
        dropButton.setBounds(350, 200, 120, 30);
        getContentPane().add(dropButton);
    }

    /**
     * 로그아웃 버튼 설정
     */
    private void setLogoutButton() {
        logoutButton = new JButton("로그아웃");
        logoutButton.setBounds(350, 250, 120, 30);
        getContentPane().add(logoutButton);
    }

    /**
     * 테이블 설정
     */
    private void setTable() {
        table = new JTable();
        table.setBounds(30,50,300,460);
        getContentPane().add(table);
    }

    private void setEvent(){
        TableProcessinglEventController tableProcessinglEventController = new TableProcessinglEventController(this);
        createButton.addActionListener(tableProcessinglEventController);
        selectButton.addActionListener(tableProcessinglEventController);
        alterButton.addActionListener(tableProcessinglEventController);
        dropButton.addActionListener(tableProcessinglEventController);
        logoutButton.addActionListener(tableProcessinglEventController);
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JButton getSelectButton() {
        return selectButton;
    }

    public JButton getAlterButton() {
        return alterButton;
    }

    public JButton getDropButton() {
        return dropButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }
}
