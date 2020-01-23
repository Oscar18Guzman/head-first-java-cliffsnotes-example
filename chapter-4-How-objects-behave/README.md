# How Objects Behave

state affects behavior -> behavior affects state;


we know that objects have state and behavior, represented by instance variables and methods. Now we'll look at how state and behavior are related. 

## Table of contents 
- Methods use object state (bark different)
- Method arguments and return types
- Pass-by-value (the variable is always copied)
- Getters and Setters
- Encapsulation (do it or risk humilation)
- Using references in an array

### Methods use object state 
class - blueprint for an object
when you write a class, you're describing how the JVM should make an object of that type. You already know that every object of that type can have different `instance variables` values.

You can pass values into your methods. For example, want to tell a Dog object how many times to bark by calling :
d.bark(3);

arguments/parameters - The values passed into a method

#### a method uses parameters. A caller passes arguments.
arguments are the things you pass into the methods. An argument (a value like 2, 'Foo') lands in a parameter. 
they're no more than local variables.
If a method takes a parameter, you must pass it something

``` java 
void bark(int numOfBarks) {
    while (numOfBarks > 0) {
        System.out.println("Ruff");
        numOfBarks = numOfBarks - 1;
    }
}

Dog d = new Dog();
d.bark(3)
```
1 - call the bark method on the Dog reference, and pass in the value 3 (as the argument to the method).
2 - The bits representing the int value 3 are delivered into the bark method.
3 - the bits land in the numOfBarks parameter (an int-sized variable).
4 - Use the NumOfBarks parameter as a variable in the method code.

### Methods arguments and return types

Methods can return values. Every method is declared with a return type, but we have only used `void` return type. Which means they don't give anything back
``` java 
void go() {

}
```
But we can declare a method to a specific type of value back to the caller

``` java
 int giveSecret() {
     return 42;
 }
```

Methods have have multiple parameters. They are seperated with a commas when you declare them. If a method has parameters, you must pass arguments of the right type and order

Calling a 2 parameter method, and sending it two arguments

``` java
void go() {
    TestStuff t = new TestStuff();
    t.takeTwo(12, 34); // The arguments you pass land in the same order you passed them. 12 goes for x, 34 goes for y
}
void takeTwo(int x, int y) {
    int z = x + y;
    System.out.println("Total is " + z);
}
```

### Pass-by-value

``` java
int x = 7; // Declare an int variable and assign it the value 7

void go(int z) { } // Decalare a method with an int parameter named z

foo.go(x)
void go(int z) { } // Call the go() method, passing the variable x as the argument. The bits in x are copied, and the copy lands in z. 
```

### Getters and Setters

they are formally known as Accessors and Mutators 
They let you "get and set things"

- A getter's sole purpose in life is to send back, as a return value, the value of whatever it is that particular Getter is supposed to be Getting.
- A Setter lives and breathes for the chance to take an argument value and use it to set the value of an instance variable. 

``` java
class ElectricGuitar {
    String brand;
    int numOfPickups;
    boolean rockStarUsesIt;
    String getBrand() {
        return brand;
    }
    void setBrand(String aBrand) {
        brand = aBrand;
    }
    int getNumOfPickups() {
        return numOfPickups;
    }
    void setNumOfPickups(int num) {
        numOfPickups = num;
    }
    boolean getRockStarUsesIt(boolean yesOrNo) {
        rockStarUsesIt = yesOrNo;
    }

}
```

### Encapsulation

We've been exposing our data though, reachable with the dot operator as in:
``` java
theCat.height = 27;
```

A way to fix this is to build setter methods for all the instance variables, and find a way to force other code to call the setters rather than access the data directly.

```java
// By forcing everybody to call a setter method, we can protect the cat from unacceptable size changes.
public void setHeight(int ht) {
    if (ht > 9) { // we put in checks to guarantee a minimum cat height
        height = ht;
    }
}
```
You would use public and private access modifiers to hide data. you're familiar with `public` we use it with every main method. 
Encapsulation starter rule:
- Mark instance variables `private`
- Mark getters and setters `public`

``` java
class GoodDog {
    private int size; // make the instance variable private
    public int getSize() { // make the getter method public
        return size;
    }
    public void setSize(int s) { //  make the setter methods public
        size = s;
    }
    void bark() {
        if (size > 60) {
            System.out.println("Woof!");
        } else if (size > 14) {
            System.out.println("Ruff Ruff");
        } else {
            System.out.println("Yip")
        }
    }
}

class GoodDogTestDrive {
    public static void main (String[] args) {
        GoodDog one = new GoodDog();
        one.setSize(70);
        GoodDog two = new GoodDog();
        two.setSize(8);
        System.out.println("Dog one: " + one.getSize());
        System.out.println("Dog two:" + two.getSize());
        one.bark();
        two.bark();

    }
}

```
### Using references in arrays

just like any other object. The only difference is how you get to them.

Calling a method on Dog objects in an array
step 1 : Declare and create a Dog array, to hold 7 Dog references.
``` java 
Dog[] pets;
pets = new Dog[7];
```
step 2 : Create two newDog objects, and assign them to the first two array elements.
``` java 
pets[0] = new Dog();
pets[1] = new Dog();
```
step 3 : Call methods on the two Dog objects
``` java 
pets[0].setSize(30);
int x = pets[0].getSize();
pets[1].setSize(8);
```
#### declaring and initializing instance variables

 a variable declaration needs a name and type: 
 ``` java
int size;
String name;
 ```

 and you know that you can initizalize (assign a value) to the variable at the same time:
 ``` java
int size = 420;
String name = "Donny";
 ```

 But when you don't initialize an instance variable and try to call a getter method
 it returns:
 - 0 for ints
 - Null for strings

 #### the difference between instacne and local variables

 step: 1 `Instance` variables are declared inside a class but not within a method.
 ``` java 
class Horse {
    private double hieght = 15.2;
    private String breed;
    // more code
}
 ```
Step 2: `Local` variables a declared within a method
``` java
class Addthing {
    int a;
    int b = 12;
    public int add() {
        int total = a + b;
        return total;
    }
}
```

Step 3: `Local` variables must be initalized before use!
``` java
class Foo {
    public void go() {
        int x;
        int z = x + 3; // WONT COMPILE, variable x isn't initialized
    }
}
```