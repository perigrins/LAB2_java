# Projekt utworzony na potrzeby kursu **Języki programowania do zastosowań biomedycznych**

## Zadanie 1

### Klasa **Pol**
Przyjmuje jako konstruktor listę współczynników definiowaną jako ArrayList <Integer> Coefficient. Wielomiany zapisywane są w kolejności odwrotnej, co znaczy, że zapis 

ArrayList<Integer> c = new ArrayList<>(Arrays.asList(3, 2, 1));

oznacza wielomian 1x^2 + 2x + 3.

Klasa **Pol** zawiera metody:
1. **static int polynomialDegree(Pol pol)**, która zwraca stopień wielomianu
2. **public static void printPol(Pol polynomial)**, która wyświetla wielomian w czytelnej postaci
3. **public static double polynomialValue(Pol pol, int arg)**, która dla zadanej wartości argumentu arg zwraca wartość wielomianu W(arg)
4. **public static Pol polynomialOperations(Pol pol, Pol pol2, char option)**, która w zależności od wybranej opcji (+, -, *) przeprowadza odpowiednie działanie na dwóch wielomianach. Zaimplementowano również odpowiadające tym działaniom operatory złożone (+=, -=, *=), które definiowane są jako metody **public void add(Pol other)**, **public void subtract(Pol other)** i **public void multiply(Pol other)**.

### Testy - zadanie 1
W pliku *PolTest* znajdują się testy sprawdzające odpowiednio:
1. Poprawność funkcji zwracającej stopień wielomianu (dla pustego wielomianu, wielomianu składającego się tylko z wyrazu wolnego i "standardowego" wielomianu)
2. Poprawność funkcji zwracającej wartość W(x) dla x = {-1, 0, 1}
3. Poprawność funkcji przeprowadzającej odpowiednie operacje na dwóch wielomianach - dodawanie, odejmowanie i mnożenie

### Prezentacja zadania 1
W funkcji **main** w klasie **Pol** napisała została czytelna prezentacja działania każdej metody.

## Zadanie 2

### Klasa **Sequence**
Utworzono klasę abstrakcyjną **Sequence**, po której dziedziczą klasy **DNASequence**, **RNASequence** oraz **ProteinSequence**. Klasa **Sequence** zawiera metody powtarzające się w każdej z klas dziedziczących, tj.:
1. Konstruktor, w którym zawarta jest walidacja
2. **public String getIdentifier()**, która zwraca wartość *identifier*
3. **public String getData()**, która zwraca wartość *data*
4. **public int getLength()**, która zwraca długość wartości *data*
5. **public void mutate(int position, char val)**, która przeprowadza mutację, tj. wstawia wartość *val* na pozycję *position*
6. **public int findMotif(String motif)**, która zwraca pozycję ciągu znaków *motif* (zwraca -1 jeśli nie znaleziono ciągu znaków)
7. **public String toString()**, która odpowiada za wyświetlanie danych w formacie FASTA
8. **protected boolean validate()**, która odpowiada za odpowiednią walidację
9. **protected abstract java.util.Set<Character> getValidCharacters()**, która w odpowiednich klasach dziedziczących zwraca zbiór dozwolonych znaków *VALID_CHARS*

Ponadto klasa **Sequence** zawiera właściwości **identifier** i **data**, które również są częścią każdej z klas dziedziczących.

### Klasa **DNASequence**
Klasa **DNASequence** zawiera:
1. Konstruktor
2. metodę **public String complement()**, która zwraca nić komplementarną do nici DNA
3. metodę **public RNASequence transcribe()**, która zwraca obiekt klasy **RNASequence** reprezentujący wynik transkrypcji DNA
4. zbiór **protected Set<Character> getValidCharacters()**, który zwraca listę dozwolonych znaków

### Klasa **DNASequence** - testy
W pliku *DNASequenceTest* znajdują się testy sprawdzające odpowiednio:
1. Poprawność funkcji zwracającej wartości *data* i *indentifier*
2. Poprawność funkcji testującej wyjątki, tj. użycie niepoprawnych znaków
3. Poprawność funkcji przeprowadzającej mutację
4. Poprawność funkcji zwracającej nić komplementarną do nici DNA
5. Poprawność funkcji zwracającej pozycję ciągu znaków
6. Poprawność funkcji przeprowadzającej transkrypcję DNA

### Klasa **RNASequence**
Klasa **RNASequence** zawiera:
1. Konstruktor
2. metodę **public String complement()**, która zwraca nić komplementarną do nici RNA
3. metodę **public ProteinSequence transcribe()**, która zwraca obiekt klasy  **ProteinSequence** reprezentujący wynik translacji sekwencji RNA
4. metodę **private Map<String, Character> getCodonTable()**, w której zawarte są tłumaczenia wybranych aminokwasów
5. zbiór **protected Set<Character> getValidCharacters()**, który zwraca listę dozwolonych znaków

### Klasa **RNASequence** - testy
W pliku *RNASequenceTest* znajdują się testy sprawdzające odpowiednio:
1. Poprawność funkcji zwracającej wartości *data* i *indentifier*
2. Poprawność funkcji testującej wyjątki, tj. użycie niepoprawnych znaków
3. Poprawność funkcji przeprowadzającej mutację
4. Poprawność funkcji zwracającej nić komplementarną do nici RNA
5. Poprawność funkcji zwracającej pozycję ciągu znaków
6. Poprawność funkcji przeprowadzającej translację RNA

### Klasa **ProteinSequence**
Klasa **ProteinSequence** zawiera:
1. Konstruktor
2. zbiór **protected Set<Character> getValidCharacters()**, który zwraca listę dozwolonych znaków

### Klasa **ProteinSequence** - testy
W pliku *ProteinSequenceTest* znajdują się testy sprawdzające odpowiednio:
1. Poprawność funkcji zwracającej wartości *data* i jej długość
2. Poprawność funkcji przeprowadzającej translację RNA
3. Poprawność funkcji testującej wyjątki, tj. użycie niepoprawnych znaków
4. Poprawność funkcji przeprowadzającej mutację
5. Poprawność funkcji zwracającej nić komplementarną do nici RNA
6. Poprawność funkcji zwracającej dane w formacie FASTA

### Klasa **Main**
W klasie **Main**  znajduje się czytelna prezentacja wszystkich metod zawartych w klasie **Sequence** i klasach po niej dziedziczących.
