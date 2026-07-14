package com.pluralsight;

import java.io.*;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class LedgerModel {
    private String fileName;
    HashMap<Integer, Transaction> currentTransactions = new HashMap<>();

    // getters
    public String getFileName() {return this.fileName;}
    // setters
    public void setFileName(String fileName) {this.fileName = fileName;}

    // methods
    public void readFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader
                ("src\\main\\resources\\inventory.csv"))) {

            String header = bufferedReader.readLine();

            String print;
            while ((print = bufferedReader.readLine()) != null) {
                String[] lines = print.split("\\|");

                if (lines.length < 7) {continue;}

                int id = Integer.parseInt(lines[0]);

                Transaction t = transactionPasser(
                        id,                         // ID
                        lines[1],                   // Date
                        lines[2],                   // Time
                        Double.parseDouble(lines[3]),// Amount
                        lines[4],                   // Vendor
                        lines[5],                    // Description
                        lines[6]                    // Category
                );
                currentTransactions.put(id, t);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

    public void writeFile() {

        File file = new File("src\\main\\resources\\inventory.csv");
        boolean isFileEmpty = !file.exists() || file.length() == 0;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter
                (file, true))) {

            if (isFileEmpty) {
                bufferedWriter.write("ID|Date|Time|Amount|Vendor|Description|Category");
                bufferedWriter.newLine();
            }

            for (Transaction transaction : currentTransactions.values()) {
                String lineToSave = String.format("%d|%s|%s|%.2f|%s|%s|%s",
                        transaction.getId(),
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getAmount(),
                        transaction.getVendor(),
                        transaction.getDescription(),
                        transaction.getCategory()
                );
                bufferedWriter.write(lineToSave);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

    public Transaction transactionPasser(int id, String date,
                                         String time, double amount, String vendor, String desc, String cat) {
        Transaction t = new Transaction();

        t.setId(id);
        t.setDate(LocalDate.parse(date));
        t.setTime(LocalTime.parse(time));
        t.setAmount(amount);
        t.setVendor(vendor);
        t.setDescription(desc);
        t.setCategory(cat);
        return t;
    }

    public double seeTheBalance(String option){
        double deposit = 0.0;
        double payments = 0.0;

        for (Transaction transaction : currentTransactions.values()) {
            if (transaction.getAmount() > 0) {
                deposit += transaction.getAmount();
            }

            if (transaction.getAmount() < 0) {
                payments += transaction.getAmount();
            }
        }

        switch (option) {
            case "deposit": return  deposit;
            case "payments": return payments;
            case "balance": return  payments + deposit;
            default : return  0;
        }
    }

    public void displayBalance(){
        System.out.println(Colors.PINK_PURPLE + "==========BALANCE==========" + Colors.RESET);
        System.out.printf(Colors.AQUA_BLUE + "Deposit: $%.2f" + Colors.RESET + "%n", seeTheBalance("deposit"));
        System.out.printf(Colors.PINK_PURPLE +"Payments: $%.2f" + Colors.RESET + "%n",seeTheBalance("payments"));
        System.out.printf(Colors.AQUA_BLUE +"Current Balance: $%.2f"+ Colors.RESET + "%n", seeTheBalance("balance"));

    }
}
