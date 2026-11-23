package basics;

// =====================================================================
// TOPIC 9: JAVA PACKAGES & API
// - A package groups related classes (like folders on your hard drive)
//   to avoid name conflicts and keep code maintainable.
// - Two categories of packages:
//   1. Built-in Packages (Java API): Prewritten classes included in the JDK
//      (e.g., java.util, java.time, java.io).
//   2. User-defined Packages: Folders you create (like 'package day02_oop;').
// - Importing syntax:
//   - Import a single class  : import java.util.Arrays;   (Recommended!)
//   - Import a whole package : import java.util.*;        (Wildcard import)
// =====================================================================

import java.util.Scanner;   // Scanner class, which is used to get user input.
import java.time.LocalDate; // Single-class import from built-in Java API
import java.util.Arrays;    // Another built-in utility class

public class PackagesAndApi {
    void main() {
        // Using built-in Java API classes imported above
        LocalDate today = LocalDate.now();
        int[] scores = {90, 45, 78, 100};
        Arrays.sort(scores);

        Scanner myObj = new Scanner(System.in);
        IO.println("Enter username");

        String userName = myObj.nextLine();
        IO.println("Username is: " + userName);

        IO.println("Current Package: " + PackagesAndApi.class.getPackageName());
        IO.println("Built-in java.time.LocalDate: " + today);
        IO.println("Built-in java.util.Arrays sorted: " + Arrays.toString(scores));
    }
}

// SUMMARY:
// - 'package' must be line 1 and mirror your folder path.
// - Use 'import package.name.ClassName;' to pull in built-in or custom classes.
// - Classes inside the exact same package do not need to import each other.
