import org.junit.Test;

import static org.junit.Assert.*;

public class UpperCaseCounterTest {
    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    @Test
    public void nullcheck(){ //널체크를 해서 널이 맞을때 정상작동
        String str = null;
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(result == 0);
    }

    @Test
    public void emptycheck(){ //empty체크를 해서 비어있을때 정상작동
        String str = "";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        assertTrue(result == 0);
    }

    @Test
    public void 대문자_ABC(){ //대분자 ABC가 들어있을때 오류없이 정상작동
        String str = "ABC";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        System.out.println("result : " + result);
    }
}