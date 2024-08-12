# day 1 of week 2

Heute konnte ich mit der Game of Life Code Kata anfangen. Diese Kate haben wir möglicherweise bereits im letzten Jahr
einmal ausprobiert. Die Regeln musste ich doch nochmals durchlesen.
Wie üblich musste als erstes mal das Repo gesäubert und das Projekt neu initialisiert werden.
Mit IntelliJ offen und maven bereit. Machte ich mir einige Gedanken zum üblichen Problem bei solchen Games: wie finde
ich heraus, was Nachbar-Objekte tun oder in welchem State sie sind.
Dann dachte ich mir ich sollte einfach mal einen Shameless Green Approach machen und dann von dort aus über das saubere
Nachbar-Design nachdenken. Also habe ich fröhlich angefangen eine Zellen-Klasse zu erstellen und sie mit Verhalten zu 
füllen. Doch bald wurde mir klar, dass ich schneller beim Nachbarproblem angelagt bin als ich dachte.
Zudem fällt mir jetzt gerade, beim schreiben der Reflexion auf, dass ich nicht nur ein Nachbarproblem habe, sondern auch
ein Historienproblem. Denn eigentlich prüfen wir den State aller Zellen zum Zeitpunkt X und erst dann generieren wir
die nächste Generation mit Zeitpunkt X+1. Also können wir nicht einfach über die Liste (oder Grid) loopen und Zelle für
Zelle aktualisieren. Eine wichtige Lesson Learned für morgen :)
Der eigentliche Fokus lag aber trotz allem bei VIM und ich muss langsam feststellen, dass meine Ambitionen meinen
Fähigkeiten weit Voraus sind. Es gibt noch soviele Dinge, die ich lernen muss... hierzu eine kleine Auflistung:

- Navigation innerhalb IntelliJ z.B. failed tests, Syntax Errors
- Refactoring wie z.B. Extract Method, Rename Method/Variable zusammen mit VIM gibt ein Hotkeysalat
- Navigation in der Projektstruktur mittels VIM um neue Dateien anzulegen
- Copy Paste innerhalb VIM mit yank
- Copy Paste von aussen (z.B. Stackoverflow) nach IntelliJ (hierzu musste ich CTRL+V wieder auf IDE Standard setzen)
- Markieren, Löschen, Verschieben von grösseren Codesnipptes mittels Visual Mode
- Grössere Sprünge in der Datei ohne spammen von jjjjjj oder lllllll oder kkkkkkk
- Intuitives Gebrauchen von hjkl