package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordStrengthMeterTest {
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();
    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }
    @Test
    void meetsAllCriteria_Then_Strong() {
//        PasswordStrengthMeter meter = new PasswordStrengthMeter();
//        값타입 결과 = meter.meter("ab12!@AB");
//        assertEquals(기댓값,결과);
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc!1Add", PasswordStrength.STRONG);
    }

    @Test
    void meetsOhterCriteria_except_for_Length_Then_Normal(){
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOhterCriteria_except_for_number_Then_Normal(){
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

}