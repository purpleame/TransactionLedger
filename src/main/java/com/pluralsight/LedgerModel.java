package com.pluralsight;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class LedgerModel {
    private String print;
    private String fileName;

    // getters
    public String getFileName() {return this.fileName;}
    // setters
    public void setFileName(String fileName) {this.fileName = fileName;}

    // methods
    public void readFile(String userFileName) {
        try {
            FileReader fileReader = new FileReader("src\\main\\resources\\" + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String header = bufferedReader.readLine();

            while ((print = bufferedReader.readLine()) != null) {
                String[] lines = print.split("\\|");

                LocalDate transactionDate = LocalDate.parse(lines[0]);
                LocalTime transactionTime = LocalTime.parse(lines[1]);
                double transactionAmount = Double.parseDouble(lines[2]);
                String description = lines[3];
                String vendor = lines[4];

                Transaction transaction = new Transaction();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFile(String userFileName) {
        try {
            FileWriter fileWriter = new FileWriter("src\\main\\resources\\" + fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
