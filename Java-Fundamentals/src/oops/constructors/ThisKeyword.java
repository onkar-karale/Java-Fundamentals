package oops.constructors;

// =====================================================================
// TOPIC 6: JAVA 'this' KEYWORD
// - 'this' refers to the CURRENT object inside a method or constructor.
// - Two primary uses:
//   1. Eliminating confusion (shadowing) between class attributes and
//      parameters with the same name (this.x = x).
//   2. Calling another constructor in the same class via this(...)
//      (constructor chaining—must be the very first statement).
// =====================================================================
public class ThisKeyword {

    static class Student {
        String name;
        int age;

        // Constructor 1: Chains to Constructor 2 using this(...)
        public Student(String name) {
            this(name, 18); // Must be the first line in the constructor
        }

        // Constructor 2: Uses 'this' to distinguish instance fields from parameters
        public Student(String name, int age) {
            this.name = name; // this.name = class attribute; name = parameter
            this.age = age;
        }

        public void introduce() {
            IO.println("Hi, I am " + this.name + " and I am " + this.age + " years old.");
        }
    }

    void main() {
        Student s1 = new Student("Meera");        // Uses default age 18 via this(...)
        Student s2 = new Student("Aarav", 22);    // Sets both name and age directly

        s1.introduce();
        s2.introduce();
    }
}

// SUMMARY:
// - 'this.field' points to the current object's instance variable.
// - 'this(...)' invokes another overloaded constructor in the same class.
