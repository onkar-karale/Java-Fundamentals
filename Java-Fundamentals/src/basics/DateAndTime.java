package basics;

// =====================================================================
// TOPIC 20: JAVA DATE & TIME (java.time Package)
// - Java does not have a single built-in Date type; instead, modern Java
//   uses the 'java.time' package (replacing old java.util.Date).
// - Key Classes:
//   - LocalDate         : Date only (yyyy-MM-dd)
//   - LocalTime         : Time only (HH:mm:ss.ns)
//   - LocalDateTime     : Both date and time (yyyy-MM-ddTHH:mm:ss.ns)
//   - DateTimeFormatter : Formats and parses date-time objects into custom strings
// - Common Pattern Codes:
//   - yyyy = 4-digit year   | MM = month (01-12) | MMM = short month (Nov)
//   - dd   = day (01-31)    | E  = day of week (Mon)
//   - HH   = 24-hour clock  | mm = minutes       | ss  = seconds
// =====================================================================

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
    void main() {
        // 1. Display Current Date
        LocalDate currentDate = LocalDate.now();
        IO.println("Current Date: " + currentDate);

        // 2. Display Current Time
        LocalTime currentTime = LocalTime.now();
        IO.println("Current Time: " + currentTime);

        // 3. Display Current Date and Time
        LocalDateTime now = LocalDateTime.now();
        IO.println("Before Formatting: " + now);

        // 4. Formatting Date and Time with DateTimeFormatter
        DateTimeFormatter numericFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter readableFormat = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

        IO.println("Formatted (dd-MM-yyyy HH:mm:ss): " + now.format(numericFormat));
        IO.println("Formatted (E, MMM dd yyyy)     : " + now.format(readableFormat));
    }
}

// SUMMARY:
// - Always use java.time (LocalDate, LocalTime, LocalDateTime)—standard in Spring Boot.
// - Use DateTimeFormatter.ofPattern(...) to convert timestamps into human-readable strings.
