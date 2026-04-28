package com.pluralsight;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class LedgerModel {
    private String print;
    private String fileName;

    // getters
    public String getFileName() {return this.fileName;}
    // setters
    public void setFileName(String fileName) {this.fileName = fileName;}

    // methods
    public void initFile(String userFileName) {
        try {
            FileReader fileReader = new FileReader("src\\main\\resources\\" + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
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
