Einfachste Form einer Challenge. Es wird eine einzelne Klasse erstellt, die eine Methode implementiert, welche getestet wird.

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
### config.json
```json
{
  "friendlyName": "Beispiel einfache Javaklasse",
  "difficulty": "2",
  "shortDescription": "Beispiel für eine einfache Javaklasse",
  "tags": ["beispiel"],
  "templates": [
    {
      "title": "Deine Lösung:",
      "classname": "Main",
      "content": "public class Main {\n    public void method() {\n        //Schreibe deinen Code hier\n    }\n}"
    }
  ]
}
```