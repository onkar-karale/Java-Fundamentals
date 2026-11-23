package basics;

// =====================================================================
// TOPIC: JAVA STRINGS
// - A String in Java is an OBJECT (reference type), not a primitive,
//   representing a sequence of characters wrapped in double quotes ("...").
// - IMMUTABILITY (Crucial Concept):
//   - Strings in Java are immutable—once created, their characters CANNOT
//     be changed. Methods like .toUpperCase() or .replace() always return
//     a brand-new String object instead of modifying the original.
// - EQUALITY RULE:
//   - Always compare String text using .equals() or .equalsIgnoreCase().
//   - Never use '==' (it compares memory addresses, not text content).
// - CONCATENATION & NUMBERS:
//   - '+' adds two numbers, OR concatenates if either side is a String.
//   - Warning: Evaluation runs left-to-right ("10" + 20 -> "1020",
//     but 10 + 20 + "30" -> "3030").
// - SPECIAL CHARACTERS (Escape Sequences):
//   - \" (double quote), \' (single quote), \\ (backslash),
//     \n (new line), \t (tab), \r (carriage return).
// - PERFORMANCE (StringBuilder):
//   - Never concatenate strings with '+' inside a large loop (creates
//     hundreds of throwaway objects). Use StringBuilder instead.
// =====================================================================

public class Strings {
    void main() {
        // 1. CREATING STRINGS & LENGTH
        // Note: For Strings, length() is a METHOD (with parentheses),
        // unlike arrays where .length is a property without parentheses.
        String greeting = "Hello, Java!";
        IO.println("String: " + greeting);
        IO.println("Length: " + greeting.length());

        IO.println("");

        // 2. COMMON STRING METHODS (Original string stays unchanged!)
        String sample = "  Spring Boot Backend  ";
        IO.println("Original       : [" + sample + "]");
        IO.println("trim()         : [" + sample.trim() + "]");       // Removes leading/trailing spaces
        IO.println("toUpperCase()  : " + sample.trim().toUpperCase());
        IO.println("toLowerCase()  : " + sample.trim().toLowerCase());
        IO.println("charAt(0)      : " + sample.trim().charAt(0));    // 'S' (0-based index)
        IO.println("indexOf('Boot'): " + sample.trim().indexOf("Boot")); // Returns 7 (-1 if not found)
        IO.println("contains('API'): " + sample.contains("API"));     // false
        IO.println("substring(0,6) : " + sample.trim().substring(0, 6)); // "Spring" (end index exclusive)
        IO.println("replace()      : " + sample.trim().replace("Backend", "API"));
        IO.println("isBlank()      : " + "   ".isBlank());            // true (whitespace counts as blank)
        IO.println("isEmpty()      : " + "   ".isEmpty());            // false (length is 3)

        // Splitting a String into a String[] array (just like JS .split(","))
        String csvRoles = "ADMIN,USER,AUDITOR";
        String[] roles = csvRoles.split(",");
        IO.print("split(\",\"): ");
        for (String role : roles) {
            IO.print("[" + role + "] ");
        }
        IO.println("\n");

        // 3. COMPARING STRINGS (.equals vs .equalsIgnoreCase vs ==)
        String role1 = "ADMIN";
        String role2 = "admin";
        String dynamicRole = new String("ADMIN");

        IO.println("role1.equals(dynamicRole)          : " + role1.equals(dynamicRole));        // true
        IO.println("role1 == dynamicRole               : " + (role1 == dynamicRole));           // false!
        IO.println("role1.equalsIgnoreCase(role2)      : " + role1.equalsIgnoreCase(role2));    // true

        // Null-safe comparison pattern (put constant first to prevent NullPointerException)
        String nullableInput = null;
        IO.println("Null-safe check \"ADMIN\".equals(null): " + "ADMIN".equals(nullableInput)); // false (no crash!)

        IO.println("");

        // 4. CONCATENATION (+ operator & .concat())
        String firstName = "Onkar";
        String lastName = "Karale";
        IO.println("Using +        : " + firstName + " " + lastName);
        IO.println("Using concat() : " + firstName.concat(" ").concat(lastName));

        // Numbers and Strings Trap:
        int x = 10;
        int y = 20;
        String z = "30";
        IO.println("int + int          (10 + 20)        : " + (x + y));     // 30 (addition)
        IO.println("String + int       (\"30\" + 10)      : " + (z + x));     // "3010" (concatenation)
        IO.println("int + int + String (10 + 20 + \"30\"): " + (x + y + z)); // "3030" (left-to-right!)

        IO.println("");

        // 5. SPECIAL CHARACTERS (Escape Sequences)
        String quote = "Developers say \"Write Once, Run Anywhere\".";
        String apostrophe = "It\'s a strongly typed language.";
        String windowsPath = "C:\\Program Files\\Java\\jdk-27";
        String formattedLines = "Line 1\n\tIndented Line 2";

        IO.println(quote);
        IO.println(apostrophe);
        IO.println("Windows Path: " + windowsPath);
        IO.println(formattedLines);

        IO.println("");

        // 6. STRINGBUILDER (Mutable String for loops & heavy string building)
        StringBuilder logBuilder = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            logBuilder.append("Step-").append(i);
            if (i < 5) {
                logBuilder.append(" -> ");
            }
        }
        String finalLog = logBuilder.toString();
        IO.println("StringBuilder Output: " + finalLog);

        // 7. MODERN TEXT BLOCKS (Java's equivalent of JS backtick template literals)
        String json = """
                {
                    "developer": "%s",
                    "status": "%s"
                }
                """.formatted(firstName, "READY");
        IO.println(json);
    }
}

// SUMMARY:
// - Strings are immutable Objects—calling methods returns a new String.
// - Use .length() (with parentheses) to get character count.
// - Always compare Strings with .equals() or .equalsIgnoreCase(), never ==.
// - Use escape sequences (\", \\, \n, \t) for special characters inside quotes.
// - Use StringBuilder when building Strings inside loops for performance.
// - Use Text Blocks (""") with .formatted(...) for multi-line templates/JSON.
