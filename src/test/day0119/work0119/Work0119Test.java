package day0119.work0119;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;


class Work0119Test {
    @Test
    void 점_없는_파일명_반환() {
        Work0119 work0119 = new Work0119();
        String result = work0119.returnBackUpFileName("test");
        assertEquals("test_bak", result);

        String result1 = work0119.returnBackUpFileName("temp");
        assertEquals("temp_bak", result1);

        String result2 = work0119.returnBackUpFileName("what");
        assertEquals("what_bak", result2);

    }

    @Test
    void 점_있는_파일명_반환() {
        Work0119 work0119 = new Work0119();
        String result = work0119.returnBackUpFileName("test.txt");
        assertEquals("test_bak.txt", result);

        String result1 = work0119.returnBackUpFileName("temp.exe");
        assertEquals("temp_bak.exe", result1);

        String result2 = work0119.returnBackUpFileName("what.html");
        assertEquals("what_bak.html", result2);
    }

    @Test
    void 매개변수_배열_반환_김씨_제외() {

        Work0119 work0119 = new Work0119();

        String[] result = work0119.returnCsvData
                ("김감자,김감각,정서중.메가도스~가습기 물병,위닉스,김호랑.김토끼");
        assertArrayEquals(new String[]
                {"감자", "감각", "정서중", "메가도스", "가습기", "물병", "위닉스", "호랑", "토끼"}, result);

    }

}