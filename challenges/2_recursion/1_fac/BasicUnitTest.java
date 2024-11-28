
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BasicUnitTest {

    private Main main;

    @BeforeEach
    public void setUpStreams() {
        main = new Main();
    }
    @ParameterizedTest(name = "Eingabe: {0} ==> Erwartetes Ergebniss: {1}")
    @MethodSource("tableProvider")
    @DisplayName("Teste Werte aus der Tabelle: ")
    void testWithMultiArgMethodSource(int n, int fac) {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            int result = main.rec_fac(n);
            assertEquals(fac, result);
        });
    }

    static Stream<Arguments> tableProvider() {
        return Stream.of(
                Arguments.arguments(0, 1),
                Arguments.arguments(1, 1),
                Arguments.arguments(2, 2),
                Arguments.arguments(3, 6),
                Arguments.arguments(4, 24),
                Arguments.arguments(5, 120),
                Arguments.arguments(6, 720),
                Arguments.arguments(7, 5040),
                Arguments.arguments(8, 40320)
        );
    }

    @RepeatedTest(value = 5, name = "{currentRepetition}/{totalRepetitions}")
    @DisplayName("Teste Zufallszahlen")
    void testRandomMax() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            int max = randomInt();
            int result = main.rec_fac(max);
            assertEquals(factorial(max), result);
        });
    }


    @ParameterizedTest(name = "Eingabe: {0}")
    @ValueSource(ints = {-1})
    @NullSource
    @DisplayName("Teste ungültige Eingaben")
    public void testInvalidParameter(int n) {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {  //FAIL asap timeout occurs
            assertThrows(IllegalArgumentException.class, () -> {
                main.rec_fac(n);
            });
        });
    }


    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private int randomInt(){
        Random random = new Random();
        int min = 8;
        int max = 50;
        return random.nextInt(max - min + 1) + min;
    }
}