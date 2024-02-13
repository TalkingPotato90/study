package kr.co.sist.module.logAnaysis.controller;

import kr.co.sist.util.FileUtil;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 로그 분석 기능을 수행<br>
 * 이 클래스의 각 메서드를 분담하여 구현
 */
public class LogAnalyzerController {

    public static List<Map<String, Object>> resultList = null;
    public void parseLogFile() {
        FileUtil fileUtil = new FileUtil();
        Path filePath = Paths.get("C:/Users/potatomoong/Desktop/sist_input_1.log");
        List<String> fileContents = fileUtil.loadFile(filePath);

        resultList = new ArrayList<>();

        for (int i = 0; i < fileContents.size(); i++) {
            if (i >= fileContents.size()) {
                // 파일 내용의 범위를 벗어난 경우
                JOptionPane.showMessageDialog(null, "입력된 라인 값이 파일에 저장된 라인보다 많습니다.");
                break;
            }

            String readLine = fileContents.get(i);
            Map<String, Object> content = new HashMap<>();

            // 상세 파싱 코드 작성
            Pattern pattern = Pattern.compile("\\[(.*?)\\]\\[(.*?)\\]\\[(.*?)\\]\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(readLine);

            if (matcher.find()) {
                String resultCode = matcher.group(1);// index1을 파싱한 결과 넣기
                String url = matcher.group(2);// index2을 파싱한 결과 넣기
                String browser = matcher.group(3);// index3을 파싱한 결과 넣기
                String createdDate = matcher.group(4);// index4을 파싱한 결과 넣기

                content.put("resultCode", resultCode);
                content.put("url", url);
                content.put("browser", browser);
                content.put("createdDate", createdDate);

                resultList.add(content);
            }
        }
    }

    /**
     * 기능 0 : 로그파일을 읽고 읽은 내용을 파싱한다.<br>
     * 설명 : [결과코드][URL][브라우저][생성일시]<br>
     * [index1][index2][index3][index4]<br>
     *
     * @param : int(시작행) , int(종료행)
     */
    public void parseLogFile(int startRowNum, int endRowNum) {
        FileUtil fileUtil = new FileUtil();
        Path filePath = Paths.get("C:/Users/potatomoong/Desktop/sist_input_2.log");
        List<String> fileContents = fileUtil.loadFile(filePath);

        resultList = new ArrayList<>();

        for (int i = startRowNum; i <= endRowNum; i++) {
            if (i >= fileContents.size()) {
                // 파일 내용의 범위를 벗어난 경우
                JOptionPane.showMessageDialog(null, "입력된 라인 값이 파일에 저장된 라인보다 많습니다.");
                break;
            }

            String readLine = fileContents.get(i);
            Map<String, Object> content = new HashMap<>();

            // 상세 파싱 코드 작성
            Pattern pattern = Pattern.compile("\\[(.*?)\\]\\[(.*?)\\]\\[(.*?)\\]\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(readLine);

            if (matcher.find()) {
                String resultCode = matcher.group(1);// index1을 파싱한 결과 넣기
                String url = matcher.group(2);// index2을 파싱한 결과 넣기
                String browser = matcher.group(3);// index3을 파싱한 결과 넣기
                String createdDate = matcher.group(4);// index4을 파싱한 결과 넣기

                content.put("resultCode", resultCode);
                content.put("url", url);
                content.put("browser", browser);
                content.put("createdDate", createdDate);

                resultList.add(content);
            }
        }
    }

    /**
     * 기능 1 : 최다사용 키의 이름과 횟수
     */
    public Map<String, Object> getMaxUsedKeyInfo(List<Map<String, Object>> resultList) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Integer> keyInfo = new HashMap<>();

        String url="";
        String keyPattern="";
        for (Map<String, Object> one : resultList) {
            url = (String) one.get("url");
            /* key 값을 찾는 로직 작성 */
            keyPattern = "key=([^&]+)";
            Pattern pattern = Pattern.compile(keyPattern);
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                String key = matcher.group(1);
                keyInfo.put(key, keyInfo.getOrDefault(key, 0) + 1);
            }
        }

        /* 최다사용 키를 찾는 로직 */

        String maxKey = "";
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : keyInfo.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        // 결과 맵에 최다사용 키와 해당 횟수 추가
        result.put("maxKey", maxKey);
        result.put("maxValue", maxValue);

        System.out.println("최다사용 키: " + result.get("maxKey"));
        System.out.println("횟수: " + result.get("maxValue"));

        return result;
    }

    /*
    1. 최다사용 키의 이름과 횟수 | java xx회

    2. 브라우저별 접속횟수, 비율
	IE - xx (xx%)
	Chrome - xx (xx%)

    3. 서비스를 성공적으로 수행한(200) 횟수,실패(404) 횟수

    4. 요청이 가장 많은 시간 [10시]

    5. 비정상적인 요청(403)이 발생한 횟수,비율구하기

    6. books에 대한 요청 URL중 에러(500)가 발생한 횟수, 비율 구하기

    7. 입력되는 라인에 해당하는 정보출력
    (예 :1000~1500라인 이 입력되면)
    1000~1500번째 라인에 해당하는 정보 중
    최다사용 키의 이름과 횟수 | java/ xx회)

    8. view버튼과report 생성버튼을 만들고 view버튼이 클릭되면 위의 내용을 Dialog에 출력하고,
    report생성 버튼이 클릭되면 c:/dev/report폴더를 생성한 후 “report_생성날짜.dat” 파일을 생성하여 1~6까지의 작업을 모두 출력한다.
    */


    public static void main(String[] args) {

        LogAnalyzerController lac = new LogAnalyzerController();
        lac.parseLogFile();
        lac.getMaxUsedKeyInfo(resultList);

    }
}
