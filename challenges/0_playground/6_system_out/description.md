Beispiel dafür wie System.out dargestellt wird

### config.json
```json
{
  "friendlyName": "System Out Darstellung",
  "difficulty": "3",
  "shortDescription": "Beispiel dafür wie System.out dargestellt wird",
  "tags": ["beispiel"],
  "templates": [
    {
      "title": "Deine Lösung:",
      "classname": "Main",
      "content": "public class Main {\n    public void method(String message) {\n        System.out.println(message + \" \" + message.length());\n    }\n}"
    }
  ]
}
```
Um die Challenge Seite übersichtlich zu halten werden Nachrichten aus dem std-out hinter einem Modal versteckt. Dieses Modal wird durch einen Button hinter dem 
jeweils zugehörigen Test geöffnet. Der Button wird nur angezeigt, wenn Nachrichten im std-out vorhanden sind.
Weiterhin wird der std-out nur dann an das Modal weitergegeben, wenn der Test nicht auf std-out prüft. Bei der Erstellung der Test kann dies aber ggf. überschrieben werden, falls dies als nötig empfunden wird.\
\
Gleiches gilt für die Darstellung von System.err und Stacktraces.\
Sowohl Stacktraces die entstehen, wenn ein Test durch einen nicht vorhergesehenen Laufzeitfehler des Nutzer-Codes fehlschlägt, als auch Stacktraces die durch erwartete Fehlermeldungen entstehen, werden in einem Modal dargestellt.