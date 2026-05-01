package com.pluralsight;

public class LedgerView {

    public void displayHomeScreen() {
        System.out.println("\nHome Screen");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("F) Load File - Loads transaction file");
        System.out.println("S) Save File - Saves transaction date opened into a file");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
        System.out.println("-------------------------------------------");
        System.out.print("Please select an option: ");
    }

    public void displayLedgerScreen() {
        System.out.println("\nWelcome to your Ledger!");
        System.out.println("A) All - Display all entries");
        System.out.println("D) Deposits - Display only deposits");
        System.out.println("P) Payments - Display only payments");
        System.out.println("R) Reports - Custom searches");
        System.out.println("H) Home - Go back to Home Screen");
        System.out.println("-------------------------------------------");
        System.out.print("Please select an option: ");
    }

    public void displayReportsScreen() {
        System.out.println("\nReports Screen");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) Back - Go back to Ledger page");
        System.out.print("Please select a report: ");
    }

    public void enterTransactionName() {
        System.out.println("Enter the transaction file name (e.g., transactions.csv): ");
    }

    public void promptFor(String text) {
        System.out.println("Input transaction " + text + ": ");
    }

    public void transactionAddedSuccessfully(int id) {
        System.out.println("Transaction " + id + " added successfully!");
    }

    public void invalidInput(String type) {
        System.out.println("Invalid " + type + " format. Please try again.");

    }

    public void transactionHeaderPrint() {
        System.out.println("\nDate       | Time     | Amount   | Vendor               | Description");
        System.out.println("-------------------------------------------------------------------------");
    }

}

