package com.pluralsight;

public class LedgerView {
    LedgerController userSession = new LedgerController();

    public void loadFile() {
        System.out.println("Enter the transaction file name (e.g., transactions.csv): ");
        userSession.fileNameGrabber();
    }

    public void transactionPasserPrinter(String text) {
        switch (text) {
            case "date":
                System.out.println("Input transaction date: ");
                break;
            case "time":
                System.out.println("Input transaction time: ");
                break;
            case "amount":
                System.out.println("Input transaction amount: ");
                break;
            case "description":
                System.out.println("Input transaction description: ");
                break;
            case "vendor":
                System.out.println("Input transaction vendor: ");
                break;
        }
    }
}

