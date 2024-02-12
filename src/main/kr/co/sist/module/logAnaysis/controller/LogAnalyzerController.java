package kr.co.sist.module.logAnaysis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 로그 분석 기능을 수행<br>
 * 이 클래스의 각 메서드를 분담하여 구현
 */
public class LogAnalyzerController {

    public static List<Map<String, Object>> resultList = null;
public void parseLogFile(){

}
    /**
     * 기능 0 : 로그파일을 읽고 읽은 내용을 파싱한다.<br>
     * 설명 : [결과코드][URL][브라우저][생성일시]<br>
     * [index1][index2][index3][index4]<br>
     *
     * @param : int(시작행) , int(종료행)
     */
    public void parseLogFile(int startRowNum, int endRowNum) {

        Map<String, Object> content = null;
        resultList = new ArrayList<>();

        String readLine = "";

        /* 파싱 */
        for (int i = startRowNum; i <= (endRowNum - startRowNum); i++) {
            readLine = "[200][http://sist.co.kr/find/books?key=mongodb&query=sist][ie][2024-02-06 09:35:16]";
            content = new HashMap<>();

            //상세 파싱코드 작성
            String resultCode = "";//index1을 파싱한 결과 넣기
            String url = "";//index2을 파싱한 결과 넣기
            String browser = "";//index2을 파싱한 결과 넣기
            String createdDate = "";//index2을 파싱한 결과 넣기

            content.put("resultCode", resultCode);
            content.put("url", url);
            content.put("browser", browser);
            content.put("createdDate", createdDate);
            resultList.add(content);
        }
    }

    /**
     * 기능 1 : 최다사용 키의 이름과 횟수
     */
    public Map<String, Object> getMaxUsedKeyInfo(List<Map<String, Object>> resultList) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Integer> keyInfo = new HashMap<>();

        for (Map<String, Object> one : resultList) {
            String url = (String) one.get("url");
            /* key 값을 찾는 로직 작성 */
            String key = "java";

            keyInfo.put(key, keyInfo.get("key") + 1);
        }
        /* 최다사용 키를 찾는 로직 */

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
        String test = "2024-02-06 09:07:35";
        String[] arr = test.split(" ");
        String time = arr[1].substring(0, 2);

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(time);

    }
}
