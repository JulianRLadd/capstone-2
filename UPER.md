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
Decided to make a board using a matrix (i.e. q2,d3,r4)

\*Settled on making 3 classes so far:
GameBoard, MoveChecker, and CheckerDisc
Gameboard will be the board matrix mentioned above
MoveChecker will check the condition of the disc(whether it is a king or not)
and will provide/show/tell available moves
CheckerDisc will be the class implementing/inheriting from abstract or interface
and have the fields for a taken piece, a regular disc, or a king disc

\*Decided to make the AI later
For now, get it working; worry about bells and whistles later
Therefore, will go with a 2 player game, using threads to decide
whose turn it is

_Worry about the front end later
will attempt to make my code modular so
inserting a GUI or a front end later will be easy
_ \* \* \*

<h2>
    3. Executing the Plan
</h2>
*Used Creately App to diagram the program layout
    Followed the project requirements closely to 
        confirm I'm on the right path(measure twice, cut once)
*
*
*
*
*
*
*
<h2>
    4. Reflection / Refactor
</h2>
*
*
*
*
*
*
*
*
