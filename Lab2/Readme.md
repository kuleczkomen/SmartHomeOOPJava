## Lab 2: Dzwoni kuzyn

Celem laba jest zapoznanie studentów z zasadami SOLID, jak i innymi podstawowymi regułami, którymi należy się kierować w trakcie implementacji systemu.

Zadaniem będzie refactoring istniejącego kodu – coś, z czym w swojej ścieżce zawodowej zapewne spotkacie się nieraz.

Starałem się go napisać tak źle i brzydko, jak się tylko da — samo zrozumienie, co się właściwie dzieje, może być już wyzwaniem.

Ogółem rzecz biorąc ten kod jest:
 - Niezrozumiały
 - Ciężko rozszerzalny (bardzo często trzeba mocno ingerować w istniejący już kod)
 - Nieodporny na błędy użytkownika - sygnatury metod pozwalają bardzo łatwo
Do tego nawet nie wiem, czy działa — ale tym się nie przejmujemy na razie. Testy będą później w toku kursu.

### Zadanie 1

Zapoznaj się z dostarczonym kodem i poczyń odpowiedni refactor, tak aby kod spełniał zasady SOLID i nie łamał innych dobrych praktyk programowania.

*Disclaimer*: Czasami interpretacja tego co robi metoda/jak ma działac może nie byc do końca jasna (jako side-effect brzydkiego kodu) - interpretacje przyjmijcie dowolną, o ile nie będzie totalnie bezsensowna to jest na waszą korzyśc.

Dla ułatwienia zadanie, dobrym pomysłem może byc wygenerowanie sobie diagramu klas z opcją "Show Dependencies".

*Jak dużo trzeba zrobić?*

Refaktoryzować kod można bez końca tak, aby był ✨perfekcyjny✨, jednak gdzieś trzeba postawić granicę.
Każda zasada z SOLIDa jest złamana przynajmniej raz — wystarczy naprawić każdą z nich przynajmniej raz.
Niemniej, oczywiście, jeśli zauważysz złamianie zasady w innym miejscu, gorąco zachęcam, aby tę część kodu również poprawić.

**Co załączyć** Tutaj oprócz kodu prosiłbym także o jakiś dokument (np. Markdown) podsumowywujący zakres zmian w kontekście danych zasad. Coś w stylu:

*Zasada S - klasa `X` miała taką i taką odpowiedzialność więc wprowadziłem klasy `Y`, `Z` w celu rozdzielenia odpowiedzialności*

### Zadanie 2

1. W kodzie projektu znajdziesz metodę, która zapisuje zdjęcia do chmury — dodaj nowego clouda, do którego można by zapisać zdjęcia.

1. Dodatkowo zaproponuj rozszerzenie istniejącego systemu. Zwróć uwagę na to, aby sposób jego realizacji był zgodny z którąś zasadą SOLID.
Może być to przykładowo dodanie nowej funkcjonalności do telefonu (ale dłuższej niż 5 linii), wzbogacenie telefonu o interakcję z innym urządzeniem/klasą (np. nadajnik GPS) lub wprowadzenie nowego telefonu.

W markdownie wspomnianym w **Zadaniu 1** chciałbym także informację na temat wprowadzonej nowej funkcjonalności, coś w stylu:

 *Wprowadziłem/am nową funkcjonalność X, została zrealizowana z dodaniem tej i tej klasy, w celu zachowania zasady Y*.

### Tipy typu "Zrób to za mnie IDE"

IDE to z reguły dość potężne narzędzia. Posiadają wiele wbudowanych funkcji upraszczających robotę. Oto pare z nich w jedynej uczciwej cenie (za darmo):
 - Rename (aka zmiana nazwy) czegokolwiek - zmienia nazwę danej rzeczy WSZĘDZIE (klasa, użycia) + jakiś zależności (np. nazwa zmiennej typu klasy której nazwe zmieniamy) - **PPM -> Rename, Shift+F6**
 - Użycia klasy/metody -  **klik "Find Usages" (obok klasy) albo Alt+F7**
 - Tworzenie sygnatury metody która nie istnieje - np. najpierw koncepcyjnie w jakieś big metodzie piszemy sobie co musi być wykonane (jako nazwy metod), a potem pyk, metody się same pojawiają z odpowiednim wyjściem i wejściem - **Kursor na metode/ALT+ENTER -> "Create Method" lub "Created Abstract Method**
 - Ekstrakcja interfejsu - robi interfejs na podstawie istniejącej klasy i jej metod - **PPM -> Refactor -> Extract Interface**
 - Przenoszenie metod do innej (np. nowej klasy) - działa zarówno dla statycznych metod (do nowej klasy), jak i instancyjnych (do klasy używanej w jednym z atrybutów) - **PPM -> Refactor -> Move members / Move instance method** 
 - Przenoszenie metod do interfejsu - jednym kliknięciem wrzucamy metody z danej klasy do interfejsu, który realizujemy - **PPM -> Refactor -> Pull Members Up**

Więcej przydatnych skrótów w IntelliJ w [poradniku z przedmiotu Programowanie Obiektowe](https://github.com/Soamid/obiektowe-lab/blob/master/guides/IntelliJ%20-%20porady%20i%20konfiguracja.md)
.
### Materiały

 - [Prezentacja z zajęć](https://www.canva.com/design/DAHDXA-8S_o/8jr39VzRfcMIRkV0TwWMPA/view?utm_content=DAHDXA-8S_o&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=hbabf327b6a)
 - [Prezentacja z Programowania Obiektowego](https://www.canva.com/design/DAGbt85OPV0/RjGm17Fnxssa2XNvDme4yA/view?utm_content=DAGbt85OPV0&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=he2f1c89ef7)

Powodzenia!
