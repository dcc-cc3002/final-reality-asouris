# Final Reality
This is for the class CC3002. And it will be a journal about my progress with the project.

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
#### Fixing functionality from past assignments
First, any mistakes from the past assignments were corrected. And also, all the testing for every functionality already implemented was done.

The most difficult thing to fixed was the weapon equipping system. This system is not strictly necessary for this assignment, but I started it out of need, and now I need to finished it :/.
So I did some research, found out that the thing I wanted to do was double dispatch. Saw some examples online and we had a class about it. I ended up reversing my plan so the weapons where the classified items (EquippableByKnight, EquippableByNinja, etc.) and not the players, how I originally intended it. Now it works fine :)

#### Adding this assignment's tasks
In this assigment we were asked to add an attack functionality for characters to attack each other affecting their life attribute. That was implemented with no major complications by two functions: `attackCharacter()` and `receiveAttack()`. This last one was implemented to make the attacked character`s issue how it handled border cases when receiving damage.
 
We were also asked to check privacy matters with attributes, members and methods. I revised that later on and went to check on initialization of attributes when creating an object.
The task was to define a range of valid values for the attributes in constructors, then check in the constructor if the parameters were within that range.
In order to do this I did some research to find the best way to ensure that a valid value was passed. Checking with an if statement sounded a little sketchy, so I opted for using require() to check the parameters. 

Now, back on the privacy issues, the default should be to make all things private if possible to maintain control over how things are being changed. So I did that because I didn't implement it right the first time.

Then I added testing to get 90+% coverage :). And finally I added all the documentation that was missing.

## Assigment 2
The second part begins
### Assignment 2: Part 3
There was only one task on this part, and it was to implement a way for players to equip weapons respecting the restrictions of type of player.
I actually did this for the last assignment :). The only thing I fixed a little were the exceptions.

This project is licensed under the
[Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).