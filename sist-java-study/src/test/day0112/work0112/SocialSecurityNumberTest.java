package day0112.work0112;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SocialSecurityNumberTest {
    @Test
    void length_check(){
        SocialSecurityNumber ssn = new SocialSecurityNumber("123456-1234567");
        boolean result = ssn.ssnArrayLength() == 14;
        assertTrue(result);
    }

    @Test
    void check_7th_index(){
        SocialSecurityNumber ssn = new SocialSecurityNumber("123456-1234567");
        assertEquals("-", ssn.getSsnArray()[6]);
    }

    @Test
    void birth_year_print() {
        SocialSecurityNumber ssn1 = new SocialSecurityNumber("123456-1234567");
        assertEquals("1912", ssn1.checkBirthYear());

        SocialSecurityNumber ssn2 = new SocialSecurityNumber("123456-3123456");
        assertEquals("2012", ssn2.checkBirthYear());

        SocialSecurityNumber ssn3 = new SocialSecurityNumber("123456-9123456");
        assertEquals("1812", ssn3.checkBirthYear());
    }

    @Test
    void check_age() {
        SocialSecurityNumber ssn1 = new SocialSecurityNumber("123456-1234567");
        assertEquals(2024 - 1912, ssn1.calculateAge());

        SocialSecurityNumber ssn2 = new SocialSecurityNumber("123456-3123456");
        assertEquals(2024 - 2012, ssn2.calculateAge());

        SocialSecurityNumber ssn3 = new SocialSecurityNumber("123456-9123456");
        assertEquals(2024 - 1812, ssn3.calculateAge());

    }

    @Test
    void testDetermineGender() {
        SocialSecurityNumber ssn1 = new SocialSecurityNumber("123456-1234567");
        assertEquals("남자", ssn1.checkGender());

        SocialSecurityNumber ssn2 = new SocialSecurityNumber("123456-2234567");
        assertEquals("여자", ssn2.checkGender());
    }
}