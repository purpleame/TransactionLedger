package com.pluralsight;

import java.util.Scanner;

public class LedgerController {

    public void fileNameGrabber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename to save (e.g., transactions.csv): ");
        String userFileName = input.nextLine();

        LedgerDataManager manager = new LedgerDataManager();
        manager.initFile(userFileName);
    }
}
