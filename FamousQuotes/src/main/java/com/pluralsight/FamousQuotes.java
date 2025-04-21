package com.pluralsight;

import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] quotes = {
                "Without effort, you can't even pull a fish out of the pond",
        "Measure seven times, cut once",
        "The quieter you go, the further you'll get",
        "Don't dig a hole for someone else — you might fall into it yourself.",
        "An old friend is better than two new ones.",
        "You can't feed a horse with tales.",
        "A word is not a sparrow; once it flies out, you won’t catch it.",
        "After the rain on Thursday.",
        "The wolf is fed by its feet.",
        "What is written with a pen cannot be cut down with an ax."
        };
        System.out.print("Enter a number between 1 and 10 to see a quote: ");
        int choice = scanner.nextInt();
        System.out.println(quotes[choice - 1]);
    }
}
