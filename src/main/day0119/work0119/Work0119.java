package day0119.work0119;

import day0119.TokenDataVO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class Work0119 {

    public static final int KR = 0;
    public static final int US = 1;
    public static final int JP = 2;
    public static final int CA = 3;

    public String returnBackUpFileName(String fileName) {
//        1. 일단 그냥 예시에 대한 결과내는 방법 생각해보기
//        String result = "test_bak";
//        String result = fileName.concat("_bak");
//        if(fileName.equals("temp")){
//            result = "temp_bak";
//        }
//        if(fileName.equals("test.txt")){
//            result = "test_bak.txt";
//        }else if(fileName.equals("temp.exe")){
//            result = "temp_bak.exe";
//        }

//        2. 일반적인 상황에서 적용 가능한 코드로 변경하기
//        String tempFileName;
//        String tempExtensionName;
//        if(fileName.contains(".")){
//            tempFileName = fileName.substring(0, fileName.lastIndexOf("."));
//            tempExtensionName = fileName.substring(fileName.lastIndexOf("."));
//            result = tempFileName + "_bak" + tempExtensionName;
//        }
//
//        return result;

//        3. 좀 더 효율적인 방법 생각하기
        StringBuilder result = new StringBuilder(fileName);

        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex != -1) {
//            arguments 가독성 높이기
//            String tempFileName = fileName.substring(0, fileName.lastIndexOf("."));
//            String tempExtensionName = fileName.substring(fileName.lastIndexOf("."));
            String tempFileName = fileName.substring(0, lastDotIndex);
            String tempExtensionName = fileName.substring(lastDotIndex);
            result = new StringBuilder(tempFileName).append("_bak").append(tempExtensionName);
        } else {
            result.append("_bak");
        }

        return result.toString();
    }

    public String[] returnCsvData(String csvData) {
        // 성이 아닌 이름에 '김'이 있으면 조짐
        StringTokenizer stk = new StringTokenizer(csvData, ",.~ 김");
        int tokenCnt = stk.countTokens();
        String[] changeData = new String[tokenCnt];

        int i = 0;
        while (stk.hasMoreTokens()) {
            changeData[i] = stk.nextToken();
            i++;
        }

        return changeData;
    }

    public void printCsvData(String csvData) {
        for (String value : returnCsvData(csvData)) {
            System.out.println(value);
        }
    }

    public String returnTime(int countryCode) {

        if (countryCode < KR || countryCode > CA) {
            countryCode = KR;
        }
        Locale result = Locale.KOREA;

        if (countryCode == US) {
            result = Locale.US;
        } else if (countryCode == JP) {
            result = Locale.JAPAN;
        } else if (countryCode == CA) {
            result = Locale.CANADA;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE", result);

        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        Work0119 work0119 = new Work0119();

        System.out.println(work0119.returnBackUpFileName("test.txt"));
        System.out.println(work0119.returnBackUpFileName("test"));

        String csvData = "고한별,김도원,김동섭.김무영~김현종 박시현,손지민,김병년.김일신";
        work0119.printCsvData(csvData);

        System.out.println(work0119.returnTime(KR));
        System.out.println(work0119.returnTime(US));
        System.out.println(work0119.returnTime(JP));
        System.out.println(work0119.returnTime(CA));
    }
}
