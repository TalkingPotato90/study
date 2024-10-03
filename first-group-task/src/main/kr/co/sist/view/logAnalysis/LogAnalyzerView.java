package kr.co.sist.view.logAnalysis;

import kr.co.sist.module.logAnaysis.controller.LogAnalyzerEventController;

import javax.swing.*;

/**
 * 로그인 후 로그분석을 위해 나오는 화면
 */
public class LogAnalyzerView extends JFrame {
    private JPanel panel;
    private JRadioButton fullAnalysisRadioButton, partialAnalysisRadioButton;
    private JLabel startRowLabel, endRowLabel;
    private JTextField startRowField, endRowField;
    private JButton viewButton, reportButton, logoutButton;
    private JTextArea resultTextArea;
    private JScrollPane scrollPane;

    public LogAnalyzerView() {
        setFrame();
        setSelectRangeButton();
        setStartRow();
        setEndRow();
        setViewButton();
        setReportButton();
        setLogoutButton();
        setLogView();
        applyEvent();

        partialAnalysisRadioButton.addActionListener(e -> enablePartialAnalysis());
        disablePartialAnalysis();
    }

    /**
     * 로그분석기 창 설정
     */
    private void setFrame() {
        setTitle("sist 로그 분석기");
        setSize(330, 360);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        add(panel);

        setVisible(true);
    }

    /**
     * 전체 분석 할 지 부분 분석 할 지 선택하는 라디오버튼
     */
    private void setSelectRangeButton() {
        fullAnalysisRadioButton = new JRadioButton("전체 분석");
        fullAnalysisRadioButton.setBounds(100, 20, 80, 25);
        panel.add(fullAnalysisRadioButton);

        partialAnalysisRadioButton = new JRadioButton("부분 분석");
        partialAnalysisRadioButton.setBounds(180, 20, 80, 25);
        panel.add(partialAnalysisRadioButton);

        ButtonGroup bg =new ButtonGroup();
        bg.add(fullAnalysisRadioButton);
        bg.add(partialAnalysisRadioButton);

        fullAnalysisRadioButton.setSelected(true);
    }

    /**
     * 시작 라인을 입력하는 칸
     */
    private void setStartRow() {
        startRowLabel = new JLabel("<html>시작 행 : <br>기본값 1</html>");
        startRowLabel.setBounds(20, 50, 80, 25);
        panel.add(startRowLabel);

        startRowField = new JTextField();
        startRowField.setBounds(100, 50, 150, 25);
        panel.add(startRowField);
    }

    /**
     * 끝 라인을 입력하는 칸
     */
    private void setEndRow() {
        endRowLabel = new JLabel("<html>종료 행 : <br>기본값 최대</html>");
        endRowLabel.setBounds(20, 80, 80, 25);
        panel.add(endRowLabel);

        endRowField = new JTextField();
        endRowField.setBounds(100, 80, 150, 25);
        panel.add(endRowField);
    }

    /**
     * view 버튼
     */
    private void setViewButton() {
        viewButton = new JButton("View");
        viewButton.setBounds(30, 120, 70, 25);
        panel.add(viewButton);
    }

    /**
     * report 버튼
     */
    private void setReportButton() {
        reportButton = new JButton("Report");
        reportButton.setBounds(110, 120, 80, 25);
        panel.add(reportButton);
    }

    /**
     * 로그아웃 버튼
     */
    private void setLogoutButton() {
        logoutButton = new JButton("계정전환");
        logoutButton.setBounds(200, 120, 90, 25);
        panel.add(logoutButton);
    }

    /**
     * view로 불러온 내용 출력창
     */
    private void setLogView(){
        resultTextArea = new JTextArea();
        scrollPane = new JScrollPane(resultTextArea);
        scrollPane.setBounds(20, 160, 280, 150);
        panel.add(scrollPane);
    }

    public void enablePartialAnalysis() {
        startRowField.setEnabled(true);
        endRowField.setEnabled(true);
    }

    public void disablePartialAnalysis() {
        startRowField.setEnabled(false);
        endRowField.setEnabled(false);
    }

    /**
     * 이벤트 등록
     */
    private void applyEvent() {
        LogAnalyzerEventController logAnalyzerEventController = new LogAnalyzerEventController(this);
        fullAnalysisRadioButton.addActionListener(logAnalyzerEventController);
        partialAnalysisRadioButton.addActionListener(logAnalyzerEventController);
        startRowField.addActionListener(logAnalyzerEventController);
        endRowField.addActionListener(logAnalyzerEventController);
        viewButton.addActionListener(logAnalyzerEventController);
        reportButton.addActionListener(logAnalyzerEventController);
        logoutButton.addActionListener(logAnalyzerEventController);
    }

    public JRadioButton getFullAnalysisRadioButton() {
        return fullAnalysisRadioButton;
    }

    public JRadioButton getPartialAnalysisRadioButton() {
        return partialAnalysisRadioButton;
    }

    public JTextField getStartRowField() {
        return startRowField;
    }

    public JTextField getEndRowField() {
        return endRowField;
    }

    public JButton getViewButton() {
        return viewButton;
    }

    public JButton getReportButton() {
        return reportButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JTextArea getResultTextArea() {
        return resultTextArea;
    }
}
