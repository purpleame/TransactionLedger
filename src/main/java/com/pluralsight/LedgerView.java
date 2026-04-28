package com.pluralsight;

public class LedgerView {
    LedgerController userSession = new LedgerController();

    public void loadFile() {
        System.out.println("Enter the transaction file name (e.g., transactions.csv): ");
        userSession.fileNameGrabber();
    }
}

