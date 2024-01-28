package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReadyForGameTest {
    @Test
    void 컴퓨터_숫자_자릿수_확인(){
        ReadyForGame rfg = new ReadyForGame();
        int size = rfg.computerNumber().size();
        boolean result = size == 3;
        assertTrue(result);
    }
}