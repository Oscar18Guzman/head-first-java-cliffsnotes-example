# Using the Java library 

## table of contents 
- Analyzing the bug in the simple dot com game
- ArrayList (taking advantage of the Java API)
- Fixing the DotCom class code
- Building the real game (sink a dot com)
- prepcode for the real game
- code for the real game
- boolean expressions
- Using the library (Java API)


### Anaylzing the bug 

``` java 
if (guess == cell) {
    result = "hit";
    numOfHits++;
}
```
Here's where it goes wrong. we counted a hit every time the user guessed a cell location. Even if that location already been hit!

#### how to fix it

we delete each cell location as it gets hit, and then modify the array to be smaller. Except arrays can't change their size, so we have to make a new array and copy the remaining cells from the old array into the new smaller one.

New Prepcode: 

Repeat with each of the remaining location cells
    // compare teh user guess to the location cell
If the user guess matches
    remove this cell from the array 
    // find out if it was the last location fo teh cell
    If the array is now empty. return "kill"
    Else it was not a kill, so return "hit"
    End if
Else user guess did not match , so return "miss"
End Repeat

 


### ArrayList

The Java standard edition ships with hundreds of pre-built classes. Just like our Ready-Bake code
except that these built-in classes are already compiled

which means no typing
``` java
add(Object elem)
// adds the object parameter to the list
remove(int index)
// removes the object at the index parameter
remove(Object elem)
// Removes this objet (if its in the arraylist)
contains(Object elem)
//returns 'true' if there's a match for the object parameter
isEmpty()
// returns 'true' if the list has no elements
indexOf(Object elem)
// returns either the index of the Object parameter, or -1
size()
// returns the number of elements currently in the list
get(int index)
// returns the object currently at the index parameter
``` 

Some things you can do with an ArrayList
1: make one
- ArrayList<Egg> myList = new ArrayList<Egg>();
Don't worry about this new <Egg> angle-bracket syntax right now; it just means make this  a list of Egg objects

2: put something in it
- Egg s = new Egg();
- Mylist.add(s)

3: Put another thing in it
- Egg b = new Egg();
- myList.add(b);

4: Find out how many things are in it
- int the Size = myList.size();

5: Find out if it contains something
- boolean isIn = myList.contains(s);

6: Find out where something is (i.e. its index)
- int idx = myList.indexOf(b)

7: Find out if it's empty
- boolean empty = myList.isEmpty();

8: Remove something from it
- myList.remove(s);

#### ArrayList and Regular arrays

ArrayList<String> myList = new
ArrayList<String>();

(regular)

String[] myList = new String[2];

(ArrayList)

String a = new String("Woohoo");

(regular)

String a = new String("Woohoo");

### fixing the DotCom code

#### before 
``` java
public class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;
    
    public void setLocationCells(int[] locs)
    {
        locationCells = locs;
    }
    
    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        for (int cell: locationCells)
        {
            if (guess == cell) { /// Where it all went wrong. We counted each guess as a hit without checking whether that cell ahd already been hit 
                result = "hit";
                numOfHits++;
                break; 
            }
        }
        if (numOfHits == locationCells.length)
        {
            result = "kill";
        }
        System.out.println(result);
        return result;
    }
}
```


#### after

``` java
import java.util.ArrayList;
public class DotCom {
    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> loc) { // change the strinng array to an ArrayList that holds Strings
        locationCells = loc;
    }
    public String checkYourself(String userInput) { // new and improved argument name
        String result = "miss";

        int index = locationCells.indexOf(userInput); // Find out if the user guess is in the ArrayList, by asking for its index. If it's not in the list, then indexOf() returns a -1


        if (index >= 0) { // if index is greater than or equal to zero, the user guess is definitely in the list, so remove it
            locationCells.remove(index);

            if (locationCells.isEmpty()) { // if the list is empty, this was the final hit... critical 
                result = "kill";
            } else {
                result = "hit";
            }
        }
        return result;    
    } 
}
```

### Building the REAL game: "Sink a Dot Com"

Goal: sink all of the computer's Dot Coms in the fewest number of guesses. You're given a rating level based on how well you perform

Setup: When the game program is launched, the computer places three dot coms, randomly on the virtual 7 x 7 grid. when that's complete, the game asks for your first guess. 

How you play: We haven't learned how to build th GUI yet, so this version works at the command-line. The computer will prompt you to enter a guess (a cell), which you'll type at the command-line(as 'A3', 'c5')
In response to your guess, you'll see a result at the command-line, either "hit", "miss" or "you sunk"


#### what needs to change?

A: DotCom class
- add a name variable to hold the name of the DotCom so each DotCom can print its name when it's killed 

B: DotComBust class (the game)
- Create 3 DotComs instead of one and give each of the 3 one the name
- Put all DotComs on a grid rather than justa single row,
- Check each user guess with all three DotComs, instead of just one and keep playing the game unitl there are no more live DotComs
- Get out of main. We kept the simple on the main just to keep it simple. But that's not what we want for the real game


#### 3 class:

DotComBust 
The game class
makes dotCOms, gets user input, plays until all DotComs are dead

DotCom
The actual DotCom objects
DotComs know their name, location and how to check if a user guess for a match

