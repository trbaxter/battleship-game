### Instance Variable Declarations
<br>  

`DECLARE` and instantiate the _GameHelper_ instance variable named _helper_.

`DECLARE` and instantiate an _ArrayList_ to hold the list of 3 battleships, called _battleshipList_.

`DECLARE` an _int_ variable to hold the number of user guesses, named _numOfGuesses_, and set it to zero.

---
### Method Declarations
<br>

`DECLARE` a _setUpGame()_ method to create and initialize the battleship objects with names and locations.
Also have it include a brief set of instructions to the user.

`DECLARE` a _startPlaying()_ method that asks the player for guesses and calls the _checkUserGuess()_ method until all
the battleship objects are removed from the game.

`DECLARE` a _checkUserGuess()_ method that loops through all the remaining battleship objects and calls each battleship
object's _checkYourself()_ method.

`DECLARE` a _finishGame()_ method that prints a message about the player's performance based on the number of guesses.

---
### Method Logic
<br>

**METHOD:** _void setUpGame()_  
&nbsp; &nbsp; &nbsp; &nbsp;
`CREATE` three battleship objects.  
&nbsp; &nbsp; &nbsp; &nbsp;
`SET` a name for each battleship.  
&nbsp; &nbsp; &nbsp; &nbsp;
`ADD` the battleships to the _battleshipList_ (i.e. the ArrayList).   
&nbsp; &nbsp; &nbsp; &nbsp;
`REPEAT` with each of the battleship objects in the _battleshipList_ array.  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`CALL` the _placeBattleship()_ method on the helper object to get a randomly-selected location  
&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;
for this battleship (either vertically or horizontally placed on a 7x7 grid).  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`SET` the location for each battleship based on the result of the _placeBattleship()_ call.  
&nbsp; &nbsp; &nbsp; &nbsp;
END REPEAT  
END METHOD  
<br>

**METHOD:** _void startPlaying()_  
&nbsp; &nbsp; &nbsp; &nbsp;
`REPEAT` while any battleships still exist.  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`GET` user input by calling the helper _getUserInput()_ method.  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`EVALUTE` the user's guess by the _checkUserGuess()_ method.  
&nbsp; &nbsp; &nbsp; &nbsp;
END REPEAT  
END METHOD  
<br>

**METHOD** _void checkUserGuess (String userGuess)_  
&nbsp; &nbsp; &nbsp; &nbsp;
`INCREMENT` the number of user guesses in the _numOfGuesses_ variable.  
&nbsp; &nbsp; &nbsp; &nbsp;
`SET` the local _result_ variable to "Miss!", assuming that the user's guess will miss.  
&nbsp; &nbsp; &nbsp; &nbsp;
`REPEAT` with each of the battleship objects in the _battleshipList_ array.  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`EVALUATE` the user's guess by calling the battleship object's _checkYourself()_ method.  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`SET` the result variable to "Hit!" or "Battleship destroyed!" when appropriate.

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`IF` the result is "Battleship destroyed!",  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`REMOVE` the battleship from the _battleshipList_.  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
END IF

&nbsp; &nbsp; &nbsp; &nbsp;
END REPEAT  
&nbsp; &nbsp; &nbsp; &nbsp;
`DISPLAY` the _result_ score value to the user.  
END METHOD  
<br>

**METHOD** _void finishGame()_  
&nbsp; &nbsp; &nbsp; &nbsp;
`DISPLAY` a "Game Over" message, then:

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`IF` the number of user guesses is small,  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`DISPLAY` a congratulations message.  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`ELSE`  
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
`DISPLAY` an insulting message.

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
END IF  
END METHOD