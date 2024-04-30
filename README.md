# Final Reality

Final Reality is a simplified clone of the renowned game, Final Fantasy. Its main purpose is to
serve as an educational tool, teaching foundational programming concepts.

## Assignment 1
Each assignment is divided in parts so the development of the project can be accomplished in time.
### Assignment 1: Part 1
The objective on this first part is to settle the entities and necessary structures for the project. 
The characters were added, those could be playable characters or enemies. And on top of that, there are five types of playable characters: Paladin, Warrior, Ninja, Black Mage and a White Mage.
The weapons were also added, like the playable characters, there are also five types: Axe, Sword, Bow, Staff and Wand.
Finally, a party class was added with the basic functionality of adding and removing characters from it.

In this assignment it was expected to add testing of all functionalities, so there was testing for every function implemented. However, there were missing two fundamental functions for the classes: `toString()` and `equals()`.

### Assignment 1: Part 2
The objective for this part is to start the bases for the combat system. In particular, was implemented a class `TurnScheduler` which is in charge of handling the turn giving dynamic during combat. 
In this dynamic there are a handful of characters in game which could be ready to attack or not. Every character has an action bar, whose max amount is determine by the weight of the character and the weight of the weapon it is carrying. Then, every few units of time, this action bar is increase a little bit until is full. When is full, the character could be giving a turn to play.
When the characters are ready to play they wait in order in a queue for a turn to play.

Additionally, in this part it was attempted to implement a system for equipping weapons to playable characters. This is quite tricky since not all characters can yield every weapon. The attempt was not successful but progress was made. 

Lastly, there were tests added for almost all functionalities and a big percentage of documentation was also added.
### Assigment 1: Final

This project is licensed under the
[Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).