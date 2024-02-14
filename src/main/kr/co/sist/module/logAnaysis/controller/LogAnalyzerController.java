package kr.co.sist.module.logAnaysis.controller;

import kr.co.sist.util.FileUtil;

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
 */
public class LogAnalyzerController {

    private List<Map<String, Object>> resultList;
    private String path;

    /**
     * 기능 : util.FileUtil 에서 불러 온 파일의 데이터를 입력 받은 라인 수 범위내로 파싱 <br>
     *       줄단위 데이터를 맵으로 구성하는 상세 로직은 parseLogLine()에서 진행<br>
     * 작성자 : 고한별
     * @param startRowNum 시작 행 번호
     * @param endRowNum 종료 행 번호
     */
    public void parseLogFile(int startRowNum, int endRowNum) {
        FileUtil fileUtil = new FileUtil();
        this.path = LogAnalyzerEventController.path;
        Path logFilePath = Paths.get(path);
        List<String> fileContents = fileUtil.loadFile(logFilePath);

        resultList = new ArrayList<>();

        for (int i = startRowNum; i <= endRowNum && i < fileContents.size(); i++) {
            String readLine = fileContents.get(i);
            Map<String, Object> content = parseLogLine(readLine);
            resultList.add(content);
        }
    }

    /**
     * 가눙 : 파일의 데이터 한 줄을 대괄호 단위의 데이터로 파싱<br>
     * 설명 : [resultCode] [url]       [browser]    [createdDate]<br>
     *       [코드]        [실행데이터]  [브라우저]     [생성일시]<br>
     * 작성자 : 고한별
     * @param logLine
     * @return 파싱된 데이터 맵
     */
    private Map<String, Object> parseLogLine(String logLine) {
        Map<String, Object> content = new HashMap<>();

        Pattern pattern = Pattern.compile("\\[(.*?)\\]\\[(.*?)\\]\\[(.*?)\\]\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(logLine);

        if (matcher.find()) {
            String resultCode = matcher.group(1);
            String url = matcher.group(2);
            String browser = matcher.group(3);
            String createdDate = matcher.group(4);

            content.put("resultCode", resultCode);
            content.put("url", url);
            content.put("browser", browser);
            content.put("createdDate", createdDate);
        }
        return content;
    }

    /**
     * 기능 : key 값 중에서 가장 많이 사용된 값의 이름과 횟수 저장<br>
     * 작성자 : 고한별<br>
     * @return 최다 사용 key와 횟수 맵
     */
    public Map<String, Object> getMaxUsedKeyInfo() {
        Map<String, Object> result = new HashMap<>();
        Map<String, Integer> keyInfo = new HashMap<>();

        for (Map<String, Object> one : resultList) {
            String url = (String) one.get("url");
            String keyPattern = "key=([^&]+)";
            Pattern pattern = Pattern.compile(keyPattern);
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                String key = matcher.group(1);
                keyInfo.put(key, keyInfo.getOrDefault(key, 0) + 1);
            }
        }

        String maxKey = "";
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : keyInfo.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        result.put("maxKey", maxKey);
        result.put("maxValue", maxValue);

        return result;
    }

    /**
     * 기능 : 로그 파일의 생성 날짜 부분에서 시간을 추출하여 최다 요청 시간 확인<br>
     * 작성자 : 진수현<br>
     * @return 요청이 많은 시간 정보 맵
     */
    public Map<String, Object> getMexUsedTime(){
        Map<Object, Integer> mexUsedTime = new HashMap<>();

        // resultList의 모든 맵을 반복하여 특정 키에 해당하는 값을 전부 구합니다.
        for (Map<String, Object> map : resultList) {
            Object createdDateValue = map.get("createdDate");
            String stChange = (String)createdDateValue;
            Object createdDateValueEx = stChange.substring(stChange.indexOf(" "), stChange.indexOf(":"));

            if (createdDateValue != null) { // Null 체크 추가
                mexUsedTime.put(createdDateValueEx, mexUsedTime.getOrDefault(createdDateValueEx, 0) + 1);
            }
        }

        Object mostRepeatedValue = null;
        int maxCount = 0;
        for (Map.Entry<Object, Integer> entry : mexUsedTime.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostRepeatedValue = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        // 결과를 담은 맵 생성
        Map<String, Object> result = new HashMap<>();
        result.put("MostUsedTime", mostRepeatedValue);

        return result;
    }

// 나머지 기능 구현 필요
}
