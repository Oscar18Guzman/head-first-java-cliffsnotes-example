# Better living in objectville

### Table of contents
- Understanding inheritance
- Avoiding duplicate code
- overriding methods
- what do you inherit from your superclass?
- Polymorphism
- Rules for overriding
- method overloading


### Understanding Inheritance
when one class inherits from another, the `subclass` inherits from the `superclass`

Instance variables are not overridden because they don't need to be. They don't define any special behavior, so a subclass can give an inherited instance variable any value it chooses.
``` java
public class Doctor {
    boolean worksAtHospital;

    void treatPatient() {
        // perform checkup
    }
}

public class FamilyDoctor extends Doctor {
    boolean makesHOuseCalls;
    void giveAdvice() {
        //give homespun advice
    }
}

public class Surgeon extends Doctor{
    void treatPatient() {
        // perform surgery
    }
    void makeIncision() {
        // poke
    }
}
```
### using IS-A and HAS-A

One class inherits from another, we say that the subclass extends the superclass, if you want to know if one thing should extend another, apply the Is-a test

- Triangle IS-A shape
- Cat IS-A feline

To know if you've designed your types correctly, ask youself "Does it make sense to say type X is-a type Y" if it doesn't you know there's something wrong with the design
- Tub IS-A bathroom is false 

Tub and bathroom are related but not through `inheritance`. Tub and bathroom are joined by a HAS-A relationship. "Bathroom has a tub" that means bathroom has a `Instance variable` called tub 

### inherit from your superclass

the Do's and Don't 
### DO 
use inheritance when one class is a more specific type of a superclass.
- willow is a more specific type of Tree, so Willow extends Tree makes sense
      
consider inheritance when you have behavior (implemented code) that should be shared among multiple classes of the same general type. 
- Square, Circle, and Triangle all need to rotate ad play sound, so putting that functionality in a superclass Shape might make sense, and makes for easier maintenance and extensiblity. 


### DON'T
use inheritance just so that you can reuse code from another class, if the relationship between the superclass and the subclass violate either of the above two rules. For example
- imagine you wrote special printing code in the Alarm class and now you need printing code in the piano class, so you have piano extend Alarm so that piano inherits the printing code. A piano is not a more specific type of Alarm.
- the printing code should be in a Printer class, that all printable objects can take advantage of via a HAS-A relationship 

If they dont pass the IS-A test Don't inherit. 


Inheritance lets you gurantee that all classes grouped under a certain supertype have all the same method that the supertype has
*You define a common protocol for a set of classes related through the inheritance*

When you define a supertype for a group of classes, any sublclass fo that supertype can be substituted where teh supertype is expected

#### why would you care
- you get to take advantage of polymorphism

#### which matters because?
- because you get to refer to a subclass object using a reference declared as the supertype

#### and that means to you?
You get to write flexible code. much easier to develop and much easier to extend.

### Polymorphism 

the reference type can be a superclass of the actual object type
- when you declare a reference variable, any object that passes that IS-A test for the declared type of the reference variable can be assigned to that reference
*Anything that extends the declared reference variable type can be assigned to the reference variable. this lets you do things like make polymorphic arrays*
ex:

``` java 
Animal[] animals = new Animal[5];// declare an array that will hold objects of the type Animal

animals [0] = new Dog();// you can put any subclass of Animal in the Animal array
animals [1] = new Cat();
animals [2] = new Wolf();
animals [3] = new Hippo();
animals [4] = new Lion();

for (int i = 0; i < animals.length; i++ ) { // you can loop through the array and call one of the Animal-class methods, and every object does the right thing.
    animals[i].eat();

    animals[i].roam();

}
```

#### you can have polymorphic arguments and return types
If you can declare a reference variable of a supertype, say, Animal, and assign a subclass object to it, say, Dog, think of how that might work when the reference is an arguement to the method

``` java 
class Vet {
    public void giveShot (Animals a) {
        // do unspokeable thigns to the Animal at
        // the other end of the 'a' parameter 
        a.makeNoise();
    }
}

class PetOwner {
    public void start(){
        Vet v = new Vet();
        Dog d = new Dog();// the Vet's giveShot() method can take any Animal you give it. As long as the object
        Hippo h = new Hippo();// you pass in as the argument is a subclass of Animal, it will work. 
        v.giveShot(d);
        v.giveShot(h);
    }
}
```

### rules for overriding 

1 - Arguments must be the same, and return types must be compatible.

- the contract of superclass defines how other code can use a method. Whatever the superclass takes as an argument, the subclass overriding the method must use that same argument. And whatever the superclass declares as a return type, the overriding method must declare either the same type, or a sublclass type.


2 - The method can't be less accessbile 
- That menas the access level must be the same, or friendlier. That means you can't, for example, override public method and make it private. 


### Overloading a method

- Method overloading is nothing more than having two methods with the same name but different argument lists. no polymorphism involved with overloading methods.

It lets you make multiple versions of a method, with different argument lists, for convenience to the callers.

1 - The return types can be different
- you're free to change the return types in overloaded methods, as long as the argument lists are different.

2 - You can't change ONLY the return type
- if only the return type is different, it's not a valid overload - the compiler will assume you're trying to override a method. 

3 - You can vary the access levels in any direction
- You're free to overload a method with a method that's more restrictive. It doesn't matter, since the new method isn't method isn't obligated to fulfill the contract of the overloaded method


Examples of method overloading

``` java
public class Overloads { 
    String uniqueID;

    public int addNums (int a, int b) {
        return a + b;
    }

    public double addNums (double a, double b){
        return a + b;
    }

    public void setUniqueID(String theID) {
        // lots of validation
        uniqueID = theID;
    }

    public void setUniqueID(int ssNumber) {
        String numString = "" + ssNumber;
        setUniqueID(numString);
    }
}
```
