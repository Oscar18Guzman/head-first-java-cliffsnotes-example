# A trip to objectville 


# In Chapter 1, We put all of our code in the main() method. That's not exaclty object oriented so now e've got to leave that procedural world behind and start making some objects of our own. We'll look at what makes object-oriented (OO) development in Java so much fun. We'll look at the difference between a class and an object. We'll look at how objects can improve your life. 

# Table of contents 
 - Inheritance 
 - Overriding methods (an introduction)
 - What's in a class?(methods, instance variables)
 - Making your first object 
 - using main()


 # Inheritance 
                    SHAPE
                    - Rotate()
                    - Sound()
                       |
          |--------------|----------------|
          |              |                |
          |              |                |
          |              |                |
    Triangle          Square            Circle

The `SHAPE` class is called the `SuperClass`, of the 3 `SubClasses` they all inherit the methods of the super class ( Rotate(), Sound() ). 
If the shape class has the functionality then the sub classes get the same one

# overriding a method

you would just add the methods you wish, to the sub classes and they run those instead.
                    SHAPE
                    - Rotate()
                    - Sound()
                       |
          |--------------|----------------|
          |              |                |
          |              |                |
          |              |                |
    Triangle          Square            Circle
    - Resize()
    - Color()

# What's in a class

When designing a class; look at it as a checklist and see what you need.
When you design a class, think about the `objects` that will be created from that class type
    - Things the object knows
    - Things the object does

Things an object knows about itself
- Instance Variables (They represent an object's state (The data) and have unique values for each object of that type)
Things an object can do? 
- Methods

# What's the difference between a Class and an Object?

A class is not an object
- It can be used to construct them

a class is a blueprint for an object. It tells the Virtual Java Machine (JVM) how to make an object of that particular type. Each object made from that class can have its own values for the instance variables 

# Making your first object 

You'll need 2 classes
- one for the type of objects you want to use (Dog, AlarmClock, DecadesOld)
- and another class to test your new class. The `Tester` class is where your put the main method, and in that you create and access objects

# Step1 write your class

``` java 
class Dog {
    int size;
    String breed; // Instance Variable
    String name;
    void bark() { // Method
        System.out.println("My name is snowball, like the reference of the dog from Rick and Morty")
    }
}
```

# Step2 write a tester (TestDrive) class

``` java 
class DogTestDrive {
    public static void main(String[] args) { // just a main method next step will have code in it
        // dog test code goes here
    }
}

```

# Step3 In your Tester, make an object and access the object's variables and methods
``` java 
class DogTestDrive {
    public static void main(String[] args) {
        Dog d = new Dog(); // make a dog object
        d.size = 40; // use the dot operator to set the size of the dog
        d.bark() // and to call its bark() method
    }
}
```

# Using Main()

The 2 uses of Main 
- test your real class
- Launch/Start your Java application

A real java application is nothing but objects talking to other objects. In this case, talking means objects calling methods on one another.
Talking shop you could say 

# Who am I?

[Class, Method, Object, Instance Variable]

I am compiled from a .java file                                                 `Class`          
My instance variable values can be different from my buddys values              `Object`
I behave like a template                                                        `Class`    
I like to do stuff                                                              `Object, Method`
I can have many methods                                                         `Class, Object`
I represent `state`                                                             `Instance Variable`
I have behaviors                                                                `Object, Class`
I am lovated in objects                                                         `Method, Instance Variable`
I live on the Heap                                                              `Object`
I am used to create object instances                                            `Class`
My state can change                                                             `Object, Instance Variable`
I declare methods                                                               `Class`
I can change at runtime                                                         `Object, Instance Variable`


