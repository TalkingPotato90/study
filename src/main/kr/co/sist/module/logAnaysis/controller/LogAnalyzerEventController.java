package kr.co.sist.module.logAnaysis.controller;

import kr.co.sist.module.login.controller.LoginController;
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
            if (LoginController.isAdmin()) { // 로그인 정보의 권한을 확인하여 ADMIN인지 확인
                JOptionPane.showMessageDialog(null, "파일 저장 완료");
            } else {
                JOptionPane.showMessageDialog(null, "권한이 없습니다."); // 권한이 없는 경우 메시지 출력
            }
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

            int startRow = getStartRowValue();
            int endRow = getEndRowValue();

            logAnalyzerController.parseLogFile(startRow, endRow);
            Map<String, Object> maxUsedKeyInfo = logAnalyzerController.getMaxUsedKeyInfo();
            resultBuilder.append("1. 최다 사용 키: ").append(maxUsedKeyInfo.get("maxKey")).append(" ").append(maxUsedKeyInfo.get("maxValue")).append("회");
            maxUsedKeyInfo = logAnalyzerController.getMexUsedTime();
            resultBuilder.append("\n4. 요청이 많은 시간: ").append(maxUsedKeyInfo.get("MostUsedTime")).append(" ").append("시");
            logAnalyzerView.getResultTextArea().setText(resultBuilder.toString());

        }
    }

    /**
     * 입력받은 시작 라인 값을 int 형의 인덱스 값으로 반환
     *
     * @return 시작 인덱스 (예외 발생시 0)
     */
    private int getStartRowValue() throws NumberFormatException {
        if (logAnalyzerView.getFullAnalysisRadioButton().isSelected()) {
            return 0;
        }
        try {
            int tempStartRow = Integer.parseInt(logAnalyzerView.getStartRowField().getText());
            int startRowIndex = tempStartRow - 1;
            if (startRowIndex < 0) {
                JOptionPane.showMessageDialog(logAnalyzerView, "시작 행을 기본값으로 조회합니다.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
            return startRowIndex;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(logAnalyzerView, "시작 행을 기본값으로 조회합니다.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    /**
     * 입력받은 종료 라인 값을 int 형의 인덱스 값으로 반환
     *
     * @return 끝 인덱스 (예외 발생시 최대라인값)
     */
    private int getEndRowValue() throws NumberFormatException {
        if (logAnalyzerView.getFullAnalysisRadioButton().isSelected()) {
            return Integer.MAX_VALUE;
        }
        try {
            int tempEndRow = Integer.parseInt(logAnalyzerView.getEndRowField().getText());
            int endRowIndex = tempEndRow - 1;
            if (endRowIndex < 0) {
                JOptionPane.showMessageDialog(logAnalyzerView, "마지막 행을 기본값으로 조회합니다.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return Integer.MAX_VALUE;
            }
            return endRowIndex;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(logAnalyzerView, "마지막 행을 기본값으로 조회합니다.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return Integer.MAX_VALUE;
        }
    }

    private void reportEvent(){

    }
}
