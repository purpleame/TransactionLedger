package com.pluralsight;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class LedgerController {
    private LedgerModel model = new LedgerModel();
    private LedgerView view = new LedgerView();
    private Random random = new Random();
    Scanner input = new Scanner(System.in);

    public void start() {
        boolean running = true;

        // This is the top-level loop (Home Screen)
        while (running) {
            view.displayHomeScreen();
            String choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "D":
                    userEntry("Deposit");
                    break;
                case "P":
                    userEntry("Payment");
                    break;
                case "L":
                    displayLedgerMenu();
                    break;
                case "X":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    public void fileNameGrabber() {
        view.enterTransactionName();
        String fileName = input.nextLine();
        model.setFileName(fileName);
    }

    public int generateId() {
        return random.nextInt(900) + 100;
    }

    public void userEntry(String type) {
        int id = generateId();

        String date = getValidDateTime("date (YYYY-MM-DD)");

        String time = getValidDateTime("time (HH:MM)");

        view.promptFor("amount");
        double amount = getValidNumber();

        if (type.equalsIgnoreCase("Payment")) {
            amount = -Math.abs(amount);
        } else {
            amount = Math.abs(amount);
        }

        view.promptFor("description");
        String description = input.nextLine();

        view.promptFor("vendor");
        String vendor = input.nextLine();

        model.currentTransactions.put(id, model.transactionPasser(
                id, date, time, amount, vendor, description));
    }

    public double getValidNumber() {
        while (true) {
            try {
                double amount = input.nextDouble();
                input.nextLine();
                return amount;
            } catch (InputMismatchException e) {
                view.invalidInput("double (must be e.g. 23.23 or 23)");
                input.next(); // clear invalid input
            }
        }
    }

    public String getValidDateTime(String type) {
        while (true) {
            try {
                view.promptFor(type);
                String i = input.nextLine();

                if (type.equalsIgnoreCase("date (YYYY-MM-DD)")) {
                    LocalDate.parse(i);
                } else {
                    LocalTime.parse(i);
                }
                return i;
            } catch (DateTimeParseException e) {
                view.invalidInput(type);
            }
        }
    }

    public void displayLedgerMenu() {
        boolean inLedger = true;
        while (inLedger) {
            view.displayLedgerScreen();
            String choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "A": // Display All
                    showFilteredTransactions("All");
                    break;
                case "D": // Deposits Only
                    showFilteredTransactions("Deposit");
                    break;
                case "P": // Payments Only
                    showFilteredTransactions("Payment");
                    break;
                case "H":
                    inLedger = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void showFilteredTransactions(String filter) {
        java.util.List<Transaction> all = new java.util.ArrayList<>();
        all.addAll(model.savedTransactions.values());
        all.addAll(model.currentTransactions.values());

        all.sort((t1, t2) -> {
            int dateComp = t2.getDate().compareTo(t1.getDate());
            if (dateComp != 0) return dateComp;
            return t2.getTime().compareTo(t1.getTime());
        });

        System.out.println("\nDate       | Time     | Amount   | Vendor               | Description");
        System.out.println("-------------------------------------------------------------------------");

        for (Transaction t : all) {
            boolean matchesFilter = false;
            if (filter.equals("All")) matchesFilter = true;
            else if (filter.equals("Deposit") && t.getAmount() > 0) matchesFilter = true;
            else if (filter.equals("Payment") && t.getAmount() < 0) matchesFilter = true;

            if (matchesFilter) {
                System.out.printf("%s | %s | %8.2f | %-20s | %s\n",
                        t.getDate(),
                        t.getTime(),
                        t.getAmount(),
                        t.getVendor(),
                        t.getDescription()
                );
            }
        }
    }
}