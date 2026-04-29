package com.pluralsight;

import java.util.HashMap;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class LedgerModel {
    private String print;
    private String fileName;
    HashMap<Integer, Transaction> savedTransactions = new HashMap<>();
    HashMap<Integer, Transaction> currentTransactions = new HashMap<>();

    // getters
    public String getFileName() {return this.fileName;}
    // setters
    public void setFileName(String fileName) {this.fileName = fileName;}

    // methods
    public void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader("src\\main\\resources\\" + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String header = bufferedReader.readLine();

            while ((print = bufferedReader.readLine()) != null) {
                String[] lines = print.split("\\|");

                transactionPasser("read",
                        Integer.parseInt(lines[0]), // ID
                        lines[1],                   // Date
                        lines[2],                   // Time
                        Double.parseDouble(lines[3]),// Amount
                        lines[4],                   // Vendor
                        lines[5]                    // Description
                );
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

    public void writeFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter("src\\main\\resources\\" + fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("ID|Date|Time|Amount|Vendor|Description");
            bufferedWriter.newLine();

            transactionPasser("write",
                        Integer.parseInt(lines[0]), // ID
                        lines[1],                   // Date
                        lines[2],                   // Time
                        Double.parseDouble(lines[3]),// Amount
                        lines[4],                   // Vendor
                        lines[5]                    // Description
                );
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

    public void transactionPasser(String readOrWrite, int id, String date,
                                  String time, double amount, String vendor, String desc) {
        Transaction t = new Transaction();

        t.setId(id);
        t.setTransactionDate(LocalDate.parse(date));
        t.setTransactionTime(LocalTime.parse(time));
        t.setTransactionAmount(amount);
        t.setVendor(vendor);
        t.setDescription(desc);

        switch (readOrWrite) {
            case "read":
                savedTransactions.put(id, t);
                break;
            case "write":
                savedTransactions.put(id, t);
                break;
        }
    }
}
