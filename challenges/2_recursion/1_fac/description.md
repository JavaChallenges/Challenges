### Beschreibung
Mathematisch ist die **Fakultät** für eine positive Zahl $n$ als das Produkt aller natürlichen Zahlen von 1 bis einschließlich $n$ definiert. Zur Notation wird ein Ausrufezeichen hinter die Zahl geschrieben, von der die Fakultät gebildet werden soll.
Als Beispiel sähe die Fakultät von 5 so aus:
$5!=5*4*3*2*1=120$ 

Verallgemeinert ist die Fakultät von $n$ also \
$n!=n*(n-1)*(n-2)*\dots*2*1$ 

Basierend darauf ergibt sich die rekursive Definition\
$\begin{equation}
    n!=
    \begin{cases}
        1,&n=0, n=1\\
        n*(n-1)!, &\forall n>1
    \end{cases}
\end{equation}$ 

_Reminder: Das Umgedrehte >A< ($\forall$) ist der **Allquantor** und steht für >für Alle<_

Zum klaren Verständnis hier noch mal der Werteverlauf von $n$ für die ersten 8 Fakultäten


| n  | 1 | 2 | 3 | 4  | 5   | 6   | 7    | 8     |
|----|---|---|---|----|-----|-----|------|-------|
| n! | 1 | 2 | 6 | 24 | 120 | 720 | 5040 | 40320 |

### Aufgabenstellung
Implementiere basierend auf dieser Definition die Funktion `int rec_fac(int n)` die für ein beliebiges $n$ dessen Fakultät zurückgibt