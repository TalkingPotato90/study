package kr.co.sist.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 데이터 처리 전의 파일 불러오기와 처리 후 의 파일 저장을 위한 클래스
 */
public class FileUtil {

    /**
     * 외부 파일 호출
     */
    public List<String> loadFile(Path path) {
        List<String> lineData;

        try (Stream<String> lineStream = Files.lines(path)) {
            lineData = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lineData;
    }


    /**
     * 외부 파일 저장
     */

}
