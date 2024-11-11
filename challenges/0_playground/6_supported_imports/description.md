Ein Beispiel für eine Java Klasse die imports aus der Standardbibliothek verwendet.

### config.json
```json
{
  "friendlyName": "Java Klasse mit Importen",
  "difficulty": "3",
  "shortDescription": "Beispiel für eine einfache Java Klasse mit Importen",
  "templates": [
    {
      "title": "Deine Lösung:",
      "classname": "Main",
      "content": "import java.util.*;\n\npublic class Main {\n    public void method() {\n        //Schreibe deinen Code hier\n    }\n}",
      "whitelist": [
        "java.util"
      ]
    }
  ]
}
```
Im Abschnitt 'templates.whiteList' wird angegeben, dass nur der Import 'java.util' erlaubt ist. Alle anderen Import statements werden stumm aus dem codeblock entfernt.
Sollte es dadurch zu einem Fehler kommen, wird dieser an den Nutzer weitergegeben.