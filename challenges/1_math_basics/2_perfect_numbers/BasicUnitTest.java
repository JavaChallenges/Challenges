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

//TODO: Write a test for random number inputs
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
                Arguments.arguments(1000, new ArrayList<>(Arrays.asList(6, 28, 496))),
                Arguments.arguments(10000, new ArrayList<>(Arrays.asList(6, 28, 496, 8128)))
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
}