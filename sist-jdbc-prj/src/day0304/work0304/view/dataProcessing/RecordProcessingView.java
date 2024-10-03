package day0304.work0304.view.dataProcessing;

import javax.swing.*;

/**
 * 조건에 따라 조회된 레코드의 insert, update, delete, commit, rollback 수행할 수 있는 view
 */
public class RecordProcessingView extends JFrame {
    private JButton insertButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton commitButton;
    private JButton rollbackButton;
    private JTable table;

    public RecordProcessingView() {
        ininitialize();
        setTable();
        setInsertButton();
        setUpdateButton();
        setDeleteButton();
        setCommitButton();
        setRollbackButton();
    }

    /**
     * 기본 프레임 설정
     */
    private void ininitialize() {
        setTitle("레코드 관리");
        setBounds(500, 150, 500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setVisible(true);
    }

    /**
     * 레코드 삽입 버튼 설정
     */
    private void setInsertButton() {
        insertButton = new JButton("레코드 삽입");
        insertButton.setBounds(350, 50, 120, 30);
        getContentPane().add(insertButton);
    }

    /**
     * 레코드 수정 버튼 설정
     */
    private void setUpdateButton() {
        updateButton = new JButton("레코드 수정");
        updateButton.setBounds(350, 100, 120, 30);
        getContentPane().add(updateButton);
    }

    /**
     * 레코드 삭제 버튼 설정
     */
    private void setDeleteButton() {
        deleteButton = new JButton("레코드 삭제");
        deleteButton.setBounds(350, 150, 120, 30);
        getContentPane().add(deleteButton);
    }

    /**
     * 변경사항 커밋 버튼 설정
     */
    private void setCommitButton() {
        commitButton = new JButton("COMMIT");
        commitButton.setBounds(350, 200, 120, 30);
        getContentPane().add(commitButton);
    }

    /**
     * 변경사항 롤백 버튼 설정
     */
    private void setRollbackButton() {
        rollbackButton = new JButton("ROLLBACK");
        rollbackButton.setBounds(350, 250, 120, 30);
        getContentPane().add(rollbackButton);
    }

    /**
     * 테이블 설정
     */
    private void setTable() {
        table = new JTable();
        table.setBounds(30,50,300,460);
        getContentPane().add(table);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RecordProcessingView recordProcessingView = new RecordProcessingView();
        });
    }
}
