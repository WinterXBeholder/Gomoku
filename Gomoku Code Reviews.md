
# Module 2 Code Reviews

## Process

## Requirements Checklist

* [ ] Gameplay
    * [ ] Set-up
    * [ ] Play
    * [ ] Win/Lose/Draw
    * [ ] Play Again
* [ ] Players (user can play both the HumanPlayer and RandomPlayer)
* [ ] Naming (uses consistent and meaningful names for classes, variables, and methods)
* [ ] Classes (solves the game with multiple classes)
* [ ] Methods (methods demonstrates single responsibility principle, belong in the class, and are right-sized)
* [ ] Existing classes are unmodified (`Gomoku`, `Player`, `HumanPlayer`, `RandomPlayer`, `Stone`, `Result`)
* [ ] Code Format (Java code formatting is idiomatic)
* [ ] Data Types (no unused variables, data types are sensible)
* [ ] Static vs. Instance Methods (uses instance methods except in rare circumstances)

## Test Plan

* [ ] On startup, select `HumanPlayer` for Player 1
    * [ ] Prompts for the player's name
* [ ] Select `RandomPlayer` for Player 2
    * [ ] Auto-generates the player's name (using the provided code)
* [ ] Shuffles who goes first (using the provided code)
* [ ] Displays the player's name when asking questions of the user
* [ ] When it is Player 1's turn, attempt to place a stone at row: 0 column 0
    * [ ] Stone placement fails
    * [ ] Message is displayed informing the user that the stone is off the board
    * [ ] The user is re-prompted for their stone placement
* [ ] On re-prompt, attempt to place a stone at row: 16 column 16
    * [ ] Stone placement fails
    * [ ] Message is displayed informing the user that the stone is off the board
    * [ ] The user is re-prompted for their stone placement
* [ ] On re-prompt, attempt to place a stone at row: 1 column: 1 (if that space is available)
    * [ ] Stone placement succeeds
    * [ ] The board is printed with the stone on the board
    * [ ] The stone is the correct color: `X` is black (odd moves), `O` is white (even moves)
    * [ ] Game progresses to Player 2 (`RandomPlayer`)
* [ ] On Player 1's next turn, attempt to place a stone at the same position as the last turn
    * [ ] Stone placement fails
    * [ ] Message is displayed informing the user that the move is a duplicate move
    * [ ] The user is re-prompted for their stone placement
* [ ] Play the game to get exactly 5 stones in a row
    * [ ] Player 1 is announced as the winner
    * [ ] The user is prompted to play again
* [ ] On the "Play Again" prompt, select "yes"
    * [ ] Game play starts over by prompting for Player 1 and Player 2 information
* [ ] On this play-through, have both players be `RandomPlayer`
    * [ ] Game plays through to success
    * [ ] The board is printed for each turn
    * [ ] Invalid moves are printed for the players
    * [ ] Win/Lose/Draw conditions are printed