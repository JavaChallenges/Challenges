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

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @BeforeEach
    public void setUpStreams() {
        main = new Main();
    }
    @ParameterizedTest(name = "Eingabe: {0} ==> Erwartetes Ergebniss: {1}")
    @MethodSource("tableProvider")
    @DisplayName("Teste Werte aus der Tabelle: ")
    void testWithMultiArgMethodSource(int index, int fibonacciNumber) {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            int result = main.fibIter(index);
            assertEquals(fibonacciNumber, result);
        });
    }

    static Stream<Arguments> tableProvider() {
        return Stream.of(
                Arguments.arguments(1, 1)),
        Arguments.arguments(2, 1)),
        Arguments.arguments(3, 2)),
        Arguments.arguments(4, 3)),
        Arguments.arguments(5, 5)),
        Arguments.arguments(6, 8)),
        Arguments.arguments(7, 13)),
        Arguments.arguments(8, 21))
        );
    }

    @ParameterizedTest(name = "Eingabe: {0}")
    @ValueSource(ints = {-1})
    @NullSource
    @DisplayName("Teste ungültige Eingaben")
    public void testInvalidParameter(int index) {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {  //FAIL asap timeout occurs
            assertThrows(IllegalArgumentException.class, () -> {
                main.fibIter(index);
            });
        });
    }

    @RepeatedTest(value = 5, name = "{currentRepetition}/{totalRepetitions}")
    @DisplayName("Teste Zufallszahlen")
    void testRandomMax() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            int index = randomInt();
            int result = main.fibIter(index);
            assertEquals(fibIter(index), result);
        });
    }

    private int fibIter(final int index){
        if(n <= 0){
            throw new IllegalArgumentException("fibRec error: Wähle einen Index >= 1");
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int fibN_2 = 1;
        int fibN_1 = 1;
        for(int count = 2; count < index; count++) {
            int fibN = fibN_1 + fibN_2;
            fibN_2 = fibN_1;
            fibN_1 = fibN;
        }
        return fibN;
    }

    private int randomInt(){
        Random random = new Random();
        int min = 8;
        int max = 50;
        return random.nextInt(max - min + 1) + min;
    }
}