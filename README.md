# Battleship Game

### **Goal:**
Sink all the computer's battleships in the fewest number of guesses.  
At the end, the player receives a rating based on performance.  
<br>

### **Setup:**
When the program is launched, the computer places three battleships on a virtual
7x7 grid. Each battleship takes up three cells.  
When that's complete, the game asks the player for the first guess.  
<br>

### **How to play:**
The computer will prompt the player for a guess (a cell) that will be entered into
the terminal as "A3", "A5", etc.  
In response to the guess, the player will see a result in the terminal
indicating "Hit", "Miss", or "Battleship destroyed!".

When the player destroys every battleship, the game ends by displaying the user's rating.
<br>
<br>

## Visualization

An example game would have the following layout on the virtual grid:

<img src="Pictures/Battleship Grid.png"/></img>

<br>
<br>

## Design Diagram

```mermaid



flowchart LR
    
    %% Game Start %%
    A([Start]):::start
    
    %% Game End %% 
    H([Finish]):::finish
    
    %% Game Actions %%
    B[Set up\n game]:::action
    C[Get user\n guess]:::action
    E[Remove\n cell]:::action
    F[Remove\n Battleship]:::action
    G[Display\n user score]:::action
    
    %% Game Decisions %%
    D{Check\n user\n guess}:::decision
    F1{Do any\n battleships\n remain?}:::decision
    
    %% Links %%
    A --> B  
    B --> C
    C --> D
    D -- &nbsp <b>Miss!</b> &nbsp ---> C
    D -- &nbsp <b>Hit!</b> &nbsp ---> E
    E --> C
    D -- &nbsp <b>Battleship destroyed!</b> &nbsp ---> F
    F --> F1
    F1 -- &nbsp <b>Yes</b> &nbsp --> C
    F1 -- &nbsp <b>No</b> &nbsp --> G
    G --> H

    %% Class Colors %%
    classDef start stroke:#0f0,stroke-width:2px;
    classDef finish stroke:#f00, stroke-width:2px;
    classDef decision stroke:#cc5500, stroke-width:2px;
    classDef action stroke:#33FF, stroke-width:2px;
```