GameHelper
The helper class
It knows how to accept user command-line input, and make DotCom locations.



#### 5 objects:

- 1 DotComBust
- 3 DotCom
- 1 GameHelper



### prepcode for the real game


#### Variable Declarations

Declare and instantiate the `GameHelper` instance variable, named helper.
Declare and instantiate an `ArrayList` to hold the list of DotComs (initially three), call it dotComList
Decalre an int variabel to hold the number of guesses (so that we can give the user a score at the end). Name it numOfGuesses and set it to 0


#### Method Declarations


Declare a setUpGame() method to create and initialize the DotCom objects with names and locations. Display brief instructions to the user.
Declare a startPlaying() method that asks the player for guesses and calls the checkUserGuess() method until all the DotCom objects are removed from play
Declare a checkUserGuess() method that loops through all remaining DotCom objects and calls each DotCom objects checkYourself() method
Declare a finishGame() method that prints a message about the user's performance, based on how many guesses it took to sink all the DotCom objects


#### Method Implementations

Method: void setUpGame()
    Create three DotCom objects
    Set a name for each DotCom
    Add the DotComs to the dotComsLIst (the array list)
    Repeat with each of the DotCom objects in the dotComsList array 
        Call the placeDotCom() method location, to get a randomly selected location for this DotCom (3 cells, vertically or horizontally aligned on a 7 x 7 grid)
        Set the location for each DotCom based on the result of the placeDotCom() call.
    end repeat
end method

Method: void startPlayIng()
    repeat while any DotComs exist
        Get user input by calling the helper getUserInput() method
        Evaluate the user's guess by checkUserGuess() method
    end repeat
end method

Method: void checkUserGuess(String userGuess)

    increment the number of user guesses in the numOfGuesses variable
    Set the local result variable (a string) to 'miss', assuming that the user's guess will be a miss
    Repeat with each of the DotObjects in the dotComsList array
        Evaluate ther user's guess by calling the DotCom object's checkYourself() method
        Set the result variable to 'hit' or 'kill' if appropriate
        If the result is 'kill', Remove the DotCom from teh dotComsList
    end repeat
    Display the result value to the user
end method

Method: void finishGame()
    Display a generic 'game over' message, then:
        if number of user guesses is small,
            Display a congratulations message
        else
            Display an insulting one
        End if
End method


### code for the real game

``` java
import java.util.*;
public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        // first make some dot coms and give them locations
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (DotCom dotComToSet : dotComsList) { // Its getting each single object from dotComsList, setting it as dotComToSet and it needs a type so the DotCom is the type. 

        
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        } // close for loop
    } // close setUpGame method

private void startplaying() {
    while (!dotComsList.isEmpty()) {
        String userguess = helper.getUserInput("Enter a Guess");
        checkUserGuess(userGuess);
    }// close while loop
    finishGame();
} // close startPlaying method

private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = 'miss';

    for (DotCom dotComToTest : dotComsList) {
        result = dotComToTest.checkYourself(userGuess);
        if (result.equals("hit")) {
            break;
        }
        if (result.equals("kill")) {
            dotComsList.remove(dotComToTest);
            break;
        }
    } // close for
    System.out.println(result);
} // close method

private void finishGame() {
    System.out.println("All Dot Coms are Dead! Your stock is now worthless.");
    if (numOfGuesses <= 18) {
        System.out.println("It only took you" + numOfGuesses + "guesses.");
        System.out.println("You got out before your options sank");
    } else {
        System.out.println("Took you long enough. " + numOfGuesses + "guesses");
        System.out.println("Fish are dancing with your options");
    }
} // close method

public static void main(String[] args) {
    DotComBust game = new DotComBust();
    game.setUpGame();
    game.startPlaying();
} // close method

```

#### Final version of the DotCom class

``` java
import java.util.*;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = 'miss';
        int index = locationCells.indexOf(userInput)
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = 'kill';
                System.out.println("ouch! You sunk " + name + " : (")
            } else {}
        }
    }
}

```

### Short Circuit Operators 

( &&, ||)

*If the price range is between $300 and $400 then choose x*

```java

if (price >= 300 && price < 400) {
    camera = 'x';
}
```

``` java
if (brand.equals("A") || brand.equals("B") ) {
    // do stuff for only brand a or brand b
}
```


### Using the library (the java API)

in the Java API, classes are grouped into packages

To use a class in the API, you have to know which package the class is in 

Every class in the Java library belongs to a package. The package has a name, like javax.swing (a package that holds some of the Swing GUI classes) ArrayList is in the package called java.util. which holds the utility classes


- java.util.ArrayList
ArrayList is not the full name.
'java.util' - package name
'ArrayList' - class name

You hvae to tell Java which ArrayList you want to use.

#### import
put an import statement at the top of your source code file:
``` java
import java.util.ArrayLIst;
public class myClass {...}
```
Or

#### Type
type the full name everywhere in your code. Each time you use it. Anywhere you use it. 

Declare/ Instantiate
'java.util.ArrayList<Dog> list = new java.util.ArrayList<Dog>();'

Argument Type
'public void go(java.util.ArrayList<Dog> list) {...}'

Return Type
'public java.util.ArrayList<Dog> foo() {...}'