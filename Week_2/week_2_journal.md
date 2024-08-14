# day 3

Heute hab ich mich gewagt den ersten Teil mal von gestern aus dem Kopf zu übernehmen. Also ein Grundgerüst ohne Tests.
Wobei ich schon nach paar wenigen Zeilen doch einen Test machen wollte um die ganze Nachbarlogik der Zellen zu prüfen.
Mit gutem Gewissen und etwas TDD hab ich das auch gemacht und war wohl zu schnell zufrieden.
Nachdem ich die Reglen implementiert habe und weitere Tests geschrieben habe, musste ich feststellen, dass meine
Nachbarlogik wieder fehlerhaft war. Weitere Tests haben das bestätigt und ich hab extrem viel Zeit mit debugging verloren.
Dann das AHA Erlebnis, meine Logik und meine Tests waren wirklich schlecht.
Ich hab die letzen 12 Minuten oder so nur damit verschwendet meine Booleans zu tweaken aber ohne Erfolg, ist wohl doch
etwas zu spät.
Dennoch habe ich heute noch zu später Stunde etwas neues gelernt: suchen und ersetzen via VIM mittels 
`:%s/suche/ersetze/g` was nach "suche" sucht und mit "ersetze" ersetzg über das ganze File dank dem /g am Ende.