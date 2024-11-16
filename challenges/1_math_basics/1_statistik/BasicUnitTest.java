
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BasicUnitTest {

    private Main main;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        main = new Main();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @ParameterizedTest(name = "Eingabe: {0} ==> Erwartet Anzahl: {1}; Erwartete Summe: {2}")
    @MethodSource("tableProvider")
    @DisplayName("Teste Werte aus der Tabelle: ")
    void testWithMultiArgMethodSource(int max, int amount, int sum) {
        main.calcSumAndCountAllNumbersDivBy_2_Or_7(max);
        assertEquals(amount + ", " + sum, outContent.toString().trim());
    }

    static Stream<Arguments> tableProvider() {
        return Stream.of(
                Arguments.arguments(3, 1, 2),
                Arguments.arguments(8, 4, 19),
                Arguments.arguments(15, 8, 63)
        );
    }

    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Teste Zufallszahlen")
    void testRandomMax() {

        int amount = 0;
        int sum = 0;
        int max = randomInt();
        for(int i = max-1; i != 0; i--){
            if(i % 7 == 0 || i % 2 == 0){
                amount++;
                sum += i;
            }
        }
        main.calcSumAndCountAllNumbersDivBy_2_Or_7(max);
        assertEquals(amount + ", " + sum, outContent.toString().trim());
    }

    @ParameterizedTest(name = "Eingabe: {0}")
    @ValueSource(ints = {-1})
    @NullSource
    @DisplayName("Teste ungültige Eingaben")
    public void testInvalidParameter(int max) {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {  //FAIL asap timeout occurs
            assertThrows(IllegalArgumentException.class, () -> {
                main.calcSumAndCountAllNumbersDivBy_2_Or_7(max);
            });
        });
    }



    private int randomInt(){
        Random random = new Random();
        int min = 16;
        int max = 100;
        return random.nextInt(max - min + 1) + min;
    }
}