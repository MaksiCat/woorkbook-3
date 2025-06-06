package com.pluralsight; // Declares the package name for organizational purposes

import java.time.LocalDateTime;// Imports the LocalDateTime class to work with date and time
import java.time.format.DateTimeFormatter;// Imports DateTimeFormatter to format date and time
import java.time.ZonedDateTime;
import java.time.ZoneId;
//import java.math.BigDecimal;

public class AppTime { // Defines the main class named AppTime
    public static void main(String[] args) {  // Main method – the entry point of the program
        LocalDateTime now = LocalDateTime.now(); // Gets the current date and time

        dateFormat1(now); // Calls method to format as MM-dd-yyyy
        dateFormat2(now); // Calls method to format as yyyy/MM/dd
        dateFormat3(now); // Calls method to format as MM dd, yyyy
        dateFormat4(now); // Calls method to format as E, MMM dd yyyy (day of week, month, day, year)
        dateFormat5(now); // Calls method to display time in hh:mm format with extra message
        dateFormat6(now); // Calls method to display time and date in a detailed custom format
    }

    static void dateFormat1(LocalDateTime now) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM-dd-yyyy");// Defines format: month-day-year
        System.out.println(now.format(format1));
    }

    static void dateFormat2(LocalDateTime now) {
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");// Defines format: year/month/day
        System.out.println(now.format(format2));// Outputs formatted date
    }

    static void dateFormat3(LocalDateTime now) {
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MM dd, yyyy");// Defines format: month day, year
        System.out.println(now.format(format3));// Outputs formatted date
    }

    static void dateFormat4(LocalDateTime time) {
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("E, MMM dd yyyy");// Defines format: abbreviated day, month name, day, year
        System.out.println(time.format(format4));// Outputs formatted date
    }

    static void dateFormat5(LocalDateTime now) {
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm 'GMT'");// Defines format: hour:minute (12-hour)
        System.out.println(gmtTime.format(formatter));
    }

    static void dateFormat6(LocalDateTime now) {
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("H:mm 'on' dd MMM yyyy");// Defines format: hour:minute on day Month year (24-hour)
        System.out.println(format6.format(now) + " \n00DF display in your local time zone");// Outputs full formatted string with time zone message
    }
}

