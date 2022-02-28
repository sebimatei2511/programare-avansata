În temă, am implementat:
- o funcție checkNumber, care va verifica daca un input dat este de tip int.
- o funcție checkChar, care va verifica dacă un input dat este de tip string.
- o funcție addElement, care adaugă un element de tip string la un array, ambele date ca parametri.
- o funcție compareTwoStrings, care verifică dacă 2 stringuri au simboluri diferite, cu ajutorul unu hashset: în cazul în care la parcurgerea celui de al doilea string întâlnim simboluri ce au fost găsite în parcurgerea primului string, rezultatul este true.

În main, declar pentru început variabila startTime, care va reține momentul 0 la care programul începe.
Sunt verificate primele 2 valori date drept input: dacă cele 2 sunt de tip int, programul continuă, altfel se oprește.
Vom salva în n și p cele 2 valori de mai sus și vom crea un alphabet de tip string.
Parcurgem restul de valori din input și le testăm cu checkChar. Dacă testul este trecut, valorile vor fi adăugate în alphabet. Altfel, ne oprim.
Până aici, dacă vor fi afișate mesaje pozitive cu privire la validitatea inputului, putem continua și declarăm words de tip string.
Cu ajutorul a doup instrucțiuni for, creem array-ul words ce conține n elemente d elungime p, generate aleatoriu.
Words este afișat, conform cerinței.
Declarăm matricea cerută, o listă de liste, iar matricea o setăm cu valoarea false pe fiecare element.
Parcurgem matricea, iar acolo unde este cazul, schimbă valoarea în true. În același timp, creem și listele de vecini pentru fiecare cuvânt din words.
Afișăm words.
Pentru a verifica cele lucrate, afișăm și matricea ca să avem o vedere mai bună a datelor.
Este declarat endTime, cu ajutorul căruia obținem timeDifference ce va reprezenta timpul în nanosecunde în care a rulat programul.
Conform cerinței, timeDifference va fi afișat doar pentru n > 30000.

* nu am reușit să fac funcționabilă partea cu timpul pentru un n atât de mare.
* programul rulează foarte bine și din Cmd.
