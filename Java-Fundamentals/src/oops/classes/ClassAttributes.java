package oops.classes;

// =====================================================================
// TOPIC 2: JAVA CLASS ATTRIBUTES (FIELDS)
// - Variables declared directly inside a class are called attributes
//   (also known as fields).
// - Access or modify attributes using dot syntax (object.attribute).
// - Marking an attribute 'final' prevents it from being reassigned.
// - Changing an attribute on one object does NOT affect other objects
//   created from the same class.
// =====================================================================

public class ClassAttributes {

    static class Person {
        // Multiple attributes inside one class
        String firstName = "John";
        String lastName = "Doe";
        int age = 24;

        // 'final' attribute: cannot be overridden/reassigned later
        final String species = "Human";
    }

    void main() {
        Person person1 = new Person();
        Person person2 = new Person();

        // Accessing attributes using dot syntax
        IO.println("Initial Person 1: " + person1.firstName + " " + person1.lastName + ", Age: " + person1.age);

        // Modifying attributes on person1 only
        person1.firstName = "Aarav";
        person1.age = 28;
        // person1.species = "Robot"; // Compilation error: cannot assign a value to final variable

        // Proof that each object keeps its own independent copy of attributes
        IO.println("Modified Person 1: " + person1.firstName + ", Age: " + person1.age + ", Species: " + person1.species);
        IO.println("Unchanged Person 2: " + person2.firstName + ", Age: " + person2.age);
    }
}

// SUMMARY:
// - Attributes are variables belonging to a class/object.
// - Use 'object.field' to read or update non-final attributes.
// - Use 'final' when an attribute must remain constant.
// - Each object instance stores its own copy of instance attributes.
