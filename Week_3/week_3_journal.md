# day 5 last day of performance week

Der Fokus lag für mich heute beim Refactoring. Ich hab deshalb zuerst mal ganz grob im main.java die Klassen angelegt.
Also das beinhaltete game, player, snake, ladder, teleporter, die etc.
Dann habe ich mittels Tests der Game Klasse die Regeln implementiert.

Ein kleiner Exkurs zu Chat GPT habe ich mit folgender Frage gemacht:


> given the snake and ladder game in a coding kata. using DDD and proper object oriented programming i wonder if i 
should implement a player move and bounce back behaviour in the player class, coupling it to the game since 
the bounce is dictated by the game's last field/goal or implement in the game class how boucing works and just 
tell the player objekt where to move to

Die Antwort war etwas vage. Der Ansatz der Implementation in der Player Klasse koppelt den Player an das Game oder
umgekehrt bauen wir eine riesige Game Klasse mit sämtlicher Logik. Jedoch hat ChatGPT einen 3. Ansatz erwähnt, welchen
ich verfolgt habe:

> 3. Hybrid Approach (Best Practice) Responsibility Split:
The player is responsible for basic movement, like updating its position.
The game is responsible for validating moves, including handling special rules like bouncing back.
The game class tells the player to move, checks if the move is valid (e.g., within the bounds of the board), and applies any special rules like bouncing back.
The player only updates its position as dictated by the game.

Somit habe ich im Game dem Spieler einfach wieviel bewegt werden soll, damit das Game nacher diverse Regeln anwenden
kann. Im Fall hier zuerst den Bounce-Back und dann die Snakes and Ladders Regel (aka Teleport).

Dieser Ansatz fand ich doch bezogen auf das Problem und die Komplexität doch sehr vernünftig.

