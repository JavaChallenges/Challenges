## Beschreibung
In dieser Challenge sollst du eine Funktion schreiben, die eine arabische Zahl in eine römische Zahl umwandelt. Die römischen Zahlen sind eine Zahlendarstellung, die im alten Rom verwendet wurde. Sie bestehen aus den Zeichen `I`, `V`, `X`, `L`, `C`, `D` und `M`. Diese Zeichen stehen für folgende Werte:

| Römisch | Arabisch |
|---------|----------|
| I       | 1        | 
| V       | 5        | 
| X       | 10       | 
| L       | 50       |
| C       | 100      |
| D       | 500      |
| M       | 1000     |

Die römischen Zahlen werden von links nach rechts gelesen und addiert. Es gibt jedoch einige zusätzliche Regeln, die beachtet werden müssen:

1. Alle Zeichen nebeneinander werden addiert.\
Im Wert kleinere Zahlzeichen folgen den im Wert größeren Zahlzeichen (sie stehen weiter rechts).\
Zum Beispiel $XVII = 10+5+1+1 = 17$.\
$X (10)$ zuerst, dann $V (5)$ und dann $I (1)$
2. Es dürfen nur maximal drei gleiche Zeichen aufeinander folgen.\
Zum Beispiel: $III$, $XXX$, $CCC$ oder $MMM$).\
Die Zahlzeichen $V$, $L$, $D$ werden nie mehrfach geschrieben, denn bspw. $VV$ wäre ja $X$.
3. Subtraktionsregel\
Steht ein kleines Zahlzeichen (wie $I$) vor einem größeren (wie $V$), so wird es abgezogen.\
Also 4 wäre $IV$ (1 vor 5).\
Es darf immer nur ein Zeichen vorangestellt werden. Erlaubt sind $I$, $X$ und $C$.
4. Reihenfolge bei Subtraktion\
Eine bestimmte Reihenfolge ist bei der Subtraktion einzuhalten:\
$I$ (1) darf nur von $V$ (5) und $X$ (10) abgezogen werden. Erlaubt sind also nur $IV$ und $IX$.\
$X$ (10) darf nur von $L$ (50) und $C$ (100) abgezogen werden. Erlaubt sind also nur $XL$ und $XC$.\
$C$ (100) darf nur von $D$ (500) und $M$ (1000) abgezogen werden. Erlaubt sind also nur $CD$ und $CM$.