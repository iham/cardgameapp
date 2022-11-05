![Logo](logo.jpg)

# Exercise project "CardGameApp"
Playing Cards is FUN!

## Targets
- Create a small project in Java using OOP concepts
  - OOP
    - Encapsulation
    - Inheritance
    - Abstraction
    - Interfaces
  - Types
    - Primitive Types
    - Complex Types
  - Classes
    - Constructors
    - Setters & Getters
    - Modifiers
      - public
      - private 
      - protected
      - abstract
      - final
    - Return value Type
  - Exceptions
    - TooManyPlayers
    - NotEnoughPlayers
    - PlayerNotOldEnough
    - NoMoreCardsOnStack
    - 
- Logging via Framework "???"
- Testing via Framework "???"
- Write a project documentation in MarkDown
- Write a code documentation with javadoc

## NOT targets
- Developing a (G)UI
- Developing a Gaming AI to play against
- Develop a production ready application


## CardGameApp
Base idea of this project is to create an extensible Base of (abstract) Types, to create and play several different Card Games.
Each Game implements it's own set of rules how

Possible Games are:
[List of Card Games by Amount of Cards](https://de.wikipedia.org/wiki/Liste_von_Kartenspielen_nach_Kartenanzahl_geordnet)
- BlackJack (17+4)
- Schnapsen (Cards could be "Französich" or "DoppelDeutsch")
  - Schnapsen
  - BauernSchnapsen
  - TalonSchnapsen
- Uno
- Rommé
- etc


### Diagram
<!-- insert image here -->
![Diagram](model.png)

### Card
Is an abstract class to represent a gaming card in a Deck of Cards.

### Deck
### Player
### Game
### Exceptions