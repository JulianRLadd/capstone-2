<h1>The Problem Solving Framework : 'UPER'</h1>

- U = "Understand"
- P = "Plan"
- E = "Execute"
- R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
* Decided to go with checkers 
* Things I need to research:
    What exactly is a text based game?

    How do I implement a board using only text?

\*What classes and funtions do I need?

\*Should I make an AI?

\*Should I do a front-end or a GUI?

\*What kind of settings do I want?
Rainbow jumps for kings?
Forced jumps or no? both?
double jumps allowed?

\*How do I determine valid moves?
Maybe a mini-matrix for each piece that informs
the null, the available, and the enemy spaces?

\*How do I make a jump?
Using math, determine which spaces are available
to land on; as well as which are valid or may
have double jump opportunities

_Secret: have a double king if you perform
certain conditions; maybe move twice?
_

<h2>
    2. Planning the Solution
</h2>
*Researched text based games(Thank you for the link Amir!)
    Looked up and read about some text based adventure games,
        Now that I have an example of what I want to design I can
        make better decisions and move forward

\*Googled other checker games made in Java
Decided to make a board using a matrix (i.e. x2,y3)

\*Settled on making 3 classes so far:
GameBoard, MoveChecker, and CheckerDisc
Gameboard will be the board matrix mentioned above
MoveChecker will check the condition of the disc(whether it is a king or not)
and will provide/show/tell available moves
CheckerDisc will be the class implementing/inheriting from abstract or interface
and have the fields for a taken piece, a regular disc, or a king disc

\*Used Creately App to diagram the program layout
Followed the project requirements closely to
confirm I'm on the right path(measure twice, cut once)

\*Decided to make the AI later
For now, get it working; worry about bells and whistles later
Therefore, will go with a 2 player game, using threads to decide
whose turn it is

\*Worry about the front end later
will attempt to make my code modular so
inserting a GUI or a front end later will be easy

\*

<h2>
    3. Executing the Plan
</h2>
*Matrix came off without a hitch, used a ternary to design the checkerboard
    Had to change to format for the X-axis because the numbers wouldn't line up correctly
    Matrix updates correctly along with the checkers positions field

\*Changed plans on classes; there will still be a gameboard class(checkerBoard), but the other
classes will be Player and Checker.
Made a couple of child classes for Checker (King and Vamp)

\*Had trouble finding the correct Checker using streams and updating it.
A bit of research through the docs helped out.
.get() for Optionals and the overloaded
remove function for the ArrayList were extremely helpful.

_Restructured the executeMove function to use the kingMe() function in Checker class
_ \*

<h2>
    4. Reflection / Refactor
</h2>
*Change the app to more of a single responsibility approach
    Have the move function be apart of the player class.
        Upgrade the abstact class Owner to interact with the move function.
        
*Take a load off of checkerboard; shift the responsibility around among the classes.

\*Upgrade the turn switch boolean into a multi thread feature. (for Online play)

\*Find a better way to make sure parameters are in bound, run them through an array with a loop

\*Combine the validMove if/else statements into a more concise function that takes the objects in
question as parameters and determines what happens from there. Too much repeated code.

\*Create a function for upgrading checkers that will cut down on wet code.

\*Make the app AI capable for one player mode

\*Have an observer as a go-between for the display and the checker position fields

\*Create a singleton for checkerBoard since only one is ever necessary

\*Invent a better input method; typing those numbers is slow and tiring. Also cuts down on UX

\*A better way to determine if the game is over. The scorched earth policy isn't conducive to
success in this case

\*Make a GUI
