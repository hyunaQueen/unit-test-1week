import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    @Test
    public void add() { //customcalculator객체에 add한값이 비교값과 같으면 테스트 성공
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(10,15);
        assertThat("result", result, is(25));
        assertTrue(result == 25);
        System.out.println("result :: " + result);
    }

    @Test
    public void subtract() { ////customcalculator객체에 sub한값이 비교값과 같으면 테스트 성공
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        assertThat("result", result, is(13));
        assertTrue(result == 13);
        System.out.println("result :: " + result);
    }

    @Test
    public void multiply() { //customcalculator객체에 mul한값이 비교값과 같으면 테스트 성공
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        assertThat("result", result, is(45));
        assertTrue(result == 45);
        System.out.println("result :: " + result);
    }

    @Test
    public void divide() { //customcalculator객체에 mul한값이 비교값과 같으면 테스트 성공
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        assertThat("result", result, is(5));
        assertTrue(result == 5);
        System.out.println("result :: " + result);
    }
}