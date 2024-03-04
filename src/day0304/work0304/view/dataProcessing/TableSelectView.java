package day0304.work0304.view.dataProcessing;

import javax.swing.*;

/**
 * 선택된 테이블의 전체 내용을 조회할 것인지 where 절의 적용을 할 것인지 선택하고
 * where 절의 내용을 입력받는 view
 */
public class TableSelectView extends JFrame {
    private JRadioButton fullSelect;
    private JRadioButton patialSelect;
    private JTextField whereField;
    private JButton selectButton;
    private JButton exitButton;
    private JLabel whereLabel;

    public TableSelectView() {
        initialize();
        setInquryButton();
        setWhereField();
        setSelectButton();
        setExitButton();
    }

    /**
     * 테이블 조회의 기본 프레임 초기화
     */
    private void initialize() {
        setTitle("테이블조회");
        setBounds(550, 350, 300, 190);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setVisible(true);
    }

    /**
     * 라디오버튼 설정
     */
    private void setInquryButton() {
        fullSelect = new JRadioButton("전체 조회");
        patialSelect = new JRadioButton("부분 조회");
        fullSelect.setBounds(40,10,100,30);
        patialSelect.setBounds(170,10,100,30);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(fullSelect);
        buttonGroup.add(patialSelect);
        getContentPane().add(fullSelect);
        getContentPane().add(patialSelect);
    }

    /**
     * 조건 입력창 설정
     */
    private void setWhereField() {
        whereLabel =new JLabel("WHERE = ");
        whereLabel.setBounds(40,50,80,30);
        getContentPane().add(whereLabel);

        whereField = new JTextField();
        whereField.setBounds(110, 50, 130, 30);
        getContentPane().add(whereField);
        whereField.setColumns(10);
    }

    /**
     * 조회 버튼 설정
     */
    private void setSelectButton() {
        selectButton = new JButton("조회");
        selectButton.setBounds(50, 100, 80, 25);
        getContentPane().add(selectButton);
    }

    /**
     * 종료 버튼 설정
     */
    private void setExitButton() {
        exitButton = new JButton("종료");
        exitButton.setBounds(150, 100, 80, 25);
        getContentPane().add(exitButton);
    }

}
