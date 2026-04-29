package com.pluralsight;

import java.util.Scanner;

public class LedgerController {
        Scanner input = new Scanner(System.in);
        LedgerView view = new LedgerView();

    public String fileNameGrabber() {
        view.enterTransactionName();
        String fileName = input.nextLine();
        return fileName;
    }

}