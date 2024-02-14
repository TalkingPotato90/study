package kr.co.sist.module.logAnaysis.controller;

import kr.co.sist.view.logAnalysis.LogAnalyzerView;
import kr.co.sist.view.login.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.Map;

/**
 * 로그 분석 기능의 view와 controller 연결
 */
public class LogAnalyzerEventController extends WindowAdapter implements ActionListener {
    private LogAnalyzerView logAnalyzerView;
    private LogAnalyzerController logAnalyzerController;
    public static String path;

    public LogAnalyzerEventController(LogAnalyzerView logAnalyzerView) {
        this.logAnalyzerView = logAnalyzerView;
        this.logAnalyzerController = new LogAnalyzerController();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // 부분 분석시 라인 입력창 활성화
        if (ae.getSource() == logAnalyzerView.getPartialAnalysisRadioButton()) {
            logAnalyzerView.enablePartialAnalysis();
        }
        // 전체 분석시 라인 입력창 비활성화
        if (ae.getSource() == logAnalyzerView.getFullAnalysisRadioButton()) {
            logAnalyzerView.disablePartialAnalysis();
        }
        // view 버튼 클릭 시
        if (ae.getSource() == logAnalyzerView.getViewButton()) {
            viewEvent();
        }
        // report 버튼 클릭 시 지정된 경로와 형식에 맞는 이름의 파일 저장
        // 구현 필요
        if (ae.getSource() == logAnalyzerView.getReportButton()) {
            JOptionPane.showMessageDialog(null, "파일 저장");
        }
        // 계정전환 버튼 누르면 로그분석 창 닫고 로그인 창 열기
        if (ae.getSource() == logAnalyzerView.getLogoutButton()) {
            SwingUtilities.invokeLater(LoginView::new);
            logAnalyzerView.dispose();
        }
    }

    /**
     * 뷰 버튼 클릭시 파일 다이얼로그를 열어서 path 입력하고 데이터 분석 결과 출력
     */
    private void viewEvent() {
        FileDialog fileDialog = new FileDialog(logAnalyzerView, "분석파일선택", FileDialog.LOAD);
        fileDialog.setVisible(true);
        StringBuilder resultBuilder = new StringBuilder();
        if (fileDialog.getFile() != null) {
            path = fileDialog.getDirectory() + fileDialog.getFile();
            logAnalyzerController.parseLogFile(0, Integer.MAX_VALUE);
            Map<String, Object> maxUsedKeyInfo = logAnalyzerController.getMaxUsedKeyInfo();
            resultBuilder.append("최다 사용 키: ").append(maxUsedKeyInfo.get("maxKey")).append(" ").append(maxUsedKeyInfo.get("maxValue")).append("회");
            maxUsedKeyInfo = logAnalyzerController.getMexUsedTime();
            resultBuilder.append("\n최다 사용 시간: ").append(maxUsedKeyInfo.get("MostUsedTime")).append(" ").append("시");
            logAnalyzerView.getResultTextArea().setText(resultBuilder.toString());

        }
    }
}
