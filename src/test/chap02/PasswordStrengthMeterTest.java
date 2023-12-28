package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordStrengthMeterTest {
    @Test
    void meetsAllCriteria_Then_Strong() {
//        PasswordStrengthMeter meter = new PasswordStrengthMeter();
//        값타입 결과 = meter.meter("ab12!@AB");
//        assertEquals(기댓값,결과);
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
        PasswordStrength result2 = meter.meter("abc!Add");
        assertEquals(PasswordStrength.STRONG, result2);
    }


}