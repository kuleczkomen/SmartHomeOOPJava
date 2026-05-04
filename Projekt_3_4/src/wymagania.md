# Należy oddac UML, krótki opis oraz kod

## Użyj wzorców:
- Factory / Factory Method
- Builder
- Strategia
- Kompozyt
- Dekorator
- Komenda
- Fasada
- (dodatkowo) wizytor


3. dodawanie nowych sprzętów (nazwa, typ urządzenia, pomieszczenie)
2. urządzenia można włączać i wyłączać
3. termostat może zmieniać temperaturę, max 1 termostat na pokój
4. głośnik ustawia poziom głośności, ale w sypialni max 30
5. dom składa się z ```parteru``` oraz ```piętra```
6. ```parter``` składa się z salonu, kuchni oraz korytarza
7. ```piętro``` składa się z sypialni oraz pokoju biurowego
8. polecenie ```wyłącz``` można wykonać z poziomu pokoju, piętra lub całego domu
9. (dla ambitnych) każde polecenie można odpalić na każdym poziomie (pokój, piętro, dom)
10. każdą operację można ``confnąć``, ale tylko ostatnią
11. ```scenariusze``` muszą zawierać nazwę oraz listę akcji do wykonania. Nullable: e-mail (sprawdź czy jest w bazie), godzina i lista dni okresowego uruchmienia
12. ```predefiniowane scenariusze```: party, audyt
13. ```termostat``` ma różne tryby działania
14. ```szczegółowy audyt``` i ```spanie```
15. integracja z systemem alarmowym: funckje uzbrój alarm i sprawdx czujnik dymmu
    (szczególy w opisie)