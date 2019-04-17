import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp(){

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스","탑");
        Champion jungleChamp = new Champion("리신","정글");
        Champion midChamp = new Champion("르블랑","미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    @Test
    public void givenCollectionWhenEmptyCorrect(){ //리스트가 비어있어야 한다.
            List<String> emptyList = new ArrayList<String>();
            assertThat(emptyList, empty());
    }

    @Test
    public void notNullCheck(){ //비어있지 않고 lck가 들어있어야 한다.
        String lck = "LCK";
        assertThat(lck, notNullValue());
    }

    @Test
    public void givenStringWhenMeetsAnyOfGivenConditionsThenCorrect() {
        String sampleString = "Player Focus";
        String startString = "Player";
        String endString = "point";
        assertThat(sampleString, anyOf(startsWith(startString), containsString(endString)));//Player로 시작하거나 point로 끝나거나 둘중에 하나만 하면 정상
    }

    @Test
    public void givenStringWhenMeetsAllOfGivenConditionsThenCorrect() { //스트링 비교
        String sampleString = "Player Focus";
        String startString = "Player";
        String endString = "Focus";
        assertThat(sampleString, anyOf(startsWith(startString), containsString(endString))); //Player로 시작하고Focus로 끝나면 정상
    }

    @Test
    public void 부동소수점체크() {
        //3에서 0.2까지의 차이는 통과한다.
        assertThat(3.14, closeTo(3, 0.2));
    }

    //의미없는 테스트로 보일 수 있지만 에러가 발생하면 테스트 fail이 발생
    //2가 아닌 5이상의 값을 참조하게 될때는 에러가 발생
    @Test
    public void shouldNotErrorGetReforence(){
        assertThat(championList.get(2), anything());
    }

    @Test
    public void shouldChampionCountFive(){ //5개의 챔피언은 꼭 픽이되어야한다.
        assertThat(championList.size(), is(5));
        assertThat(championList, Matchers.<Champion>hasSize(5));
    }

    @Test
    public void 서폿챔피언은타릭이어야한다(){ //서폿챔피언의 포지션과 이름이 타릭이면 정상작동
        Champion supportChamp = new Champion("타릭", "바텀");
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));
    }

    @Test
    public void shouldHasPropertyPosition(){ //챔피언은 포지션정보가 있어야 한다
        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
    }

    @Test
    public void shouldHaveSomeChampName(){ //특정챔프의 이름과 리스트 원소와 같다면 정상작동
        List<String> championNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames.get(1), hasToString("애쉬"));
    }

    @Test
    public void shouldHaveSamePropertyAndValue(){ //리스트1와 2가 같다면 정상작동
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames1, samePropertyValuesAs(championNames2));
    }

    @Test
    public void shouldTopChampionIsDarious(){ //탑챔프가 다리우스면 정상작동
        Optional<Champion> filterdChamion = championList.stream()
                .filter(c ->c.getPosition().equals("탑"))
                .findFirst();
        String champName = filterdChamion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));
    }
}