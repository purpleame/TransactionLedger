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

    public void fileNameGrabber() {
        view.enterTransactionName();
        String fileName = input.nextLine();
        model.setFileName(fileName);
    }

    public int generateId() {
        return random.nextInt(900) + 100;
    }

    public void userEntry() {
        int id = generateId();

        String date = getValidDateTime("date (YYYY-MM-DD");

        String time = getValidDateTime("time (HH:MM)");

        view.promptFor("amount");
        double amount = getValidNumber();

        view.promptFor("description");
        String description = input.nextLine();

        view.promptFor("vendor");
        String vendor = input.nextLine();

        model.currentTransactions.put(id, model.transactionPasser(
                id, date, time, amount, description, vendor));
    }

    public double getValidNumber() {
        while (true) {
            try {
                return input.nextDouble();
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

                if (type.equalsIgnoreCase("Date")) {
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
}