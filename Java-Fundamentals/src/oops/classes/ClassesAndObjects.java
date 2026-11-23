package oops.classes;

// =====================================================================
// TOPIC 1: JAVA CLASSES & OBJECTS
// - Java is an object-oriented programming language.
// - Everything in Java is associated with classes and objects, along
//   with attributes (data) and methods (behavior).
// - Real-life analogy: A Car is an object. Attributes = weight, color;
//   Methods = drive(), brake().
// - A Class is a "blueprint" used to create objects.
// - An Object is an instance created from a class using the 'new' keyword.
// =====================================================================

public class ClassesAndObjects {

    // Blueprint class (representing a simple object with one attribute)
    static class Box {
        int x = 5;
    }

    void main() {
        // Creating a single object from the Box class
        Box firstObj = new Box();
        IO.println("First object x: " + firstObj.x);

        // Creating multiple independent objects from the same class
        Box secondObj = new Box();
        IO.println("Second object x: " + secondObj.x);

        // Using multiple classes: in real projects, you can also put
        // 'Box' in its own file (Box.java) in the same package and call
        // 'new Box()' from here without needing any import.
    }
}

// SUMMARY:
// - Use the 'class' keyword to define a blueprint.
// - Use 'new ClassName()' to instantiate an object.
// - Multiple objects can be created from a single class.
