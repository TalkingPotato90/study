package day0119.work0119;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Work0119Test {
    @Test
    void 점_없는_파일명_반환() {
        Work0119 work0119 = new Work0119();
        String result = work0119.retunBackUpFileName("test");
        assertEquals("test_bak",result);

        String result1 = work0119.retunBackUpFileName("temp");
        assertEquals("temp_bak",result1);

        String result2 = work0119.retunBackUpFileName("what");
        assertEquals("what_bak",result2);

    }

    @Test
    void 점_있는_파일명_반환() {
        Work0119 work0119 = new Work0119();
        String result = work0119.retunBackUpFileName("test.txt");
        assertEquals("test_bak.txt",result);

        String result1 = work0119.retunBackUpFileName("temp.exe");
        assertEquals("temp_bak.exe",result1);

        String result2 = work0119.retunBackUpFileName("what.html");
        assertEquals("what_bak.html",result2);
    }

    @Test
    void 매개변수_배열_반환() {
    }

    @Test
    void 김씨_성_제외() {
    }

    @Test
    void 날짜_반환() {

    }

    @Test
    void 국가_확인() {
    }
}