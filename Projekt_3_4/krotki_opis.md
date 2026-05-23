# Użycie wzorców projektowych:


* ```Builder``` - tworzenie różnych typów pokoju (**IRoom**) - klasa **RoomBuilder**
* ```Factory``` - dodanie logiki dla różnych pokojów w trakcie ich tworzenia - klasa **IRoomFactory**
* ```Strategia``` - tworzenie scenariuszy dla mieszkań oraz trybów termostatu. Nie można użyć w termostacie dekoratora, ponieważ tryby chcą ustawiać różne temperatury - klasy **IScenarioStrategy** oraz **IthermostatStrategy**
* ```Kompozyt``` - drzewiasta struktura domu - tworzą ją dom, piętra, pomieszczenia i urządzenia
* ```Dekorator``` - tryb audytu i spania dla urządzeń - klasy w pakiecie **device.decorator**
* ```Komenda``` - klasy **ICommand** oraz **CommandRunner**
* ```Fasada``` - klasy **ISecuritySysten** i **LegacySecureNetFacade**