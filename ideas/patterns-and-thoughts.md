# Patterns and Thoughts

## Strategy Pattern
- in GAMEs we have different **STRATEGIES** to deal CARDs from a DECK
- there are different **STRATEGIES** how PACKs of CARDs are created
- there are different **STRATEGIES** how the GOAL of a GAME is achieved

## Singleton Pattern
- a specific implementation of a PACK can be a **SINGLETON** as its CARDs are copied over to a DECK inside a GAME
- SUITs and RANKs are **SINGLETON** as the are done via ENUMs
- maybe several OPERATIONs/ACTIONs and STATEs can be stored via ENUMs
- using ENUMSETs to slice specific RANKs for PACKs of CARDs
- using ENUMMAPs to add values and/or penalties to CARDs

## Builder Pattern
- maybe a PACK **BUILDER** would be an option instead of the **SINGLETONS**

## Abstraction & Interface Pattern
- use **INTERFACES** for SUITs, RANKs, and other things used by PATTERNS
- use **ABSTRACTIONS** for PERSONs, (PACKs), GAME, ...

## State Pattern
- use **STATEs** for CARD faces
- in GAMEs we have some CONTANT **STATES** like "end", "start"
- PLAYERs can have different **STATES** like "won", "lost", "hold", "locked"
- (an ACE or JOKER could use **STATES** to represent there Value) -> maybe better use **DECORATION** or **PROXY**

## Decorator Pattern
- CARD are very different and consist of varies of values.
  - **DECORATION** for the (optional) SUIT, RANK, VALUE, PENALTY, DATA (think Quartett cards where data categories are matched up)

## Command Pattern
- ACTIONs in GAMES could be implemented via **COMMANDs** and executed by CARDs, PLAYERs, DEALERs or the GAME itself
- 

## Memento Pattern
- to keep track of a GAMEs HISTORY