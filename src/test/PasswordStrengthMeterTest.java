package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }
    // 강함, 보통, 약함
    // 첫번째 모든 규칙을 충족하는 경우
    // 가장 쉬운것
    // 모든규칙에 충족하지않거나, 모든 규칙을 충족하거나
    @Test
    void meetsAllCriteria_Then_string(){
        // 열거타입을 사용
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
    }

    // 숫자를 포함x 나머지 조건은 충족하는 경우
    @Test
    void 세번째_test(){
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test
    void 값이없는경우(){
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void 값이빈경우(){
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    void 대문자를_포함하지_않고_나머지조건충족(){
        assertStrength("ab12!@df",PasswordStrength.NORMAL);
    }

    @Test
    void 길이가8글자만만족(){
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }
    @Test
    void 숫자포함조건만충족(){
        assertStrength("12345", PasswordStrength.WEAK);
    }
    @Test
    void 대문자포함조건만만족(){
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    @Test
    void 아무조건충족x(){
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
