import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamsTest {

    @Parameterized.Parameter()
    public String sex;
    @Parameterized.Parameter(1)
    public boolean expectedHasMane;

    @Mock
    Feline feline;

    @Parameterized.Parameters(name = "Sex: {0}, hasMane: {1}")
    public static Object[][] getSex() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}