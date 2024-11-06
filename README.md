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
            └── description.md    <- Beschreibung der Challenge
```
### description.md
Alle .md Dateien werden auf der Website vollständig Markdown Complient abgebildetm bei Links zu Ankerpunkten kann es aber unter Umständen zu unverhersehbarem scollverhalten kommen, eine Verwendung davon wird also ohne intensives Testen abgeraten. Weiterhin ist die Implementation des Markdowninterpreters auf der Website dazu fähig LaTex Math Mode zu interpretieren. Dieser wird mit `$ %Latex Math Mode $` verwendet.

### Kategorieverzeichnis
Das Kategorieverzeichnis enthält:
- Mindestens ein funktionierendes [Challenge Verzeichnis](#challengeverzeichnis)
- `config.yml` der unten folgenden Form
- `description.md` die die Kategorie ausführlicher beschreibt.

#### config.yml Kategorieverzeichnis
```yaml
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
- `config.yml` der unten folgenden Form
- `description.md` die die Challenge ausführlicher beschreibt, die Aufgabenstellung und ggf. Bearbeitungshinweise für diese Enthält.

#### config.yml Challengeverzeichnis
```yaml
{
  "friendlyName": "Beispiel einfache Javaklasse",
  "difficulty": "2",
  "shortDescription": "Beispiel für eine einfache Javaklasse",
  "templates": [
    {
      "title": "Deine Lösung:",
      "classname": "Main",
      "content": "public class Main {\n    public void method() {\n        //Schreibe deinen Code hier\n    }\n}"
    }
  ]
}
```
- `friendlyName` der Namen der Challenge, welcher in UI Elementen angezeigt wird, welche diese Challenge referenzieren.
- `difficulty` Zahl von 1-5 die eine grobe Einschätzung des Schwierigkeitsgrad der Challenge geben soll. Dies wird auf der Website an verschiedenen Stellen in Form von Sternen repräsentiert.
- `shortDescription` Ist eine Kurzbeschreibung die auf allen Übersichtsseiten auf der diese Challenge auftaucht, die in kurzen Worten beschreiben soll, was den Nutzer in dieser Challenge erwartet
- `templates` Liste für die Codeblöcke in die der Nutzer seinen Code einfügen soll, die diese Form erfüllen:
  - `title` Freies textfeld in dem Kontextbasiert eingetragen werden kann, was im folgenden Codeblock eingetragen werden kann. Bei einfachen Aufgaben bietet sich etwas wie "Deine Lösung" an. Bei Aufgaben mit mehreren Klassen, bietet es sich an hier den entsprechenden Klassennamen einzutragen
  - `classname` Name der Klasse in der der Code aus diesem Codeblock gespeichert werden soll. Dies ist vor allem für die Automatischen Unittests relevant, damit diese den Code auch richtig zuordnen können.
  - `content` Platzhaltercode um den Nutzer schneller an die Stelle zu bringen an der er eigentlich die Aufgabe löst um ihm Boilerplate schreibarbeiten zu ersparen. Kann auch genutzt werden um Nutzer fehler im Code finden zu lassen oder den Code zu verbessern.

## Erstellen und Löschen
Beim Erstellen muss nichts weiter beachtet werden, als das die oben genannten konventionen eingehalten werden. Wurden Challenges oder Kategorien gelöscht ist es sinnvoll sich die Datei bzw. Ordnernamen der gelöschten Kategorien oder Challenges zu merken, da es zu ungewünschten Seiteneffekten kommen kann, wenn diese in Zukunft wiederverwendet werden

## Bearbeiten
Beim bearbeiten von Challenges und Kategorien muss ebenfalls beachtet werden, dass sich bei Umbenennung die veralteten Namen gemerkt werden, da es zu ungewünschten Seiteneffekten kommen kann, wenn diese in Zukunft wiederverwendet werden. Außerdem ist zu beachten, dass Nutzerfortschritt ggf. verloren geht, wenn Challenges zwischen Kategorien verschoben werden.
