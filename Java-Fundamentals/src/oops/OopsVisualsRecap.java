package oops;

// =====================================================================
// TOPIC 17: JAVA OOP VISUALS (THE 4 PILLARS IN ONE VIEW)
//
//        +---------------------------------------------+
//        |      ABSTRACT CLASS / INTERFACE (Contract)  |  <-- ABSTRACTION
//        |         PaymentMethod { pay(amount) }       |
//        +----------------------+----------------------+
//                               | (extends / implements)  <-- INHERITANCE
//                 +-------------+-------------+
//                 |                           |
//      +----------v-----------+    +----------v-----------+
//      |     UpiPayment       |    |     CardPayment      |
//      | - private upiId      |    | - private cardNo     | <-- ENCAPSULATION
//      | + pay() -> "UPI..."  |    | + pay() -> "Card..." | <-- POLYMORPHISM
//      +----------------------+    +----------------------+
//
// - Encapsulation : Keeps fields private; exposes controlled methods.
// - Inheritance   : Child reuses parent's shared fields/methods.
// - Abstraction   : Exposes 'pay()' without revealing internal gateway logic.
// - Polymorphism  : Same 'pay()' call executes different logic per object type.
// =====================================================================

public class OopsVisualsRecap {

    // ABSTRACTION: Contract hiding internal details
    static abstract class PaymentMethod {
        private final String currency; // ENCAPSULATION: private field

        protected PaymentMethod(String currency) {
            this.currency = currency;
        }

        public String getCurrency() {
            return currency;
        }

        public abstract void pay(double amount);
    }

    // INHERITANCE: UpiPayment extends PaymentMethod
    static class UpiPayment extends PaymentMethod {
        private final String upiId;

        public UpiPayment(String upiId) {
            super("INR");
            this.upiId = upiId;
        }

        // POLYMORPHISM: Custom behavior for pay()
        @Override
        public void pay(double amount) {
            IO.println("Paid %s %.2f via UPI (%s)".formatted(getCurrency(), amount, upiId));
        }
    }

    // INHERITANCE: CardPayment extends PaymentMethod
    static class CardPayment extends PaymentMethod {
        private final String lastFour;

        public CardPayment(String lastFour) {
            super("INR");
            this.lastFour = lastFour;
        }

        // POLYMORPHISM: Different behavior for the exact same pay() call
        @Override
        public void pay(double amount) {
            IO.println("Paid %s %.2f via Card (****%s)".formatted(getCurrency(), amount, lastFour));
        }
    }

    void main() {
        PaymentMethod[] payments = {
                new UpiPayment("onkar@okicici"),
                new CardPayment("4829")
        };

        for (PaymentMethod method : payments) {
            method.pay(1250.00);
        }
    }
}

// SUMMARY:
// - The 4 OOP pillars work together: Encapsulate data, Abstract contracts,
//   Inherit shared behavior, and swap implementations via Polymorphism.
