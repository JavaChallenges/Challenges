## Beschreibung
Ermitteln Sie die Anzahl, sowie die Summe der natürlichen Zahlen, die durch 2 oder 7 teilbar sind, bis zu einem gewissen Maximalwert (exklusiv) und geben Sie diese auf der Konsole aus. Schreiben Sie eine Methode
```java
void calcSumAndCountAllNumbersDivBy_2_Or_7(int max);
```
welche die Anzahl und die Summe der Zahlen im Format `[Anzahl], [Summe]` ausgibt.
Zum besseren Verständiss hier ein paar Beispiele:

| Maximalwert [`int max`] | Teilbar durch 2        | Teilbar durch 7 | Anzahl | Summe | Ausgabe |
|-------------------------|------------------------|-----------------|--------|-------|---------|
| 3                       | 2                      | -/-             | 1      | 2     | `1, 2`  |
| 8                       | 2, 4, 6                | 7               | 4      | 19    | `4, 19` |
| 15                      | 2, 4, 6, 8, 10, 12, 14 | 7, 14           | 8      | 63    | `8, 63` |