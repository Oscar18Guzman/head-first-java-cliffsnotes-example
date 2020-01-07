# breaking the surface 

# table of contents
 - the way Java works 
 - Code Structure in Java
 - Anatomy of a class
 - The main() Method
 - Looping
 - Compiler vs JVM


# the way Java works 
 - The goal is to write one application and have it work on whatever device your friends have 
4 steps: 

 - Source 
   - Create a source document. Use an established protocol like ` .java `
 - Compiler 
   - Run your document through a source code compiler. It checks for errors and wont let you compile unit it knows everything will run correctly. 
 - Output (code)
   - The compiler creates new document, coded into java 'bytecode', any device capable of running Java will be able to interpret or translate this file into something it can run. Its platform-independent
- Virtual Machines 
  - Your friends don't have a pysical Java machine, but they all have virtual Java Machine running inside. It's what reads the bytecode. 


# Code Structure 

 - Put a class in a source file 
     - a source code file holds ONE class definition. The class represnts a piece of your program. Classes go with curly braces 

 - Put methods in a class
     - a class has one or more methods. Methods must be declared inside a class (within the curly braces of the class)

 - Put statements in a method 
     - Within the curly braces of a method, write your instructions for how that mehtod should be performed. You can think of it as its procedure. 

# Anatomy of a Class
``` java 
public class MyFirstApp { 
    public static void main (String[] args) {
        System.out.println("Greetings World, I come in peace")
    }
}

```

# line 38
 - public so everyone can access it,
 - add class so it knows its a class,
 - The name of the class

# line 39 

 - public again so everyone can access it
 - static for it to share the same variable or method of a given class
 - void for the return type . Void meands theres no return Value 
 - Then main as the name of the method, no matter how big the code is, theres got to be a main() method to get the ball rolling.
 - The arguments for the method must be an array of Strings, and the array will be called 'args'

# line 40
 - System.out.println is the same concept as printing, I added the println because the "ln" in it means new line  

then follow up with the closing braces 


# The main() Method

In java everything goes in a class. You'll type your source code file (with a `.java` extension). Then compile it into a new class file (with `.class` extension) So when you run your program your really running a  `class`

Running a program means telling the Java Virtual Machine (JVM) to "load the (class name), then start executing it's main()
No matter how big your program is (in other words, no matter how mnay classes your program uses), there's got to be a main() method 


# looping 

Java has 3 standard looping constructs. `while`, `do-while`, `for`.
The syntax for looping is similar to other languages. You do everytbing inside the loop block. its bounded by curly braces so whatever you want to repead needs to be inside that block
The key to a loop is conditional test. Which is an expression that results in a `Boolean` Value `true or false`
- example 
``` java 
class IfTest {
    public static void main(String[] args) {
        int x = 3;
        if (x == 3){
            System.out.println("x must be 3");
        }
        System.out.println("This runs no matter what")
    }
}
``` 

# code output 
java IfTest
x must be 3
this runs no matter what




# Compiler vs JVM whats more important?

Java Virtual Machnine 
 - Runs/ Interprets/ translates Bytecode into Native Machine Code.
 - if you really wanted to, the programmer can write the code themselves instead of using compiler help
 - Include ClassCostExceptions

Compiler 
 - only gives a file
 - Java designed to use bytecode for the Compiler 
 - If it werent a OOP and instead interpreted it would be running really slow
 - Since java is a strongly-typed language. Compiler can't allow variables to hold on data of the wrong type
 - first line of defense 
    - prevents access violations
    - prevents code trying to invoke a private method
