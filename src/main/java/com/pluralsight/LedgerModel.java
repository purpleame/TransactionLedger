package com.pluralsight;

import java.util.HashMap;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class LedgerModel {
    private String fileName;
    HashMap<Integer, Transaction> savedTransactions = new HashMap<>();
    HashMap<Integer, Transaction> currentTransactions = new HashMap<>();

    // getters
    public String getFileName() {return this.fileName;}
    // setters
    public void setFileName(String fileName) {this.fileName = fileName;}

    // methods
    public void readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader
                ("src\\main\\resources\\" + fileName))) {

            String header = bufferedReader.readLine();

            String print;
            while ((print = bufferedReader.readLine()) != null) {
                String[] lines = print.split("\\|");

                if (lines.length < 6) {continue;}

                int id = Integer.parseInt(lines[0]);

                Transaction t = transactionPasser(
                        id,                         // ID
                        lines[1],                   // Date
                        lines[2],                   // Time
                        Double.parseDouble(lines[3]),// Amount
                        lines[4],                   // Vendor
                        lines[5]                    // Description
                );
                savedTransactions.put(id, t);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

    public void writeFile(String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter
                ("src\\main\\resources\\" + fileName))) {

            bufferedWriter.write("ID|Date|Time|Amount|Vendor|Description");
            bufferedWriter.newLine();

            for (Transaction transaction : currentTransactions.values()) {
                String lineToSave = String.format("%d|%s|%s|%.2f|%s|%s",
                        transaction.getId(),
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getAmount(),
                        transaction.getVendor(),
                        transaction.getDescription()
                );
                bufferedWriter.write(lineToSave);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

    public Transaction transactionPasser(int id, String date,
                                         String time, double amount, String vendor, String desc) {
        Transaction t = new Transaction();

        t.setId(id);
        t.setDate(LocalDate.parse(date));
        t.setTime(LocalTime.parse(time));
        t.setAmount(amount);
        t.setVendor(vendor);
        t.setDescription(desc);
        return t;
    }

    public List<Transaction> transactionCombiner() {
        List<Transaction> all = new java.util.ArrayList<>();
        all.addAll(savedTransactions.values());
        all.addAll(currentTransactions.values());

        all.sort((t1, t2) -> {
            int dateComp = t2.getDate().compareTo(t1.getDate());
            if (dateComp != 0) return dateComp;
            return t2.getTime().compareTo(t1.getTime());
        });
        return all;
    }
}
