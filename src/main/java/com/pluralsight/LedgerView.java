package com.pluralsight;

public class LedgerView {

    public void displayHomeScreen() {
        System.out.println("\n-------------------------------------------");
        System.out.println(Colors.BLUE+ "Home Screen" + Colors.RESET);
        System.out.println("-------------------------------------------");
        System.out.println(Colors.PURPLE +"D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("S) Save File - Saves transaction date opened into a file");
        System.out.println("L) Ledger");
        System.out.println("X) Exit"+ Colors.RESET);
        System.out.println("-------------------------------------------");
        System.out.print(Colors.CYAN_BLUE + "Please select an option: "+ Colors.RESET);

    }

    public void displayLedgerScreen() {
        System.out.println("\n-------------------------------------------");
        System.out.println(Colors.BLUE+"Welcome to your Ledger!"+ Colors.RESET);
        System.out.println("-------------------------------------------");
        System.out.println(Colors.PURPLE + "A) All - Display all entries");
        System.out.println("D) Deposits - Display only deposits");
        System.out.println("P) Payments - Display only payments");
        System.out.println("R) Reports - Custom searches");
        System.out.println("H) Home - Go back to Home Screen"+ Colors.RESET);
        System.out.println("-------------------------------------------");
        System.out.print(Colors.CYAN_BLUE + "Please select an option: "+ Colors.RESET);
    }

    public void displayReportsScreen() {
        System.out.println("\n-------------------------------------------");
        System.out.println(Colors.BLUE+"Reports Screen"+ Colors.RESET);
        System.out.println("-------------------------------------------");
        System.out.println(Colors.PURPLE + "1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("6) See the total balance");
        System.out.println("7) Search by Category");
        System.out.println("0) Back - Go back to Ledger page" + Colors.RESET);
        System.out.print(Colors.CYAN_BLUE +"Please select a report: "+ Colors.RESET);
    }


    public void enterTransactionName() {
        System.out.println(Colors.AQUA_BLUE + "Enter the transaction file name (e.g., transactions.csv): "+ Colors.RESET);
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
        System.out.println(Colors.MEDIUM_BLUE +"\nDate       | Time     | Amount   | Vendor               | Description  | Category" +Colors.RESET);
        System.out.println("-------------------------------------------------------------------------");
    }


}

