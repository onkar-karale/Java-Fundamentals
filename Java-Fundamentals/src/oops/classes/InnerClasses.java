package oops.classes;

// =====================================================================
// TOPIC 13: JAVA INNER CLASSES (NESTED CLASSES)
// - You can nest a class inside another class to logically group classes
//   that belong together, making code cleaner and easier to maintain.
// - Types covered:
//   1. Regular Inner Class : Requires an outer object to instantiate, and
//                            CAN directly access outer class private attributes.
//   2. Private Inner Class : Hidden from outside classes completely.
//   3. Static Inner Class  : Does NOT require an outer object to instantiate
//                            (cannot directly access non-static outer fields).
// =====================================================================

public class InnerClasses {

    static class OuterClass {
        int outerX = 10;

        // 1. Regular (non-static) inner class
        class InnerClass {
            int innerY = 5;

            // Inner classes can directly read the outer class's fields!
            public int getOuterX() {
                return outerX;
            }
        }

        // 2. Private inner class (only usable inside OuterClass)
        private class SecretInner {
            String message = "Only OuterClass can create me!";
        }

        public void useSecretInner() {
            SecretInner secret = new SecretInner();
            IO.println("Private Inner: " + secret.message);
        }

        // 3. Static inner class (independent of any OuterClass instance)
        static class StaticInnerClass {
            int staticZ = 25;
        }
    }

    void main() {
        // 1. Regular inner class requires an OuterClass instance first
        OuterClass myOuter = new OuterClass();
        OuterClass.InnerClass myInner = myOuter.new InnerClass();
        IO.println("Outer x + Inner y = " + (myOuter.outerX + myInner.innerY));
        IO.println("Inner reading Outer x directly: " + myInner.getOuterX());

        // 2. Private inner class accessed only through OuterClass's method
        myOuter.useSecretInner();

        // 3. Static inner class instantiated WITHOUT creating OuterClass
        OuterClass.StaticInnerClass myStaticInner = new OuterClass.StaticInnerClass();
        IO.println("Static Inner z: " + myStaticInner.staticZ);
    }
}

// SUMMARY:
// - Regular inner classes are tied to an outer instance and can read outer fields.
// - Private inner classes hide helper logic completely inside the outer class.
// - Static nested classes don't need an outer object (most common in real projects).
