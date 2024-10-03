package kr.co.sist.module.logAnaysis.controller;

import kr.co.sist.util.FileUtil;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
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
     * 기능 : 브라우저별 사용 횟수와 비율<br>
     * 작성자 : 양수민
     * @return
     */
    public  Map<String, Object> getBrInfo() {
        int ieCnt = 0;
        int chCnt = 0;
        int totalCnt=0;

        Map<String, Object> result = new HashMap<>();

        // resultList의 모든 맵을 반복하여 특정 키에 해당하는 값을 전부 구합니다.
        for (Map<String, Object> map : resultList) {
            String createdDateValue = (String)map.get("browser");

            if (createdDateValue != null) {
                // 브라우저 정보가 있는 경우만 처리
                if (createdDateValue.equals("ie")) {
                    ieCnt++;
                } else if(createdDateValue.equals("Chrome")){
                    chCnt++;
                }
            }
        }//end if

        totalCnt = ieCnt+chCnt;

        double iePercent= (double)ieCnt / (double)totalCnt * 100;
        double iePercent2= (double)chCnt / (double) totalCnt * 100;

        result.put("Chrome", chCnt +", "+ (int)iePercent2+"%");
        result.put("ie", ieCnt + ", "+(int)iePercent+"%");

        return result;
    }


    /**
     * 기능 : 서비스를 성공적으로 수행한 횟수와 실패한 횟수<br>
     * 작성자 : 김일신
     * @return
     */
    public Map<String, Object> serviceStatusCount() {
        Map<String, Object> result = new HashMap<>();

        int successCount = 0;
        int failCount = 0;

        for (Map<String, Object> num : resultList) {
            String resultCode = (String) num.get("resultCode"); // 결과 코드를 문자열로 변환

            if ("200".equals(resultCode)) { // 문자열 비교로 변경
                successCount++;
            } else if ("404".equals(resultCode)) { // 문자열 비교로 변경
                failCount++;
            }
        }

        result.put("성공", successCount);
        result.put("실패", failCount);

        return result;
    }

    /**
     * 기능 : 요청이 가장 많은 시간 찾기<br>
     * 작성자 : 진수현
     * @return
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


    /**
     * 기능 : 비정상적인 요청이 발생한 횟수와 비율 구하기<br>
     * 작성자 : 김도원
     * @return
     */
    public Map<String, Object> getCount403(){
        //선언
        Map<String,Integer> countMap = new HashMap<>();
        //값의 횟수를 계산하여 countMap에 저장

        int times = 0;
        for (Map<String, Object> map : resultList) {
            times++;
            Object createdDateValue = map.get("resultCode");
            if(createdDateValue.equals("403")) {
                String sortedvalue = (String)createdDateValue;
                countMap.put(sortedvalue, countMap.getOrDefault(sortedvalue, 0)+1);
            }//if
        }//for

        int countedTimes = 0;
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            countedTimes = entry.getValue();

        }//end for
        DecimalFormat df = new DecimalFormat("#.##");
        Map<String, Object> result = new HashMap<>();
        result.put("count", countedTimes);
        result.put("countPercent", df.format((double)countedTimes/times*100));

        return result;
    }//print403Count

    /**
     * 기능 : books에 대한 요청중 url 에러가 발생한 횟수와 비율<br>
     * 작성자 : 김현종
     * @return
     */
    public Map<String, Object> getCountBooksAnd500(){

        //값의 횟수를 계산하여 countMap에 저장
        int bookCount = 0;
        int sameCount = 0;

        for (Map<String, Object> map : resultList) {
            Object createdDateValue = map.get("resultCode");
            Object createdDateValue2 = map.get("url");

            if(createdDateValue.equals("500") && createdDateValue2.toString().contains("books")) {
                sameCount++;
            }
        }
        for (Map<String, Object> map : resultList) {
            Object createdDateValue = map.get("url");
            if(createdDateValue.toString().contains("books")) {
                bookCount++;
            }
        }

        Map<String, Object> result = new HashMap<>();
        DecimalFormat df = new DecimalFormat("#.##");
        result.put("count", sameCount);
        result.put("countPercent",  df.format((double)sameCount/bookCount*100));

        return result;
    }
}
