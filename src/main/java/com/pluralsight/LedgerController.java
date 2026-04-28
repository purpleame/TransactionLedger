package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class LedgerController {
        Scanner input = new Scanner(System.in);
        LedgerView view = new LedgerView();

    public String fileNameGrabber() {
        String fileName = input.nextLine();
        return fileName;
    }


}








//        Transaction transaction = new Transaction();
//        transaction.setId();
//
//        view.transactionPasserPrinter("date");
//        LocalDate date = LocalDate.parse(scanner.nextLine());
//        transaction.setTransactionDate(date);
//
//        view.transactionPasserPrinter("time");
//        LocalTime time = LocalTime.parse(scanner.nextLine());
//        transaction.setTransactionTime(time);
//
//        view.transactionPasserPrinter("amount");
//        transaction.setTransactionAmount(scanner.nextDouble());
//
//        view.transactionPasserPrinter("description");
//        transaction.setDescription(scanner.nextLine());
//
//        view.transactionPasserPrinter("vendor");
//        transaction.setVendor(scanner.nextLine());
//
//        return transaction;
