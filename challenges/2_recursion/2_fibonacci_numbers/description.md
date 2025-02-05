## Fibonacci

Das Berechnen der Fibonacci Zahlen kann auf zwei verschiedenen Wegen umgesetzt werden. In dieser Aufgabe wollen wir uns mit diesen befassen. 

### Rekursiv vs Iterativ

- **Rekursiv:** Hilft uns zu verstehen wie man rekursive Methoden für das Berechnen von mathematischen Folgen anwendet.
- **Iterativ:** Die rekursive Berechnung der Fibonacci-Zahlen ist leider nicht sehr effizient. Die Laufzeit vergrößert sich enorm bei großen Inputs. Um den Prozess effizienter zu gestalten, implementieren wie eine iterative Form des Algorithmus'.

### Die Fibonacci Zahlen

Die Fibonacci Zahlen sind eine aus der Mathematik bedeutende Folge von Zahlen welche mit einem Algorithmus berechnet werden können. In der Mathematik verwendet man folgende Definition:

> $$
fib(n) =
\begin{cases}
1, &  x =1 \\
1, & x =2  \\
fib(n-1) +fib(n-2), &\forall n>2
\end{cases} $$

#### Example

| n      | 1 | 2 | 3 | 4 | 5 | 6 | 7  | 8  |
|--------|---|---|---|---|---|---|----|----|
| fib(n) | 1 | 1 | 2 | 3 | 5 | 8 | 13 | 21 |