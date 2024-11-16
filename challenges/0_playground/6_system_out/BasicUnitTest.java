
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class BasicUnitTest {

    @Test
    @DisplayName("Fehlerfreie Ausführung mit std-out")
    public void stdOutDemo() {
        Main main = new Main();
        main.method("Hello World!");
        assertTrue(true);
    }

    @Test
    @DisplayName("Fehlschlagender Test mit std-out")
    public void stdOutError() {
        Main main = new Main();
        main.method("Hello Error!");
        assertTrue(false);
    }

    @Test
    @DisplayName("Laufzeitfehler mit stacktrace ohne std-out")
    public void errorDemo() {
        Main main = new Main();
        main.method(null);
        assertTrue(true);
    }

    @Test
    @DisplayName("Ausbleibendes std-out bei Testprüfung auf std-out")
    public void noStdOut() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main main = new Main();
        main.method("Diese Nachricht kommt nicht durch");
        assertTrue(true);

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Künstliche std-out bei Testprüfung auf std-out")
    public void additionalStdOut() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main main = new Main();
        main.method("Diese Nachricht kommt doch durch");
        assertTrue(true);

        String message = outContent.toString();
        System.setOut(originalOut);
        System.out.println(message);
    }
}