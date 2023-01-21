==== Rozszerzenie języka C o łatwą obsługę formatu JSON ====
  - Dane studenta(-ów): Dominika Bocheńczyk, Monika Pyrek
  - Pliki źródłowe: https://github.com/mpyrek/MiAK/tree/main/main_class
  - Założenia programu i krótki opis: Program pozwala na łatwiejszą obsługę plików json w języku C. Odpowiednio przekształca plik wejściowy JSON do formatu ułatwiającego stosowanie jego zawartości w programie w C.  
  - Spis tokenów: https://github.com/mpyrek/MiAK/blob/main/out/production/antlr4/JSON.tokens

  `T__0=1
  T__1=2
  T__2=3
  T__3=4
  T__4=5
  T__5=6
  T__6=7
  T__7=8
  T__8=9
  STRING=10
  NUMBER=11
  WS=12
  '{'=1
  ','=2
  '}'=3
  ':'=4
  '['=5
  ']'=6
  'true'=7
  'false'=8
  'null'=9`
 
  - Gramatyka przetwarzanego formatu (gramatyka JSON): https://github.com/mpyrek/MiAK/blob/main/out/production/antlr4/JSON.g4
  - Informacja o stosowanych generatorach skanerów/parserów, pakietach zewnętrznych:
    - program ANTLR4 (jego wtyczka do Intellij)
  - Krótka instrukcja obsługi:
    - Uruchamiamy plik Launch.java z naszym plikiem wejściowym JSON
    - Program w Javie z pomocą programu ANTLR4 tworzy parser dla gramatyki i następnie i zwraca plik .txt ze zmiennymi do użycia w programie w C
    - Na koniec załączamy do pliku .c nasz plik .txt jako wejściowy oraz przygotowaną do obsługi tego formatu bibliotekę jsonlib.c 
    - Kompilujemy i uruchamiamy :)
  - Przykład zwróconego pliku .txt

    `string title = "animals";
    int animals = ["lion", "cat", "dog", "cow", "monkey", "bird", "pig"];
    int animals_age = [2, 7, 4, 12, 0.5, 1, 3];
    int child = [1, 0, 1, 1, 1, 0, 0];
    int friendly = 1;`
