# Extra Strength Methods

## table of contents
- Building the sink with a dot com game
- writing prepcode (pseudocode for the game)
- test code for simple dot come
- Coding the simple dot com game 
- Final Code for simple dot com game
- Generating random numbers with Math.random()
- Ready-bake code for getting user input from the command-line
- Looping with for loops
- Casting primitives from a large size to a smaller size

### building the sink a dot com game

Goal - Sink all of the computers dot comes in the fewest number of guesses

Setup - When the program is launched, the computer places three dot coms on a virtual 7 x 7 grid
When that's complete, the game asks you for your first guess

In the simple version, the game `class` has no instance variables, and all the game code is in the main() method.

Developing a Class 
- Figure out what the class is supposed to do 
- List the instance variables and methods
- Write prepcode for the methods
- Write test code for the methods
- Implement the class
- Test the methods
- Debug and reimplement as needed

#### 3 things you'll write for a class
- Prep code
 - The form of pseudocode, to help you focus on the logics without stressing about syntax
- Test code
 - A class or methods that will test the real code and validate that it's doing the right thing
- Real code
 - The actual implementation of the class. 


### pseudocode
`Declare` an int array to hold the locations cells. Call it `locationCells`
`Declare` an int to hold the number of hits. Call it numOfHits and Set it to 0

`Declare` a checkYourself() method that takes a String for the user's guess ("1", "3", etc)
`Declare` a setLocationCells()setter method that takes an int array ( which has the 3 cell locations as ints (2, 3, 4 etc))

`Method`: String checkYourself(String userGuess)
    `GET` the user guess as a String parameter
    `Convert` the user guess to an int
    `Repeat` with each of the location cells in the int array
        `Compare` the user guess to the location cell
        `If` the user guess matches
            `Increment` the number of hits
                // Find out if it was the last location cell:
            `If` number of hits is 3, `Return` "Kill" as the result
            `Else` it was not a kill, so `Return` "hit" as the result
            End If
        `Else` the user guess did not match, so `Return` "miss"
        End if
    End repeat
End method

`Method`: void setLocationCells(int[] cellLocations)
    `GET` the cell locations as an int array parameter
    `Assign` the cell locations parameter to the cell locations instacne variable 
End Method


### test code for simple dot com
Heres what we should test:
 - Instantiate a SimpleDotCom object
 - Assign it a location (an array of 3 ints)
 - Create a String to represent a user guess
 - Invoke the checkYourself() method passing it the fake user guess
 - Print out the result to see if it's correct ("passed" or "failed")


``` java
public class SimpleDotComTestDrive {
    public static void main (String[] args) {
        SimpleDotCom dot = new SimpleDotCom(); // instantiate a SimpleDotCom object

        int[] locations = {2, 3, 4}; // make an int array for the location of the dot com (3 consecutive ints out of a possible 7)
        dot.setLocationsCells(locations); // invoke the setter method on the dot com

        String userGuess = "2"; // make a fake user guess
        String result = dot.checkYourself(userGuess); // invoke the checkYourself() method on the dot com object, and pass it the fake guess
        String testResult = "failed";
        if (result.equals("Hit")) {
            testResult = "passed"; // if the fake guess (2) gives back a "hit", it's working
        }
        System.out.println(testResult); // print out the test result (passed or fail)
    }
}
```
#### Coding the simple dot com game

``` java
public String checkYourself(String stringGuess) {
    int guess = Integer.parseInt(stringGuess); // Converts a string to int
    String result = "miss"; // makes a variable hold the result we'll return, we are gonna assume its a miss

    for (int cell : locationCells) { // repeat for every cell in the locationCell array
        if (guess == cell) {
            result = "hit"
            numOfHits++; // add 1 to whatvere's there
            break;
        }
    }
    if (numOfHits == locationCells.length) { // checks to see if we killed all cells (no cells were harmed during the making of these notes)
        result = "kill";
    }
    System.out.println(result);
    return result;
}
```


### Final code for for game

``` java
public class SimpleDotComTestDrive {
    public static void main (String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = {2,3,4};
        dot.setLocationCells(locations);
        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
    }
}

public class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;
    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        for (int cell : locationCells) {
            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length) {
            result = "kill";
        }
        System.out.println(result);
            return result;
    }
}
```

#### quick tips
- Your Java program should start with a high level design
- Typically youll write 3 things when you create a new class:
    - prepcode
    - testcode
    - real (java) code
- Prepcode should describe what to do, not how to do it. Implementation comes later
- Use the prepcode to help design the test code
- Write test code before you implement the methods 
- Choose for loops over while loops when you know how mnay times you want to repeat the loop code
- Use the pre/post increment operator to add 1 to a variable(++)
- Use Integer.parseInt() to get the int value of a String


### Make a random number
``` java 
int randomNum = (int) (Math.random() * 5)

```
(int) = This is a `cast` and it forces the thing immediateley after it to become the type of the cast. The random number would have been a double but since the cast said `int` it kept it correct


### Getting user input using the GameHelper class
``` java
String guess = helper.getUserInput("Enter a number");
```
`helper` - an instance we made earlier, of a class that we built to help with the game.
`getUserInput` - A method of the GameHelper class that asks the user for command-line input, reads it in after the user hits RETURN. and gives back the result as a string


#### one last class: GameHelper
all thats left is the helper class - the one with the getUserInput() method.


``` java
import java.io.*;
public class GameHelper {
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                new InputStreamReader(System.in)
            );
            inputLine = is.readLine();
            if (inputLine.length() == 0 ) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}
```

### the enhanced for loop

Java has a second kind of for loop called the `Enhanced for` that makes it easier to iterate over.

```java
for (String name : nameArray) { }
```
`String` - the elemtns in the array MUST be compatible with the declared type
`nameArray` - The collection of elements that you want to iterate over.
`{ }` - is the body of the loop, the code to repeat would be here


###### what it means in plain English: 
- "For each element in name Array, assign the element to the `name` variable, and run the body of the loop