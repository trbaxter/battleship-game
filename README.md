# Battleship - The Classic Strategy Guessing Game

### **How to play:**

The computer will prompt the player for a guess (a cell location) that will be entered into
the console.  
For example, "A3", "F2", and so forth.  
The program will check the user's guess and determine if a hit or miss occurs.  
If a ship receives three consecutive hits, it is destroyed and removed from the game.

### **Goal:**

Sink all the computer's battleships in the fewest number of guesses.  
At the end, the player receives a rating based on performance.

### **Setup:**

When the program is launched, the program randomly places three battleships on a virtual
7x7 grid.  
An example layout is shown below:

<img src="Pictures/Battleship Grid.png" alt=""/>

When the setup is complete, the game asks the player for the first guess.

<br>

## Design Diagram

```mermaid
flowchart LR


%% Start %%
    start([<center> Start]):::start
%% End %% 
    finish([<center> Finish]):::finish
%% Actions %%
    A1[<center> &nbsp Set up &nbsp\n &nbsp game &nbsp\n]:::action
    A2[<center> Remove\n cell]:::action
    A3[<center> Remove\n Battleship]:::action
%% Input %%
    I1[/<center> &nbsp User enters\nguess&nbsp/]:::input
%% Output %%
    O1[/<center> &nbsp&nbsp&nbsp Display &nbsp \n &nbsp title &nbsp/]:::output
    O2[/<center> &nbsp Game displays\n user's score &nbsp/]:::output
%% Decisions %%
    D1{<center> Hit\nor\nmiss?}:::decision
    D2{<center> Ship\nDestroyed?}:::decision
    D3{<center> Ships\nremaining?}:::decision
%% Other %%
    null[&nbsp]:::empty

%% Links %%
    start --> A1
    A1 --> O1
    O1 --> I1
    I1 --> D1
    D1 -.-> |\n\n\n&nbsp Miss! &nbsp\n\n\n|I1
    D1 ---- |&nbsp Hit! &nbsp|A2
    A2 --> D2
    D2 -.-> |&nbsp No &nbsp|I1
    D2 --> |&nbsp Yes &nbsp|A3
    D3 -.-> |&nbsp Yes &nbsp|I1
    A3 --> D3
    D3 --> |&nbsp No &nbsp|O2
    O2 --> finish

    
    
%% Class Colors %%
    classDef start stroke: #0f0, stroke-width: 2.5px;
    classDef finish stroke: #f00, stroke-width: 2.5px;
    classDef decision stroke: #cc5500, stroke-width: 2.5px;
    classDef action stroke: #196de3, stroke-width: 2.5px;
    classDef input stroke: #ca14de, stroke-width: 2.5px;
    classDef output stroke: #ede205, stroke-width: 2.5px;
    classDef empty width:0px, height:0px;
```

## Diagram Legend
```mermaid

flowchart LR
    
%% Diagram Legend Shapes %%    
        L1(["&emsp; &emsp;"]):::start
        L2["&emsp; &emsp; &nbsp "]:::action
        L3[/"&emsp; &emsp; &nbsp "/]:::output
        L4[/"&emsp; &emsp; &nbsp"/]:::input
        L5{"&nbsp"}:::decision
        L6(["&emsp; &emsp;"]):::finish
%% Null Spaces for Shape Labels %%        
        null[&nbsp]:::empty
        null2[&nbsp]:::empty
        null3[&nbsp]:::empty
        null4[&nbsp]:::empty
        null5[&nbsp]:::empty
        null6[&nbsp]:::empty
%% Links %%        
        L1 ~~~ L2 ~~~ L3 ~~~ L4 ~~~ L5 ~~~ L6
        null["App Start"] ~~~ null2["Program\nAction"] ~~~ null3["Program &emsp; \n Output &emsp;"]
        null3 ~~~ null4["User &nbsp &nbsp\n Input &nbsp &nbsp"] ~~~ null5["Decision"] ~~~ null6[App end]
%% Class Colors %%
    classDef start stroke: #0f0, stroke-width: 2.5px;
    classDef finish stroke: #f00, stroke-width: 2.5px;
    classDef decision stroke: #cc5500, stroke-width: 2.5px;
    classDef action stroke: #196de3, stroke-width: 2.5px;
    classDef input stroke: #ca14de, stroke-width: 2.5px;
    classDef output stroke: #ede205 , stroke-width: 2.5px;
    classDef empty width:0px, height:0px;
```

<br>

## Future Ideas for Improvement

### Addition of a GUI

While the game functions as expected, it can be a little difficult for a user to keep track of all their guesses.  
It would be great to include a graphic interface allowing players to pick their guessing locations and have previous
guesses tracked visually.

### Prevent repeat guesses

Currently, a player can accidentally enter the same location multiple times when guessing.  
Adding the capability to avoid counting previous guesses would improve the player experience.

### Better game function separation

There's a lot of condensed logic in the Main class and in other locations as well.  
It would be a big improvement to place some of these functions in their own classes and organize things further. 