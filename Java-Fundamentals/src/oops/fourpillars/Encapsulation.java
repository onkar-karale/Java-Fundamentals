package oops.fourpillars;

// =====================================================================
// TOPIC 8: JAVA ENCAPSULATION
// - Meaning: Make sure "sensitive" data is hidden from outside users.
// - How to achieve it:
//   1. Declare class attributes as 'private'.
//   2. Provide 'public' get (getter) and set (setter) methods to read
//      and update the value with validation.
// - Why use Encapsulation?
//   - Better control of attributes and methods (add validation in setters).
//   - Make fields read-only (provide only getter) or write-only (only setter).
//   - Flexible: change internal implementation without breaking callers.
//   - Increased security of data.
// =====================================================================
public class Encapsulation {

    static class Account {
        private String ownerName; // Hidden from direct external access
        private double balance;

        // Getter (read access)
        public String getOwnerName() {
            return ownerName;
        }

        // Setter (controlled write access with validation)
        public void setOwnerName(String newName) {
            if (newName == null || newName.isBlank()) {
                throw new IllegalArgumentException("Owner name cannot be blank.");
            }
            this.ownerName = newName;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double newBalance) {
            if (newBalance < 0) {
                IO.println("Rejected: Balance cannot be negative.");
                return;
            }
            this.balance = newBalance;
        }
    }

    void main() {
        Account acc = new Account();
        // acc.ownerName = "John"; // Compilation error: ownerName has private access

        acc.setOwnerName("Onkar");
        acc.setBalance(5000.00);
        acc.setBalance(-200.00); // Safely blocked by setter validation

        IO.println("Owner: " + acc.getOwnerName());
        IO.println("Balance: " + acc.getBalance());
    }
}

// SUMMARY:
// - Keep fields 'private' and expose controlled 'public' getters/setters.
// - Prevents invalid state and protects internal class design.
