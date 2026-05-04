## Lab 3: Galactic Cruise

Celem laba jest zapoznanie studentów z trzema wzorcami projektowymi:
 - Builder
 - Factory (lub factory method)
 - Strategia

 Poprzez stworzenie wymagań, których zaimplementowanie lekko wymusza użycie konkretnego wzorca (o ile kod ma być piękny, śliczny i wgl.). Dodatkowo różne wymagania mogą wymuszać użycie wzorca w różny sposób - tak aby zobrazować że wzorzec to tylko pewna idea, która można sobie modyfikować pod własne potrzeby.

 ### Opis systemu
 System który będzie tworzony to prosty system do rezerwacji wycieczek kosmicznych. Mamy dwa rodzaje wycieczek:
  - Kolonialną
  - Naukową

Każda z nich posiada jakieś swoje atrybuty + obiekt z podstawowymi atrybutami wspólnymi dla każdej wycieczki (obiekt `SpaceTrip`).


Rezerwacja wycieczki ma zawarty koszt takiej wycieczki. Nie jest to jednak sztywna wartość - zależy od konkretnych detali wycieczki (o tym dokładniej później) a także od momentu poczynienia tej rezerwacji (o tym też później).

Punktem wejściowym do kreatora wycieczki jest `ReservationPlanner`. Przyjmuje on typ wycieczki a także obiekt `SpaceTrip` i czyni rezerwacje (na potrzeby laba punktem wejściowym do tego obiektu będzie Main, natomiast w normalnym projekcie detale mogłybybyć wyklikiwane na UIu a potem przesyłane do backendu przez request HTTP).

### Zadanie 1: Builder
Obiekt `SpaceTrip` posiada parę opcjonalnych pól (nie za dużo żeby się długo nie implementowało). Tworzenie go ręcznie z pomocą konstruktora wygląda brzydko i ogólnie jest nieprzyjemne:
 - Zaimplementuj buildera dla tego obiektu
 - w klasie main w odpowiednich miejscach podstaw buildera tam gdzie obiekt tworzony jest ręcznie

 ### Zadanie 2: Factory (lub factory method)
 `ReservationPlaner` ma oddzielne metody dla dwóch typów wycieczek - a różnić ma się w sumie tylko sposób ich tworzenia. (są opisane komentarzami w kodzie, ale daje tu też dla formalności)

 **Wymagania dla wycieczki kolonialnej**:
  - Jeśli celem jest Mars, dodajemy 1000 do subsydium
  - Jeśli ilość dodatkowych zbiorników tlenu jest większa niż 5, odejmujemy 2000 od subsydium
(gdzie subsydium to jakiś kwit który wpływa na cene wycieczki)


**Wymagania dla wycieczki naukowej**
 - Grant jest przyznawany dla wycieczek nie wysokiego ryzyka trwających dłużej niż 30 dni
 - Wycieczka jest wysokiego ryzyka gdy insuranceLimit jest większy niż 1 milion
 - Dodatkowo jak destynacja wycieczki to "DeepSpace" to checmy robić loga do systemu (tutaj po prostu jakiś print)

Wykorzystanie factory pozwoliłoby uwspólnić późniejszą logikę.

Tutaj wojowniku możesz wybrać dwie drogi (która chcesz):
 - **Factory method** - tworzenie wycieczki do osobnej metody, logika wspólna w jednej metodzie (będzie to raczej wymagało podzielenia ReservationPlannera na 2 klasy)
 - **Factory** - tworzenie wycieczki do osobnej klasy, w ReservationPlanerze na podstawie `SpaceTripType` wybór konkretnej factorki


 ### Zadanie 3: Strategia
 W zależności kiedy nasza wycieczka startuje licząc od dzisiaj jej koszt może się ostatecznie zmienić (dotyczy obu typów wycieczek).
 

 Reguły są następujące (w kodzie są też komentarze):
  - Jak nasza wycieczka odbywa się mniej niż 30 dni od moment rezerwacji (stworzenia jej) - cena rośnie o 70% (nie lubimy tu last minute)
  - Jak nasza wycieczka odbywa się między 30 a 90 dni od moment rezerwacji - cena zostaje taka sama
  - Jak nasza wycieczka odbywa się więcej niż 90 dni od moment rezerwacji - cena spada o 30% (lubimy planowanie z wyprzedzeniem)

Co prawda logika tego nie jest jakaś potężna - ale może się zmienić (agile i te sprawy) i jest ważna - bezpośrednio wpływa na to ile zarabiamy. Ograj to wzorcem strategia, tak aby odpowiadał za zmianę ceny. A skąd wziąć odpowiednią strategie? (aka gdzie te dni ogarnąć) - może jakiś inny wzorzec to może załatwić.

### Przydatne materiały

- [Prezentacja z zajęć](https://canva.link/9y9yn6td29da651)
- [Refactoring Guru](https://refactoring.guru/pl/design-patterns/creational-patterns)

--- moje notatki
Factory i strategia są bardzo podobne (logika vs tworzenie obiektu)