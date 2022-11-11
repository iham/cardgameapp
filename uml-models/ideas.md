# Thoughts and Hopes

## a cards game consists of
- a set of rules
- n moves
- n rounds
- a direction (cw or ccw)
- a goal (is goal reached? -> end game)
- a stack of cards
- 1-n player(s)
- (a history of moves)
- (a dealer - optionally)

## a card game can
- add 1-n player(s)
- (make a player or optionally add a dealer -> TypeCasting from player to dealer)
- begin and end the game
- determine if goal is reached (-> player n won)

## a card game has actors
- 1-n player(s)
- (optionally 1 dealer)

## a dealer can
- mix a stack of cards
- give cards from stack to (next) player
- be a player of the game too (ATTENTION: schizophrena alert ;) )
- 
  
## a player can
- pick 1-n card(s) from the stack
- do tricks
- play a card
- win/loose a game

## a stack of cards consists of
- 1-n decks of a specific cards

## a stack of cards can
- be shuffled
- allow to pick a card

## a deck of cards consits of
- a list of cards
- depending on the deck or type of card, those cards need to be unique

## a card consists of
- a name
- a color
- a symbol
- (optionally an image for UI)
- a "strenght" value (for tricks)
- a penalty value (eg: if still in hand at end of game)














## OPTIONAL STUFF
## a game tray consists of
- cards players throw away

## a game tray can
- can add cards players played
- be emptied after each round

## a gamer tray consits of
- cards a 