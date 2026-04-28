package com.pluralsight;

import java.util.Scanner;

public class LedgerController {

    public String fileNameGrabber() {
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();

        return fileName;
    }
}
