# day 4

Heute am 2. letzten Tag habe ich nach circa 30 Minuten das gleiche Fundament geschaffen, wie an den vorherigen Tagen.
Demnach blieben mir gute 20 Minuten um meine bisherigen Refactoring Skills anzuwenden. Ich habe somit versucht, die
Logik in der Game Klasse auszulagern und meistens in die Player Klasse zu verschieben.

Ich war mir z.B. nicht ganz sicher, ob die Berechnung für das Zurückbouncen ein Teil des Game ist, da es abhängig von
der Spielgrösse (LIMIT) ist oder doch eher Teil des Player, da der Bounce ein Verhalten der Position resp. Move ist.

Ich habe mich dann entschieden die LIMIT Variable via Param dem Player.move() mitzugeben, damit das Game dem Player
mitteilt, wieviel bewegt wird und somit ist der Bounce ein Teil der Player Logik.

Im nächsten Schritt hätte ich das Teleporting (aka Snake and Ladder) angeschaut und möglicherweise ebenfalls in die
Player Klasse gesteckt. Wobei ich auch hier (wie auch zuvor) gerne mit einem Entwickler darüber philosophiert hätte...
Pair Programming wäre sicherlich interessant gewesen um solche Fragen zu diskutieren.

Bezüglich VIM musste ich heute erneut feststellen, dass mir die Hotkeys zum Movement noch nicht ganz sitzen. Also
spezifisch die Movements über halbe oder ganze Seiten, also grosse Sprünge. Die kleinen Movements innerhalb einer Zeile
sitzen doch schon relativ gut.

Noch grosse Mühe habe ich mit dem Misch-Masch zwischen IntelliJ Refactoring/Renaming und dem IdeaVIM. Also wenn ich eine
Variable/Methode umbenenne, dann muss ich oft zuerst vom Visual in den Insert Mode wechseln, damit ich es editieren
kann. Oft passieren dann ganz lustige Dinge, die ich nocht nicht ganz verstehe. Z.B. wird der ganze Methodennamen mit
'e' überschrieben oder ich lösche 60% der Datei ausversehen.
