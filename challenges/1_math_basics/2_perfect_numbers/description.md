### Beschreibung

Per Definition ist eine natürliche Zahl `perfekt`, wenn ihr Wert gleich der Summe all ihrer Teiler ist. Dies trifft zum Beispiel zu auf 6:

> $1+2+3=6$

### Aufgabenstellung

Schreibe eine Methode 
```java
List<Integer> calcPerfectNumbers(int upperLimit);
```
welche eine Liste von `perfect numbers` bis zu dem Wert der eingegebenen Zahl berechnet.</br>
Wichtig!: <br>
Die perfekten Zahlen sind alles natürliche Zahlen ausgehend von 1.

### Beispiel

| Input | Result          |
| ----- |-----------------|
| 1000  | [6,28,496]      |
| 10000 | [6,28,496,8128] |

### Tipps:
<details>
  <summary>Hilfsmethode isPerfectNumber()</summary>
    Benutze eine Hilfsmethode, welche alle Teiler bis zur Hälfte des oberen Limits überprüft.
</details>



