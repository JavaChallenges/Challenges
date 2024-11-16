# Challenges erstellen, bearbeiten oder Löschen
## Übersicht über verwendete Dateien und deren Zweck
### Basis Ordnerstruktur
```plaintext
└── challenges                    <- Root-Verzeichnis für alle Challenges
    ├── description.md            <- Textbeschreibung für die Übersichtsseite
    └── 0_category                <- Kategorie-Verzeichnis
        ├── config.yml            <- Konfiguration für Kategorie-Übersichtsseite
        ├── description.md        <- Textbeschreibung für die Kategoriespezifische Übersichtsseite
        └── 1_challenge           <- Challenge-Verzeichnis
            ├── config.yml        <- Konfiguration für Challengeseite
            ├── > 1 UnitTest.java <- Mindestens eine Testklasse die den Code der Challenge testet
            ├── description.md    <- Beschreibung der Challenge
            └── templates         <- (OPTIONAL) Codevorlagen für die Challenge als .java Dateien
                └── template.java <- (OPTIONAL) Codevorlagen als .java Datei
```
### description.md
Alle .md Dateien werden auf der Website vollständig Markdown Complient abgebildetm bei Links zu Ankerpunkten kann es aber unter Umständen zu unverhersehbarem scollverhalten kommen, eine Verwendung davon wird also ohne intensives Testen abgeraten. Weiterhin ist die Implementation des Markdowninterpreters auf der Website dazu fähig LaTex Math Mode zu interpretieren. Dieser wird mit `$ %Latex Math Mode $` verwendet.

### Kategorieverzeichnis
Das Kategorieverzeichnis enthält:
- Mindestens ein funktionierendes [Challengeverzeichnis](#challengeverzeichnis)
- `config.yml` der unten folgenden Form
- `description.md` die die Kategorie ausführlicher beschreibt.

#### config.json Kategorieverzeichnis
```json
{
  "friendlyName": "0. Beispiele",
  "shortDescription": "Beispielsammlung für die Challenge-Plattform um die Funktionalität zu demonstrieren."
}
```
- `friendlyName` der Namen der Kategorie, welcher in UI Elementen angezeigt wird, welche diese Kategorie referenzieren.
- `shortDescription` Ist eine Kurzbeschreibung der Kategorie die auf der Übersichtsseite angezeigt wird.

### Challengeverzeichnis
Das Challengeverzeichnis enthält:
- Mindestens eine `unittest.java` Datei, die beliebig benannt werden darf. Alle `*.java` Dateien in diesem Ordner werden als Unittest Dateien betrachtet
- `config.json` der unten folgenden Form
- `description.md` die die Challenge ausführlicher beschreibt, die Aufgabenstellung und ggf. Bearbeitungshinweise für diese Enthält.

#### config.json Challengeverzeichnis
```json
{
  "friendlyName": "Beispiel einfache Javaklasse",
  "difficulty": "2",
  "shortDescription": "Beispiel für eine einfache Javaklasse",
  "tags":["beispiel"],
  "templates": [
    {
      "title": "Deine Lösung:",
      "classname": "Main",
      "content": "public class Main {\n    public void method() {\n        //Schreibe deinen Code hier\n    }\n}",
      "OR": "=====",
      "content": "Main.java",
      "whitelist": [
        "java.util"
      ]
    }
  ]
}
```
- `friendlyName` der Namen der Challenge, welcher in UI Elementen angezeigt wird, welche diese Challenge referenzieren.
- `difficulty` Zahl von 1-5 die eine grobe Einschätzung des Schwierigkeitsgrad der Challenge geben soll. Dies wird auf der Website an verschiedenen Stellen in Form von Sternen repräsentiert.
- `shortDescription` Ist eine Kurzbeschreibung die auf allen Übersichtsseiten auf der diese Challenge auftaucht, die in kurzen Worten beschreiben soll, was den Nutzer in dieser Challenge erwartet
- `tags` Liste von Tags die die Challenge beschreiben. Diese werden auf der Website als Filtermöglichkeit neben den Kategorien für die Challenges angeboten und sollten sich daher von den Katgeorienamen unterscheiden.
- `templates` Liste für die Codeblöcke in die der Nutzer seinen Code einfügen soll, die diese Form erfüllen:
  - `title` Freies textfeld in dem Kontextbasiert eingetragen werden kann, was im folgenden Codeblock eingetragen werden kann. Bei einfachen Aufgaben bietet sich etwas wie "Deine Lösung" an. Bei Aufgaben mit mehreren Klassen, bietet es sich an hier den entsprechenden Klassennamen einzutragen
  - `classname` Name der Klasse in der der Code aus diesem Codeblock gespeichert werden soll. Dies ist vor allem für die Automatischen Unittests relevant, damit diese den Code auch richtig zuordnen können.
  - `content` Vorgegebener Code der in den Codeblock eingefügt wird. Dieser kann beliebig lang sein und sollte den Nutzer bei der Bearbeitung der Challenge unterstützen um bspw. simple Tipparbeit zu ersparen, um den Nutzer auf die richtige Spur zu bringen oder ihm Hilfsklassen oder -methoden zur Verfügung zu stellen.
    - "inline" Code, wie in der ersten Variante im oben gezeigten Beispiel
    - In eine Java Datei ausgelagert werden, was sich besonders bei längeren Codevorgaben anbietet. Diese Datei muss im `templates` Ordner der Challenge abgelegt werden und in diesem Abschnitt mit dem Namen der Datei referenziert werden.
  - `whitelist` Liste von Packages die der Nutzer verwenden darf. Alle anderen Imports, die die Nutzer evtl. verwenden möchte werden vor dem Kompilieren entfernt. Damit wird verhindert, dass der Nutzer uneingeschränkten Zugriff auf das gesamte Java SDK hat und somit die Challenge evtl. zu einfach wird und um zu verhindern, dass der Nutzer spezifische Arten von Code wie bspw. Downloads oder Dateimanipulationen ausführen kann.

## Unit Tests
Zur Erstellung von Unittests steht die aktuellste Version von `JUnit` und `JUnit Params` zur Verfügung. Bei allen Tests sollte darauf geachtet werden, dass Ausführungen von Nutzercode in ein `assertTimeoutPreemptively(Duration.ofSeconds(x), () -> {//Nutzercode... })` gepackt sind. Dies bricht die Ausführung des Codes des Nutzers nach X Sekunden ab.
Dies Verhindert lange wartezeiten bei Endlosschleifen oder anderen Problemen im Nutzercode. X sollte natürlich entsprechend einer realistischen Zeit gewählt werden, die der Nutzercode benötigen darf.

## Erstellen und Löschen
Beim Erstellen muss nichts weiter beachtet werden, als das die oben genannten Konventionen eingehalten werden. Wurden Challenges oder Kategorien gelöscht ist es sinnvoll sich die Datei bzw. Ordnernamen der gelöschten Kategorien oder Challenges zu merken, da es zu ungewünschten Seiteneffekten kommen kann, wenn diese in Zukunft wiederverwendet werden

## Bearbeiten
Beim Bearbeiten von Challenges und Kategorien muss ebenfalls beachtet werden, dass sich bei Umbenennung die veralteten Namen gemerkt werden, da es zu ungewünschten Seiteneffekten kommen kann, wenn diese in Zukunft wiederverwendet werden. Außerdem ist zu beachten, dass Nutzerfortschritt ggf. verloren geht, wenn Challenges zwischen Kategorien verschoben werden.
