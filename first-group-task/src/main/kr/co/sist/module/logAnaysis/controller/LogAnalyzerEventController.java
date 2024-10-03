package kr.co.sist.module.logAnaysis.controller;

import kr.co.sist.module.login.controller.LoginController;
import kr.co.sist.view.logAnalysis.LogAnalyzerView;
import kr.co.sist.view.login.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        if (ae.getSource() == logAnalyzerView.getReportButton()) {
            if (LoginController.isAdmin()) {
                reportEvent();
            } else {
                JOptionPane.showMessageDialog(null, "권한이 없습니다.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        // 계정전환 버튼 누르면 로그분석 창 닫고 로그인 창 열기
        if (ae.getSource() == logAnalyzerView.getLogoutButton()) {
            SwingUtilities.invokeLater(LoginView::new);
            logAnalyzerView.dispose();
        }
    }

    /**
     * 뷰 버튼 클릭시 displayView 호출
     */
    private void viewEvent() {
        displayView();
    }

    /**
     * 기능 : report 버튼을 클릭하면 수행할 이벤트
     */
    private void reportEvent() {
        if (!logAnalyzerView.getResultTextArea().getText().isEmpty()) {
            saveReport(logAnalyzerView.getResultTextArea().getText(), "c:\\dev\\report");
        } else {
            JOptionPane.showMessageDialog(logAnalyzerView, "view를 먼저 수행해주세요.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 로그 분석 결과를 StringBuilder를 이용하여 출력
     */
    private void displayView() {
        FileDialog fileDialog = new FileDialog(logAnalyzerView, "분석파일선택", FileDialog.LOAD);
        fileDialog.setVisible(true);
        StringBuilder resultBuilder = new StringBuilder();
        if (fileDialog.getFile() != null) {
            path = fileDialog.getDirectory() + fileDialog.getFile();
            int startRow = getStartRowValue();
            int endRow = getEndRowValue();

            if (startRow > endRow) {
                startRow = 0;
                endRow = Integer.MAX_VALUE;
                JOptionPane.showMessageDialog(logAnalyzerView, "행 입력 오류, 전체 파일을 대상으로 조회합니다.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            logAnalyzerController.parseLogFile(startRow, endRow);
            Map<String, Object> maxUsedKeyInfo = logAnalyzerController.getMaxUsedKeyInfo();
            resultBuilder.append("1. 최다 사용 키: ").append(maxUsedKeyInfo.get("maxKey")).append(" ").append(maxUsedKeyInfo.get("maxValue")).append("회\n");
            maxUsedKeyInfo = logAnalyzerController.getBrInfo();
            resultBuilder.append("2. 브라우저별 접속횟수와 비율 : \n").append("IE : ").append(maxUsedKeyInfo.get("ie")).append("\nChrome : ").append(maxUsedKeyInfo.get("Chrome")).append("\n");
            maxUsedKeyInfo = logAnalyzerController.serviceStatusCount();
            resultBuilder.append("3. 서비스를 수행한 횟수 : \n").append("성공 횟수 : ").append(maxUsedKeyInfo.get("성공")).append("회\n").append("실패 횟수 : ").append(maxUsedKeyInfo.get("실패")).append("회\n");
            maxUsedKeyInfo = logAnalyzerController.getMexUsedTime();
            resultBuilder.append("4. 요청이 가장 많은 시간: ").append(maxUsedKeyInfo.get("MostUsedTime")).append(" ").append("시\n");
            maxUsedKeyInfo = logAnalyzerController.getCount403();
            resultBuilder.append("5. 비정상적인 요청이 발생한 횟수와 비율 : ").append(maxUsedKeyInfo.get("count")).append(" 회, ").append(maxUsedKeyInfo.get("countPercent")).append(" %\n");
            maxUsedKeyInfo = logAnalyzerController.getCountBooksAnd500();
            resultBuilder.append("6. books에 대한 요청 중 URL 에러가 발생한 횟수와 비율 : ").append(maxUsedKeyInfo.get("count")).append(" 회, ").append(maxUsedKeyInfo.get("countPercent")).append(" %\n");

            logAnalyzerView.getResultTextArea().setText(resultBuilder.toString());
        }
    }

    /**
     * 기능 : 입력받은 시작 라인 값을 int 형의 인덱스 값으로 반환
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
     * 기능 : 입력받은 종료 라인 값을 int 형의 인덱스 값으로 반환
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

    /**
     * 경로가 없으면 경로 먼저 생성, 경로가 있으면 바로 파일 생성
     *
     * @param content   textArea에 출력된 view버튼 클릭의 결과물
     * @param directory c:/dev/report
     */
    private void saveReport(String content, String directory) {
        try {
            File dir = new File(directory);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String currentDate = dateFormat.format(new Date());
            String filePath = directory + File.separator + "report_" + currentDate + ".dat";

            File outputFile = new File(filePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "파일저장 완료");
    }
}
