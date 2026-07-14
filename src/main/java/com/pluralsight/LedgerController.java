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
    private static Random random = new Random();
    Scanner input = new Scanner(System.in);

    public void start() {
        model.readFile();
        boolean running = true;
        while (running) {
            view.displayHomeScreen();
            String choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "D": userEntry("Deposit"); break;
                case "P": userEntry("Payment"); break;
                case "L": displayLedgerMenu(); break;
                case "S": saveFile(); break;
                case "X": running = false; break;
                default: System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void displayLedgerMenu() {
        boolean inLedger = true;
        while (inLedger) {
            view.displayLedgerScreen();
            String choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "A": showFilteredTransactions("All"); break;
                case "D": showFilteredTransactions("Deposit"); break;
                case "P": showFilteredTransactions("Payment"); break;
                case "R": displayReportsMenu(); break;
                case "H": inLedger = false; break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    public void displayReportsMenu() {
        boolean inReports = true;
        while (inReports) {
            view.displayReportsScreen();
            String choice = input.nextLine();

            switch (choice) {
                case "1": runReport("Month To Date"); break;
                case "2": runReport("Previous Month"); break;
                case "3": runReport("Year To Date"); break;
                case "4": runReport("Previous Year"); break;
                case "5": searchByVendor(); break;
                case "6": model.displayBalance(); break;
                case "7": searchByCategory(); break;
                case "0": inReports = false; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }


    public void saveFile() {
        model.writeFile();
        System.out.println(Colors.PINK_PURPLE +"Data saved to inventory.csv" + Colors.RESET);
    }

    public static int generateId() {
        return random.nextInt(900) + 100;
    }

    public void userEntry(String typeToDisplay) {
        int id = generateId();

        String date = getValidDateTime("date (YYYY-MM-DD)");

        String time = getValidDateTime("time (HH:MM)");

        view.promptFor("amount");
        double amount = getValidNumber();

        if (typeToDisplay.equalsIgnoreCase("Payment")) {
            amount = -Math.abs(amount);
        } else {
            amount = Math.abs(amount);
        }

        view.promptFor("description");
        String description = input.nextLine();

        view.promptFor("vendor");
        String vendor = input.nextLine();

        view.promptFor("category");
        String cat = input.nextLine();

        model.currentTransactions.put(id, model.transactionPasser(
                id, date, time, amount, vendor, description, cat));

        view.transactionAddedSuccessfully(id);
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
                String i = input.nextLine().trim();

                if (i.isEmpty()) {
                    if (type.equalsIgnoreCase("date (YYYY-MM-DD)")) {
                        return LocalDate.now().toString();
                    } else {
                        return LocalTime.now().withNano(0).toString();
                    }
                }

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

    private void showFilteredTransactions(String filter) {
        view.transactionHeaderPrint();

        for (Transaction t : model.currentTransactions.values()) {
            boolean matchesFilter = false;
            if (filter.equals("All")) matchesFilter = true;
            else if (filter.equals("Deposit") && t.getAmount() > 0) matchesFilter = true;
            else if (filter.equals("Payment") && t.getAmount() < 0) matchesFilter = true;

            if (matchesFilter) {
                System.out.printf("%s | %s | %8.2f | %-20s | %s | %s\n",
                        t.getDate(),
                        t.getTime(),
                        t.getAmount(),
                        t.getVendor(),
                        t.getDescription(),
                        t.getCategory()
                );
            }
        }
    }

    private void runReport(String reportType) {
        LocalDate now = LocalDate.now();

        view.transactionHeaderPrint();

        for (Transaction t : model.currentTransactions.values()) {
            LocalDate date = t.getDate();
            boolean matches = false;

            switch (reportType) {
                case "Month To Date":
                    matches = (date.getMonth() == now.getMonth() && date.getYear() == now.getYear());
                    break;
                case "Previous Month":
                    LocalDate prev = now.minusMonths(1);
                    matches = (date.getMonth() == prev.getMonth() && date.getYear() == prev.getYear());
                    break;
                case "Year To Date":
                    matches = (date.getYear() == now.getYear());
                    break;
                case "Previous Year":
                    matches = (date.getYear() == now.getYear() - 1);
                    break;
            }

            if (matches) {
                System.out.printf("%s | %s | %8.2f | %-20s | %s | %s\n",
                        t.getDate(), t.getTime(), t.getAmount(), t.getVendor(), t.getDescription(), t.getCategory());
            }
        }
    }

    private void searchByVendor() {
        view.promptFor("Vendor Name");
        String search = input.nextLine().toLowerCase();
        view.transactionHeaderPrint();

        for (Transaction t : model.currentTransactions.values()) {
            if (t.getVendor().toLowerCase().contains(search)) {
                System.out.printf("%s | %s | %8.2f | %-20s | %s | %s\n",
                        t.getDate(), t.getTime(), t.getAmount(), t.getVendor(), t.getDescription(), t.getCategory());
            }
        }
    }

    private void searchByCategory() {
        view.promptFor("category");
        String search = input.nextLine().toLowerCase();
        view.transactionHeaderPrint();

        for (Transaction t : model.currentTransactions.values()) {
            if (t.getCategory().toLowerCase().contains(search)) {
                System.out.printf("%s | %s | %8.2f | %-20s | %s | %s\n",
                        t.getDate(), t.getTime(), t.getAmount(), t.getVendor(), t.getDescription(), t.getCategory());
            }
        }
    }
}