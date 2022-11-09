package chap02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateTest {

    @Test
    void plus(){
        int result = Calculator.plus(1,2);
        Assertions.assertEquals(result, 3);
        Assertions.assertEquals(5, Calculator.plus(4, 1));
    }

}
