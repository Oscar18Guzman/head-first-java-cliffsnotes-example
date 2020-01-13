# Know your Variables

# table of contents 

- Declaring a variable (Java cares about type)
- Primitive Types
- Java Keywords
- Reference variables
- Object declaration and assignment 
- Objects on the garbage-collectivle heap
- arrays (a first look)


## Declaring a variable 

Java cares about the type, It won't let you put a floating point number into an integer variable, unless you acknowledge the compiler that you know you you might lose precision (like, everything after the decimal point)

Variables come in 2 ways
 - Primitive - Hold fundamental values (simple bit patterns)
 - Objective reference - refer to objects


## primitive types

type | bit Depth | value range

### Boolean and Char
boolean| JVM-specific | True or False
char   | 16 bits      | 0 to 65535


### numeric (all are signed )

#### Integer

byte | 8 bits  | -128 to 127
short| 16 bits | -32768 to 32767
int  | 32 bits | -2147483648 to 2147483647
long | 64 bits | -huge to huge

#### floating point

float | 32 bits | varies 
double | 64 bits | varies

#### Primitive declarations with assignments
int x;
x = 234;
byte b = 89;
boolean isFun = True;
double d = 3455.98
char c = 'f'
float f = 32.5f (got to have the "F" because Java thinks anything with a floating point is a double)


### Java Keywords

For any variables you will need a name and a type for it, you can name a class, method, or variable according to the following rules (the real rules are slightly more flexible but these will keep you safe)
- It must start with a letter, underscore(_), or a dollar sign($). You cant start a name with a number. 
- After the first character, you can use numbers as well. Just don't start it with a number.
- It can be anything you like, subject to those two rules, just so long as it isn't one of Java's reserved words.

We have already seen some reserved words when we looked at writing our first main class:
- pubilc 
- static 
- void 
and the primitave types are reserved as well: 
- boolean 
- char
- byte
- short 
- int 
- long 
- float
- double

#### Reserved Table

boolean, byte, char, double, float, int, long, short, public, private, protected, abstract, final, native, static, strictfp, synchronized, transient, valatile, if, else, do, while, switch, case, default, for, break, continue, assert, class, extends, implements, import, instanceof,interface, new, package, super, this, catch, finally, try, throw, throws, return, void, const, goto, enum



### Reference variables 

You can't stuff a object into a variable. They only live in one place and one place only:
 - The garbage collectible `heap`

 although a primitive variable is full of bits representing the actual value of the variable, an object reference variable is full of bits representing a way to get to the object

You can use a dot operator (.) on a reference variable
``` java

myDog.bark()

```
means, "use the object referenced by the variable `myDog` to invoke the bark() method." when you use the dot operator on an object reference variable, of it like pressing a button on the remote control for that object.

### Object declaration and assignment

|---1---||3||---2---|
Dog myDog = new Dog();

#### 1 Declare a reference variable
Dog myDog = new Dog();

tell the JVM to allocate space for a reference variable, and names that variable `myDog`. The reference variable is, forever, of type Dog. In other words, a remote control that has buttons to control a Dog, but not a Cat or a Button or a Socket. 


#### 2 Create an object
Dog myDog = new Dog();
Tells the JVM to allocate space for a new Dog object on the heap (we'll learn a lot more about that process, especially in chapter 9.)


#### 3 Link the object and the reference
Dog myDog = new Dog();
Assigns the new Dog to the reference variable myDog. In other words, programs the remote control


### Objects on the garbage-collectivle heap

Book b = new Book();
Book c = new Book();
Declare two Book reference variables. Create two new Book objects. Assign the Book objects to the reference variables. 
the two Book objects are now living on the heap.

Book d = c;

Declare a new Book reference variable. Rather than creating a new, third Book object, assign the value of variable c to variable d. But what does this mean? It's like saying, "Take the bits in c, make a copy of them, and stick that copy into d."

Both c and d refer to the same object.
The c and d variables hold two differenct copies of the same value. Two remotes programmed to one TV.


c = b;

Assign the value of variable b to variable c. By now you know what this means. The bits inside variable b are copied,and that new copy is stuffed into variable c.
Both b and c refer to the same object. 


Book b = new Book();
Book c = new Book();

Decalare two Book reference variables. Create two new Book objects to the reference variables. 
The two book objects are now living on the heap. 

b = c;

Assign the value of variable c to variable b. The bits inside variable c are copied, and the new copy is stuffed into variable b. Both variables hold identical values.
Both b and c refer to the same object. Object 1 is abandoned and eligible for Garbage Collection (GC).


c = null;

Assign the value `null` to variable c. This makes c a null reference, meaning it dose not refer to anything. But it's still a reference variable, and another Book object can still be assigned to it. 
Object 2 still has an active reference (b), and as long as it does, the object is not eligible for GC.



### Arrays 

#### 1: 
Declare an int array variable. An array variable is a remote control to an array object.
int[] nums;

#### 2:
Create a new int array with a length of 7, and assign it to the previously declared int[] variable nums
nums = new int[7];

#### 3:
Give each element in the array an int value. Remember, elements in an int array are just int variables

7 int variables
- nums[0] = 6;
- nums[1] = 19;
- nums[2] = 44;
- nums[3] = 42;
- nums[4] = 10;
- nums[5] = 20;
- nums[6] = 1;

arrays are great when you just want quick, ordered list of things. array's give you fast random access by letting you use an index position to get to any element in the array.
They are always objects, whether they're declared to hold primitives or object references. 
in other words, The array object can have elements which are primitives, but the array itself is never a primitive.



``` java
class Dog {
    String name;

    public static void main(String[] args) {
        // Create a dog and access it
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Bart";
        // Create a dog array ([])
        Dog[] myDogs = new Dog[3];
        // and put some dogs in it
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;
        // Access the Dogs using a array dot reference (.)
        myDogs[0].name = "Fred";
        myDogs[1].name = "Marge";
        // You maybe asking where myDogs[2] name is, By over riding it I made it have the same object as dog1
        System.out.print("Last dog's name is ");
        System.out.println(myDogs[2].name);
        // now loop through the dogs, FOR EACH dog make it bark (hint: "FOR EACH")
        int x = 0;
        while (x < myDogs.length) {
            // using the dot operator, .length will give you the number of elements in that array
            myDogs[x].bark();
            x = x + 1;
        }

    }

    public void bark() {
        System.out.println(name + " Says Ruff!");
    }
}


```

### Summary 
- variables come in two different ways: primitive and reference variables
- Variables must always be declared with a name and a type
- A primitive variable value is the bits representing the value(5, 'a', true, 3.146, etc)
- A reference variable value is the bits representing a way to get to an object on the heap
- A reference variable is like a remote control. Using the dot operator (.) on a reference variable is like pressing a button on the remote control to access a method or instance variable.
- A reference variable has a value of null when it is not referencing any object.
- An array is always an object, even if the array is declared to hold primitives. There is no such thing as a primitive array, only an array that holds primitives.
