# Implemention of the Card Game App

Main goal is to try and implement an extensible card game using **Java** and it's **Data Structure**.

## Step 1 - A most basic Implementation
The BlackJack Class holds all fields and methods
There is no **Abstraction**, no **Interfaces**.
Just the plain logic to play a game of BlackJack including some features used in Java like:
 - class
 - constructor
 - modifiers (private/public/static)
 - getters/setters
 - lambda functions
 - several types to structure data:
   - int
   - boolean
   - String
   - ArrayList
   - (nested) LinkedHashMap
   - Random
   - Scanner
   - Collections (shuffle)

### Class Diagram
![Step 1](uml-models/step1.png)


*Biggest Issue so far: implementing the game logic of BlackJack as it is a round based game, where the dealer actually is a player and plays against every other player, while players don't play against each other...*


## Step 2 - Abstract and implement Persons
Create a Person class and make Dealer and Player inherit from that.

## Step 3 - Abstract and implement Deck
Make Deck a separated class to create Cards.

# Step 4 - Abstract and implement Cards
Make Cards a Class

# Step 5 - 