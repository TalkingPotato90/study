package day0123.work0123;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {

    @Test
    void 입력_모드_확인(){
        HomeWork homeWork = new HomeWork();
        String result = homeWork.selectMode();
        assertEquals(",", result);
    }

    @Test
    void 입력_값_할당_확인(){

    }

    @Test
    void 출력_모드_확인(){
        HomeWork homeWork = new HomeWork();
        String result = homeWork.selectMode();
        assertEquals("출력",result);
    }

    @Test
    void 실행_종료_확인(){
        HomeWork homeWork = new HomeWork();
        String result = homeWork.selectMode();
        assertEquals("y",result);
    }

    @Test
    void 번호_일치_확인(){

    }

    @Test
    void 총점_계산(){

    }

    @Test
    void 출력_데이터_일치_확인(){

    }

}