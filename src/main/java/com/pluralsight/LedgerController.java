package com.pluralsight;

import java.util.Scanner;
import java.util.Random;

public class LedgerController {
    private Random random = new Random();
    Scanner input = new Scanner(System.in);
    LedgerView view = new LedgerView();

    public String fileNameGrabber() {
        view.enterTransactionName();
        String fileName = input.nextLine();
        return fileName;
    }

    public int generateId() {
        return random.nextInt(900) + 100;
    }

}