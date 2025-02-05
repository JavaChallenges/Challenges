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
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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

    @ParameterizedTest(name = "Eingabe: {0} ==> Erwartete Liste: {1}")
    @MethodSource("tableProvider")
    @DisplayName("Teste Werte aus der Tabelle: ")
    void testWithMultiArgMethodSource(int upperLimit, List<Integer> perfectNumbers) {
        main.calcPerfectNumbers(upperLimit);
        assertEquals(perfectNumbers.toString(), outContent.toString().trim());
    }

    static Stream<Arguments> tableProvider() {
        return Stream.of(
                Arguments.arguments(1000, List.of(6, 28, 496))),
                Arguments.arguments(10000, List.of(6, 28, 496, 8128)))
        );
    }

    @ParameterizedTest(name = "Eingabe: {0}")
    @ValueSource(ints = {-1})
    @NullSource
    @DisplayName("Teste ungültige Eingaben")
    public void testInvalidParameter(int upperLimit) {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {  //FAIL asap timeout occurs
            assertThrows(IllegalArgumentException.class, () -> {
                main.calcPerfectNumbers(upperLimit);
            });
        });
    }

    @RepeatedTest(value = 5, name = "{currentRepetition}/{totalRepetitions}")
    @DisplayName("Teste Zufallszahlen")
    void testRandomMax() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            int max = randomInt();
            int result = main.calcPerfectNumbers(max);
            assertEquals(calcPerfectNumbers(max), result);
        });
    }

    private static boolean isPerfectNumberSimple(final int number) {
        int sumOfMultipliers = 1;
        for(int i = 2; i <= number/2; i++) {
            if(number%i == 0){
                sumOfMultipliers += i;
            }
        }
        return sumOfMultipliers == number;
    }

    private static List<Integer> calcPerfectNumbers(final int maxExclusive){
        final List<Integer> results = new ArrayList<>();
        if(maxExclusive <= 0) {
            throw new IllegalArgumentException();
        }
        for(int i = 2; i < maxExclusive; i++){
            if(isPerfectNumberSimple(i)){
                results.add(i);
            }
        }
        return results;
    }

    private int randomInt(){
        Random random = new Random();
        int min = 8;
        int max = 50;
        return random.nextInt(max - min + 1) + min;
    }
}