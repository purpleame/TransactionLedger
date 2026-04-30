package com.pluralsight;

import java.util.Scanner;
import java.util.Random;

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

        view.transactionChoice("date (YYYY-MM-DD)");
        String date = input.nextLine();

        view.transactionChoice("time (HH:MM)");
        String time = input.nextLine();

        view.transactionChoice("amount");
        double amount = input.nextDouble();

        view.transactionChoice("description");
        String description = input.nextLine();

        view.transactionChoice("vendor");
        String vendor = input.nextLine();

        model.currentTransactions.put(id, model.transactionPasser(
                id, date, time, amount, description, vendor));
    }

}